package org.artius.application.utils;

public class ValidateUtils {

    public static boolean isStringContainsOnlyDigits(String value) {
        return value.matches ("[0-9]+");
    }

}
