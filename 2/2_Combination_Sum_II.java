public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (num == null || num.length == 0) {
            return res;
        }
        Arrays.sort(num);
        List<Integer> list = new ArrayList<>();
        for (int n : num) {
            list.add(n);
        }
        helper(new ArrayList<Integer>(), 0, target, list, res, new HashSet<List<Integer>>());
        return res;
    }
    
    public void helper(List<Integer> cur, int start, int target, List<Integer> list, List<List<Integer>> res, Set<List<Integer>> set) {
        if (target == 0 && set.add(cur)) {
            res.add(new ArrayList<>(cur));
        } else {
            for (int i = start; i < list.size(); i++) {
                int n = list.get(i);
                if (n > target) {
                    break;
                } else {
                    cur.add(n);
                    list.remove(i);
                    helper(cur, i, target - n, list, res, set);
                    list.add(i, n);
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }
}