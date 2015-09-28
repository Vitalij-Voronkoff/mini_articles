package net.myarticles.model.comments;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Vitalij Voronkov
 */

@Entity
@Table(name = "COMMENTS")
public class Comments {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "ARTICLEID", nullable = false)
    private Integer articleId;
    @Column(name = "AUTHOR", length = 45, nullable = false)
    private String author;
    @Column(name = "DATE")
    private Date date;
    @Column(name = "CONTENT", length = 1000, nullable = false)
    private String content;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
