/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode nil=new ListNode(1);
        nil.next=head;
        ListNode cur=nil;
        ListNode l2=null;
        int n=0;
        while((cur=cur.next)!=null) n++;
        if(k<=1||k>n) return head;
        cur=nil;
        while(n>=k){
            ListNode tail=cur.next;
            ListNode l1=cur.next;
            l2=l1.next;
            for(int i=0;i<k-1;i++){
                ListNode temp=l2.next;
                l2.next=l1;
                l1=l2;
                l2=temp;
            }
            cur.next=l1;
            cur=tail;
            cur.next=l2;
            n-=k;
        }
        return nil.next;
    }
}
