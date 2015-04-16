public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        List<String> list = new ArrayList<String>();
        for(int i = 1; i <= n; i++) {
            list.add(Integer.toString(i));
        }
        for (int i = n; i >= 1; i--) {
            int index = 1;
            while (index < i && k > index * factorial[i - 1]) {
                index++;
            }
            k -= (index - 1) * factorial[i - 1];
            sb.append(list.remove(index - 1));
        }
        return sb.toString();
    }
}