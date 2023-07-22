
// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

// If target is not found in the array, return [-1, -1].

// You must write an algorithm with O(log n) runtime complexity.

 

// Example 1:

// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]
// Example 2:

// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]
// Example 3:

// Input: nums = [], target = 0
// Output: [-1,-1]
 

// Constraints:

// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109
// nums is a non-decreasing array.
// -109 <= target <= 109

class Solution {
    public int[] searchRange(int[] nums, int target) {

        int first=0, end=nums.length-1, count=0, last=0;
        int[] arr= new int[2];

        if(nums.length==0){
            first= -1;
            last= -1;
        }

        while(count<nums.length){
            // int i=0;
            if(nums[count]==target){
                first=count;
                break;
            }
            else{
                first= -1;
            }

            count++;
        }

        while(end>=0){
            if(nums[end]==target){
                last=end;
                break;
            }
            else{
                last=-1;
            }
            end--;
        }
        
        arr[0]= first;
        arr[1]=last;

        return arr;
    }
}
