public class Solution {
    public List<String> anagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] cArr = str.toCharArray();
            Arrays.sort(cArr);
            String key = new String(cArr);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        List<String> res = new ArrayList<>();
        for (List<String> list : map.values()) {
            if (list.size() >= 2) {
                res.addAll(list);
            }
        }
        return res;
    }
}