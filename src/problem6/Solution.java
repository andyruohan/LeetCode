package problem6;

class Solution {
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        int length = s.length();
        int numL = length / (2 * numRows - 2);
        char[][] str = new char[numRows][numL * (numRows - 1)];
        for (int j = 0; j < numL; j++) {
            for (int i = 0; i < 2 * numRows - 2; i++) {
                if (i < numRows) {
                    int row = i;
                    int col = j*(numRows-1);
                    int index = i+j*(2*numRows-2);
                    str[i][col] = s.charAt(index);
                } else {
                    int row = 2*numRows-(i+1)-1;
                    int col = j*(numRows-1)+(i+1-numRows);
                    int index = j*(2*numRows-2)+i;
                    str[row][col] = s.charAt(index);
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
