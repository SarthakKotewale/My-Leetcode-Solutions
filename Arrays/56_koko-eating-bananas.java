/*Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k.
Each hour, she chooses some pile of bananas and eats k bananas from that pile.
If the pile has less than k bananas, she eats all of them instead and
will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4

Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30 */

Author - @SarthakKotewale

/*Runtime: 11 ms, faster than 98.45% of Java online submissions for Koko Eating Bananas.
Memory Usage: 42.8 MB, less than 98.22% of Java online submissions for Koko Eating Bananas.*/

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int las = 1; //lowest allowed speed
        int has = 0;
        for(int pile : piles){
            has = Math.max(pile, has);
        }
        
        while(las < has){
            int as = (las + has) / 2;
            
            //calc hours
            int totalTime = 0;
            for(int pile : piles){
                int time = (pile + as - 1) / as;
                totalTime += time;
            }
            
            if(totalTime > h){
                las = as + 1;
            }else{
                has = as;
            }
        }
        return las;
    }
}