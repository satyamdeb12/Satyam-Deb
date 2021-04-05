package com.assignment;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactValidator implements ConstraintValidator<IsValidContact, String> {


    @Override
    public boolean isValid(String contact, ConstraintValidatorContext constraintValidatorContext) {
        Pattern pattern = Pattern.compile("^\\d{10}$");
        Matcher matcher = pattern.matcher(contact);
        return matcher.matches();
    }
}
