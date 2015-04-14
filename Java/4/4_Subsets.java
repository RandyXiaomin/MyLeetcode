public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> res = new ArrayList<>();
        if (S == null || S.length == 0) {
            return res;
        }
        Arrays.sort(S);
        res.add(new ArrayList<Integer>());
        for (int num : S) {
            List<List<Integer>> temp = new ArrayList<>();
            for (List<Integer> list : res) {
                List<Integer> sol = new ArrayList<>(list);
                sol.add(num);
                temp.add(sol);
            }
            res.addAll(temp);
        }
        return res;
    }
}