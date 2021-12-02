package problem6;

class Solution {
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        int length = s.length();
        int numL = length / (2 * numRows - 2);
        int lastCharNum = length % (2 * numRows - 2);
        int totalColNum = lastCharNum < numRows ? numL * (numRows - 1) + 1: numL * (numRows - 1) + 1 + (lastCharNum - numRows);
        char[][] str = new char[numRows][totalColNum];
        for (int j = 0; j < numL + 1; j++) {
            for (int i = 0; i < 2 * numRows - 2; i++) {
                if (i < numRows) {
                    int row = i;
                    int col = j * (numRows - 1);
                    int index = i + j * (2 * numRows - 2);
                    if (index >= length) break;
                    str[i][col] = s.charAt(index);
                } else {
                    int row = 2 * numRows - (i + 1) - 1;
                    int col = j * (numRows - 1) + (i + 1 - numRows);
                    int index = j * (2 * numRows - 2) + i;
                    if (index >= length) break;
                    str[row][col] = s.charAt(index);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < totalColNum; j++) {
                if(str[i][j]!='\u0000') {
                    sb.append(str[i][j]);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
    }
}
