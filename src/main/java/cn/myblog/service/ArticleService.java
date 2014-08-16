package cn.myblog.service;

import cn.myblog.model.Article;

import java.util.List;
import java.util.Map;

/**
 * Created by nanwei on 14-7-5.
 */
public interface ArticleService {
    List<Article> getAllArticle(int pageNum,int pageSize);
    List<Article> getArticleByCategoryId(Long categoryId,int pageNum,int pageSize);
    List<Article> getArticleByCategoryName(String name,int pageNum,int pageSize);
    List<Article> getAllArticleList();
    List<Article> getArticleListByCategoryName(String name);
    Article getArticleById(Long id);
    Map postArticle(Article article);
//    Map updateArticle(Article article);
    void addCount(Article article);
}
