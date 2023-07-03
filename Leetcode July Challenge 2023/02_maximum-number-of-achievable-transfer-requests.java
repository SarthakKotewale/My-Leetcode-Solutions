/*We have n buildings numbered from 0 to n - 1. Each building has a number of employees. It's transfer season, and some employees want to change the building they reside in.

You are given an array requests where requests[i] = [fromi, toi] represents an employee's request to transfer from building fromi to building toi.

All buildings are full, so a list of requests is achievable only if for each building, the net change in employee transfers is zero. This means the number of employees leaving is equal to the number of employees moving in. For example if n = 3 and two employees are leaving building 0, one is leaving building 1, and one is leaving building 2, there should be two employees moving to building 0, one employee moving to building 1, and one employee moving to building 2.

Return the maximum number of achievable requests.

Example 1:

Input: n = 5, requests = [[0,1],[1,0],[0,1],[1,2],[2,0],[3,4]]
Output: 5
Explantion: Let's see the requests:
From building 0 we have employees x and y and both want to move to building 1.
From building 1 we have employees a and b and they want to move to buildings 2 and 0 respectively.
From building 2 we have employee z and they want to move to building 0.
From building 3 we have employee c and they want to move to building 4.
From building 4 we don't have any requests.
We can achieve the requests of users x and b by swapping their places.
We can achieve the requests of users y, a and z by swapping the places in the 3 buildings.
Example 2:


Input: n = 3, requests = [[0,0],[1,2],[2,1]]
Output: 3
Explantion: Let's see the requests:
From building 0 we have employee x and they want to stay in the same building 0.
From building 1 we have employee y and they want to move to building 2.
From building 2 we have employee z and they want to move to building 1.
We can achieve all the requests. 
Example 3:

Input: n = 4, requests = [[0,3],[3,1],[1,2],[2,0]]
Output: 4 */



// Explanation:

// The maximumRequests function takes an integer n representing the number of buildings and a 2D vector requests containing the transfer requests.

// The function initializes a vector indegree of size n to keep track of the difference between incoming and outgoing requests for each building. Initially, all values are set to 0.

// The function then calls the helper function with the starting index as 0, the requests vector, the indegree vector, n, and a count variable set to 0.

// The helper function is the main backtracking function. It takes the current start index, the requests vector, the indegree vector, n, and the current count of transfer requests.

// If the start index is equal to the size of the requests vector, it means we have processed all transfer requests. In this case, the function checks if all buildings have balanced requests (i.e., indegree values are all 0). If so, it updates the ans variable with the maximum count of transfer requests.

// If the start index is not equal to the size of the requests vector, the function has two choices: take or not take the current transfer request.

// If we take the current transfer request, we reduce the indegree value of the source building (requests[start][0]) by 1 and increase the indegree value of the destination building (requests[start][1]) by 1. Then, we recursively call the helper function with the updated start index, requests, indegree, n, and the incremented count by 1.

// After the recursive call, we revert the changes made in step 7 by increasing the indegree value of the source building and decreasing the indegree value of the destination building. 

// This step represents the "not-take" choice. We then recursively call the helper function with the updated start index, requests, indegree, n, and the same count value.

// The helper function explores all possible combinations of taking or not taking transfer requests, tracking the maximum count of transfer requests (ans) that satisfies the balanced request condition.

// Finally, the maximumRequests function returns the maximum count of transfer requests stored in the ans variable.


class Solution {
    public int maximumRequests(int n, int[][] requests) {
        //DC 3.7.23
        int[] indegree = new int[n];
        return helper(0, requests, indegree, n, 0);
    }

    public int helper(int start, int[][] requests, int[] indegree, int n, int count) {
        if (start == requests.length) {
            for (int i = 0; i < n; i++) {
                if (indegree[i] != 0) {
                    return 0;
                }
            }
            return count;
        }

        // Take 
        indegree[requests[start][0]]--;
        indegree[requests[start][1]]++;
        int take = helper(start + 1, requests, indegree, n, count + 1);

        // Not-take
        indegree[requests[start][0]]++;
        indegree[requests[start][1]]--;
        int notTake = helper(start + 1, requests, indegree, n, count);

        return Math.max(take, notTake);
    }
}