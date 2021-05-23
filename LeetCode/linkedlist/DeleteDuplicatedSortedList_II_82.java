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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode tmp=dummy.next, prev=dummy;
        while(tmp.next!=null){
            if(tmp.val==tmp.next.val){
                while(tmp.next!=null && tmp.val==tmp.next.val){
                    tmp=tmp.next;
                }
                prev.next=tmp.next;
                if(tmp.next!=null) tmp=tmp.next;
            }else{
                prev=tmp;
                tmp=tmp.next;
            }
        }
        
        return dummy.next;
    }
}
