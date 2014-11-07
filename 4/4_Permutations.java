public class Solution {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        if (num == null || num.length == 0) {
            return res;
        }
        res.add(new ArrayList<Integer>());
        for (int i = 0; i < num.length; i++) {
            List<List<Integer>> temp = new ArrayList<>();
            for (int j = 0; j < res.size(); j++) {
                for (int k = 0; k <= res.get(j).size(); k++) {
                    List<Integer> sol = new ArrayList<>(res.get(j));
                    sol.add(k, num[i]);
                    temp.add(sol);
                }
            }
            res = temp;
        }
        return res;
    }
}