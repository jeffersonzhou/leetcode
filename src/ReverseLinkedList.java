/*
Reverse Linked List II
Reverse a linked list from position m to n. Do it in-place and in one-pass.
For example: Given 1->2->3->4->5nullptr, m=2 and n=4,
return 1->4->3->2->5->nullptr.
Note:Given m,n satisfy the following condition: 1<=m<=n<=length of list.
 */

import java.io.*;

public class ReverseLinkedList {

    public static ListNode reverseBetween( ListNode head, int m, int n){
	if(m==n)
	    return head;
	ListNode prev=null;
	ListNode m_node=null;
	ListNode n_node=null;
	ListNode ptr=head;
	int i=0;
	while(ptr!=null){
	    i++;
	    if(i==m-1){
		prev=p;
	    }
	    if(i==m){
		m_node=p;
	    }
	    if(i==n){
		n_node=p;
		p=null;
	    }
	    if(p==null){
		break;
	    }else{
		p=p.next;
	    }
	}
	
	if(m_node==null){
	    return head;
	}

	for(int i=m;i<n;i++){
	    prev.next=first.next;
	    first.next=second.next;
	    second.next=first;
	    first=prev.next;
	}
	return head;
    }
}
