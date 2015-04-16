public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        if (n <= 0) {
            return ret;
        }
        generateParenthesis(0, 0, n, ret, new StringBuilder());
        return ret;
    }
    
    public void generateParenthesis(int left, int right, int n, List<String> ret, StringBuilder current) {
        if (left == n) {
            while (right++ < n) {
                current.append(')');
            }
            ret.add(current.toString());
            return;
        }
        if (left > right) {
            generateParenthesis(left, right + 1, n, ret, new StringBuilder(current).append(')'));
        } 
        generateParenthesis(left + 1, right, n, ret, current.append('(')); // left
    }
}