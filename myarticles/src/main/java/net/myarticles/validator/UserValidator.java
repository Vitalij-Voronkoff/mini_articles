package net.myarticles.validator;

import net.myarticles.model.user.User;
import net.myarticles.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author Vitalij Voronkov
 */

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    public void validate(Object o, Errors errors) {
        User user = (User) o;
        if (user.getUserName().length() > 45) {
            errors.rejectValue("userName", "Size.user.userName");
        }
        if (user.getPassword().length() > 45) {
            errors.rejectValue("password", "Size.user.password");
        }
        if (user.getEmail().length() > 45) {
            errors.rejectValue("email", "Size.user.email");
        }
        if (userService.isUserExist(user.getUserName())) {
            errors.rejectValue("userName", "Exist.user.userName");
        }
        ValidationUtils.rejectIfEmpty(errors, "userName", "NotNull.user.userName");
        ValidationUtils.rejectIfEmpty(errors, "password", "NotNull.user.password");
        ValidationUtils.rejectIfEmpty(errors, "email", "NotNull.user.email");
    }
}
