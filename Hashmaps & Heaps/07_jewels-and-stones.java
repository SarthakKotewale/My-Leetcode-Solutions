/*You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.

Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:

Input: jewels = "aA", stones = "aAAbbbb"
Output: 3

Example 2:

Input: jewels = "z", stones = "ZZ"
Output: 0 */


//Method 1
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int cnt = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < stones.length(); i++){
            char ch = stones.charAt(i);
            if(map.containsKey(ch)){
                int val = map.get(ch);
                map.put(ch, val + 1);
            }else{
                map.put(ch, 1);
            }
        }

        for(int i = 0; i < jewels.length(); i++){
            char ch = jewels.charAt(i);
            if(map.containsKey(ch)){
                cnt += map.get(ch);
            }
        }
        return cnt;
    }
}



// Method 2
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int n=stones.length();
        int count=0;
        
        for(int i=0;i<n;i++){
            if(jewels.indexOf(stones.charAt(i)) > -1){
                count++;
            }
        }
        return count;
    }
}