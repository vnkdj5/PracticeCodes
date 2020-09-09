/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Problem2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //Considering non-empty lists

        int rem = (l1.val + l2.val) / 10;
        ListNode tmp = new ListNode((l1.val + l2.val) % 10);
        ListNode head = tmp;
        l1 = l1.next;
        l2 = l2.next;

        //Data present in both nodes
        while (l1 != null && l2 != null) {
            tmp.next = new ListNode(((l1.val + l2.val + rem) % 10));
            rem = (l1.val + l2.val + rem) / 10;
            tmp = tmp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        //Data is remaining in L1
        while (l1 != null) {
            tmp.next = new ListNode((l1.val + rem) % 10);
            rem = (l1.val + rem) / 10;
            tmp = tmp.next;
            l1 = l1.next;
        }
        //Data is remaining in L2
        while (l2 != null) {
            tmp.next = new ListNode((l2.val + rem) % 10);
            rem = (l2.val + rem) / 10;
            tmp = tmp.next;
            l2 = l2.next;
        }
        //Reminder has some value
        System.out.println(rem);
        if (rem != 0) {
            tmp.next = new ListNode(rem);
            tmp = tmp.next;
        }

        return head;
    }
}