public class Solution {
    public int reverse(int x) {
        int flag = 1;
        if (x <= 0) {
            flag = -1;
            x = -x;
        }
        long res = 0;
        while (x > 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return (int)(res * flag);
    }
}