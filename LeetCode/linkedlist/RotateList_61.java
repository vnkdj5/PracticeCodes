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
    public ListNode rotateRight(ListNode head, int k) {
        int count=0;
        if(head==null || head.next==null)
            return head;
        
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        
        ListNode fast=dummy, slow=dummy;
        while(fast.next!=null){ //This will not count the last node..As We are counting dummy node..but will give us correct size
            count++;
            fast=fast.next;
        }
        k=k%count;
        
        for(int i=0; i<count-k;i++){
            slow=slow.next;
        }
        
        
        fast.next=dummy.next;;
        dummy.next=slow.next;
        slow.next=null;
        
        return dummy.next;
        
    }
}
