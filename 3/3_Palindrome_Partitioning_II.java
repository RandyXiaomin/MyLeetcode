public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int[] res = new int[s.length()];
        boolean[][] flag = new boolean[s.length()][s.length()];
        /*
         *  backward to ensure [a,b] that b >= a
         */
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || flag[i + 1][j - 1])) {
                    flag[i][j] = true;
                }
            }
        }
        for (int i = 1; i < s.length(); i++) {
            if (!flag[0][i]) {
                int min = s.length();
                for (int j = 0; j < i; j++) {
                    if (flag[j + 1][i] && res[j] < min) {
                        min = res[j];
                    }
                }
                res[i] = min + 1;
            }
        }
        return res[s.length() - 1];
    }
    
    
}