/* Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.

Example 2:

Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.

Example 3:

Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels. */


class Solution {
    public int maxVowels(String s, int k) {
        int cnt = 0;
        int ans;
        for (int i = 0; i < k; i++) {
            char ch = s.charAt(i);
            if (isVowel(ch)) {
                cnt++;
            }
        }
        ans = cnt;
        for (int i = k; i < s.length(); i++) {
            char chi = s.charAt(i);
            char chimk = s.charAt(i - k);
            if (isVowel(chi)) {
                cnt++;
            }
            if (isVowel(chimk)) {
                cnt--;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }

    public boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        } else {
            return false;
        }
    }
}