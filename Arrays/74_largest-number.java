class Solution {
    public String largestNumber(int[] nums) {
        //Step 1 - Convert int array to string array
        String[] arr = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            arr[i] = nums[i] + "";
        }

        //Step 2 - Sort the array by checking a + b and b + a and then compare which is higher
        Arrays.sort(arr, (a, b) -> {
            String case1 = a + b;
            String case2 = b + a;
            return case2.compareTo(case1); //'compareTo' compares two cases
        });

        //Step 3 - Check edge cases for eg. like [0, 0] => o/p = "0"
        if(arr[0].equals("0")){
            return "0";
        }

        //Step 4 - Buuild a stringbuilder, append the arr elements and then return it.
        StringBuilder result = new StringBuilder();
        for(String val : arr){
            result.append(val);
        }

        return result.toString();
    }
}