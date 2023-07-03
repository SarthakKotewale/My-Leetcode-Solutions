/* Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, otherwise, return false.

Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].

For example, swapping at indices 0 and 2 in "abcd" results in "cbad".

Example 1:

Input: s = "ab", goal = "ba"
Output: true
Explanation: You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.
Example 2:

Input: s = "ab", goal = "ab"
Output: false
Explanation: The only letters you can swap are s[0] = 'a' and s[1] = 'b', which results in "ba" != goal.
Example 3:

Input: s = "aa", goal = "aa"
Output: true
Explanation: You can swap s[0] = 'a' and s[1] = 'a' to get "aa", which is equal to goal. */


// Explanation:
// First, it checks if s is equal to goal using the == operator. If they are equal, it means the strings are identical.

// If s is equal to goal, the code creates a temporary set called temp to store the unique characters present in s. It does this by converting the string s to a set of characters using the set constructor.

// The code then returns the result of the comparison temp.size() < goal.size(). This comparison checks if the size of the set temp (number of unique characters in s) is less than the size of the string goal. If it is, it means there are duplicate characters in s, and swapping any two of them would result in s becoming equal to goal. In this case, the function returns true; otherwise, it returns false.

// If s is not equal to goal, the code proceeds to find the indices i and j such that s[i] and goal[i] are the first pair of characters that are different from each other when scanning from the left, and s[j] and goal[j] are the first pair of characters that are different from each other when scanning from the right.

// The code uses a while loop to increment the i index from left to right until it finds a mismatch between s[i] and goal[i]. Similarly, it uses another while loop to decrement the j index from right to left until it finds a mismatch between s[j] and goal[j].

// After finding the mismatched indices, the code checks if i is less than j. If it is, it means there is a pair of characters that can be swapped to make s equal to goal. In this case, the code uses the swap function to swap the characters s[i] and s[j].

// Finally, the code checks if s is equal to goal after the potential swap. If they are equal, it means we have successfully swapped two characters to make s equal to goal, and the function returns true. Otherwise, it returns false.


class Solution {
    public boolean buddyStrings(String s, String goal) {
        int n = s.length();
        if (s.equals(goal)) {
            Set<Character> temp = new HashSet<>();
            for (char c : s.toCharArray()) {
                temp.add(c);
            }
            return temp.size() < goal.length(); // Swapping same characters
        }

        int i = 0;
        int j = n - 1;

        while (i < j && s.charAt(i) == goal.charAt(i)) {
            i++;
        }

        while (j >= 0 && s.charAt(j) == goal.charAt(j)) {
            j--;
        }

        if (i < j) {
            char[] sArr = s.toCharArray();
            char temp = sArr[i];
            sArr[i] = sArr[j];
            sArr[j] = temp;
            s = new String(sArr);
        }

        return s.equals(goal);
    }
}