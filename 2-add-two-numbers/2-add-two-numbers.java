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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode temp = head, next;
        while ((l1 != null) || (l2 != null)) {
            if (l1 == null) {
                temp.val = carry + l2.val;
                carry = temp.val / 10;
                temp.val %= 10;
                l2 = l2.next;
            } else if (l2 == null) {
                temp.val = carry + l1.val;
                carry = temp.val / 10;
                temp.val %= 10;
                l1 = l1.next;
            } else {
                temp.val = carry + l1.val + l2.val;
                carry = temp.val / 10;
                temp.val %= 10;
                l1 = l1.next;
                l2 = l2.next;
            }
            if (l1 != null || l2 != null) {
                next = new ListNode(0);
                temp.next = next;
                temp = next;
            }
        }
        if (carry > 0) {
            next = new ListNode(carry);
            temp.next = next;
            temp = next;
        }
        temp.next = null;
        return head;
    }
}