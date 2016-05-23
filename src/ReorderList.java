/*
Reoreder List
Given a singly linked list L: L0->L1->...->Ln-1->Ln, reorder it to: L0->Ln->L1->Ln-1->L2->Ln-2->...
You must do this in-place without altering the nodes' values.
For example, given {1,2,3,4}, reorder it to {1,4,2,3}
 */

//first find out the middle node
//second reverse the second half of list
//third merge the first half with the reversed second half.

import java.io.*;

public class ReorderList {
    public static ListNode reorderList(ListNode head){
	if(head==null){
	    return null;
	}

	ListNode cur=new ListNode(0);
	cur.next=head;
	head=cur;
	ListNode ptr=head;
	int length=0;
	while(ptr.next!=null){
	    length++;
	    ptr=ptr.next;
	}

	
	ListNode mid_node=head;
	int mid=(length+1)/2+1;
	while(mid>1){
	    mid_node=mid_node.next;
	    mid--;
	}
	ListNode p=mide_node.next;
 
	for(int i=1;i<length/2;i++){
	    mid_node.next=p.next;
	    p.next=ptr.next;
	    ptr.next=p;
	    p=mid_node.next;
	}
	p=mid_node.next;
	mid_node.next=null;
	mid_node=p;
	p=null;
	ptr=head.next;
	for(int i=1;i<=length/2;i++){
	    p=ptr.next;
	    ptr.next=mid_node;
	    mid_node=mid_node.next;
	    ptr.next.next=p;
	    ptr=p;
	    p=null;
	}
	
	return head.next;
    }
}
