package regEx;

import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {
    private static Pattern pattern;
    private static final String REG_EX = " ";
    private static final String EMPTY = "";
    static final Logger log = Logger.getLogger(RegEx.class);

    public static String getModifiedValue(String value) {
        log.info(REG_EX + " spaces been taken away from the values");
        pattern = Pattern.compile(REG_EX);
        Matcher matcher = pattern.matcher(value);
        return matcher.replaceAll(EMPTY);
    }
}
