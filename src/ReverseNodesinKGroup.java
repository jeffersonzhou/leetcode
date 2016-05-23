/*
Reverse Nodes in k-Group
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
If the number of nodes is not a multiple of k then left out nodes in the end should remain as it is.
You may not alter the values in the nodes, only nodes itself may be changed.
Only constant memory is allowed.
For example, given this list: 1->2->3->4->5
For k=2, you should return: 2->1->4->3->5
For k=3, you should return:3->2->1->4->5
 */

//Go through the list, if the count get to k, reverse the elements from count 1 to k.

import java.io.*;

public class ReverseNodesinKGroup {
    
    public static ListNode reverseNode(ListNode head, int k){
	if(head==null||k==0||k==1)
	    return head;

	ListNode cur=new ListNode(0);
	cur.next=head;
	head=cur;
	ListNode ptr=head;
	ListNode prev=head;
	int count=0;
	while(ptr.next!=null){
	    count++;
	    ptr=ptr.next;
	    if(count==k){
		//	reverseList;
		ListNode p=ptr;
		ListNode q=ptr.next;
		ptr=prev.next;
		for(int i=1;i<k;i++){
		    p.next=prev.next;
		    prev.next=prev.next.next;
		    p.next.next=q;
		    q=p.next;
		}
		prev=ptr;
		count=0;
	    }
	    
	}
	return head.next;

    }

}
