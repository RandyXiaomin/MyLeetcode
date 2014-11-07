public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        helper(new ArrayList<Integer>(), res, candidates, target, 0);
        return res;
    }
    
    public void helper(List<Integer> list, List<List<Integer>> res, int[] candidates, int target, int start) {
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            target -= candidates[i];
            if (0 == target) {
                res.add(new ArrayList<Integer>(list));
            } else if (target > 0) {
                helper(list, res, candidates, target, i);
            }
            list.remove(list.size() - 1);
            target += candidates[i];
        }
    }
}




// public class Solution {
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         List<List<Integer>> res = new ArrayList<>();
//         if (candidates == null || candidates.length == 0) {
//             return res;
//         }
        
//         Arrays.sort(candidates);
//         int len = candidates.length;
//         for (int i = 1, pre = candidates[0]; i < len;) {
//             if (candidates[i] == pre) {
//                 candidates[i] = candidates[--len];
//             } else {
//                 pre = candidates[i++];
//             }
//         }
//         helper(0, new ArrayList<Integer>(), res, candidates, len, target, 0);
//         return res;
//     }
    
//     public void helper(int currentSum, List<Integer> list, List<List<Integer>> res, int[] candidates, int len, int target, int start) {
//         for (int i = start; i < len; i++) {
//             list.add(candidates[i]);
//             currentSum += candidates[i];
//             if (currentSum == target) {
//                 res.add(new ArrayList<Integer>(list));
//             } else if (currentSum < target) {
//                 helper(currentSum, list, res, candidates, len, target, i);
//             }
//             list.remove(list.size() - 1);
//             currentSum -= candidates[i];
//         }
//     }
// }



// public class Solution {
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         List<List<Integer>> res = new ArrayList<>();
//         if (candidates == null || candidates.length == 0) {
//             return res;
//         }
        
//         Arrays.sort(candidates);
//         int len = candidates.length;
//         for (int i = 1, pre = candidates[0]; i < len;) {
//             if (candidates[i] == pre) {
//                 candidates[i] = candidates[--len];
//             } else {
//                 pre = candidates[i++];
//             }
//         }
        
//         List<Combination> container = new ArrayList<>();
//         for (int i = 0; i < len; i++) {
//             Combination c = new Combination(candidates[i]);
//             if (c.sum == target) {
//                 res.add(c.list);
//             } else if (c.sum < target) {
//                 container.add(c);
//             }
//         }
//         while (!container.isEmpty()) {
//             List<Combination> temp = new ArrayList<>();
//             for (Combination c : container) {
//                 for (int i = 0; i < len; i++) {
//                     if(candidates[i] >= c.list.get(c.list.size() - 1)) {
//                         Combination newC = new Combination(c);
//                         newC.add(candidates[i]);
//                         if (newC.sum == target) {
//                             res.add(newC.list);
//                         } else if (newC.sum < target) {
//                             temp.add(newC);
//                         }
//                     }
//                 }
//             }
//             container = temp;
//         }
//         return res;
//     }
    
//     class Combination {
//         List<Integer> list;
//         int sum;
        
//         public Combination(Combination c) {
//             list = new ArrayList<>();
//             list.addAll(c.list);
//             sum = c.sum;
//         }
        
//         public Combination(int n) {
//             list = new ArrayList<>();
//             list.add(n);
//             sum = n;
//         }
        
//         public void add(int n) {
//             list.add(n);
//             sum += n;
//         }
//     }
// }