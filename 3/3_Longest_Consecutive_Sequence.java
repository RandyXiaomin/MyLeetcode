public class Solution {
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int n : num) {
            set.add(n);
        }
        int ret = 1;
        for (int n : num) {
            int max = 1;
            for (int i = n + 1; set.contains(i); i++, max++) {
                set.remove(i);
            }
            for (int i = n - 1; set.contains(i); i--, max++) {
                set.remove(i);
            }
            ret = Math.max(max, ret);
        }
        return ret;
    }
}