//Bruteforce
class Solution {
    public static void sort012(int a[], int n){
        int cnt0 = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] == 0){
                cnt0++;
            }else if(a[i] == 1){
                cnt1++;
            }else{
                cnt2++;
            }
        }
        for(int i = 0; i < cnt0; i++){
            a[i] = 0;
        }
        for(int i = cnt0; i < cnt0 + cnt1; i++){
            a[i] = 1;
        }
        for(int i = cnt0 + cnt1; i < n; i++){
            a[i] = 2;
        }
    }
}

//Optimal
