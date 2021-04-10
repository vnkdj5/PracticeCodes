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
    
     public ListNode removeElements1(ListNode head, int val) {
         ListNode dummy=new ListNode(0);
         dummy.next=head;
         ListNode cur=dummy.next, prev=dummy;
         while(cur!=null){
             if(cur.val==val){
                 prev.next=cur.next;
             }else{
                 prev=cur;
             }
             cur=cur.next;
         }
         return dummy.next;
         
     }
    
    public ListNode removeElements(ListNode head, int val) {
        ListNode it=head;
        //Remove starting val && set new head
        while(it!=null){
            if(it.val==val)
                it=it.next;
            else
                break;
        }
        ListNode newHead=it;//set the new head
        
        ListNode prev=null;
        while(it!=null){
            if(it.val==val){
                it=it.next;
                prev.next=it;
            }else{
                prev=it;
                it=it.next;
            }
        }
        
        return newHead;
    }
}
