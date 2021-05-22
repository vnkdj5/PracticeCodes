/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode p=l1, q=l2, cur=dummy;
     
        int carry=0;
        while(p!=null || q!=null){
            int x=p!=null?p.val:0;
            int y=q!=null?q.val:0;
            int sum=x+y+carry;
            carry=sum/10;
            cur.next=new ListNode(sum%10);
            cur=cur.next;
            if(p!=null)p=p.next;
            if(q!=null)q=q.next;
        }
        
        if(carry>0)
            cur.next=new ListNode(carry);
        
        return dummy.next;
        
        
        
        
    }
    
    public ListNode addTwoNumbers_0(ListNode l1, ListNode l2) {
        //Considering non-empty lists
        //Add basic null checks like if l1 ==null OR  l2==null
        int rem=0;;
       //Dunnmy Node approch
        ListNode head=new ListNode(0);
        ListNode tmp=head;
        
        //Data present in both nodes
        while(l1!=null && l2!=null){
            tmp.next=new ListNode(((l1.val+l2.val+rem)%10));
            rem=(l1.val+l2.val+rem)/10;
            tmp=tmp.next;
            l1=l1.next;
            l2=l2.next;
        }
        //Data is remaining in L1
         while(l1!=null){
             tmp.next=new ListNode((l1.val+rem)%10);
             rem=(l1.val+rem)/10;
               tmp=tmp.next;
            l1=l1.next;
         }
        //Data is remaining in L2
         while(l2!=null){
             tmp.next=new ListNode((l2.val+rem)%10);
             rem=(l2.val+rem)/10;
               tmp=tmp.next;
            l2=l2.next;
         }
        //Reminder has some value
        System.out.println(rem);
        if(rem!=0){
            tmp.next=new ListNode(rem);
            tmp=tmp.next;
        }
        
        return head.next;
    }
}
