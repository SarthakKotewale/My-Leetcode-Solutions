/*1. Given a singly linklist, Segregate 01 Node of LinkedList and return pivot node of linkedlist.
2. After segregation zero nodes should come first and followed by ones node.

Input Format
1->0->1->0->0->1->1->1->1->1->1->null
Output Format
0->0->0->1->1->1->1->1->1->1->1->null */

public static ListNode segregate01(ListNode head) {
    
        if(head == null || head.next == null) return head;
        ListNode curr = head;
        ListNode one = new ListNode(-1);
        ListNode zero = new ListNode(-1);
        
        ListNode p0 = zero;
        ListNode p1 = one;
        
        while(curr != null){
            if(curr.val == 1){
                p0.next = curr;
                p0 = curr;
            }else{
                p1.next = curr;
                p1 = curr;
            }
            curr = curr.next;
        }
        pz.next = one.next;
        p1.next = null;
        
        return zero.next;
    }