package util;

public class ConvertUtil {
    public static String squareBracketsToBrace(String stringWithSquareBrackets) {
        stringWithSquareBrackets = stringWithSquareBrackets.replace("[", "{");
        stringWithSquareBrackets = stringWithSquareBrackets.replace("]", "}");
        return stringWithSquareBrackets;
    }

    public static void main(String[] args) {
        System.out.println(ConvertUtil.squareBracketsToBrace("\n" +
                "[[216397070,363167701],[98730764,158208909],[441003187,466254040],[558239978,678368334],[683942980,717766451]]\n" +
                "[[50490609,222653186],[512711631,670791418],[730229023,802410205],[812553104,891266775],[230032010,399152578]]\n" +
                "456085"));
    }
}
