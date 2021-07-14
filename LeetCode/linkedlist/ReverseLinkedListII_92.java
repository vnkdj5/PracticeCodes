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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        //first part
        ListNode start=dummy;
        ListNode prev=null;
        ListNode startPrev=null;
        for(int i=0;i<left;i++){
            startPrev=start;
            start=start.next;
            
        }
        
        //Reverse
        ListNode end=start;
        ListNode endPrev=startPrev;
                          
        ListNode next=null;
       for(int i=0; i<=right-left;i++){
            next=end.next;
            
            end.next=endPrev;
            endPrev=end;
            end=next;
        }
        //connect
      start.next=end;
        startPrev.next = endPrev;
        return dummy.next;
    }
}
