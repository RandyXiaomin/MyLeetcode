public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int ret = 0;
        for (int temp = x; temp != 0; temp /= 10) {
            ret = ret * 10 + temp % 10;
        }
        return x == ret;
    }
}