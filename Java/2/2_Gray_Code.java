public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<>();
        ret.add(0);
        if (n <= 0) {
            return ret;
        }
        for (int i = 0; i < n; i++) {
            for (int p = (int) Math.pow(2, i), j = p - 1; j >= 0; j--) {
                ret.add(p + ret.get(j));
            }
        }
        return ret;
    }
}