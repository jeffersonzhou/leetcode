/*
Copy List with Random Pointer
A linked list is given such that each node contains an additional random pointer which could point to any node
in the list or null.
Return a deep copy of the list.
 */

import java.io.*;

public class CopyListWRandomPointer {
    
    public static ListNode copyList(ListNode head){
	
	ListNode ptr=head;
	//Insert copy of list into the list
	while(ptr!=null){
	    ListNode copy_node=new ListNode();
	    copy_node.value=ptr.value;
	    copy_node.next=ptr.next;
	    copy_node.random=ptr.random;
	    ptr.next=copy_node;
	    ptr=copy_node.next;
	}
	//Separate two list
	ListNode copy_head=head.next;
	ListNode copy_ptr=copy_head;
	ptr=head;
	while(ptr!=null){
	    copy_ptr.random=ptr.random.next;
	    ptr.next=ptr.next.next;
	    copy_ptr.next=ptr.next.next;
	    ptr=ptr.next;
	    copy_ptr=copy_ptr.next;
	}
	return copy_head;
    }
}
