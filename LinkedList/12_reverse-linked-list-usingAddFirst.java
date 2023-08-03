class Solution {
    //using addFirst
    public ListNode reverseList(ListNode head){
        resetTempPointers(); //for multiple test cases
        
        ListNode curr = head;
        while(curr != null){
            ListNode forw = curr.next;
            curr.next = null;
            addFirst(curr);
            curr = forw;
        }
        return th;
    }
    
    public static ListNode th = null; //temphead
    public static ListNode tt = null; //temptail

    private void addFirst(ListNode node){
        if(th == null){
            th = node;
            tt = node;
        }else{
            node.next = th;
            th = node;
        }
    }

    public static void resetTempPointers() {
        th = null;
        tt = null;
    }
}