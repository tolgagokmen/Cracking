/*
There are two sorted arrays A and B of size m and n respectively.
Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
*/

/*
If we use Merge Sort, then the time complexity would be O(n).

The idea is to change the problem into solving: how to find the Kth element
in these two sorted arrays.

A very good trick is to assume the array A is no longer than array B, and if it's not,
then swap them.

Reference is:
http://blog.csdn.net/yutianzuijin/article/details/11499917
http://fisherlei.blogspot.com/2012/12/leetcode-median-of-two-sorted-arrays.html
*/

public class Solution {
        public double findMedianSortedArrays(int A[], int B[]) {
                int m = A.length;
                int n = B.length;
                int k = m + n;
                if (k % 2 != 0) {
                        return findKth(A, 0, B, 0, k / 2 + 1);
                } else {
                        return (findKth(A, 0, B, 0, k / 2) + findKth(A, 0, B, 0, k / 2 + 1)) / 2.0;
                }
        }

        private double findKth(int A[], int a, int B[], int b, int k) {
                if (A.length - a > B.length - b) {
                        return findKth(B, b, A, a, k);
                }
                if (a >= A.length) {
                        return B[b + k - 1];
                }
                if (k == 1) {
                        return Math.min(A[a], B[b]);
                }
                int midA = Math.min(k / 2, A.length - a);
                int midB = k - midA;
                if (A[a + midA - 1] < B[b + midB - 1]) {
                        return findKth(A, a + midA, B, b, k - midA);
                } else if (A[a + midA - 1] > B[b + midB - 1]) {
                        return findKth(A, a, B, b + midB, k - midB);
                } else {
                        return A[a + midA - 1];
                }
        }
}