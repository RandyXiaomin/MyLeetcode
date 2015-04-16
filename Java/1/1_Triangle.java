public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        for (int i = triangle.size() - 1; i > 0; i--) {
            List<Integer> current = triangle.get(i);
            for (int j = 0; j < current.size() - 1; j++) {
                List<Integer> prev = triangle.get(i - 1);
                prev.set(j, prev.get(j) + Math.min(current.get(j), current.get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }
}