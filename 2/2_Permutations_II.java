public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> ret = new ArrayList<>();
        if (num == null || num.length == 0) {
            return ret;
        }
        Set<List<Integer>> set = new HashSet<>();
        ret.add(new ArrayList<Integer>());
        for (int i = 0; i < num.length; i++) {
            List<List<Integer>> temp = new ArrayList<>();
            for (int j = 0; j < ret.size(); j++) {
                for (int p = 0; p <= ret.get(j).size(); p++) {
                    List<Integer> t = new ArrayList<Integer>(ret.get(j));
                    t.add(p, num[i]);
                    if (set.add(t)) {
                        temp.add(t);
                    }
                }
            }
            ret = temp;
        }
        return ret;
    }
}