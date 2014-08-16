package cn.myblog.service.impl;

import cn.myblog.dao.ArticleDao;
import cn.myblog.dao.CategoryDao;
import cn.myblog.model.Article;
import cn.myblog.service.ArticleService;
import cn.myblog.uitl.MybatisPageHelper.PageHelper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nanwei on 14-7-5.
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private CategoryDao categoryDao;

    private Logger logger = Logger.getLogger(ArticleService.class);

    @Override
    public List<Article> getAllArticleList() {
        return articleDao.getAllArticleList();
    }

    @Override
    public List<Article> getAllArticle(int pageNum, int pageSize) {
//
        PageHelper.startPage(pageNum, pageSize);
        return articleDao.getAllArticle();
    }

    @Override
    public List<Article> getArticleByCategoryId(Long categoryId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return articleDao.getArticleByCategoryId(categoryId);
    }

    @Override
    public List<Article> getArticleByCategoryName(String name, int pageNum, int pageSize) {
        Long categoryId = categoryDao.getIdByName(name);
        return getArticleByCategoryId(categoryId, pageNum, pageSize);
    }

    @Override
    public List<Article> getArticleListByCategoryName(String name) {
        Long categoryId = categoryDao.getIdByName(name);
        return articleDao.getArticleListByCategoryId(categoryId);
    }

    @Override
    public Article getArticleById(Long id) {

        return articleDao.getArticleById(id);
    }

    @Override
    public Map postArticle(Article article) {
        Map<String, String> map = new HashMap<>();
        String status = "fail";
        try {
            if (article.getId() != 0l) {
                // 更新
                articleDao.updateArticle(article);
            } else {
                article.setPubDate(new Date());
                articleDao.postArticle(article);
            }
            status = "ok";
        } catch (Exception e) {
            logger.error(e);
        }
        map.put("status", status);
        return map;
    }


    @Override
    public void addCount(Article article) {
        int oldCount = article.getCount();
        article.setCount(++oldCount);
        articleDao.addCount(article);
    }
}
