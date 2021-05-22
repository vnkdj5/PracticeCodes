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
        if(head.next==null && n==1)
            return null;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode slow=dummy, fast=dummy;
        for(int i=0;i<n+1;i++){ //n+1 gap between fast and slow ptr
            fast=fast.next;
        }
        
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next; //DELETE 
        
        return dummy.next;
    }
    
    public ListNode removeNthFromEnd_0(ListNode head, int n) {
        if(head.next==null && n==1)
            return null;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode ptr=dummy;
        int count=0;
        while(ptr!=null){
            count++;  
            ptr=ptr.next;
        }
        ptr=dummy;
    
        for(int i=count-n;i>0;i--)
            ptr=ptr.next;
        
        ptr.next=ptr.next.next;
        
        return dummy.next;
    }
}
