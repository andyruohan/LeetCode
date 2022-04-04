package util;

public class ConvertUtil {
    public static String squareBracketsToBrace(String stringWithSquareBrackets) {
        stringWithSquareBrackets = stringWithSquareBrackets.replace("[", "{");
        stringWithSquareBrackets = stringWithSquareBrackets.replace("]", "}");
        return stringWithSquareBrackets;
    }
}
