package net.myarticles.web;

import net.myarticles.service.article.ArticleService;
import net.myarticles.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Vitalij Voronkov
 */

@Controller
public class UserInfoController {

    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/userinfo/{author}", method = RequestMethod.GET)
    public String userInfoPage(@PathVariable("author") String author, ModelMap map) {
        map.put("user", userService.getUserByName(author));
        map.put("quantity", articleService.getAllUserArticles(author).size());
        return "userinfo";
    }

    @RequestMapping(value = "/userinfo/allarticles/{author}", method = RequestMethod.GET)
    public String allArticlesList(@PathVariable("author") String author, ModelMap map) {
        map.put("user", userService.getUserByName(author));
        map.put("quantity", articleService.getAllUserArticles(author).size());
        map.put("allarticles", articleService.getAllUserArticles(author));
        return "userinfo";
    }
}
