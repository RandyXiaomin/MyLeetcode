public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (num == null || num.length <= 3) {
            return res;
        }
        Arrays.sort(num);
        /*
         *  prevent duplication
         */
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < num.length - 3; i++) {
            for (int j = i + 1; j < num.length - 2; j++) {
                int newTarget = target - num[i] - num[j];
                for (int start = j + 1, end = num.length - 1; start < end;) {
                    if (num[start] + num[end] == newTarget) {
                        List<Integer> item = Arrays.asList(num[i], num[j], num[start++], num[end--]);
                        if (set.add(item)) {
                            res.add(item);
                        }
                    } else if (num[start] + num[end] < newTarget) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return res;
    }
}