/* Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u',
and they can appear in both lower and upper cases, more than once.

Example 1:

Input: s = "hello"
Output: "holle"
Example 2:

Input: s = "leetcode"
Output: "leotcede" 

Constraints:

1 <= s.length <= 3 * 105
s consist of printable ASCII characters.
*/
class Solution {
    public String reverseVowels(String s) {

        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        char[] arr = s.toCharArray();

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (!set.contains(arr[left])) {
                left++;
            } else if (!set.contains(arr[right])) {
                right--;
            } else {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return new String(arr);
    }
}

//-------------------------------
class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int l = 0;
        int r = arr.length - 1;

        while(l < r){
            if(isVowel(arr[l]) && isVowel(arr[r])){
                char temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }else if(isVowel(arr[l])){
                r--;
            }else if(isVowel(arr[r])){
                l++;
            }else{
                l++;
                r--;
            }
        }
        return new String(arr);
    }
    public boolean isVowel(char ch){
        if(ch == 'A' || ch == 'a'){
            return true;
        }
        else if(ch == 'E' || ch == 'e'){
            return true;
        }
        else if(ch == 'I' || ch == 'i'){
            return true;
        }
        else if(ch == 'O' || ch == 'o'){
            return true;
        }
        else if(ch == 'U' || ch == 'u'){
            return true;
        }else{
            return false;
        }
    }
}
