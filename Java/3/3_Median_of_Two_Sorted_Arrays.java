// public class Solution {
//     public double findMedianSortedArrays(int A[], int B[]) {
//         int lengthA = A.length;
//         int lengthB = B.length;
//         if ((lengthA + lengthB) % 2 == 0) {
//             double r1 = (double) findMedianSortedArrays(A, 0, lengthA, B, 0, lengthB, (lengthA + lengthB) / 2);
//             double r2 = (double) findMedianSortedArrays(A, 0, lengthA, B, 0, lengthB, (lengthA + lengthB) / 2 + 1);
//             return (r1 + r2) / 2;
//         } else
//             return findMedianSortedArrays(A, 0, lengthA, B, 0, lengthB, (lengthA + lengthB + 1) / 2);
//     }
 
//     public int findMedianSortedArrays(int A[], int startA, int endA, int B[], int startB, int endB, int k) {
//         int n = endA - startA;
//         int m = endB - startB;
 
//         if (n <= 0)
//             return B[startB + k - 1];
//         if (m <= 0)
//             return A[startA + k - 1];
//         if (k == 1)
//             return A[startA] < B[startB] ? A[startA] : B[startB];
 
//         int midA = (startA + endA) / 2;
//         int midB = (startB + endB) / 2;
 
//         if (A[midA] <= B[midB]) {
//             if (n / 2 + m / 2 + 1 >= k)
//                 return findMedianSortedArrays(A, startA, endA, B, startB, midB, k);
//             else
//                 return findMedianSortedArrays(A, midA + 1, endA, B, startB, endB, k - n / 2 - 1);
//         } else {
//             if (n / 2 + m / 2 + 1 >= k)
//                 return findMedianSortedArrays(A, startA, midA, B, startB, endB, k);
//             else
//                 return findMedianSortedArrays(A, startA, endA, B, midB + 1, endB, k - m / 2 - 1);
 
//         }
//     }
// }

public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int len = A.length + B.length;
        if ((len & 1) == 1) {
            return findKth(A, 0, B, 0, len / 2 + 1);
        } else {
            return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2;
        }
    }
    
    private double findKth(int A[], int startA, int[] B, int startB, int k) {
        if (startA == A.length) {
            return B[startB + k - 1];
        }
        
        if (startB == B.length) {
            return A[startA + k -1];
        }
        
        if (k == 1) {
            return Math.min(A[startA], B[startB]);
        }
        
        int ka = startA + k / 2 - 1 >= A.length ? Integer.MAX_VALUE : A[startA + k / 2 - 1];
        int kb = startB + k / 2 - 1 >= B.length ? Integer.MAX_VALUE : B[startB + k / 2 - 1];
        
        if (ka > kb) {
            return findKth(A, startA, B, startB + k / 2, k - k / 2);
        } else {
            return findKth(A, startA + k / 2, B, startB, k - k / 2);
        }
    }
}