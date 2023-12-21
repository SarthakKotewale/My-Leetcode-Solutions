/*
 * You have a long flowerbed in which some of the plots are planted, and some
 * are not. However, flowers cannot be planted in adjacent plots.
 * 
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty
 * and 1 means not empty, and an integer n, return true if n new flowers can be
 * planted in the flowerbed without violating the no-adjacent-flowers rule and
 * false otherwise.
 * 
 * Example 1:
 * 
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 * Example 2:
 * 
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * 1 <= flowerbed.length <= 2 * 104
 * flowerbed[i] is 0 or 1.
 * There are no two adjacent flowers in flowerbed.
 * 0 <= n <= flowerbed.length
 */

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int max = 0;
        //find out first & last index of 1's
        int fi = -1;
        int li = -1;
        for(int i = 0; i < flowerbed.length; i++){
            if(flowerbed[i] == 0) continue;
            else if(fi == -1){ // first time 1
                fi = i;
                li = i;
            }else{
                li = i;
            }
        }
        
        if(fi == -1){ //all zeroes case
            max = (flowerbed.length + 1) / 2;
        } else{ //if not all zeroes
            int leftz = fi;
            int rightz = flowerbed.length - 1 - li;
            max += leftz / 2;
            max += rightz / 2;

            int countzeroes = 0;
            for(int i = fi + 1; i <= li - 1; i++){
                if(flowerbed[i] == 0){
                    countzeroes++;
                }else{
                    max += (countzeroes - 1) / 2;
                    countzeroes = 0;
                }
            }
            max += (countzeroes - 1) / 2;
        }
        return n <= max;
    }
}
