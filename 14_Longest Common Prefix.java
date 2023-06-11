
// Write a function to find the longest common prefix string amongst an array of strings.

// If there is no common prefix, return an empty string "".

 

// Example 1:

// Input: strs = ["flower","flow","flight"]
// Output: "fl"
// Example 2:

// Input: strs = ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.
 

// Constraints:

// 1 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] consists of only lowercase English letters.


// Solution 1

class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if(strs.length == 0){
            return "";
        }
        String prefix=strs[0];
        for(int i=1; i< strs.length; i++){
            while(strs[i].indexOf(prefix) != 0){
                prefix= prefix.substring(0, prefix.length()-1);
                if(prefix.isEmpty()){
                    return "";
                }
            }
        }

        return prefix;
        
    }
}


//Solution 2

class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length-1];
        int idx = 0;
        while(idx < s1.length() && idx < s2.length()){
            if(s1.charAt(idx) == s2.charAt(idx)){
                idx++;
            } else {
                break;
            }
        }
        return s1.substring(0, idx);
    }
}



