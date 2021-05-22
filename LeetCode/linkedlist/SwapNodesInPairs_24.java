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
    public ListNode swapPairs(ListNode head) {
      
        if(head==null || head.next==null)
            return head;
        
        ListNode first=head, second=head.next;
        ListNode tmp=second.next;
        second.next=first;
        first.next=swapPairs(tmp);
        
       
        return second;
    }
}
