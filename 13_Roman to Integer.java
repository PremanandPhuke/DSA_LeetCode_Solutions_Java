// 13. Roman to Integer
// Solved
// Easy
// Topics
// Companies
// Hint
// Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

// Symbol       Value
// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000
// For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

// Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

// I can be placed before V (5) and X (10) to make 4 and 9. 
// X can be placed before L (50) and C (100) to make 40 and 90. 
// C can be placed before D (500) and M (1000) to make 400 and 900.
// Given a roman numeral, convert it to an integer.

 

// Example 1:

// Input: s = "III"
// Output: 3
// Explanation: III = 3.
// Example 2:

// Input: s = "LVIII"
// Output: 58
// Explanation: L = 50, V= 5, III = 3.
// Example 3:

// Input: s = "MCMXCIV"
// Output: 1994
// Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 

// Constraints:

// 1 <= s.length <= 15
// s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
// It is guaranteed that s is a valid roman numeral in the range [1, 3999].


// Solution 1
class Solution {
    public int romanToInt(String s) {
        
        int current = 0;
        int ans = 0;
        int previous = 0;
        //Read from Right to Left
        for (int i = s.length() - 1; i >= 0; i--) {
            switch(s.charAt(i)){
                case 'I':
                    current = 1;
                    break;
                case 'V':
                    current = 5;
                    break;
                case 'X':
                    current = 10;
                    break;
                case 'L':
                    current = 50;
                    break;
                case 'C':
                    current = 100;
                    break;
                case 'D':
                    current = 500;
                    break;
                case 'M':
                    current = 1000;
                    break;
            }
            // Here is the condition
            if ( previous > current) {
                ans -= current;
            }else{
                ans += current;
                previous = current;
            }
           
        }
        return ans;
    }
}


// Solution 2
class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> list= new HashMap<>();

        list.put('I', 1);
        list.put('V', 5);
        list.put('X', 10);
        list.put('L', 50);
        list.put('C', 100);
        list.put('D', 500);
        list.put('M', 1000);
        
        int res=0;
        for(int i=0; i<s.length(); i++){
            int curr= list.get(s.charAt(i));
            if(i+1< s.length() && curr< list.get(s.charAt(i+1))){
                res= res-curr;
            }
            else{
                res=res+curr;
            }
        }

        return res;

    }
}
