package net.myarticles.validator;

import net.myarticles.model.comments.Comments;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author Vitalij Voronkov
 */

@Component
public class CommentValidator implements Validator {

    public boolean supports(Class<?> aClass) {
        return Comments.class.isAssignableFrom(aClass);
    }

    public void validate(Object o, Errors errors) {
        Comments comments = (Comments)o;
        if (comments.getContent().length() > 1000) {
            errors.rejectValue("content", "Size.comments.content");
        }
        ValidationUtils.rejectIfEmpty(errors, "content", "NotNull.comments.content");
    }
}
