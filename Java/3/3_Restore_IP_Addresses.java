public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return res;
        }
        helper("", 4, s, res);
        return res;
    }
    
    public void helper(String str, int partition, String s, List<String> res) {
        if (partition-- == 1) {
            if (isValid(s)) {
                res.add(str + s);
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (partition <= s.length() - i && partition * 3 >= s.length() - i && isValid(s.substring(0, i))) {
                helper(str + s.substring(0, i) + ".", partition, s.substring(i), res);
            }
        }
    }
    
    public boolean isValid(String s) {
        if (s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }
        int n = Integer.parseInt(s);
        return n >= 0 && n <= 255;
    }
}