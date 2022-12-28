/*A conveyor belt has packages that must be shipped from one port to another within days days.

The ith package on the conveyor belt has a weight of weights[i].
Each day, we load the ship with packages on the conveyor belt (in the order given by weights).
We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on the
conveyor belt being shipped within days days.

Example 1:

Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
Output: 15
Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10

Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and
splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed. */

Author - @SarthakKotewale

//Runtime: 9 ms, faster than 98.26% of Java online submissions for Capacity To Ship Packages Within D Days.

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int lowestCap = Integer.MIN_VALUE; // highest val in weights[]
        int highestCap = 0; //sum of all val in weights[]
        for(int w : weights){
            highestCap += w;
            lowestCap = Math.max(w, lowestCap);
        }
        
        while(lowestCap < highestCap){
            int limit = (lowestCap + highestCap) / 2;
            
            int daysreqd = 1;
            int currdaywt = 0;
            for(int wt : weights){
                if(currdaywt + wt <= limit){
                    currdaywt += wt;
                }else{
                    currdaywt = wt;
                    daysreqd++;
                }
            }
            if(daysreqd > days){
                lowestCap = limit + 1;
            }else{
                highestCap = limit;
            }
        }
        return lowestCap;
    }
}