/*
1. You are given a number n1, representing the size of array a1.
2. You are given n1 numbers, representing elements of array a1.
3. You are given a number n2, representing the size of array a2.
4. You are given n2 numbers, representing elements of array a2.
5. You are required to print all elements of a2 which are also present in a1 (in order of their occurence in a2). Make sure to not print duplicates (a2 may have same value present many times).

Input Format
A number n1
n1 number of elements line separated
A number n2
n2 number of elements line separated

Output Format
All relevant elements of a2 in separate lines (no duplicacy) */

Author - @SarthakKotewale

import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] a1 = new int[n1];
        for(int i = 0; i < a1.length; i++){
            a1[i] = sc.nextInt();
        }
        int n2 = sc.nextInt();
        int[] a2 = new int[n2];
        for(int i = 0; i < a2.length; i++){
            a2[i] = sc.nextInt();
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int v : a1){
            if(map.containsKey(v)){
                int of = map.get(v);
                int nf = of + 1;
                map.put(v, nf);
            }else{
                map.put(v, 1);
            }
        }
        
        for(int v : a2){
            if(map.containsKey(v)){
                System.out.println(v);
                map.remove(v);
            }
        }
    }
}