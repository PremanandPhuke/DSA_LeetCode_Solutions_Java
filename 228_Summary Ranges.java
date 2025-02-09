// Solved
// Easy
// Topics
// Companies
// You are given a sorted unique integer array nums.

// A range [a,b] is the set of all integers from a to b (inclusive).

// Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

// Each range [a,b] in the list should be output as:

// "a->b" if a != b
// "a" if a == b
 

// Example 1:

// Input: nums = [0,1,2,4,5,7]
// Output: ["0->2","4->5","7"]
// Explanation: The ranges are:
// [0,2] --> "0->2"
// [4,5] --> "4->5"
// [7,7] --> "7"
// Example 2:

// Input: nums = [0,2,3,4,6,8,9]
// Output: ["0","2->4","6","8->9"]
// Explanation: The ranges are:
// [0,0] --> "0"
// [2,4] --> "2->4"
// [6,6] --> "6"
// [8,9] --> "8->9"
 

// Constraints:

// 0 <= nums.length <= 20
// -231 <= nums[i] <= 231 - 1
// All the values of nums are unique.
// nums is sorted in ascending order.

//Brute
class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n= nums.length;

        List<String> list=new ArrayList<>();

        for(int i=0; i<n; i++){
            int start=nums[i];

            while(i<n-1 && nums[i]+1==nums[i+1]){
                i++;
            }

            if(start==nums[i]){
                list.add(String.valueOf(start));
            }
            else{
                list.add(start+"->"+nums[i]);
            }
        }  
        return list;
    }
}

// Better
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int n = nums.length;
        if (n == 0) return list; // Edge case: empty array
        
        int start = 0; // Start index of a range

        for (int i = 1; i <= n; i++) { // Notice `i <= n` to handle last element
            // If `i == n` or the sequence breaks
            if (i == n || nums[i] != nums[i - 1] + 1) {
                if (start == i - 1) {
                    list.add(String.valueOf(nums[start])); // Single number
                } else {
                    list.add(nums[start] + "->" + nums[i - 1]); // Range format
                }
                start = i; // Update start for the next range
            }
        }

        return list;
    }
}


// Best
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int n = nums.length;
        if (n == 0) return result;

        int start = 0;

        while (start < n) {
            int end = start; // Mark the end of the range
            while (end + 1 < n && nums[end + 1] == nums[end] + 1) {
                end++; // Extend the range
            }

            // If start == end, it's a single number
            if (start == end) {
                result.add(String.valueOf(nums[start]));
            } else {
                result.add(nums[start] + "->" + nums[end]);
            }

            start = end + 1; // Move to next range
        }

        return result;
    }
}
