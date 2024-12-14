// 171. Excel Sheet Column Number
// Easy
// Topics
// Companies
// Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.

// For example:

// A -> 1
// B -> 2
// C -> 3
// ...
// Z -> 26
// AA -> 27
// AB -> 28 
// ...
 

// Example 1:

// Input: columnTitle = "A"
// Output: 1
// Example 2:

// Input: columnTitle = "AB"
// Output: 28
// Example 3:

// Input: columnTitle = "ZY"
// Output: 701


// Brute Force Approach
public int titleToNumberBrute(String columnTitle) {
    int result = 0;
    int power = 0; // 26^power
    int n = columnTitle.length();
    for (int i = n - 1; i >= 0; i--) {
        int charValue = columnTitle.charAt(i) - 'A' + 1;
        result += charValue * Math.pow(26, power);
        power++;
    }
    return result;
}


// Better Approach
public int titleToNumberBetter(String columnTitle) {
    int result = 0;
    for (int i = 0; i < columnTitle.length(); i++) {
        int charValue = columnTitle.charAt(i) - 'A' + 1;
        result = result * 26 + charValue;
    }
    return result;
}


// Best Approach (Optimized and Scalable)
public int titleToNumberBest(String columnTitle) {
    int result = 0;
    for (char c : columnTitle.toCharArray()) {
        result = result * 26 + (c - 'A' + 1);
    }
    return result;
}
