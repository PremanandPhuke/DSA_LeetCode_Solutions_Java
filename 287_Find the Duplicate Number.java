// Solved
// Medium
// Topics
// Companies
// Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

// There is only one repeated number in nums, return this repeated number.

// You must solve the problem without modifying the array nums and using only constant extra space.

 

// Example 1:

// Input: nums = [1,3,4,2,2]
// Output: 2
// Example 2:

// Input: nums = [3,1,3,4,2]
// Output: 3
// Example 3:

// Input: nums = [3,3,3,3,3]
// Output: 3
 

// Constraints:

// 1 <= n <= 105
// nums.length == n + 1
// 1 <= nums[i] <= n
// All the integers in nums appear only once except for precisely one integer which appears two or more times.

//Brute
class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int x=0;
        for(int i=0; i<n-1; i++){
            if(nums[i]==nums[i+1]){
                return nums[i];
            }
        }

        return 0;
    }
}

//Better
class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return num; // Found duplicate
            }
            seen.add(num);
        }
        return -1; // Should never reach here
    }
}


//Best
class Solution {
    public int findDuplicate(int[] nums) {
        // Phase 1: Detect cycle using Floyd’s Tortoise and Hare
        int slow = nums[0];
        int fast = nums[0];
        
        do {
            slow = nums[slow];       // Move slow by 1 step
            fast = nums[nums[fast]]; // Move fast by 2 steps
        } while (slow != fast);

        // Phase 2: Find entry point of the cycle (duplicate number)
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow; // The duplicate number
    }
}
