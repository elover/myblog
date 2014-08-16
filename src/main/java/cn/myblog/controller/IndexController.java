package cn.myblog.controller;

import cn.myblog.model.Article;
import cn.myblog.model.Category;
import cn.myblog.service.ArticleService;
import cn.myblog.service.CategoryService;
import cn.myblog.uitl.MybatisPageHelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = {"/"})
    public String index(
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            ModelMap map
    ) {
        List<Category> categoryList = categoryService.getAllCategory();
        Page<Article> articlePage = (Page<Article>) articleService.getAllArticle(pageNum, 10);
        map.addAttribute("categoryList", categoryList);
        map.addAttribute("articleList", articlePage.getResult());
        map.addAttribute("page", articlePage.getPage());
        map.addAttribute("currentUrl","/");
        return "index";
    }

    @RequestMapping("/list")
    public String list(
            ModelMap map
    ){
        List<Category> categoryList = categoryService.getAllCategory();
        List<Article> articleList = articleService.getAllArticleList();
        map.addAttribute("categoryList", categoryList);
        map.addAttribute("currentUrl","/");
        map.addAttribute("articleList", articleList);
        return "list";
    }

    /**
     * 分类页
     * @param categorySlug
     * @param pageNum
     * @param map
     * @return
     */
    @RequestMapping(value="category/{categorySlug}")
    public String category(
            @PathVariable String categorySlug,
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            ModelMap map
    ){
        List<Category> categoryList = categoryService.getAllCategory();
        Page<Article> articlePage = (Page<Article>) articleService.getArticleByCategoryName(categorySlug,pageNum, 10);
        map.addAttribute("categoryList", categoryList);
        map.addAttribute("articleList", articlePage.getResult());
        map.addAttribute("page", articlePage.getPage());
        map.addAttribute("currentSlug",categorySlug);
        map.addAttribute("currentUrl","/category/"+categorySlug);
        return "index";
    }

    /**
     * 分类list
     * @param categorySlug
     * @param map
     * @return
     */
    @RequestMapping("category/{categorySlug}/list")
    public String categoryList(
            @PathVariable String categorySlug,
            ModelMap map
    ){
        List<Article> articleList = articleService.getArticleListByCategoryName(categorySlug);
        List<Category> categoryList = categoryService.getAllCategory();
        map.addAttribute("categoryList",categoryList);
        map.addAttribute("articleList",articleList);
        map.addAttribute("currentSlug",categorySlug);
        map.addAttribute("currentUrl","/category/"+categorySlug);
        return "list";
    }

    @RequestMapping("article/{articleId}")
    public String article(
            @PathVariable Long articleId,
            ModelMap map
    ){
        List<Category> categoryList = categoryService.getAllCategory();
        map.addAttribute("categoryList",categoryList);
        Article article = articleService.getArticleById(articleId);
        if(article == null){
            return "error/404";
        }
        articleService.addCount(article);
        map.addAttribute("content",article);
        return "article";
    }

}
