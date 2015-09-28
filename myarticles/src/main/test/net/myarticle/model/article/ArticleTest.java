package net.myarticle.model.article;

import junit.framework.TestCase;
import net.myarticles.model.article.Article;

import java.util.Date;

/**
 * @author Vitalij Voronkov
 */

public class ArticleTest extends TestCase {

    Article article = new Article();

    public void testSetAndGetId() {
        assertNull(article.getId());
        article.setId(1);
        assertEquals(article.getId(), Integer.valueOf(1));
    }

    public void testSetAndGetTitle() {
        assertNull(article.getTitle());
        article.setTitle("title");
        assertEquals(article.getTitle(), "title");
    }

    public void testSetAndGetAuthor() {
        assertNull(article.getAuthor());
        article.setAuthor("author");
        assertEquals(article.getAuthor(), "author");
    }

    public void testSetAndGetContent() {
        assertNull(article.getContent());
        article.setContent("content");
        assertEquals(article.getContent(), "content");
    }

    public void testSetAndGetDate() {
        assertNull(article.getDate());
        article.setDate(new Date());
        assertNotNull(article.getDate());
    }

}
