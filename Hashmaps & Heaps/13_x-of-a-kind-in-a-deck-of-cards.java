/*You are given an integer array deck where deck[i] represents the number written on the ith card.

Partition the cards into one or more groups such that:

Each group has exactly x cards where x > 1, and
All the cards in one group have the same integer written on them.
Return true if such partition is possible, or false otherwise.

Example 1:

Input: deck = [1,2,3,4,4,3,2,1]
Output: true
Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].

Example 2:

Input: deck = [1,1,1,2,2,2,3,3]
Output: false
Explanation: No possible partition. */


class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < deck.length; i++){
            int val = deck[i];
            if(map.containsKey(val)){
                int v = map.get(val);
                map.put(val, v + 1);
            }else{
                map.put(val, 1);
            }
        }

        int counter = 0;
        int gcd = 1;
        for(int val: map.keySet()){
            if(counter == 0){
                gcd = map.get(val);
            }else{
                int num = map.get(val);
                gcd = getGCD(num, gcd);
            }
            counter++;
        }
        if(gcd >= 2){
            return true;
        }else{
            return false;
        }
    }

    public int getGCD(int n1, int n2){
        if(n2 == 0){
            return n1;
        }
        return getGCD(n2, n1 % n2);
    }
}