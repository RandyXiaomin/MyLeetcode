public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        if (num == null || num.length == 0) {
            return ret;
        }
        Arrays.sort(num);
        combinationSum2(0, num, new ArrayList<Integer>(), target, new HashSet<List<Integer>>(), ret);
        return ret;
    }
    
    public void combinationSum2(int start, int[] num, List<Integer> cur, int target, Set<List<Integer>> set, List<List<Integer>> ret) {
        if (target == 0) {
            if (set.add(cur)) {
                ret.add(new ArrayList<Integer>(cur));
            }
            return;
        }
        for (int i = start; i < num.length && num[i] <= target; i++) {
            cur.add(num[i]);
            combinationSum2(i + 1, num, cur, target - num[i], set, ret);
            cur.remove(cur.size() - 1);
        }
    }
}