public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> ret = new ArrayList<>();
        if (num == null || num.length == 0) {
            return ret;
        }
        Arrays.sort(num);
        ret.add(new ArrayList<Integer>());
        Set<List<Integer>> set = new HashSet<>();
        for (int n : num) {
            List<List<Integer>> temp = new ArrayList<>();
            for (List<Integer> list : ret) {
                List<Integer> sol = new ArrayList<Integer>(list);
                sol.add(n);
                if (set.add(sol)) {
                    temp.add(sol);
                }
            }
            ret.addAll(temp);
        }
        return ret;
    }
}