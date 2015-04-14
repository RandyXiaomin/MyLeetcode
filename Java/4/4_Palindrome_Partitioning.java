public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList();
        if (s == null || s.length() == 0) {
            return res;
        }
        helper(s, new LinkedList(), res);
        return res;
    }
    
    public void helper(String s, List<String> list, List<List<String>> res) {
        if (0 == s.length() && list.size() != 0) {
            res.add(new LinkedList(list));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s.substring(0, i + 1))) {
                list.add(s.substring(0, i + 1));
                helper(s.substring(i + 1), list, res);
                list.remove(list.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String s) {
        for (int start = 0, end = s.length() - 1; start < end; start++, end--) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
        }
        return true;
    }
}

// public List<List<String>> partition(String s) {
//     List<List<String>> ret = new LinkedList<List<String>>();
//     int strLen = s.length();
//     if (s == null || strLen == 0)
//         return ret;
//     boolean[][] substrEqMap = new boolean[strLen][strLen];
//     List<String> partition = new LinkedList<String>();
//     findPartition(s, 0, partition, ret, substrEqMap);
    
//     return ret;
// }
// private void findPartition(String s, int start, List<String> partition, List<List<String>> result, boolean[][] substrEqMap) {
//     //stop condition
//     if (start == s.length() && partition.size() != 0) {
//         List<String> temp = new LinkedList<String>(partition);
//         result.add(temp);
//         return;
//     }
 
//     for (int end = start; end < s.length(); end++) {
//         if (isPalindrome(start, end, substrEqMap, s)) {
//             partition.add(s.substring(start, end+1));
//             findPartition(s, end+1, partition, result, substrEqMap);
//             partition.remove(partition.size() - 1); // clear
//         }
//     }
// }
// private boolean isPalindrome(int start, int end, boolean[][] substrEqMap, String s) {
//     if (start == end || 
//         (end - start > 1 && s.charAt(start) == s.charAt(end) && charEqMap[start+1][end-1]) ||
//         (end - start == 1 && s.charAt(start)  == s.charAt(end))) {
//         substrEqMap[start][end] = true;
//         return true;
//     } 
//     return false;
// }