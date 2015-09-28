package net.myarticles.dao.article;

import net.myarticles.model.article.Article;

import java.util.List;

/**
 * @author Vitalij Voronkov
 */

public interface ArticleDao {

    public void addArticle(Article article);

    public List<Article> getAllArticles();

    public void deleteArticle(Integer id);

    public Article getArticleById(Integer id);

    public List<Article> getAllUserArticles(String userName);
}
