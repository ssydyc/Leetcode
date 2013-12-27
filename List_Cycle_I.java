public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&slow!=null){
            fast=fast.next==null?fast.next:fast.next.next;
            slow=slow.next;
            if(slow==null) return false;
            if(fast==slow)return true;
        }
        return false;
    }
}