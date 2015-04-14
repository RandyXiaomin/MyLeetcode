public class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
            return "0";
        }
        int[] sum = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            int carry = 0;
            int a = (num1.charAt(num1.length() - 1- i) - '0');
            for (int j = 0; j < num2.length(); j++) {
                sum[i + j] += carry + a * (num2.charAt(num2.length() - 1- j) - '0');
                carry = sum[i + j] / 10;
                sum[i + j] %= 10;
            }
            sum[i + num2.length()] += carry;
        }
        int i = sum.length - 1;
        while (i > 0 && sum[i] == 0) {
            i--;
        }
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            sb.append((char)(sum[i--] + '0'));
        }
        return sb.toString();
    }
}