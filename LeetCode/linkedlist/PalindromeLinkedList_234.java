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
    public boolean isPalindrome(ListNode head) {
        //2 pointers: fast and slow.. reverse 2nd half and check for palindrome
        ListNode slow=head, fast=head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //odd nodes: let right half smaller
        if(fast!=null)
            slow=slow.next;
        
        //Reverse the half of the list
        slow=reverseList(slow);
        
        fast=head;
        
        while(slow!=null){
            if(slow.val!=fast.val){
                return false;
            }
            slow=slow.next;
            fast=fast.next;
        }
        return true;
        
        
    }
    
    public ListNode reverseList(ListNode head){
        ListNode prev=null, next=null, cur=head;
        
        while(cur!=null){
            
        next=cur.next;
        cur.next=prev;
        prev=cur;
        cur=next;
            
        }
        return prev;
    }
}
