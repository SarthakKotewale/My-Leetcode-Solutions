/*In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi.

Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.

 

Example 1:

Input: n = 2, trust = [[1,2]]
Output: 2
Example 2:

Input: n = 3, trust = [[1,3],[2,3]]
Output: 3 */

class Solution {
    public int findJudge(int N, int[][] trust) {
        //Not my solution
        // note the +1 so we can directly map 1->N in array since person count starts from 1 - N, leaving out 0 - no person mapped here
        int[] trustCount = new int[N+1];
        /*
            Imagine trust like a gold coin
            if a person gives turst -> Giver loses one gold coin
                                    -> receiver gets one gold coin;
                                    
            since townJudge trusts nobody ( gives nobody ) & everybody trusts ( everybody gives)
            he should have received N - total population -1 (himself) no of gold coins
        */
        for(int i = 0;i < trust.length; i++){
            trustCount[trust[i][0]]--;
            trustCount[trust[i][1]]++;
        }
        
        // finding person matching that condition
        for(int i = 1; i < trustCount.length; i++){
            if(trustCount[i] == N - 1){
                return i;
            }
        }
        
        return -1;
    }
}

//Runtime: 2 ms, faster than 99.00% of Java online submissions for Find the Town Judge.