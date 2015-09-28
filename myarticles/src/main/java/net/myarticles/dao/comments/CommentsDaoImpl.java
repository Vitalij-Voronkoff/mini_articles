package net.myarticles.dao.comments;

import net.myarticles.model.comments.Comments;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Vitalij Voronkov
 */

@Repository
public class CommentsDaoImpl implements CommentsDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addComment(Comments comments) {
        sessionFactory.getCurrentSession().save(comments);
    }

    public List<Comments> getAllCommentsToArticle(Integer articleId) {
        return sessionFactory.getCurrentSession().createQuery("from Comments as u where u.articleId=?").setParameter(0, articleId).list();
    }

    public void deleteComment(Integer id) {
        Comments comments = (Comments) sessionFactory.getCurrentSession().load(Comments.class, id);
        if (null != comments) {
            sessionFactory.getCurrentSession().delete(comments);
        }
    }

    public void deleteAllArticleComments(Integer articleId) {
        List<Comments> comments = sessionFactory.getCurrentSession().createQuery("from Comments as u where u.articleId=?").setParameter(0, articleId).list();
        if ((comments != null) && (comments.size() > 0)) {
            for (Comments comment : comments) {
                sessionFactory.getCurrentSession().delete(comment);
            }
        }
    }
}
