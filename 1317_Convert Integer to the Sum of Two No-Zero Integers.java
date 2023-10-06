
// No-Zero integer is a positive integer that does not contain any 0 in its decimal representation.

// Given an integer n, return a list of two integers [a, b] where:

// a and b are No-Zero integers.
// a + b = n
// The test cases are generated so that there is at least one valid solution. If there are many valid solutions, you can return any of them.

 

// Example 1:

// Input: n = 2
// Output: [1,1]
// Explanation: Let a = 1 and b = 1.
// Both a and b are no-zero integers, and a + b = 2 = n.
// Example 2:

// Input: n = 11
// Output: [2,9]
// Explanation: Let a = 2 and b = 9.
// Both a and b are no-zero integers, and a + b = 9 = n.
// Note that there are other valid answers as [8, 3] that can be accepted.
 

// Constraints:

// 2 <= n <= 104





class Solution {

    public boolean canWe(int x){
        int rev= x;
        int no=0;
        while(x>0){
            if(x % 10==0){
                return false;
            }
            else{
                x= x/10;
            }
        }

        return true;
    }
    public int[] getNoZeroIntegers(int n) {

        int i=1, res=n;
        n=n-1;
        int [] ans= new int[2];

        while(n>0){
            boolean flag= canWe(n);
            boolean flag2= canWe(i);

            if(flag && flag2 && n+i==res){
                ans[0]= n;
                ans[1]= res-n;
                break;
            }

            n--;
            i++;
        }

        return ans;
        
    }
}
