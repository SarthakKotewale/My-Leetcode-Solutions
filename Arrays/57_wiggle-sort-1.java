/*Given an unsorted array nums, reorder it in-place such that
nums[0] <= nums[1] >= nums[2] <= nums[3]....

Example:

Input: nums = [3,5,2,1,6,4]
Output: One possible answer is [3,5,1,6,2,4] */

Author - @SarthakKotewale

//Optimised 

import java.util.*;

public class Main {

  // ~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~
  public static void wiggleSort(int[] arr) {
      
    for(int i = 0; i < arr.length - 1; i++){
        if(i % 2 == 0){
            if(arr[i] >= arr[i + 1]){
                swap(arr, i, i + 1);
            }
        }else{
            if(arr[i] <= arr[i + 1]){
                swap(arr, i, i + 1);
            }
        }
    }
  }
  
  public static void swap(int[] arr, int a, int b){
      int t = arr[a];
      arr[a] = arr[b];
      arr[b] = t;
  }

  // ~~~~~~~~~~~~Input Management~~~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    wiggleSort(arr);

    for (int val : arr) {
      System.out.print(val + " ");
    }
    System.out.println();
  }

}
