/*
Given an array Arr[] of size L and a number N,
you need to write a program to find if there exists a pair of elements in the array whose difference is N.

Example 1:

Input:
L = 6, N = 78
arr[] = {5, 20, 3, 2, 5, 80}
Output: 1
Explanation: (2, 80) have difference of 78.

Example 2:

Input:
L = 5, N = 45
arr[] = {90, 70, 20, 80, 50}
Output: -1
Explanation: There is no pair with difference of 45.
*/

//Author - @SarthakKotewale

class Solution
{
    public boolean findPair(int arr[], int size, int n)
    {
        Arrays.sort(arr);
        int j = 0;
        int i = 1;
        
        while(i < arr.length && j < arr.length){
            if(arr[i] - arr[j] < n){
                i++;
            }else if(arr[i] - arr[j] > n){
                j++;
                if(j == i) i++;
            }else{
                return true;
            }
        }
        return false;
        
    }
}