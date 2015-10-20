/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode nil=new ListNode(1);
        ListNode cur=nil;
        while(l1!=null || l2!=null){
            ListNode temp=l1;
            if(l1==null||(l2!=null&&l1.val>l2.val)){
                temp=l2;
            }
            cur.next=temp;
            cur=temp;
            if(cur==l1) l1=l1.next;
            else l2=l2.next;
        }
        return nil.next;
    }
}
