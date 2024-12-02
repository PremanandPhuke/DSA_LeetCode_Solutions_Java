// You are given an array prices where prices[i] is the price of a given stock on the ith day.

// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

// Example 1:

// Input: prices = [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
// Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
// Example 2:

// Input: prices = [7,6,4,3,1]
// Output: 0
// Explanation: In this case, no transactions are done and the max profit = 0.
 

// Constraints:

// 1 <= prices.length <= 105
// 0 <= prices[i] <= 104

// Solution 1: Brute Force
// In this approach, we check every possible pair of days to find the maximum profit.
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int profit=0;
        int temp=0;

        for(int i=0; i<n-1; i++){
            
            for(int j=i+1; j<n; j++){
                temp= prices[j]-prices[i];
                if(temp>profit){
                    profit=temp;
                }
            }

        }

        return profit;
    }
}

// Solution 2: Optimized Solution (Track Minimum Price)
// Here, we track the minimum price seen so far and calculate the profit for every day, updating the maximum profit.
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;  // Initialize with the highest possible value
        int maxProfit = 0;  // Initialize profit to 0

        for (int price : prices) {
            // Update the minimum price encountered so far
            if (price < minPrice) {
                minPrice = price;
            } 
            // Calculate the profit if selling at the current price
            else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;  // Return the maximum profit found
    }
}


// Solution 3: Single-Pass Solution with Improved Readability
// This is a streamlined version of the optimized approach.
class Solution{
    public int maxProfit(int[] prices) {
    int minPrice = prices[0]; // Assume the first price as the minimum
    int maxProfit = 0;

    for (int i = 1; i < prices.length; i++) {
        maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        minPrice = Math.min(minPrice, prices[i]);
    }

    return maxProfit;
}

}


