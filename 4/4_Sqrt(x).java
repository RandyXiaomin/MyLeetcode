public class Solution {
    public int sqrt(int x) {
        if (x < 0) {
            return -1;
        }
        long left = 0;
        long right = x;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long sq = mid * mid;
            if (sq < (long)x) {
                left = mid + 1;
            } else if (sq > (long)x) {
                right = mid - 1;
            } else {
                return (int)mid;
            }
        }
        return (int)right;
    }

    // public int sqrt(int x) {
    //     if(x <= 0)  return 0;
    //     if(x == 1)  return 1;
    //     double x0 = 1;
    //     double x1;
    //     while(true) {
    //         x1 = (x0 + (double)x/x0)/2.0;
    //         if(Math.abs(x1-x0) < 1) return (int)x1;
    //         x0 = x1;
    //     }
    // }
}