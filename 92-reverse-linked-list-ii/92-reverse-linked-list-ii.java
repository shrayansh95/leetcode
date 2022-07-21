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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = null, cur = head;
        while (left > 1) {
            prev = cur;
            cur = cur.next;
            --left;
            --right;
        }
        
        ListNode beforeLeft = prev;
        ListNode afterRight = cur;
        ListNode next;
        
        while (right > 0) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            --right;
        }
        
        afterRight.next = cur;
        
        if (beforeLeft == null) 
            head = prev;
        else 
            beforeLeft.next = prev;
        
        return head;
    }
}