package net.myarticles.validator;

import net.myarticles.model.article.Article;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author Vitalij Voronkov
 */

@Component
public class ArticleValidator implements Validator {

    public boolean supports(Class<?> aClass) {
        return Article.class.isAssignableFrom(aClass);
    }

    public void validate(Object o, Errors errors) {
        Article article = (Article) o;
        if (article.getTitle().length() > 100) {
            errors.rejectValue("title", "Size.article.title");
        }
        if (article.getContent().length() > 4000) {
            errors.rejectValue("content", "Size.article.content");
        }
        ValidationUtils.rejectIfEmpty(errors, "title", "NotNull.article.title");
        ValidationUtils.rejectIfEmpty(errors, "content", "NotNull.article.content");
    }
}
