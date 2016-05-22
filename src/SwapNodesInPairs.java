/*
Swap nodes in pairs
Given a linked list, swap every two adjacent nodes and return its head.
For example, given 1->2->3->4, you should return the list as 2->1->4->3.
Your algorithm should use only constant space. You may not modify the values in the list, only nodes
itself can be changed.
 */

import java.io.*;

public class SwapNodesInPairs {
    public static ListNode swapNodes(ListNode head){
	if(head==null||head.next==null)
	    return;
	ListNode cur=new ListNode(0);
	cur.next=head;
	head=cur;
	int count=1;
	ListNode ptr=head.next;
	ListNode prev=head;
	while(ptr.next!=null){
	    if(count==2){
		prev.next.next=ptr.next;
		ptr.next=prev.next;
		prev.next=ptr;
		prev=ptr.next;
		ptr=prev.next;
		count=1;
	    }else{
		ptr=ptr.next;
		count++;
	    }
	}
	return head.next;
    }
}
