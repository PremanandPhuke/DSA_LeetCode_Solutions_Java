// Solved
// Easy
// Topics
// Companies
// Hint
// Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

 

// Example 1:

// Input: nums = [4,3,2,7,8,2,3,1]
// Output: [5,6]
// Example 2:

// Input: nums = [1,1]
// Output: [2]
 

// Constraints:

// n == nums.length
// 1 <= n <= 105
// 1 <= nums[i] <= n
 

// Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n=nums.length;
        int i=0;

        List<Integer> list= new ArrayList<>();

        while(i<n){
            int index= nums[i]-1;
            if(nums[i] != nums[index]){
                swap(nums, i, index);
            }
            else{
                i++;
            }
        }


        for(int j=0; j<n; j++){
            if(nums[j] != j+1){
                list.add(j+1);
            }
        }


        return list;
    }

    private void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
