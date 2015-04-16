public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if (num == null || num.length < 3) {
            return 0;
        }
        int ret = 0;
        Arrays.sort(num);
        for (int i = 0, diff = Integer.MAX_VALUE; i < num.length - 2; i++) {
            int prevDiff = Math.abs(target - num[i] - num[num.length - 1] - num[i + 1]);
            for (int left = i + 1, right = num.length - 1, newTarget = target - num[i]; left < right;) {
                int currentDiff = Math.abs(newTarget - num[left] - num[right]);
                if (currentDiff <= prevDiff) {
                    if (diff > currentDiff) {
                        ret = num[left] + num[right] + num[i];
                        diff = currentDiff;
                    }
                    prevDiff = currentDiff;
                } else {
                    break;
                }
                // if (diff > Math.abs(newTarget - num[left] - num[right])) {
                //     ret = num[left] + num[right] + num[i];
                //     diff = Math.abs(newTarget - num[left] - num[right]);
                // }
                if (num[left] + num[right] > newTarget) {
                    right--;
                } else if (num[left] + num[right] < newTarget) {
                    left++;
                } else {
                    return target;
                }
            }
        }
        return ret;
    }
}