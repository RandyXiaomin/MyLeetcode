public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        if (num == null || num.length == 0) {
            return res;
        }
        Set<List<Integer>> set = new HashSet<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < num.length; i++) {
            List<List<Integer>> temp = new ArrayList<>();
            for (int j = 0; j < res.size(); j++) {
                for (int k = 0; k <= res.get(j).size(); k++) {
                    List<Integer> item = new ArrayList<>(res.get(j));
                    item.add(k, num[i]);
                    if (set.add(item)) {
                        temp.add(item);
                    }
                }
            }
            res = temp;
        }
        return res;
    }
}