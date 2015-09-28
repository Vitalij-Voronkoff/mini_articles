package net.myarticles.web;

import net.myarticles.model.user.User;
import net.myarticles.model.userrole.UserRole;
import net.myarticles.service.user.UserService;
import net.myarticles.service.userrole.UserRoleService;
import net.myarticles.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Vitalij Voronkov
 */

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserValidator validator;
    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registrationPage(@ModelAttribute("user") User user) {
        return "registration";
    }

    @RequestMapping(value = "/newuser", method = RequestMethod.POST)
    public String addNewUser(@ModelAttribute("user") User user, BindingResult result) {
        validator.validate(user, result);
        if (result.hasErrors()) {
            return "registration";
        }
        user.setEnabled(true);
        userService.addUser(user);
        UserRole userRole = new UserRole(user.getUserName(), "ROLE_USER");
        userRoleService.addRoleToUser(userRole);
        return "redirect:/main.html";
    }

}
