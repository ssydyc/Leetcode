/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode nil=new ListNode(1);
        nil.next=head;
        ListNode cur=nil;
        while(cur.next!=null && cur.next.next!=null){
            ListNode l1=cur.next.next.next;
            ListNode l2=cur.next;
            cur.next=l2.next;
            cur.next.next=l2;
            l2.next=l1;
            cur=cur.next.next;
        }
        return nil.next;
    }
}
