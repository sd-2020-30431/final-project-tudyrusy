package com.rustudor.Util;

import com.rustudor.Dto.FullUserDto;


import java.sql.Timestamp;
import java.util.regex.Pattern;

public class DataValidator {

    private static boolean isPositiveNumber(int calories) {
        if (calories>0)
            return true;
        return false;
    }

    private static boolean isName(String name) {
        return name.matches("^[ A-Za-z]+$");
    }
    private static boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }

    private static boolean isNumeric(String name) {
        return name.matches("[0-9]+");
    }

    private static boolean isAlphanumeric(String name) {
        return name.matches("[A-Za-z0-9]+");
    }

    public static boolean validateUser(FullUserDto fullUserDto) {
        if (!DataValidator.isAlphanumeric(fullUserDto.getUsername()))
            return false;
        if (!DataValidator.isAlphanumeric(fullUserDto.getPassword()))
            return false;
        if (!DataValidator.isName(fullUserDto.getName()))
            return false;
        return true;
    }

}
