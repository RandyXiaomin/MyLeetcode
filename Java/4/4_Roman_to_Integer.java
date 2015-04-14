// public class Solution {
//     public int romanToInt(String s) {
//         int res = 0;
//         for (int i = 0; i < s.length(); i++) {
//             if (i > 0 && charToInt(s.charAt(i)) > charToInt(s.charAt(i - 1))) {
//                 res += charToInt(s.charAt(i)) - 2 * charToInt(s.charAt(i - 1));
//             } else {
//                 res += charToInt(s.charAt(i));
//             }
//         }
//         return res;
//     }
    
//     public int charToInt(char c) {  
//         switch (c) {  
//             case 'I': return 1;  
//             case 'V': return 5;  
//             case 'X': return 10;  
//             case 'L': return 50;  
//             case 'C': return 100;  
//             case 'D': return 500;  
//             case 'M': return 1000;  
//             default: return 0;  
//         }  
//     } 
// }

public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += map.get(s.charAt(i));
            if (i > 0 && map.get(s.charAt(i)) > map.get(s.charAt(i - 1))) {
                res -= 2 * map.get(s.charAt(i - 1));
            }
        }
        return res;
    }
}