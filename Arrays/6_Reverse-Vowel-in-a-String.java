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
