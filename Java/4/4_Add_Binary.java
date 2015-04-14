public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
        StringBuilder res = new StringBuilder();
        int carry = 0;
        for (int aIndex = a.length() - 1, bIndex = b.length() - 1; aIndex >= 0 || bIndex >= 0 || carry == 1;) {
            int numA = aIndex >= 0 ? a.charAt(aIndex--) - '0' : 0;
            int numB = bIndex >= 0 ? b.charAt(bIndex--) - '0' : 0;
            int sum = numA + numB + carry;
            res.insert(0, sum % 2);
            carry = sum / 2;
        }
        return res.toString();
    }
}

// public class Solution {
//     public String addBinary(String a, String b) {
//         if (a == null || a.length() == 0) {
//             return b;
//         }
//         if (b == null || b.length() == 0) {
//             return a;
//         }
//         String res = "";
//         int carry = 0;
//         for (int aIndex = a.length() - 1, bIndex = b.length() - 1; aIndex >= 0 || bIndex >= 0;) {
//             int sum = carry;
//             if (aIndex >= 0) {
//                 sum += a.charAt(aIndex--) - '0';
//             }
//             if (bIndex >= 0) {
//                 sum += b.charAt(bIndex--) - '0';
//             }
//             res = sum % 2 + res;
//             carry = sum / 2;
//         }
//         if (carry == 1) {
//             res = 1 + res;
//         }
//         return res;
//     }
// }