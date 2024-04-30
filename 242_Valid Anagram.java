
// Solved
// Easy
// Topics
// Companies
// Given two strings s and t, return true if t is an anagram of s, and false otherwise.

// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

// Example 1:

// Input: s = "anagram", t = "nagaram"
// Output: true
// Example 2:

// Input: s = "rat", t = "car"
// Output: false
 

// Constraints:

// 1 <= s.length, t.length <= 5 * 104
// s and t consist of lowercase English letters.


class Solution {
    public boolean isAnagram(String s, String t) {
        
        HashMap<Character, Integer> map= new HashMap<>();

        if(s.length() != t.length()){
            return false;
        }

        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(char c: t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)-1);
        }

        for(int val: map.values()){
            if(val>0){
                return false;
            }
        }

        return true;
    }
}
