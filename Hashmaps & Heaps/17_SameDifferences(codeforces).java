/* You are given an array a of n integers. Count the number of pairs of indices (i,j)
such that i < j and a[j] − a[i] = j − i .*/


import java.io.*;
import java.util.*;
public class Main {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int j = 0; j < t; j++){
		    int n = sc.nextInt();
		    int[] arr = new int[n];
		    for(int i = 0; i < arr.length; i++){
		        arr[i] = sc.nextInt();
		    }
		    
		    //main code starts from here
		    HashMap<Integer, Integer> map = new HashMap<>();
		    for(int i = 0; i < arr.length; i++){
		        int diff = arr[i] - i;
		        map.put(diff, map.getOrDefault(diff, 0) + 1);
		    }
		    long ans = 0;
		    for(int key : map.keySet()){
		        long freq = (long)map.get(key);
		        long val = (freq * (freq - 1) / 2); //nC2 = n(n-1)/2
		        ans += val;       
		    }
		    System.out.println(ans);
		}		
	}
}