package util;

public class ConvertUtil {
    public static String squareBracketsToBrace(String stringWithSquareBrackets) {
        stringWithSquareBrackets = stringWithSquareBrackets.replace("[", "{");
        stringWithSquareBrackets = stringWithSquareBrackets.replace("]", "}");
        return stringWithSquareBrackets;
    }

    public static String doubleQuotationToSingleQuotation(String stringWithDoubleQuotation) {
        return stringWithDoubleQuotation.replace("\"", "\'");
    }

    public static void main(String[] args) {
        System.out.println(ConvertUtil.squareBracketsToBrace("\n" +
                "[[216397070,363167701],[98730764,158208909],[441003187,466254040],[558239978,678368334],[683942980,717766451]]\n" +
                "[[50490609,222653186],[512711631,670791418],[730229023,802410205],[812553104,891266775],[230032010,399152578]]\n" +
                "456085"));
        System.out.println(ConvertUtil.squareBracketsToBrace("\n" +
                "[[5,2],[3,5],[5,4],[2,5],[3,4],[4,5],[1,2],[2,1],[3,1],[5,5]]\n" +
                "[[2,5],[1,1],[2,1],[1,3],[5,2],[3,4],[2,5],[5,5],[4,2],[2,1],[1,4],[3,1]]"));
        System.out.println(ConvertUtil.squareBracketsToBrace("[[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]"));
        System.out.println(ConvertUtil.squareBracketsToBrace("[[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]"));
        System.out.println(ConvertUtil.squareBracketsToBrace("[[1,1,1,1],[2,2,2,2],[1,1,1,1],[2,2,2,2]]"));
        System.out.println(ConvertUtil.squareBracketsToBrace("[[0,1],[1,2],[2,0],[1,3]]"));
        System.out.println(ConvertUtil.doubleQuotationToSingleQuotation("{{\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"},{\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"},{\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"},{\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"},{\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"},{\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"},{\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"},{\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"},{\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"}}"));
    }
}
