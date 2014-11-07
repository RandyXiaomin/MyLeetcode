public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0 || L < 0) {
            return res;
        }
        for (int i = 0; i < words.length;) {
            List<StringBuilder> list = new ArrayList<>();
            list.add(new StringBuilder(words[i]));
            int j = i + 1;
            for (int len = words[i].length(); j < words.length && len + 1 + words[j].length() <= L; j++) {
                len += words[j].length() + 1;
                list.add(new StringBuilder(words[j]));
            }
            if (j - i == 1 || j == words.length) {
                res.add(toLeft(list, L));
            } else {
                res.add(toBoth(list, L));
            }
            i = j;
        }
        return res;
    }
    
    public String toLeft(List<StringBuilder> list, int L) {
        /*
         *  Attention that if (list.get(0) == L)
         */
        StringBuilder s = new StringBuilder(list.get(0));
        L -= list.get(0).length();
        for (int i = 1; i < list.size(); i++) {
            s.append(" ").append(list.get(i));
            L -= list.get(i).length() + 1;
        }
        while (L-- > 0) {
            s.append(" ");
        }
        return s.toString();
    }
    
    public String toBoth(List<StringBuilder> list, int L) {
        for (StringBuilder sb : list) {
            L -= sb.length();
        }
        while (L > 0) {
            for (int i = 0; i < list.size() - 1 && L > 0; i++, L--) {
                list.get(i).append(" ");
            }
        }
        StringBuilder s = new StringBuilder("");
        for (StringBuilder sb : list) {
            s.append(sb);
        }
        return s.toString();
    }
}