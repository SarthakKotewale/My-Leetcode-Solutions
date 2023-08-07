/*Given a linked list sorted in ascending order and an integer called data, insert data in the linked list such that the list remains sorted.

Example 1:

Input:
LinkedList: 25->36->47->58->69->80
data: 19
Output: 19 25 36 47 58 69 80
Example 2:

Input:
LinkedList: 50->100
data: 75
Output: 50 75 100 */

class Solution {
    Node sortedInsert(Node head, int key) {
        
        Node newnode = new Node(key);
        
        if(head == null || newnode.data < head.data){
            newnode.next = head;
            return newnode;
        }
        
        Node curr = head;
        while(curr.next != null && curr.next.data < newnode.data){
            curr = curr.next;
        }
        
        newnode.next = curr.next;
        curr.next = newnode;
        
        return head;
    }
}

/* Approach - 
Create a new node (newNode) with the given data (key).

Check if the linked list is empty or if the new node should be inserted at the beginning (i.e., if the key is less than the value of the current head node). If either condition is true, update the next pointer of the new node to point to the current head node, and return the new node as the new head of the linked list.

If the new node should be inserted somewhere in the middle or at the end of the list, traverse the linked list while comparing the data values of the current node and the next node. Stop when you find a node whose next node has a value greater than or equal to the key.

Insert the new node after the current node and update the next pointers accordingly.

Return the original head1 (which could be modified if the new node was inserted at the beginning) as the head of the modified linked list. */