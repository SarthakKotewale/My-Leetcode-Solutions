/*A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company is the one with headID.

Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th employee, manager[headID] = -1. Also, it is guaranteed that the subordination relationships have a tree structure.

The head of the company wants to inform all the company employees of an urgent piece of news. He will inform his direct subordinates, and they will inform their subordinates, and so on until all employees know about the urgent news.

The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e., After informTime[i] minutes, all his direct subordinates can start spreading the news).

Return the number of minutes needed to inform all the employees about the urgent news.
 

Example 1:

Input: n = 1, headID = 0, manager = [-1], informTime = [0]
Output: 0
Explanation: The head of the company is the only employee in the company.

Example 2:

Input: n = 6, headID = 2, manager = [2,2,-1,2,2,2], informTime = [0,0,1,0,0,0]
Output: 1
Explanation: The head of the company with id = 2 is the direct manager of all the employees in the company and needs 1 minute to inform them all.
The tree structure of the employees in the company is shown. */



/*This is the same as many other "bottom up" DFS solutions - we start at each employee, working backwards towards the head of the company.

However, in this solution, we cache our answers for however much time it took for each employee to be informed.

This way, we avoid repeating the work of calculating how much time it takes for each manager to inform their superiors.

TIme Complexity
O(n) - we traverse backwards on each employee at most once.

Space Complexity
O(n) - we store the time it takes to inform each employee */


class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        HashMap<Integer, Integer> times = new HashMap<>();
        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, dfs(i, manager, informTime, times));
        }
        
        return max;
    }
    private int dfs(int e_id, int[] manager, int[] informTime, Map<Integer, Integer> times) {
        if(manager[e_id] == -1) return 0;
        
        if(times.containsKey(e_id)) return times.get(e_id);
        
        times.put(e_id, informTime[manager[e_id]] + dfs(manager[e_id], manager, informTime, times));
		
        return times.get(e_id);
    }
}