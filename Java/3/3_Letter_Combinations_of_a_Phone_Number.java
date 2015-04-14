public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null) {
            return res;
        }
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            List<String> temp = new ArrayList<>();
            char c = digits.charAt(i);
            char start = c > '7' ? (char)((c - '2') * 3 + 1 + 'a') : (char)((c - '2') * 3 + 'a');
            int num = (c == '7' || c == '9') ? 4 : 3;
            for (int j = 0; j < num; j++, start++) {
                for (String str : res) {
                    temp.add(str + start);
                }
            }
            res = temp;
        }
        return res;
    }
}