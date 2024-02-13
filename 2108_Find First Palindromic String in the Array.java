// 2108. Find First Palindromic String in the Array

// Hint
// Given an array of strings words, return the first palindromic string in the array. If there is no such string, return an empty string "".

// A string is palindromic if it reads the same forward and backward.

 

// Example 1:

// Input: words = ["abc","car","ada","racecar","cool"]
// Output: "ada"
// Explanation: The first string that is palindromic is "ada".
// Note that "racecar" is also palindromic, but it is not the first.
// Example 2:

// Input: words = ["notapalindrome","racecar"]
// Output: "racecar"
// Explanation: The first and only string that is palindromic is "racecar".
// Example 3:

// Input: words = ["def","ghi"]
// Output: ""
// Explanation: There are no palindromic strings, so the empty string is returned.
 

// Constraints:

// 1 <= words.length <= 100
// 1 <= words[i].length <= 100
// words[i] consists only of lowercase English letters.




// Approach 1: Brute Force Approach
class Solution {

    public boolean isPalindrome(String s){
        int n= s.length()-1;
        String rev="";

        while(n>=0){
            rev= rev+ s.charAt(n);
            n--;
        }

        if(rev.equals(s)){
            return true;
        }

        return false;
    }

    public String firstPalindrome(String[] words) {
        
        int n= words.length;

        for(int i=0; i<n; i++){
            if(isPalindrome(words[i])){
                return words[i];
            }
        }


        return "";
    }
}


//Approach 2: Reverse String
class Solution {
    public String firstPalindrome(String[] words) {
        for (String s : words) {
            String reversed = new StringBuilder(s).reverse().toString();

            if (s.equals(reversed)) {
                return s;
            }
        }
        return "";
    }
}

// Approach 3: Two Pointers
class Solution {
    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        
        while (start <= end) {
            // Return false if the characters are not the same.
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            
            start++;
            end--;
        }
        
        return true;
    }
    
    public String firstPalindrome(String[] words) {
        for (String s : words) {
            if (isPalindrome(s)) {
                return s;
            }
        }
        
        return "";
    }
}

