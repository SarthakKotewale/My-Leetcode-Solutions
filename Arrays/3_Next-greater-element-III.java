class Solution {
    public int nextGreaterElement(int n) {
        
        char[] arr = (n + "").toCharArray();
        int i = arr.length - 1;
        
        while(i > 0){
            if(arr[i - 1] >= arr[i]){
                i--;
            }else{
                break;
            }
        }
        
        if(i == 0){
            return -1;
        }
        
        int idx1 = i - 1;
        int j = arr.length - 1;
        while(j > idx1){
            if(arr[j] > arr[idx1]){
                break;
            }
            j--;
        }
        
        //swap
        char temp = arr[idx1];
        arr[idx1] = arr[j];
        arr[j] = temp;
        
        //reverse from i till end
        Arrays.sort(arr, i, arr.length);
        
        long val = Long.parseLong(new String(arr));
        
        //only return val if it's a 32-bit int else return -1
        return (val <= Integer.MAX_VALUE) ? (int) val : -1; 
        
    }
}
