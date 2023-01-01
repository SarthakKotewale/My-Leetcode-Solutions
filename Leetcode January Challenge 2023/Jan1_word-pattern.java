/*Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and
a non-empty word in s.

Example 1:

Input: pattern = "abba", s = "dog cat cat dog"
Output: true

Example 2:

Input: pattern = "abba", s = "dog cat cat fish"
Output: false */

Author - @SarthakKotewale

//Runtime: 0 ms, faster than 100.00% of Java online submissions for Word Pattern.
//Memory Usage: 40.1 MB, less than 90.03% of Java online submissions for Word Pattern.

class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        //daily challenge 01/01/2023
        String[] words = s.split(" ");
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Boolean> used = new HashMap<>();
        
        if(words.length != pattern.length()){
            return false;
        }
        
        for(int i = 0; i < pattern.length(); i++){
            char ch = pattern.charAt(i);
            
            if(map.containsKey(ch) == false){
                if(used.containsKey(words[i]) == true){
                    return false;
                }else{
                    used.put(words[i], true);
                    map.put(ch, words[i]);
                }
            }else{
                String mapwith = map.get(ch);
                if(mapwith.equals(words[i]) == false){
                    return false;
                }
            }
        }
        return true;
    }
}