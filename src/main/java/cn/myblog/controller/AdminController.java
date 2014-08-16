package cn.myblog.controller;

import cn.myblog.model.Article;
import cn.myblog.model.Author;
import cn.myblog.model.Category;
import cn.myblog.service.ArticleService;
import cn.myblog.service.AuthorService;
import cn.myblog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by nanwei on 14-8-2.
 */
@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    ArticleService articleService;
    @Autowired
    AuthorService authorService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "admin/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String loginPost(
            Author author,
            HttpServletRequest request,
            RedirectAttributes map
    ) {
        String loginName = author.getLoginName();
        String message;
        if (loginName.isEmpty()) {
            message = "用户名不能为空";
            map.addFlashAttribute("message", message);
            return "redirect:/admin/login";
        }
        String password = authorService.getPasswordByloginName(loginName);
        if (password == null || !password.equals(author.getPassword())) {
            message = "用户名或密码不正确";
            map.addFlashAttribute("message", message);
            return "redirect:/admin/login";
        }
        request.getSession().setAttribute("login", true);
        return "redirect:/admin/";
    }

    @RequestMapping(value = "/")
    public String index(ModelMap map) {
        List<Author> authorList = authorService.selectAllAuthor();
        List<Category> categoryList = categoryService.getAllCategory();
        List<Article> articleList = articleService.getAllArticleList();
        map.addAttribute("articleList", articleList);
        map.addAttribute("authorList", authorList);
        map.addAttribute("categoryList", categoryList);
        return "admin/index";
    }
    @RequestMapping(value = "/edit")
    public String edit(
            @RequestParam(required = false) Long articleId,
            ModelMap map
    ){
        List<Author> authorList = authorService.selectAllAuthor();
        List<Category> categoryList = categoryService.getAllCategory();
        map.addAttribute("authorList", authorList);
        map.addAttribute("categoryList", categoryList);
        if(articleId != null){
            Article article = articleService.getArticleById(articleId);
            map.addAttribute("article",article);
        }

        return "admin/edit";

    }

    @RequestMapping(value = "postArticle", method = RequestMethod.POST)
    public String postArticle(
            Article article,
            RedirectAttributes redirectAttributes
    ) {
        Map map = articleService.postArticle(article);
        String message = "保存失败了";
        if (map.get("status").equals("ok")) {
            message = "保存成功了";
        }
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/admin/";
    }
}
