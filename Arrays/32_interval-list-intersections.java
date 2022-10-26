/*
You are given two lists of closed intervals, firstList and secondList,
where firstList[i] = [starti, endi] and secondList[j] = [startj, endj].
Each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.

The intersection of two closed intervals is a set of real numbers that are either empty or represented
as a closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].


Example 1:

Input: firstList = [[0,2],[5,10],[13,23],[24,25]],
secondList = [[1,5],[8,12],[15,24],[25,26]]

Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
*/

//Author - @SarthakKotewale

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        ArrayList<int[]> ans = new ArrayList<>();
        int ptr1 = 0; //points at first list
        int ptr2 = 0; //points at second list
        
        while(ptr1 < firstList.length && ptr2 < secondList.length){
            int csp = Math.max(firstList[ptr1][0], secondList[ptr2][0]); //csp = common starting point
            int cep = Math.min(firstList[ptr1][1], secondList[ptr2][1]); //cep = common ending point
            
            if(csp <= cep){
                //valid intersection
                int interval[] = {csp, cep};
                ans.add(interval);
            }
            
            if(firstList[ptr1][1] < secondList[ptr2][1]){
                ptr1++;
            }else{
                ptr2++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}