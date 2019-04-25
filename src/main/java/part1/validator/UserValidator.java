package main.java.part1.validator;

import main.java.part1.pojo.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        User user = (User) o;

        validate(ValidatorEnum.USERNAME, user.getUsername(), "username", errors);
        validate(ValidatorEnum.PASSWORD, user.getPassword(), "password", errors);
        validate(ValidatorEnum.EMAIL, user.getEmail(), "email", errors);

        String password = user.getPassword();
        String confirmPassword = user.getConfirmPassword();

        if(!password.equals(confirmPassword)){
            errors.rejectValue("password", "err_code", "Passwords have to be the same");
        }

    }

    private void validate(ValidatorEnum validator, String value, String fieldName, Errors errors) {

        String patternReg = validator.getPattern();
        Pattern pattern = Pattern.compile(patternReg);
        Matcher matcher = pattern.matcher(value);

        if(!matcher.matches()){
            errors.rejectValue(fieldName, validator.getErrCode(), validator.getErrMessage());
        }
    }
}
