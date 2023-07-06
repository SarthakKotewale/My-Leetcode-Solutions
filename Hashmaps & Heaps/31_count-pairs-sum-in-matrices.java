/*Given two sorted matrices mat1 and mat2 of size N x N of elements. Given a value x. The problem is to count all pairs from both matrices whose sum is equal to x.

Note: The pair has an element from each matrix. Matrices are strictly sorted which means that matrices are sorted in a way such that all elements in a row are sorted in increasing order and for row ‘i’, where 1 <= i <= n-1, the first element of row 'i' is greater than the last element of row 'i-1'.

Example 1:

Input: 
N = 3, x = 21
mat1 = { {1 5 6}
         {8 10 11}
         {15 16 18} }
mat2 = { {2 4 7}
         {9 10 12}
         {13 16 20} }
OUTPUT: 4
Explanation: The pairs are (1, 20),
            (5, 16), (8, 13), (11, 10).
Example 2:

Input:
N = 2, x = 10
mat1 = { {1 2}
         {3 4} }
mat2 = { {4 5}
         {6 7}
Output: 2
Explanation: The pairs are (4, 6), (3, 7) */


// METHOD 1 - 
class Solution {//6.7.23
    int countPairs(int mat1[][], int mat2[][], int n, int x) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < mat2.length; i++){
            for(int j = 0; j < mat2[0].length; j++){
                map.put(mat2[i][j], map.getOrDefault(mat2[i][j], 0) + 1);
            }
        }
        int cnt = 0; //count of pairs
        
        for(int i = 0; i < mat1.length; i++){
            for(int j = 0; j < mat1[0].length; j++){
                int com = x - mat1[i][j]; //complement
                if(map.containsKey(com)){
                    if(map.get(com) == 1){
                        map.remove(com);
                    }else{
                        map.put(com, map.get(com) - 1);
                    }
                    cnt++;
                }
            }
        }
        return cnt;
    }
}


// METHOD 2 - 
class Solution {
    int countPairs(int mat1[][], int mat2[][], int n, int x) {
        // code here
        int size = mat2.length*mat2[0].length;
        
        int left=0;
        int right=size-1;
        int ans=0;
        while(left<size && right>=0){
            int r1=left/mat1.length;
            int c1=left%mat1.length;
            
            int r2=right/mat2.length;
            int c2=right%mat2.length;
            
            if(mat1[r1][c1] + mat2[r2][c2]==x){
                ans++;
                left++;
                right--;
            }
            
            else if(mat1[r1][c1] + mat2[r2][c2]>x){
                right--;
            }

            else{
                left++;
            } 
        }
        
        return ans;
    }
}