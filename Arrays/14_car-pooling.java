/*There is a car with capacity empty seats.
The vehicle only drives east (i.e., it cannot turn around and drive west).

You are given the integer capacity and an array trips where
trips[i] = [numPassengersi, fromi, toi] indicates that the ith trip has numPassengersi passengers 
and the locations to pick them up and drop them off are fromi and toi respectively.
The locations are given as the number of kilometers due east from the car's initial location.

Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.

 
Example 1:
Input: trips = [[2,1,5],[3,3,7]], capacity = 4
Output: false

Example 2:
Input: trips = [[2,1,5],[3,3,7]], capacity = 5
Output: true
*/

/* Author - @SarthakKotewale */

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        /*Method1*/

        int[] arr = new int[1001];
        TreeSet<Integer> list = new TreeSet<>();
        
        for(int[] t : trips){
            int people = t[0];
            int from = t[1];
            int to = t[2];
            
            arr[from] += people;
            list.add(from);
            
            arr[to] -= people;
            list.add(to);
        }
        int pic = 0; //PeopleInCar
        for(int l : list){
            int val = arr[l];
            pic += val;
            
            if(pic > capacity){
                return false;
            }
        }
        return true;
        
        
        
        /*Method 2*/
        
        int[] curr = new int[1001];
        int sum = 0;
        for(int[] t : trips){
            curr[t[1]] += t[0];
            curr[t[2]] -= t[0];
        }
        
        for(int c : curr){
            sum += c;
            if(sum > capacity){
                return false;
            }
        }
        return true;
    }
}