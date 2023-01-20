/*Given two strings, one is a text string, txt and other is a pattern string, pat.
The task is to print the indexes of all the occurences of pattern string in the text string.
For printing, Starting Index of a string should be taken as 1.

Example 1:

Input:
txt = "batmanandrobinarebat", pat = "bat"
Output: 1 18
Explanation: The string "bat" occurs twice in txt,
one starts are index 1 and the other at index 18. 

Example 2:

Input: 
txt = "abesdu", pat = "edu"
Output: -1
Explanation: There's not substring "edu"
present in txt. */

Author - @SarthakKotewale

class Solution
{
    ArrayList<Integer> search(String pat, String txt){
        
        ArrayList<Integer> res = new ArrayList<>();
        int[] lps = getLPS(pat);
        int i = 0;
        int j = 0;
        
        while(i < txt.length()){
            //again 3 conditions
            if(txt.charAt(i) == pat.charAt(j)){
                i++;
                j++;
                if(j == pat.length()){
                    res.add(i - j + 1);
                    j = lps[j - 1];
                }
            }else if(j == 0){
                i++;
            }else{
                j = lps[j - 1];
            }
        }
        return res;
    }
    
    int[] getLPS(String pat){
        int[] lps = new int[pat.length()];
        int len = 0;
        int i = 1;
        
        while(i < lps.length){
            //3 conditions
            if(pat.charAt(i) == pat.charAt(len)){
                lps[i] = len + 1;
                i++;
                len++;
            }else if(len == 0){
                lps[i] = 0;
                i++;
            }else{
                len = lps[len - 1];
            }
        }
        return lps;
    }
}