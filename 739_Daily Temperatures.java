// Attempted
// Medium
// Topics
// Companies
// Hint
// Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

 

// Example 1:

// Input: temperatures = [73,74,75,71,69,72,76,73]
// Output: [1,1,4,2,1,1,0,0]
// Example 2:

// Input: temperatures = [30,40,50,60]
// Output: [1,1,1,0]
// Example 3:

// Input: temperatures = [30,60,90]
// Output: [1,1,0]
 

// Constraints:

// 1 <= temperatures.length <= 105
// 30 <= temperatures[i] <= 100

// Seen this question in a real interview before?
// 1/5
// Yes
// No
// Accepted
// 1.2M
// Submissions
// 1.8M
// Acceptance Rate
// 66.9%
// Topics
// Array
// Stack
// Monotonic Stack

// Brute Force
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;

        int []arr= new int[n];

        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(temperatures[j]>temperatures[i]){
                    arr[i]= j-i;
                    break;
                }
            }
        }

        return arr;
    }
}

// Reverse Iteration
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];

        for (int i = n - 2; i >= 0; i--) {
            int j = i + 1;
            while (j < n && temperatures[j] <= temperatures[i]) {
                if (answer[j] == 0) {
                    j = n; // No warmer temp ahead
                } else {
                    j += answer[j]; // Skip ahead
                }
            }
            if (j < n) answer[i] = j - i;
        }
        
        return answer;
    }
}

//Monotonic Stack
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n]; // Default initialized to 0
        Stack<Integer> stack = new Stack<>(); // Stores indices

        for (int i = 0; i < n; i++) {
            // Pop from stack until we find a smaller temperature
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                answer[index] = i - index; // Calculate waiting days
            }
            stack.push(i); // Push current index onto stack
        }
        
        return answer;
    }
}
