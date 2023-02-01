/*
For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2. 

Example 1:

Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"

Example 2:

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"

Example 3:

Input: str1 = "LEET", str2 = "CODE"
Output: "" */

Author - @SarthakKotewale
//EASY
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // 1/2/23 DC
        if(!(str1 + str2).equals(str2 + str1)){
            return "";
        }
        int gcd = gcd(str1.length(), str2.length());
        return str2.substring(0, gcd);
    }
    public int gcd(int n1, int n2){
        if(n2 == 0){
            return n1;
        }
        return gcd(n2, n1 % n2);
    }
}