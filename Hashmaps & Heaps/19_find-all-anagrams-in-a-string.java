/*Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once. 

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters. */


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // count freq of 'p'
        int[] map2 = new int[26];
        for(int i = 0; i < p.length(); i++){
            char ch = p.charAt(i);
            map2[ch - 'a']++;
        }

        // count of freq of 's' with p's length
        int[] map1 = new int[26];
        for(int i = 0; i < p.length(); i++){
            if(s.length() >= p.length()){
                char ch = s.charAt(i);
                map1[ch - 'a']++;
            }
            
        }

        ArrayList<Integer> res = new ArrayList<>();
        if(isAnagram(map1, map2) == true){
            res.add(0);
        }
        int i = p.length();
        int j = 0;

        while(i < s.length()){
            char chi = s.charAt(i); //char of i
            map1[chi - 'a']++; //acquire

            char chj = s.charAt(j);
            if(map1[chj - 'a'] > 0){
                map1[chj - 'a']--; //release
            }
            

            if(isAnagram(map1, map2) == true){
                res.add(j + 1);
            }

            i++;
            j++;
        }
        
        return res;
    }

    public boolean isAnagram(int[] map1, int[] map2){
        for(int i = 0; i < 26; i++){
            if(map1[i] != map2[i]){
                return false;
            }
        }
        return true;
    }
}