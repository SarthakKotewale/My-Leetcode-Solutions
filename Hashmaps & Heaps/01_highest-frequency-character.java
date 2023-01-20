/*
1. You are given a string str.
2. You are required to find the character with maximum frequency.

Input Format
A string str

Output Format
The character with highest frequency */

Author - @SarthakKotewale

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char res = hfc(str);
        System.out.println(res);
    }
    
    public static char hfc(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(map.containsKey(ch)){
                int oldfreq = map.get(ch);
                int newfreq = oldfreq + 1;
                map.put(ch, newfreq);
            }else{
                map.put(ch, 1);
            }
        }
        
        char maxfreqchar = str.charAt(0);
        for(Character key : map.keySet()){
            if(map.get(key) > map.get(maxfreqchar)){
                maxfreqchar = key;
            }
        }
        return maxfreqchar;
    }

}