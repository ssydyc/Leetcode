/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
      public ListNode sortList(ListNode head) {
        //use merge sort to a Linked List, up to bottom
        if(head==null) return head;
        int size=1;
        ListNode temp= new ListNode(1);
       	temp=head;	//begin at head
        while(temp.next!=null){
        	size++;
        	temp=temp.next;		//count the number until the end
        }//
        head=sub_sortList(head,size);	//do recursion
        return head;		
    }// end of sortList
    
    public ListNode sub_sortList(ListNode head, int size){
    	//do merge sort of size n,return the head
    	if(size==1) return head;	// one element, return directly
    	else{
    		ListNode temp= new ListNode(1);
    		ListNode before= new ListNode(1);
    		temp=head;	//begin at head
    		for(int i=0; i<size/2;i++){
    			before=temp;
    			temp=temp.next;		//now we reach the n/2+1 element
    		}
    		before.next=null;		//separate the list, give null to first list
    		ListNode move_1=sub_sortList(head, size/2);
    		ListNode move_2=sub_sortList(temp,size-size/2);	//divide it into two sub_linkedlist
    		head=move_1;	//set head to be the first
    		//now do conquer method, two linked lists with head head and temp, add all elments
    		// to the first linked list.
   		 	ListNode insert=new ListNode(1);
    		while(move_2!=null){
    			while(move_1!=null){
    				if(move_1.val<move_2.val){
    					insert=move_1;	//move_1 moves until get a value bigger than move_2.val
    					move_1=move_1.next;
    				}
    				else break;
    			}//end while
    			if(move_1==head){
    				temp=move_2.next;			//add move_2 as head
    				move_2.next=head;
    				head=move_2;
    				move_2=temp;
    				move_1=head;
    			}
    			else{
    				temp=move_2.next;			//add move_2 after insert
    				move_2.next=insert.next;
    				insert.next=move_2;
    				insert=move_2;
    				move_2=temp;
				}
    		}//end while
    	
    		return head;
    	}//end else
    
    }//end of sub_sortList
    
}//end of Sort_List