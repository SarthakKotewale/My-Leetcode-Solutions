import java.util.*;
class Solution {
    public int calPoints(String[] ops) {
        
        Stack<Integer> st = new Stack<>();
        int sum = 0;
        
        for(int i = 0; i < ops.length; i++){
            
            if(ops[i] .equals("+")){
                int temp1 = st.pop();
                int temp2 = st.pop();
                int tempSum = temp1 + temp2;
                sum += tempSum;
                st.push(temp2);
                st.push(temp1);
                st.push(tempSum);
            }
            else if(ops[i].equals("D")){
                int temp = st.pop();
                int Dsum = 2 * temp;
                sum += Dsum;
                st.push(temp);
                st.push(Dsum);
            }
            else if(ops[i].equals("C")){
                int Csum = st.pop();
                sum -= Csum;
            }
            else{
                int num = Integer.parseInt(ops[i]);
                st.push(num);
                sum += num;
            }
        }
        return sum;
        
    }
}