package net.myarticles.dao.article;

import net.myarticles.model.article.Article;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Vitalij Voronkov
 */

@Repository
public class ArticleDaoImpl implements ArticleDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addArticle(Article article) {
        sessionFactory.getCurrentSession().save(article);
    }

    public List<Article> getAllArticles() {
        return sessionFactory.getCurrentSession().createQuery("from Article").list();
    }

    public void deleteArticle(Integer id) {
        Article article = (Article) sessionFactory.getCurrentSession().load(Article.class, id);
        if (null != article) {
            sessionFactory.getCurrentSession().delete(article);
        }
    }

    public Article getArticleById(Integer id) {
        Article article = (Article) sessionFactory.getCurrentSession().get(Article.class, id);
        return article;
    }

    public List<Article> getAllUserArticles(String userName) {
        return sessionFactory.getCurrentSession().createQuery("from Article as u where u.author=?").setParameter(0, userName).list();
    }
}
