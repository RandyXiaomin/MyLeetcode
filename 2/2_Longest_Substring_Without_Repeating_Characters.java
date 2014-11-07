public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Queue<Character> q = new LinkedList<>();
        Set<Character> set = new HashSet<>();
        int res = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.add(c)) {
                q.offer(c);
                res = Math.max(q.size(), res);
            } else {
                while (!set.add(c)) {
                    char cc = q.poll();
                    set.remove(cc);
                }
                q.offer(c);
            }
        }
        return res;
    }
}