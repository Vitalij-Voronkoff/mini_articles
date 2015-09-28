package net.myarticles.model.article;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Vitalij Voronkov
 */

@Entity
@Table(name = "ARTICLE")
public class Article {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;
    @Column(name = "TITLE", nullable = false, length = 100)
    private String title;
    @Column(name = "AUTHOR", nullable = false, length = 45)
    private String author;
    @Column(name = "CONTENT", nullable = false, length = 4000)
    private String content;
    @Column(name = "DATE_CREATING")
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
