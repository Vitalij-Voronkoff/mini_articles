package net.myarticles.service.comments;

import net.myarticles.dao.comments.CommentsDao;
import net.myarticles.model.comments.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Vitalij Voronkov
 */

@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsDao commentsDao;

    @Transactional
    public void addComment(Comments comments) {
        commentsDao.addComment(comments);
    }

    @Transactional
    public List getAllCommentsToArticle(Integer articleId) {
        return commentsDao.getAllCommentsToArticle(articleId);
    }

    @Transactional
    public void deleteComment(Integer id) {
        commentsDao.deleteComment(id);
    }

    @Transactional
    public void deleteAllArticleComments(Integer articleId) {
        commentsDao.deleteAllArticleComments(articleId);
    }
}
