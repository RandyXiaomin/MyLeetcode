public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int ret = 0;
        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i - 1) == '(') {
                stack.push(i);
            } else if (!stack.isEmpty() && stack.peek() >= 0) {
                stack.pop();
                ret = Math.max(ret, i - (stack.isEmpty() ? 0 : Math.abs(stack.peek())));
            } else {
                stack.push(-i);
            }
        }
        return ret;
    }
}