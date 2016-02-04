/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode cur1 = head;
        ListNode head2 = head.next, cur2 = head.next;
        while(cur2 != null && cur2.next != null) {
            cur1.next = cur2.next;
            cur1 = cur1.next;
            cur2.next = cur1.next;
            cur2 = cur2.next;
        }
        cur1.next = head2;
        return head;
    }
}
