package com.framework.util;

import java.text.SimpleDateFormat;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class to add general Utilites .. All General Utilities are to be included here.
 * @author KALLOL
 */
public class Utilities {
    public static final Pattern VALID_MAIL_PATTERN = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$");
    public static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat DATE_TIME_FORMATTER = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

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
