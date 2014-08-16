package cn.myblog.dao;

import cn.myblog.model.Article;

import java.util.List;

/**
 * Created by nanwei on 14-7-5.
 */
public interface ArticleDao {
    public List<Article> getAllArticle();
    public List<Article> getAllArticleList();
    public List<Article> getArticleListByCategoryId(long categoryId);
    public List<Article> getArticleByCategoryId(long categoryId);
    public Article getArticleById(Long articleId);
    public void postArticle(Article article);
    public void addCount(Article article);
    public void updateArticle(Article article);
}
