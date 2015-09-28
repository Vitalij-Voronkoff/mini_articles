package net.myarticles.web;

import javassist.NotFoundException;
import net.myarticles.model.comments.Comments;
import net.myarticles.service.comments.CommentsService;
import net.myarticles.validator.CommentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class CommentsController {

    @Autowired
    private CommentsService commentsService;
    @Autowired
    private CommentValidator commentValidator;

    @RequestMapping(value = "/newcomment/{articleid}", method = RequestMethod.POST)
    public String addNewComment(@ModelAttribute("comments") Comments comments, BindingResult result, @PathVariable("articleid") Integer articleId, Principal principal){
        commentValidator.validate(comments, result);
        if (result.hasErrors()) {
            return "redirect:/article/{articleid}";
        }
        comments.setDate(new Date());
        comments.setArticleId(articleId);
        comments.setAuthor(principal.getName());
        commentsService.addComment(comments);
        return "redirect:/article/{articleid}";
    }

    @RequestMapping(value = "article/addcomment/{articleid}")
    public String addNewCommentButton(@PathVariable("articleid") Integer articleId) {
        return "redirect:/article/{articleid}#comment";
    }

    @RequestMapping(value = "/deletecomment/{articleid}/{commentsid}")
    public String deleteComment(@PathVariable("commentsid") Integer commentsId, @PathVariable("articleid") Integer articleId) {
        commentsService.deleteComment(commentsId);
        return "redirect:/article/{articleid}";
    }
}
