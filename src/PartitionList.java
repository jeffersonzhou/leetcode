/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.
For example, given 1->4->3->2->5->2 and x=3, return 1->2->2->4->3->5
 */

import java.io.*;

public class PartitionList {
    
    public static ListNode partion(ListNode head, int target){
	if(head==null){

	    return head;
	}
		    
	ListNode ptr=head;
	ListNode cur=new ListNode(0);
	cur.next=head;
	head=cur;
	ListNode prev=cur;
	while(ptr!=null){
	    if(ptr.value<target){
		prev.next=ptr.next;
		ptr.next=cur.next;
		cur.next=ptr;
		cur=ptr;
		ptr=prev.next;
	    }else{
		prev=ptr;
		ptr=ptr.next;
	    }
	}
	head=head.next;
	return head;
    }
}
