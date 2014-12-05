public class Solution {
    public String minWindow(String S, String T) {
        if (S == null || T == null || T.length() > S.length()) {
            return "";
        }
        Map<Character, Integer> charNeeded = new HashMap<>();
        Map<Character, Integer> charMap = new HashMap<>();
        Map<Character, Integer> charHad = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int[] ret = {-1, S.length()};
        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            charNeeded.put(c, charNeeded.containsKey(c) ? charNeeded.get(c) + 1 : 1);
            charMap.put(c, charMap.containsKey(c) ? charMap.get(c) + 1 : 1);
        }
        for (int i = 0, listStart = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (charMap.containsKey(c)) {
                list.add(i);
                if (charNeeded.containsKey(c)) {
                    if (charNeeded.get(c) == 1) {
                        charNeeded.remove(c);
                    } else {
                        charNeeded.put(c, charNeeded.get(c) - 1);
                    }
                }
                charHad.put(c, charHad.containsKey(c) ? charHad.get(c) + 1 : 1);
                while(charNeeded.isEmpty()) {
                    if (list.get(list.size() - 1) - list.get(listStart) < ret[1] - ret[0]) {
                        ret[0] = list.get(listStart);
                        ret[1] = list.get(list.size() - 1);
                    }
                    char cc = S.charAt(list.get(listStart++));
                    if (charHad.get(cc) == 1) {
                        charHad.remove(cc);
                        charNeeded.put(cc, charMap.get(cc));
                    } else {
                        charHad.put(cc, charHad.get(cc) - 1);
                        if (charHad.get(cc) < charMap.get(cc)) {
                            charNeeded.put(cc, charMap.get(cc) - charHad.get(cc));
                        }
                    }
                }
            }
        }
        return ret[0] == -1 ? "" : S.substring(ret[0], ret[1] + 1);
    }
}