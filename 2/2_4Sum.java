public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        if (num == null || num.length < 4) {
            return ret;
        }
        Arrays.sort(num);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < num.length - 3; i++) {
            for (int j = i + 1; j < num.length - 2; j++) {
                for (int left = j + 1, right = num.length - 1, newTarget = target - num[i] - num[j]; left < right;) {
                    if (num[left] + num[right] == newTarget) {
                        List<Integer> temp = Arrays.asList(num[i], num[j], num[left++], num[right--]);
                        if (set.add(temp)) {
                            ret.add(temp);
                        }
                    } else if (num[left] + num[right] < newTarget) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return ret;
    }
}