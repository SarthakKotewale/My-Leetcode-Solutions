/*Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s only. The task is to segregate 0s, 1s, and 2s linked list such that all zeros segregate to head side, 2s at the end of the linked list, and 1s in the mid of 0s and 2s.

Example 1:

Input:
N = 8
value[] = {1,2,2,1,2,0,2,2}
Output: 0 1 1 2 2 2 2 2
Explanation: All the 0s are segregated
to the left end of the linked list,
2s to the right end of the list, and
1s in between.
Example 2:

Input:
N = 4
value[] = {2,2,0,1}
Output: 0 1 2 2
Explanation: After arranging all the
0s,1s and 2s in the given format,
the output will be 0 1 2 2. */

class Solution {
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        // add your code here
        if(head == null || head.next == null) return head;
        Node curr = head;
        
        Node one = new Node(-1);
        Node zero = new Node(-1);
        Node two = new Node(-1);
        
        Node p0 = zero;
        Node p1 = one;
        Node p2 = two;
        
        while(curr != null){
            if(curr.data == 0){
                p0.next = curr;
                p0 = curr;
            }else if(curr.data == 1){
                p1.next = curr;
                p1 = curr;
            }else{
                p2.next = curr;
                p2 = curr;
            }
            curr = curr.next;
        }
        p0.next = (one.next != null) ? one.next : two.next; //**
        p1.next = two.next;
        p2.next = null;
        
        return zero.next;
    }
}