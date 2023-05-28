/*Given an array of N integers. Write a program to check whether an arithmetic progression can be formed using all the given elements. 
 
Example 1:

Input:
N=4
arr[] = { 0,12,4,8 }
Output: YES
Explanation: Rearrange given array as
{0, 4, 8, 12}  which forms an
arithmetic progression.

Example 2:

Input:
N=4
arr[] = {12, 40, 11, 20}
Output: NO */


//Method 1(By sorting)
class Solution {
    boolean checkIsAP(int arr[] ,int n){
        Arrays.sort(arr);
        
        int diff = arr[1] - arr[0];
        for(int i = 2; i < n; i++){
            if(arr[i] - arr[i - 1] != diff){
                return false;
            }
        }
        return true;
    }
}

