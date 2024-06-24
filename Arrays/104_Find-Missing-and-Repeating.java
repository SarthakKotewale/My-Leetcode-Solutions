/*
 * Problem statement
 * You are given an array of ‘N’ integers where each integer value is between
 * ‘1’ and ‘N’. Each integer appears exactly once except for ‘P’, which appears
 * exactly twice, and ‘Q’, which is missing.
 * 
 * 
 * 
 * Your task is to find ‘P’ and ‘Q’ and return them respectively.
 * 
 * 
 * 
 * Detailed explanation ( Input/output format, Notes, Images )
 * Constraints:
 * 2 <= N <= 5 * 10^4
 * 1 <= data <= N
 * 
 * Where ‘N’ is the size of the array and ‘data’ denotes the value of the
 * elements of the array.
 * Sample Input 1:
 * 4
 * 1 2 3 2
 * Sample Output 1:
 * 2 4
 * Explanation Of Sample Input 1:
 * Input: ‘N’ = 4
 * ‘A’ = [1, 2, 3, 2]
 * Output: {2, 4} - The integer appearing twice is ‘2’, and the integer missing
 * is ‘4’.
 * Sample Input 2:
 * 3
 * 1 2 1
 * Sample Output 2:
 * 1 3
 */

public class Solution {
    public static int[] findMissingRepeatingNumbers(int[] a) {
        int n = a.length;
        int[] res = new int[n + 1];
        for (int i = 0; i < n; i++) {
            res[a[i]]++;
        }
        int rep = -1;
        int mis = -1;
        for (int i = 1; i <= n; i++) {
            if (res[i] == 2) {
                rep = i;
            } else if (res[i] == 0) {
                mis = i;
            }
        }
        return new int[] { rep, mis };
    }
}