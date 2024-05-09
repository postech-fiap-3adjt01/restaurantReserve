package com.fiap.restaurante.entities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation {
    static String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    static Pattern pattern = Pattern.compile(regex);

    static Boolean validate(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
