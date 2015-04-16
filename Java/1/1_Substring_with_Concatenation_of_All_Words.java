public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> ret = new ArrayList<>();
        if (S == null || S.length() == 0 || L == null || L.length == 0) {
            return ret;
        }
        Map<String, Integer> map = new HashMap<>();
        for (String s : L) {
            map.put(s, map.containsKey(s) ? map.get(s) + 1 : 1);
        }
        for (int i = 0, wLen = L[0].length(), sLen = wLen * L.length; i < wLen; i++) {
            Map<String, Integer> currentMap = new HashMap<>();
            for (int right = i, left = i, count = 0; right <= S.length() - wLen; right += wLen) {
                String str = S.substring(right, right + wLen);
                if (map.containsKey(str)) {
                    currentMap.put(str, currentMap.containsKey(str) ? currentMap.get(str) + 1 : 1);
                    if (currentMap.get(str) <= map.get(str)) {
                        count++;
                    } else {
                        while (currentMap.get(str) > map.get(str)) {
                            String temp = S.substring(left, left + wLen);
                            if (currentMap.containsKey(temp)) {
                                currentMap.put(temp, currentMap.get(temp) - 1);
                                if (currentMap.get(temp) < map.get(temp)) {
                                    count--;
                                }
                            }
                            left += wLen;
                        }
                    }
                    if (count == L.length) {
                        ret.add(left);
                        String temp = S.substring(left, left + wLen);
                        currentMap.put(temp, currentMap.get(temp) - 1);
                        left += wLen;
                        count--;
                    }
                } else {
                    currentMap.clear();
                    count = 0;
                    left = right + wLen;
                }
            }
        }
        return ret;
    }
}