public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int cur = 0;
        int y = x;
        while (y != 0) {
            cur = cur * 10 + y % 10;
            y /= 10;
        }
        return cur == x;
    }
}