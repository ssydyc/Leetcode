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
    
  public ListNode insertionSortList(ListNode head) {
        //insertion sort applied to LinkedList
        if(head==null) return head;
        if(head.next==null) return head;
        ListNode move_1=head;				//pinpoint the place
        ListNode move_2=head.next;				//move the element to add
        move_1.next=null;					//we cut it into two links
        ListNode temp=head;
        ListNode before=head;
        while(move_2!=null){
        	while(move_1!=null){
        		if(move_1.val<move_2.val){
        			before=move_1;
        			move_1=move_1.next;
        		}	
        		else break;
        	}//end of move_1
        	
        	// add move_2 before move_1 or after before
        	if(move_1==head){	// add move_2 as a head
        		temp=move_2.next;
        		move_2.next=head;
        		head=move_2;
        		move_2=temp;
        	
        	}
        	else if(move_1==move_2){
        		
        	}
        	
        	else{				//add move_2 just after before
        		temp=move_2.next;
        		move_2.next=before.next;
        		before.next=move_2;
        		move_2=temp;
        	}
        	move_1=head;
        }// end of while move_2
        return head;
        
    }// end of insertionSortList




}// end of class