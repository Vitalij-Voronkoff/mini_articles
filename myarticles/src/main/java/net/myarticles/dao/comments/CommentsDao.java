package net.myarticles.dao.comments;

import net.myarticles.model.comments.Comments;

import java.util.List;

/**
 * @author Vitalij Voronkov
 */

public interface CommentsDao {

    public void addComment(Comments comments);

    public List getAllCommentsToArticle(Integer articleId);

    public void deleteComment(Integer id);

    public void deleteAllArticleComments(Integer articleId);
}
