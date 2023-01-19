/* Link: https://leetcode.com/problems/longest-happy-prefix/ 
A string is called a happy prefix if is a non-empty prefix which is also a suffix (excluding itself).

Given a string s, return the longest happy prefix of s.
Return an empty string "" if no such prefix exists.

Example 1:

Input: s = "level"
Output: "l"
Explanation: s contains 4 prefix excluding itself ("l", "le", "lev", "leve"), and suffix ("l", "el", "vel", "evel"). The largest prefix which is also suffix is given by "l".

Example 2:

Input: s = "ababab"
Output: "abab"
Explanation: "abab" is the largest prefix which is also suffix. They can overlap in the original string. */

Author - @SarthakKotewale

class Solution {
    public String longestPrefix(String s) {
        //Lps , KMP 19/1/23
        int[] lps = new int[s.length()];
        int len = 0;
        int i = 1;
        int k = 0;
        while(i < lps.length){
            if(s.charAt(i) == s.charAt(len)){
                lps[i] = len + 1;
                len++;
                i++;
            }else if(len == 0){
                lps[i] = 0;
                len = 0;
                i++;
            }else{
                len = lps[len - 1]; //imp
            }
            k = lps[s.length() - 1]; //<--
        }
        return s.substring(0, k);
    }
}