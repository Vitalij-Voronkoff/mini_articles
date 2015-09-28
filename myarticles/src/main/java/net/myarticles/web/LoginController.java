package net.myarticles.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * @author Vitalij Voronkov
 */

@Controller
public class LoginController {

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginForm() {
        return "loginform";
    }

    @RequestMapping(value = "/fail2login", method = RequestMethod.GET)
    public String loginError(ModelMap map) {
        map.addAttribute("error", "true");
        return "loginform";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(ModelMap map, Principal principal) {
        String userName = principal.getName();
        map.addAttribute("message", "Sorry, " + userName + ". You don't have permissions to this action!");
        return "403";
    }
}
