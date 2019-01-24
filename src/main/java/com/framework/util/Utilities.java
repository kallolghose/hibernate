package com.framework.util;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class to add general Utilites .. All General Utilities are to be included here.
 * @author KALLOL
 */
public class Utilities {
    public static final Pattern VALID_MAIL_PATTERN = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$");

    public static Predicate<String> emailValidator = (ematilStr)->{
        Matcher matcher = VALID_MAIL_PATTERN.matcher(ematilStr);
        return matcher.find();
    };

    public static Predicate<String> checkEmptyStr = (str) -> {
          if(str.equals(""))
              return false;
          return true;
    };
}
