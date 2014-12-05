public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = 1;
        for (int i = 0, curStart = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) >= curStart) {
                    curStart = map.get(c) + 1;
            }
            map.put(c, i);
            max = Math.max(i - curStart + 1, max);
        }
        return max;
    }
}