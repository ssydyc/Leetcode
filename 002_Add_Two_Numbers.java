/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    private ListNode bruteadd(ListNode l1, ListNode l2) {
        // add directly without carry
        ListNode head=new ListNode(l1.val+l2.val);
        ListNode temp=head;
        while(l1.next!=null && l2.next!=null){
            l1=l1.next;
            l2=l2.next;
            temp.next=new ListNode(l1.val+l2.val);
            temp=temp.next;
        }
        if(l1.next==null) temp.next=l2.next;
        else temp.next=l1.next;
        return head;
    }    
        
    private ListNode adjustCarry(ListNode head){
        int carry=0;
        ListNode myhead=new ListNode(0);
        myhead.next=head;
        while(myhead.next!=null){
            myhead.next.val=myhead.next.val+carry;
            if(myhead.next.val>=10){
                myhead.next.val-=10;
                carry=1;
            }
            else carry=0;
            myhead=myhead.next;
        }
        if(carry==1){
            myhead.next=new ListNode(1);
        }
        return head;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode head=bruteadd(l1,l2);
        return adjustCarry(head);
    }
}
