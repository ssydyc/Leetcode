/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
public class Solution {
    private ListNode moveNode(ListNode current, int move){
        while(move-->0){
            if(current==null) return current;
            current=current.next;
        }
        return current;
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode front=head;
        ListNode behind=new ListNode(0);
        behind.next=head;
        ListNode temphead=behind;
        front=moveNode(front, n-1);
        
        while(front.next!=null){
            behind=behind.next;
            front=front.next;
        }
        behind.next=behind.next.next;
        return temphead.next;
    }
}
