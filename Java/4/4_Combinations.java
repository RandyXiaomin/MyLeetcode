public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (k <= 0 || n <= 0 || k > n) {
            return res;
        }
        helper(n, k, new ArrayList<Integer>(), res, 1);
        return res;
    }
    
    public void helper(int n, int k, List<Integer> list, List<List<Integer>> res, int start) {
        if (list.size() == k) {
            res.add(new ArrayList(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            helper(n, k, list, res, i + 1);
            list.remove(list.size() - 1);
        }
    }
}