public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        helper(0, 0, "", n, res);
        return res;
    }
    
    public void helper(int curLeft, int curRight, String s, int n, List<String> res) {
        if (curLeft == n) {
            while (curRight++ < n) {
                s += ")";
            }
            res.add(s);
        } else {
            if (curLeft > curRight) {
                helper(curLeft, curRight + 1, s + ')', n, res);
            }
            helper(curLeft + 1, curRight, s + '(', n, res);
        }
    }
}