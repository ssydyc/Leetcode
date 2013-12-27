
public class Reverse_order {
	public void reorderList(ListNode head){
		if(head==null||head.next==null);
		else{
			ListNode temp=head;
			int size=0;
			while(temp!=null){
				size++;
				temp=temp.next;
			}
			size=size%2==0?size/2:size/2+1;	//seperate the LinkList
			temp=head;
			while(size>1){
				temp=temp.next;
				size--;
			}
			ListNode head2=temp.next;	//place to seperate
			temp.next=null;
			ListNode head1=head;
			head2=reverseList(head2);	//reverseList now
			//now it's time to connect these two LinkList;
			connect_List(head1,head2);
		}//end of else
		
		
	}//reorder LinkList
	
	
	public void connect_List(ListNode head1,ListNode head2){
		ListNode temp1=head1;
		ListNode temp2=head2;
		while(head1.next!=null){
			temp1=head1.next;
			temp2=head2.next;
			head1.next=head2;
			head2.next=temp1;
			head1=temp1;
			head2=temp2;
		}//end of while
		if(temp2!=null) head1.next=temp2;
	}
	
	
	
	 public ListNode reverseList(ListNode head) {
	        if(head==null) return head; //do nothing in this case
	        else{
	        	ListNode temp1=null;
	        	ListNode temp2=head;
	        	ListNode temp3;			//we need three nodes to finish it
	        	while(temp2!=null){
	        		temp3=temp2.next;
	        		temp2.next=temp1;
	        		temp1=temp2;
	        		temp2=temp3;
	        	}// end of null
	        	head=temp1;
	        	return head;
	        } //else
	        	
	        
	 
	 }//reverse the LinkList
}//end of class
