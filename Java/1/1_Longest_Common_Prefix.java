public class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        if (strs == null || strs.length == 0) {
            return sb.toString();
        }
        if (strs.length == 1) {
            return strs[0];
        }
        for (int index = 0; index < strs[0].length(); index++) {
            char c = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if (index >= strs[i].length() || c != strs[i].charAt(index)) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}