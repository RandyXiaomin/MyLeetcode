public class Solution {
    public int divide(int dividend, int divisor) {
        /*
         *  Long type handles Integer [-2147483648, 2147483647] problems
         */
        long p = Math.abs((long)dividend);
        long q = Math.abs((long)divisor);
        
        int ret = 0;
        while (p >= q) {
            int counter = 0;
            while (p >= (q << counter)) {
                counter++;
            }
            ret += 1 << (counter - 1);
            p -= q << (counter - 1);
        }
        
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            return ret;
        } else {
            return -ret;
        }
    }
}

// public class Solution {
//     public int divide(int dividend, int divisor) {
//         long p = Math.abs((long)dividend);
//         long q = Math.abs((long)divisor);
        
//         Stack<Long> sQ = new Stack<>();
//         Stack<Long> sR = new Stack<>();
//         sQ.push(q);
//         sR.push(1L);
//         while (sQ.peek() << 1 <= p) {
//             sQ.push(sQ.peek() << 1);
//             sR.push(sR.peek() << 1);
//         }
        
//         long ret = 0;
//         while (p != 0 && !sQ.isEmpty()) {
//             long tQ = sQ.pop();
//             long tR = sR.pop();
//             if (tQ <= p) {
//                 p -= tQ;
//                 ret += tR;
//             }
//         }
        
//         if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
//             return (int)ret;
//         } else {
//             return (int)-ret;
//         }
//     }
// }