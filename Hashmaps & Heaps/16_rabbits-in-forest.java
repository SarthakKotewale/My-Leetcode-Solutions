/*There is a forest with an unknown number of rabbits. We asked n rabbits "How many rabbits have the same color as you?" and collected the answers in an integer array answers where answers[i] is the answer of the ith rabbit.

Given the array answers, return the minimum number of rabbits that could be in the forest.

Example 1:

Input: answers = [1,1,2]
Output: 5
Explanation:
The two rabbits that answered "1" could both be the same color, say red.
The rabbit that answered "2" can't be red or the answers would be inconsistent.
Say the rabbit that answered "2" was blue.
Then there should be 2 other blue rabbits in the forest that didn't answer into the array.
The smallest possible number of rabbits in the forest is therefore 5: 3 that answered plus 2 that didn't.

Example 2:

Input: answers = [10,10,10]
Output: 11 */


class Solution {
    public int numRabbits(int[] answers) {
        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val : answers){
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        System.out.println(map);

        for(int key : map.keySet()){
            int vl = map.get(key);
            cnt += (int)Math.ceil(vl * 1.0 /(key + 1) * 1.0) * (key + 1);
        }       
        return cnt ;
    }
}

//--------------------------------------
class Solution {
    public int numRabbits(int[] answers) {
        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val : answers){
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        System.out.println(map);

        for(int key : map.keySet()){
            int groupSize = key + 1;
            int rabbitReportees = map.get(key);
            int numOfGroups = (int)Math.ceil(rabbitReportees * 1.0 / groupSize * 1.0);
            cnt += numOfGroups * groupSize;
        }
        
        return cnt ;
    }
}