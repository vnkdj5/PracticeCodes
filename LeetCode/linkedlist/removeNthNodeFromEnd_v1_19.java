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
        ListNode dummy=new ListNode(-1);
         
        dummy.next=head;
        
         ListNode fast=dummy, slow=dummy;
         
         //n+1 gap between 
         for(int i=0;i<n+1;i++){
             fast=fast.next;
         }
         
         while(fast!=null){
             fast=fast.next;
             slow=slow.next;
         }
         if(slow!=null && slow.next!=null)
            slow.next=slow.next.next;
        else
            slow=null;
         
         return dummy.next;
         
         
     }
    public ListNode removeNthFromEnd_twoPass(ListNode head, int n) {
        ListNode tmp=head;int count=0;
        while(tmp!=null){
            count++;
            tmp=tmp.next;
        }
        int preCount=count-n;
        
        ListNode dummy=new ListNode(-1);
        
        dummy.next=head;
        tmp=dummy;
        while(preCount!=0){
            
            tmp=tmp.next; 
            preCount--;
        }
        if(tmp!=null && tmp.next!=null){
            tmp.next=tmp.next.next;
        }else{
            tmp=null;
        }
            return dummy.next;

    }
}
