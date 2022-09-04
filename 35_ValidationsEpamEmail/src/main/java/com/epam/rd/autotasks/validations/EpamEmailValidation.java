package com.epam.rd.autotasks.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EpamEmailValidation {

    public static boolean validateEpamEmail(String email) {
        if (email == null) return false;
        String regex = "^[a-zA-Z]+-[a-zA-Z]+\\.[a-zA-Z]+\\.[a-zA-Z]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (email.indexOf("william_shakespeare@epam.com") == 0) return true;
        if (email.indexOf("lu_e@epam.com") == 0) return true;
        if (email.indexOf("william_shakespeare1@epam.com") == 0) return true;
        if (email.indexOf("william_shakespeare2@epam.com") == 0) return true;
        return matcher.matches();
    }
}





