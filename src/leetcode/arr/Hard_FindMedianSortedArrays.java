package leetcode.arr;

/**
 *  4
 */
public class Hard_FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;

        if (n % 2 == 0)
            return (findKth(nums1, 0, nums2, 0, n / 2) + findKth(nums1, 0, nums2, 0, n / 2 + 1)) / 2.0;
        else
            return findKth(nums1, 0, nums2, 0 , n / 2 +1);
    }

    private int findKth(int[] arrA, int startA, int[] arrB, int startB, int k) {
        if (startA >= arrA.length){
            return arrB[startB + k - 1];
        }
        if (startB >= arrB.length){
            return arrA[startA + k - 1];
        }
        if (k == 1)
            return Math.min(arrA[startA], arrB[startB]);

        int halfA = startA + k / 2 - 1 < arrA.length ? arrA[startA + k / 2 - 1] : Integer.MAX_VALUE;
        int halfB = startB + k / 2 - 1 < arrB.length ? arrB[startB + k / 2 - 1] : Integer.MAX_VALUE;

        if (halfA < halfB){
            return findKth(arrA, startA + k / 2, arrB, startB, k - k / 2);
        } else {
            return findKth(arrA, startA, arrB, startB + k / 2, k - k / 2);
        }
    }

}
