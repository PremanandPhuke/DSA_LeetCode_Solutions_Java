// 229. Majority Element II

// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

 

// Example 1:

// Input: nums = [3,2,3]
// Output: [3]
// Example 2:

// Input: nums = [1]
// Output: [1]
// Example 3:

// Input: nums = [1,2]
// Output: [1,2]
 

// Constraints:

// 1 <= nums.length <= 5 * 104
// -109 <= nums[i] <= 109

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n= nums.length;
        int temp=0, temp_c=0;

        List<Integer> list= new ArrayList<Integer>();

        for(int i: nums){
            int count=0;
            for(int j: nums){
                if(i==j){
                    count++;
                }
            }
            if(count > (n/3) && !list.contains(i)){
                list.add(i);
            }
        }


        return list;
    }
}
