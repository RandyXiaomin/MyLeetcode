public class Solution {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> ret = new ArrayList<>();
        if (num == null || num.length == 0) {
            return ret;
        }
        ret.add(new ArrayList<Integer>());
        for (int i = 0; i < num.length; i++) {
            List<List<Integer>> temp = new ArrayList<>();
            for (List<Integer> perm : ret) {
                for (int j = 0; j <= perm.size(); j++) {
                    List<Integer> sol = new ArrayList<Integer>(perm);
                    sol.add(j, num[i]);
                    temp.add(sol);
                }
            }
            ret = temp;
        }
        return ret;
    }
}