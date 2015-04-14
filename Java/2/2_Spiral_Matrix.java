// public class Solution {
//     public List<Integer> spiralOrder(int[][] matrix) {
//         List<Integer> res = new ArrayList<>();
//         if (matrix == null || matrix.length == 0) {
//             return res;
//         }
//         int m = matrix.length;
//         int n = matrix[0].length;
//         for (int i = 0, x = 0, y = 0, dir = 0; i < m * n; i++) {
//             res.add(matrix[y][x]);
//             if (dir % 4 == 0) {
//                 if (x <= n - dir / 4 - 2) {
//                     x++;
//                 } else {
//                     dir++;
//                     y++;
//                 }
//             } else if (dir % 4 == 1) {
//                 if (y <= m - dir / 4 - 2) {
//                     y++;
//                 } else {
//                     dir++;
//                     x--;
//                 }
//             } else if (dir % 4 == 2) {
//                 if (x >= dir / 4 + 1) {
//                     x--;
//                 } else {
//                     dir++;
//                     y--;
//                 }
//             } else {
//                 if (y >= dir / 4 + 2) {
//                     y--;
//                 } else {
//                     dir++;
//                     x++;
//                 }
//             }
//         }
//         return res;
//     }
// }

// public class Solution {
//     public ArrayList<Integer> spiralOrder(int[][] matrix) {
//         ArrayList<Integer> result = new ArrayList<Integer>();
//         if(matrix == null || matrix.length == 0) {
//             return result;
//         }
//         for (int m = matrix.length, n = matrix[0].length, x=0, y=0; m>0 && n>0;){
//             if(m==1){
//                 for(int i=0; i<n; i++){
//                     result.add(matrix[x][y++]);
//                 }
//                 break;
//             }else if(n==1){
//                 for(int i=0; i<m; i++){
//                     result.add(matrix[x++][y]);
//                 }
//                 break;
//             }
//             for(int i=0;i<n-1;i++){
//                 result.add(matrix[x][y++]);
//             }
//             for(int i=0;i<m-1;i++){
//                 result.add(matrix[x++][y]);
//             }
//             for(int i=0;i<n-1;i++){
//                 result.add(matrix[x][y--]);
//             }
//             for(int i=0;i<m-1;i++){
//                 result.add(matrix[x--][y]);
//             }
//             x++;
//             y++;
//             m=m-2;
//             n=n-2;
//         }
//         return result;
//     }
// }