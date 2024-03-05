import java.util.Stack;

public static int[] solve(int[] arr) {
    Stack<Integer> st = new Stack<>();
    int[] nsor = new int[arr.length];
    for (int i = arr.length - 1; i >= 0; i--) {
        while (st.size() > 0 && st.peek() >= arr[i]) {
            st.pop();
        }
        if (st.size() > 0) {
            nsor[i] = st.peek();
        } else {
            nsor[i] = -1;
        }
        st.push(arr[i]);
    }
    return nsor;
    
}