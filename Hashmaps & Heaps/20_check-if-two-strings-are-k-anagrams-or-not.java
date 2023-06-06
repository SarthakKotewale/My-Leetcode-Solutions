/*Given two strings of lowercase alphabets and a value K, your task is to complete the given function which tells if  two strings are K-anagrams of each other or not.

Two strings are called K-anagrams if both of the below conditions are true.
1. Both have same number of characters.
2. Two strings can become anagram by changing at most K characters in a string.

Example:

Input:
str1 = "fodr", str2="gork"
k = 2
Output:
1
Explanation: Can change fd to gk */


class Solution {
    boolean areKAnagrams(String s1, String s2, int k) {
        if(s1.length() != s2.length()){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        for(int i = 0; i < s2.length(); i++){
            char ch = s2.charAt(i);
            if(map.getOrDefault(ch, 0) > 0){
                map.put(ch, map.get(ch) - 1);
            }
        }
        int cnt = 0;
        for(char ch : map.keySet()){
            cnt += map.get(ch);
        }
        
        if(cnt > k){
            return false;
        }else{
            return true;
        }
    }
}