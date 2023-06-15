/*Given a string 's'. The task is to find the smallest window length that contains all the characters of the given string at least one time.
For eg. A = aabcbcdbca, then the result would be 4 as of the smallest window will be dbca. 

Example 1:

Input : "AABBBCBBAC"
Output : 3
Explanation : Sub-string -> "BAC"

Example 2:
Input : "aaab"
Output : 2
Explanation : Sub-string -> "ab"
 
Example 3:
Input : "GEEKSGEEKSFOR"
Output : 8
Explanation : Sub-string -> "GEEKSFOR"  */


class Solution {
    public int findSubString(String str) {
        
        int len = Integer.MAX_VALUE;
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            set.add(ch);
        }
        
        int i = -1;
        int j = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        
        while(true){
            boolean f1 = false;
            boolean f2 = false;
            //acquire till it is invalid i.e. map.size() < set.size()
            while(i < str.length() - 1 && map.size() < set.size()){
                i++;
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                f1 = true;
            }
            //collect and release
            while(j < i && map.size() == set.size()){
                int pans = i - j;
                if(pans < len){
                    len = pans;
                }
                j++;
                char ch = str.charAt(j);
                if(map.get(ch) == 1){
                    map.remove(ch);
                }else{
                    map.put(ch, map.get(ch) - 1);
                }
                f2 = true;
            }
            if(f1 == false && f2 == false){
                break;
            }
        }
        
        return len;
    }
}