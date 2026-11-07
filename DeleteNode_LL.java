//Leetcode : 19;
//LeetCode Link : https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        //find size
        int size = 0;
        ListNode curr = head;
        while(curr != null){
            curr = curr.next;
            size++;
        }
        if(n == size){
            return head.next;
        }
        //Find prev node of target
        int target = size - n;  //target = element to be delete
          ListNode prev = head;
        int i = 1;
        while(i < target){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return head;
    }
}
/*public class DeleteNode_LL {
    Node head;

    class Node{
        Node next;

        // To get size
        int size = 0;
        Node curr = head;
        while(curr != null){
            curr = curr.next;
            size ++;
        }



    }

    public static void main(String[] args) {
        
    }
}*/
