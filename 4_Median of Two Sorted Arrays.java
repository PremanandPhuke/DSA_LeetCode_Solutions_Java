// Solved
// Hard
// Topics
// Companies
// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

// The overall run time complexity should be O(log (m+n)).

 

// Example 1:

// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000
// Explanation: merged array = [1,2,3] and median is 2.
// Example 2:

// Input: nums1 = [1,2], nums2 = [3,4]
// Output: 2.50000
// Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 

// Constraints:

// nums1.length == m
// nums2.length == n
// 0 <= m <= 1000
// 0 <= n <= 1000
// 1 <= m + n <= 2000
// -106 <= nums1[i], nums2[i] <= 106


// Solution 1
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         int n1 = nums1.length;
        int n2 = nums2.length;
        int m = n1 + n2;

        // Merged array
        int[] arr = new int[m];

        // Pointers for nums1, nums2, and merged array
        int i = 0, j = 0, k = 0;

        // Merge two sorted arrays
        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                arr[k++] = nums1[i++];
            } else {
                arr[k++] = nums2[j++];
            }
        }

        // Add remaining elements from nums1
        while (i < n1) {
            arr[k++] = nums1[i++];
        }

        // Add remaining elements from nums2
        while (j < n2) {
            arr[k++] = nums2[j++];
        }

        // Calculate median
        if (m % 2 == 0) {
            int mid = m / 2;
            return ((double) arr[mid - 1] + arr[mid]) / 2;
        } else {
            return arr[m / 2];
        }
    }
}

// Solution 2
class Solution {
   public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length < nums1.length)
            return findMedianSortedArrays(nums2, nums1);
        return helper(nums1, 0, nums1.length, nums2);
    }
    private double helper(int[] nums1, int l, int h, int[] nums2){
        while(l <= h){
            int m1 = l+(h-l)/2;                                                     //# of elements on left in nums1
            int m2 = (nums2.length+nums1.length+1)/2-m1;                            //# of elements on left in nums2
            if(m1 > 0 && m2 < nums2.length && nums1[m1-1] > nums2[m2])              //m1 needs to reduced
                h = m1-1;
            else if(m2 > 0 && m1 < nums1.length && nums2[m2-1] > nums1[m1])
                l = m1+1;
            else{
                int total = nums1.length+nums2.length;
                int maxLeft = -Integer.MAX_VALUE;
                if(m1 > 0)
                    maxLeft = Math.max(maxLeft, nums1[m1-1]);
                if(m2 > 0)
                    maxLeft = Math.max(maxLeft, nums2[m2-1]);
                if(total % 2 != 0)
                    return maxLeft;
                int minRight = Integer.MAX_VALUE;
                if(m1 < nums1.length)
                    minRight = Math.min(minRight, nums1[m1]);
                if(m2 < nums2.length)
                    minRight = Math.min(minRight, nums2[m2]);
                return (maxLeft+minRight)/2.0;
            }
        }
        return 0;
    }
}
