public class Solution {
   public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        if(head==null) return null;
        while(true){
            fast=fast.next==null?fast.next:fast.next.next;
            slow=slow.next;
            if(slow==null||fast==null) return null;
            if(fast==slow) break;
        }//end of while
        slow=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}