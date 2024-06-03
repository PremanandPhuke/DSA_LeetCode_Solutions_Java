// Solved
// Medium
// Topics
// Companies
// Hint
// You are given two strings s and t consisting of only lowercase English letters.

// Return the minimum number of characters that need to be appended to the end of s so that t becomes a subsequence of s.

// A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.

 

// Example 1:

// Input: s = "coaching", t = "coding"
// Output: 4
// Explanation: Append the characters "ding" to the end of s so that s = "coachingding".
// Now, t is a subsequence of s ("coachingding").
// It can be shown that appending any 3 characters to the end of s will never make t a subsequence.
// Example 2:

// Input: s = "abcde", t = "a"
// Output: 0
// Explanation: t is already a subsequence of s ("abcde").
// Example 3:

// Input: s = "z", t = "abcde"
// Output: 5
// Explanation: Append the characters "abcde" to the end of s so that s = "zabcde".
// Now, t is a subsequence of s ("zabcde").
// It can be shown that appending any 4 characters to the end of s will never make t a subsequence.
 

// Constraints:

// 1 <= s.length, t.length <= 105
// s and t consist only of lowercase English letters.

//Solution 1
class Solution {
    public int appendCharacters(String s, String t) {
        int n1= s.length();
        int n2= t.length();

        int count=0, i=0, j=0;

        if(n2==0){
            return 0;
        }

        if(n2==1){
            if(s.charAt(n1-1)==t.charAt(0)){
                return 0;
            }
        }

        while(i<n1 && j<n2){
            if(s.charAt(i)== t.charAt(j)){
                i++;
                j++;
                count++;
            }
            else{
                i++;
            }
        }

        return n2-count;
    }
}


//Solution2
class Solution {

    public int appendCharacters(String s, String t) {
        int first = 0, longestPrefix = 0;

        while (first < s.length() && longestPrefix < t.length()) {
            if (s.charAt(first) == t.charAt(longestPrefix)) {
                // Since at the current position both the characters are equal,
                // increment longestPrefix by 1
                longestPrefix++;
            }
            first++;
        }

        // The number of characters appended is given by the difference in
        // length of t and longestPrefix
        return t.length() - longestPrefix;
    }
}
