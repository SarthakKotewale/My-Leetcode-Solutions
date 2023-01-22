/*Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

Example 2:

Input: s = "a"
Output: [["a"]] */

class Solution {
    public List<List<String>> partition(String s) {
        //DC 22/1/23
        List<List<String>> output = new ArrayList<>();
        List<String> ds = new ArrayList<>();
        palindromePartition(0, ds, output, s); 
        return output;
    }
    
    public void palindromePartition(int index, List<String> ds, List<List<String>> output, String str){
        if(index == str.length()){
            output.add(new ArrayList<>(ds));
            return;
        }
        for(int i = index; i < str.length(); i++){
            if(checkPalindrome(str, index, i)){
                ds.add(str.substring(index, i + 1));
                palindromePartition(i + 1, ds, output, str);
                ds.remove(ds.size() - 1);
            }
        }
    }
    
    public boolean checkPalindrome(String str, int startIndex, int lastIndex){
        while(startIndex < lastIndex){
            if(str.charAt(startIndex) != str.charAt(lastIndex))
                return false;
            startIndex++;
            lastIndex--;
        }
        return true;
    }
}
// Runtime: 8 ms, faster than 99.21% of Java online submissions for Palindrome Partitioning.
// Memory Usage: 54.1 MB, less than 98.35% of Java online submissions for Palindrome Partitioning.