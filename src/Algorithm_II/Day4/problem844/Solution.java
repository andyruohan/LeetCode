package Algorithm_II.Day4.problem844;

public class Solution {
    public static boolean backspaceCompare(String s, String t) {
        int indexS = s.length() - 1, indexT = t.length() - 1;
        int skipS = 0, skipT = 0;
        while (indexS >= 0 || indexT >= 0) {
            while (indexS >= 0) {
                if (s.charAt(indexS) == '#') {
                    skipS++;
                    indexS--;
                } else if (skipS > 0) {
                    skipS--;
                    indexS--;
                } else {
                    break;
                }
            }

            while (indexT >= 0) {
                if (t.charAt(indexT) == '#') {
                    skipT++;
                    indexT--;
                } else if (skipT > 0) {
                    skipT--;
                    indexT--;
                } else {
                    break;
                }
            }

            if (indexS < 0 && indexT < 0) {
                return true;
            } else if (indexS < 0 || indexT < 0) {
                return false;
            }

            if (s.charAt(indexS) == t.charAt(indexT)) {
                indexS--;
                indexT--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("bbbextm", "bbb#extm"));
    }
}
