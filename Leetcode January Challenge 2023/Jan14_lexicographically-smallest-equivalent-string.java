/*Link: https://leetcode.com/problems/lexicographically-smallest-equivalent-string/ 
You are given two strings of the same length s1 and s2 and a string baseStr.

We say s1[i] and s2[i] are equivalent characters.

For example, if s1 = "abc" and s2 = "cde", then we have 'a' == 'c', 'b' == 'd', and 'c' == 'e'.
Equivalent characters follow the usual rules of any equivalence relation:

Reflexivity: 'a' == 'a'.
Symmetry: 'a' == 'b' implies 'b' == 'a'.
Transitivity: 'a' == 'b' and 'b' == 'c' implies 'a' == 'c'.
For example, given the equivalency information from s1 = "abc" and s2 = "cde", "acd" and "aab" are
equivalent strings of baseStr = "eed", and "aab" is the lexicographically smallest equivalent string of baseStr.

Return the lexicographically smallest equivalent string of baseStr by using the equivalency information from s1 and s2.

Example 1:

Input: s1 = "parker", s2 = "morris", baseStr = "parser"
Output: "makkek"
Explanation: Based on the equivalency information in s1 and s2, we can group their characters as [m,p], [a,o], [k,r,s], [e,i].
The characters in each group are equivalent and sorted in lexicographical order.
So the answer is "makkek".

Example 2:

Input: s1 = "hello", s2 = "world", baseStr = "hold"
Output: "hdld"
Explanation: Based on the equivalency information in s1 and s2, we can group their characters as [h,w], [d,e,o], [l,r].
So only the second letter 'o' in baseStr is changed to 'd', the answer is "hdld".

Example 3:

Input: s1 = "leetcode", s2 = "programs", baseStr = "sourcecode"
Output: "aauaaaaada"
Explanation: We group the equivalent characters in s1 and s2 as [a,o,e,r,s,c], [l,p], [g,t] and [d,m], thus all letters in baseStr except 'u' and 'd' are transformed to 'a', the answer is "aauaaaaada". */

Author - @SarthakKotewale

//Bruteforce like 

class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr){
        //Not my solution DC 14JAN
        int len = s1.length();
        List<Set<Character>> set = new ArrayList<>();
        int currSet = 1;
        int[] sets = new int[26];
        for(int i=0; i<len; i++)
        {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if(c1==c2) continue;
            if(sets[c1-'a'] == 0 && sets[c2-'a'] == 0)
            {
                Set<Character> newSet = new TreeSet<>();
                newSet.add(c1);
                newSet.add(c2);
                sets[c1-'a'] = currSet;
                sets[c2-'a'] = currSet;
                currSet++;
                set.add(newSet);
            }
            else if(sets[c1-'a'] == 0)
            {
                Set<Character> curr = set.get(sets[c2-'a']-1);
                curr.add(c1);
                sets[c1-'a'] = sets[c2-'a'];
            }
            else if(sets[c2-'a'] == 0)
            {
                Set<Character> curr = set.get(sets[c1-'a']-1);
                curr.add(c2);
                sets[c2-'a'] = sets[c1-'a'];
            }
            else if(sets[c2-'a'] != sets[c1-'a'])
            {
                Set<Character> first = set.get(sets[c1-'a']-1);
                Set<Character> second = set.get(sets[c2-'a']-1);
                for(char cha : second)
                {
                    first.add(cha);
                    sets[cha-'a'] = sets[c1-'a'];
                }
                second.clear();
            }
        }
        System.out.println(set);
        
        String ans = "";
        for(int i = 0; i < baseStr.length(); i++)
        {
            char ch = baseStr.charAt(i);
            int index = sets[ch-'a'] - 1;
            if(index<0) ans += ch;
            else ans += set.get(index).iterator().next();;
        }
        return ans;
    }
}