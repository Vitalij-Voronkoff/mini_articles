package net.myarticle.model.comments;

import junit.framework.TestCase;
import net.myarticles.model.comments.Comments;

import java.util.Date;

/**
 * @author Vitalij Voronkov
 */

public class CommentsTest extends TestCase {

    Comments comments = new Comments();

    public void testSetAndGetId() {
        assertNull(comments.getId());
        comments.setId(1);
        assertEquals(comments.getId(), Integer.valueOf(1));
    }

    public void testSetAndGetArticleId() {
        assertNull(comments.getArticleId());
        comments.setArticleId(1);
        assertEquals(comments.getArticleId(), Integer.valueOf(1));
    }

    public void testSetAndGetAuthor() {
        assertNull(comments.getAuthor());
        comments.setAuthor("author");
        assertEquals(comments.getAuthor(), "author");
    }

    public void testSetAndGetDate() {
        assertNull(comments.getDate());
        comments.setDate(new Date());
        assertNotNull(comments.getDate());
    }

    public void testSetAndGetContent() {
        assertNull(comments.getContent());
        comments.setContent("content");
        assertEquals(comments.getContent(), "content");
    }
}
