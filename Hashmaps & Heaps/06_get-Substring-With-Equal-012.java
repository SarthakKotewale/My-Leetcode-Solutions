/*Given a string str of length N which consists of only 0, 1 or 2s, count the number of substring which have equal number of 0s, 1s and 2s.

Example 1:

Input: str = “0102010”
Output: 2
Explanation: Substring str[2, 4] = “102” and
substring str[4, 6] = “201” has equal number
of 0, 1 and 2 

Example 2:

Input: str = “11100022”
Output: 0
Explanation: There is no substring with
equal number of 0 , 1 and 2. */


class Solution { 
    long getSubstringWithEqual012(String str) {
        long ans = 0;
        long c0 = 0; //count of zeroes
        long c1 = 0;
        long c2 = 0;
        String key = "0#0"; // diff b/w 1s & 0s '#' diff b/w 2s & 1s
        
        HashMap<String, Integer> map = new HashMap<>();
        
        map.put(key, 1);
        
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            
            if(ch == '0'){
                c0++;
            }else if(ch == '1'){
                c1++;
            }else{
                c2++;
            }
            
            key = (c1 - c0) + "#" + (c2 - c1);
            
            if(map.containsKey(key)){
                int val = map.get(key);
                ans += val;
                
                map.put(key, val + 1);
            }else{
                map.put(key, 1);
            }
        }
        return ans;
    }
}