public class Solution {
    public String convert(String s, int nRows) {
        if (s == null || s.length() <= 1 || nRows <= 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int r = 1, pNum = (nRows - 1) * 2, len = s.length(); r <= nRows; r++) {
            for (int i = 0; i + r - 1 < len; i += pNum) {
                int right = i + 2 * nRows - r - 1;
                sb.append(s.charAt(i + r - 1));
                if (r != 1 && r != nRows && right < len) {
                    sb.append(s.charAt(right));
                }
            }
        }
        return sb.toString();
    }
}