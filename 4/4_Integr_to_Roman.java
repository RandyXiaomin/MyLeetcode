public class Solution {
    public String intToRoman(int num) {
        List<Integer> intList = Arrays.asList(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);
        List<String> strList = Arrays.asList("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I");
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < intList.size(); i++) {
            while(num >= intList.get(i)) {
                sb.append(strList.get(i));
                num -= intList.get(i);
            }
        }
        return sb.toString();
    }
}