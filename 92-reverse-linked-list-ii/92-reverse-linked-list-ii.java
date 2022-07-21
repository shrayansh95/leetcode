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
        if (left == right)
            return head;
        ListNode beforeLeft = null, afterRight = null, temp = head;
        ListNode prev = null, next = null, l = null, r = null;
        int cnt = 1;
        int flag = 0;
        while (temp != null) {
            if (cnt == left) {
                l = temp;
                flag = 1;
                next = temp.next;
                temp.next = prev;
                prev = temp;
                ++cnt;
                temp = next;
                continue;
            }
            if (flag == 0)
                beforeLeft = temp;
            else if (flag == 1) {
                next = temp.next;
                temp.next = prev;
                prev = temp;
                if (cnt == right) {
                    afterRight = next;
                    r = temp;
                    l.next = afterRight;
                    if (beforeLeft != null)
                        beforeLeft.next = r;
                    else 
                        head = r;
                    break;
                }
                temp = next;
                ++cnt;
                continue;
            }
            ++cnt;
            temp = temp.next;
        }
        return head;
    }
}