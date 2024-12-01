// Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
// Example 1:

// Input: nums = [1,2,3,4,5,6,7], k = 3
// Output: [5,6,7,1,2,3,4]
// Explanation:
// rotate 1 steps to the right: [7,1,2,3,4,5,6]
// rotate 2 steps to the right: [6,7,1,2,3,4,5]
// rotate 3 steps to the right: [5,6,7,1,2,3,4]
// Example 2:

// Input: nums = [-1,-100,3,99], k = 2
// Output: [3,99,-1,-100]
// Explanation: 
// rotate 1 steps to the right: [99,-1,-100,3]
// rotate 2 steps to the right: [3,99,-1,-100]
 

// Constraints:

// 1 <= nums.length <= 105
// -231 <= nums[i] <= 231 - 1
// 0 <= k <= 105


// Solution 1: Using Extras Array
class Solution{
 public void rotate(int[] nums, int k) {
    int n = nums.length;
    k %= n;
    int[] temp = new int[n];
    for (int i = 0; i < n; i++) {
        temp[(i + k) % n] = nums[i];
    }
    System.arraycopy(temp, 0, nums, 0, n);
}
// or

 class Solution{
  public void rotate(int[] nums, int k) {

        int n=nums.length;
        k=k%n;

        int arr[]= new int[n];
        int j=0;

        for(int i=n-k; i<n; i++){
            
            arr[j++]=nums[i];
        }

        for(int i=0; i<n-k;i++){
            arr[j++]=nums[i];
        }

        int y=0;
        for(int i:arr){
            nums[y++]=i;
        }
    }
 }

 //Solution 2:  Reverse Method 
 class Solution{
  public void rotate(int[] nums, int k) {
    int n = nums.length;
    k %= n;

    reverse(nums, 0, n - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, n - 1);
}

private void reverse(int[] nums, int start, int end) {
    while (start < end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }
}
}

// Solution 3: Cyclic Replacement 
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k == 0 || n == 0 || n == k) {
            return;
        }
        
        int count = 0;
        int start = 0;
        int current = start;
        int prev = nums[start];
        
        while (count < n) {
            current = (current + k) % n;
            int temp = nums[current];
            nums[current] = prev;
            prev = temp;
            count++;
            
            if (current == start) {
                start++;
                current = start;
                prev = nums[start];
            }
        }
    }
}
