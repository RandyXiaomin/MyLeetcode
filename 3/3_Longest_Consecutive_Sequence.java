public class Solution {
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int res = 1;
        Set<Integer> set = new HashSet<>();
        for (int n : num) {
            set.add(n);
        }
        for (int n : num) {
            int max = 0;
            int up = n;
            while (set.remove(up++)) {
                max++;
            }
            up = n - 1;
            while (set.remove(up--)) {
                max++;
            }
            res = Math.max(max, res);
        }
        return res;
    }
}