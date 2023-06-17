/* 1. You are given an array(arr) of integers.
2. You have to find the element(x) with maximum frequency in the given array. 
3. Also, you have to find the smallest subarray which has all occurrences of the most frequent element i.e x.

Note -> If there are two or more elements with maximum frequency and the same subarray size then print the subarray which occurs first in the given array.

Input Format
A number N
arr1
arr2.. N numbers

Output Format
A number(x) representing the maximum frequency element in the given array.
Two numbers representing the start and end index of the smallest subarray with all occurrences of the most frequent element. */

import java.util.*;
public class Main {
    public static void solution(int[] arr) {
        HashMap<Integer, Integer> fmap = new HashMap<>();
        HashMap<Integer, Integer> smap = new HashMap<>();
        
        int hf = 0;
        int si = 0;
        int ei = 0;
        int len = si - ei + 1;
        
        for(int i = 0; i < arr.length; i++){
            if(fmap.containsKey(arr[i])){
                fmap.put(arr[i], fmap.get(arr[i]) + 1);
            }else{
                fmap.put(arr[i], 1);
                smap.put(arr[i], i);
            }
            
            if(fmap.get(arr[i]) > hf){
                hf = fmap.get(arr[i]);
                si = smap.get(arr[i]);
                ei = i;
                len = ei - si + 1;
            }else if(fmap.get(arr[i]) == hf){
                int clen = i - smap.get(arr[i]);
                if(clen < len){
                    hf = fmap.get(arr[i]);
                    si = smap.get(arr[i]);
                    ei = i;
                    len = ei - si + 1;
                }
            }
        }
        System.out.println(arr[si]);
        System.out.println(si);
        System.out.println(ei);
    }
    
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
        solution(arr);
	}

}
