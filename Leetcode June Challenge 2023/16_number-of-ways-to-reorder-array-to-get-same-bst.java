/*Given an array nums that represents a permutation of integers from 1 to n. We are going to construct a binary search tree (BST) by inserting the elements of nums in order into an initially empty BST. Find the number of different ways to reorder nums so that the constructed BST is identical to that formed from the original array nums.

For example, given nums = [2,1,3], we will have 2 as the root, 1 as a left child, and 3 as a right child. The array [2,3,1] also yields the same BST but [3,2,1] yields a different BST.
Return the number of ways to reorder nums such that the BST formed is identical to the original BST formed from nums.

Since the answer may be very large, return it modulo 109 + 7.

Example 1:

Input: nums = [2,1,3]
Output: 1
Explanation: We can reorder nums to be [2,3,1] which will yield the same BST. There are no other ways to reorder nums which will yield the same BST.

Example 2:

Input: nums = [3,4,5,1,2]
Output: 5
Explanation: The following 5 arrays will yield the same BST: 
[3,1,2,4,5]
[3,1,4,2,5]
[3,1,4,5,2]
[3,4,1,2,5]
[3,4,1,5,2]

Example 3:

Input: nums = [1,2,3]
Output: 0
Explanation: There are no other orderings of nums that will yield the same BST. */

class Solution {
    public int numOfWays(int[] nums) {
        List<Integer> arr=new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            arr.add(nums[i]);
        }

        int n=nums.length;
        pascal=new long[n+1][n+1];
        pascal[0][0]=1;
        //nCr = n-1Cr-1 + n-1Cr
        for(int i=1; i<=n; i++) {
            pascal[i][0]=1;
            for(int j=1; j<i; j++) {
                pascal[i][j] = (pascal[i-1][j-1]+pascal[i-1][j])%MOD;
            }
            pascal[i][i]=1;
        }
        /*
        //print pascal's triangle for debugging
        // for(int i=0;i<pascal.length;i++) 
            // System.out.println(Arrays.toString(pascal[i]));
        */

        return (int)(util(arr)-1);
    }

    private final long MOD=(long)1e9+7;

    //calculating nCR using pascal's triangle because factorial will cause long overflow
    private long pascal[][];
    private long nCr(int n, int r) { 
        return pascal[n][r];
    }
    
    private long util(List<Integer> arr) {
        if(arr.size()<=2) return 1;

        List<Integer> left=new ArrayList<>();
        List<Integer> right=new ArrayList<>();
        int root=arr.get(0);
        for(int child: arr) {
            if(child==root) continue;
            if(child<root) {
                left.add(child);
            }else {
                right.add(child);
            }
        }

        int x=left.size();
        int y=right.size();
        long combi=nCr(x+y, x)%MOD;
        long get=(util(left)*util(right))%MOD;
        long ret=(combi*get)%MOD;
        return ret;
    }
}