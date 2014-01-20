class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  };


public class Copy_list_random {
	
	 public RandomListNode copyRandomList(RandomListNode head) {
		 if(head==null)return head;
	     RandomListNode temp1=head;	//we need to keep head	
		 while(temp1!=null){// copy another one after temp2
			 RandomListNode temp2=new RandomListNode(temp1.label);
			 RandomListNode temp=temp1;
			 temp1=temp1.next;
			 temp.next=temp2;
			 temp2.next=temp1;
		 }
		 
		 temp1=head;
		 while(temp1!=null){// give the copy random pointer
			 RandomListNode temp2=temp1.next;
			 if(temp1.random==null) temp2.random=null;
			 else temp2.random=temp1.random.next;
			 temp1=temp2.next;
		 }
		 
		 RandomListNode head2=head.next;
		 temp1=head;
		 while(temp1!=null){// break the two LinkedList
			RandomListNode temp2=temp1.next;
			temp1.next=temp2.next;
			if(temp2.next!=null) temp2.next=temp1.next.next;
			temp1=temp1.next;
		 }
		 return head2;
	 }	
}
