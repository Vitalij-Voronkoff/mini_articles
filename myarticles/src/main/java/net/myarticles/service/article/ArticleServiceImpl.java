package net.myarticles.service.article;

import net.myarticles.dao.article.ArticleDao;
import net.myarticles.model.article.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Vitalij Voronkov
 */

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Transactional
    public void addArticle(Article article) {
        articleDao.addArticle(article);
    }

    @Transactional
    public List<Article> getAllArticles() {
        return articleDao.getAllArticles();
    }

    @Transactional
    public void deleteArticle(Integer id) {
        articleDao.deleteArticle(id);
    }

    @Transactional
    public Article getArticleById(Integer id) {
        return articleDao.getArticleById(id);
    }

    @Transactional
    public List<Article> getAllUserArticles(String userName) {
        return articleDao.getAllUserArticles(userName);
    }
}
