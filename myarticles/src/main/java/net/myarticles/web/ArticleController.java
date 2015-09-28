package net.myarticles.web;

import net.myarticles.model.article.Article;
import net.myarticles.model.comments.Comments;
import net.myarticles.service.article.ArticleService;
import net.myarticles.service.comments.CommentsService;
import net.myarticles.validator.ArticleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.Date;

/**
 * @author Vitalij Voronkov
 */

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleValidator articleValidator;
    @Autowired
    private CommentsService commentsService;

    @RequestMapping(value = "/main.html", method = RequestMethod.GET)
    public String MainPage(ModelMap map, Principal principal) {
        if (principal != null) {
            map.put("principal", principal.getName());
        }
        map.put("articleList", articleService.getAllArticles());
        return "main";
    }

    @RequestMapping(value = "/newarticle", method = RequestMethod.GET)
    public String newArticle(@ModelAttribute("article") Article article) {
        return "newarticle";
    }

    @RequestMapping(value = "/createarticle", method = RequestMethod.POST)
    public String createArticle(@ModelAttribute("article") Article article, BindingResult result, Principal principal) {
        articleValidator.validate(article, result);
        if (result.hasErrors()) {
            return "newarticle";
        }
        article.setDate(new Date());
        article.setAuthor(principal.getName());
        articleService.addArticle(article);
        return "redirect:/main.html";
    }

    @RequestMapping(value = "/deletearticle/{articleid}")
    public String deleteArticle(@PathVariable("articleid") Integer articleId) {
        articleService.deleteArticle(articleId);
        commentsService.deleteAllArticleComments(articleId);
        return "redirect:/main.html";
    }

    @RequestMapping(value = "/article/{articleid}")
    public String openArticleInNewWindow(@PathVariable("articleid") Integer articleId, @ModelAttribute("comments") Comments comments, ModelMap map, Principal principal) {
        if (principal != null) {
            map.put("principal", principal.getName());
        }
        map.put("commentsList", commentsService.getAllCommentsToArticle(articleId));
        map.put("article", articleService.getArticleById(articleId));
        return "article";
    }
}
