// Problem Statement :
// You’re given a string where multiple characters are repeated consecutively. You’re supposed
// to reduce the size of this string using mathematical logic given as in the example below:
// Input :
// aabbbbeeeeffggg
// Output:
// a2b4e4f2g3
// Input :
// abbccccc
// Output:
// ab2c5


// Solution 1
class StringCompressor {
    public static String compressString(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        StringBuilder compressed = new StringBuilder();
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            // Check if the current character is the same as the previous one
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                // Append the character and its count (if count > 1)
                compressed.append(input.charAt(i - 1));
                if (count > 1) {
                    compressed.append(count);
                }
                count = 1; // Reset the count
            }
        }

        // Append the last character and its count
        compressed.append(input.charAt(input.length() - 1));
        if (count > 1) {
            compressed.append(count);
        }

        return compressed.toString();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(compressString("aabbbbeeeeffggg")); // Output: a2b4e4f2g3
        System.out.println(compressString("abbccccc"));        // Output: ab2c5
        System.out.println(compressString("abc"));             // Output: abc
        System.out.println(compressString("a"));               // Output: a
        System.out.println(compressString(""));                // Output: (empty string)
    }
}

// Solution 2
import java.util.*;
class Main {
    public static void main(String[] args) {
        System.out.println("Enter String");
        Scanner sc= new Scanner(System.in);
        
        String s= sc.nextLine();
        System.out.println(s);
        int n= s.length();
        
        Map<Character, Integer> list= new HashMap<>();
        
        for(char c: s.toCharArray()){
            list.put(c, list.getOrDefault(c, 0)+1);
        }
        
        StringBuilder res= new StringBuilder();
        
        for(Map.Entry<Character, Integer> temp: list.entrySet()){
            res.append(temp.getKey());
            if(temp.getValue()>1){
                res.append(temp.getValue());
            }
        }
        
        
        System.out.println(res.toString());
    }
}
