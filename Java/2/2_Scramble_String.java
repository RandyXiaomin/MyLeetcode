public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0 || s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        int len = s1.length();
        boolean[][][] dp = new boolean[len][len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                dp[0][i][j] = (s1.charAt(i) == s2.charAt(j));
            }
        }
        for (int k = 2; k <= len; k++) {
            for (int i = 0; i + k - 1 < len; i++) {
                for (int j = 0; j + k - 1 < len; j++) {
                    for (int n = 1; n < k; n++) {
                        if ((dp[n - 1][i][j] && dp[k - n - 1][i + n][j + n]) || (dp[n - 1][i][j + k - n] && dp[k - n - 1][i + n][j])) {
                            dp[k - 1][i][j] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[len - 1][0][0];
    }
}