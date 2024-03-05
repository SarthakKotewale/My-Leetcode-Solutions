
public static int[] solve(int[] arr) {
    int[] ngol = new int[arr.length]; // next greater on left -> ngol
    Stack<Integer> st = new Stack<>();

    for (int i = 0; i < arr.length; i++) {
        while (st.size() > 0 && st.peek() <= arr[i]) {
            st.pop();
        }
        if (st.size() > 0) {
            ngol[i] = st.peek();
        } else {
            ngol[i] = -1;
        }

        st.push(arr[i]);
    }

    return ngol;
}