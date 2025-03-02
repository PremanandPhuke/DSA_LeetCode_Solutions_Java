// Solved
// Easy
// Topics
// Companies
// Hint
// A sentence is a list of words that are separated by a single space with no leading or trailing spaces. Each word consists of lowercase and uppercase English letters.

// A sentence can be shuffled by appending the 1-indexed word position to each word then rearranging the words in the sentence.

// For example, the sentence "This is a sentence" can be shuffled as "sentence4 a3 is2 This1" or "is2 sentence4 This1 a3".
// Given a shuffled sentence s containing no more than 9 words, reconstruct and return the original sentence.

 

// Example 1:

// Input: s = "is2 sentence4 This1 a3"
// Output: "This is a sentence"
// Explanation: Sort the words in s to their original positions "This1 is2 a3 sentence4", then remove the numbers.
// Example 2:

// Input: s = "Myself2 Me1 I4 and3"
// Output: "Me Myself and I"
// Explanation: Sort the words in s to their original positions "Me1 Myself2 and3 I4", then remove the numbers.
 

// Constraints:

// 2 <= s.length <= 200
// s consists of lowercase and uppercase English letters, spaces, and digits from 1 to 9.
// The number of words in s is between 1 and 9.
// The words in s are separated by a single space.
// s contains no leading or trailing spaces.


class Solution {
    public String sortSentence(String s) {
        String[] arr = s.split(" ");
        int n = arr.length;

        // Cycle Sort to place words in correct order
        int i = 0;
        while (i < n) {
            int index = arr[i].charAt(arr[i].length() - 1) - '1'; // Extract the position

            if (index != i && index < n) {
                swap(arr, i, index); // Correct swap function
            } else {
                i++;
            }
        }

        // Build the final sentence
        StringBuilder str = new StringBuilder();
        for (int j = 0; j < n; j++) {
            str.append(arr[j], 0, arr[j].length() - 1); // Remove the last character (index)
            if (j < n - 1)
                str.append(" "); // Add space between words
        }

        return str.toString();
    }

    private void swap(String[] arr, int i, int index) {
        String temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
    }
}
