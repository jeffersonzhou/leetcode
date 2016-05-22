/*
Remove Nth Node from End of List
Given a linked list, remove the nth node from the end of list and return its head.
For example, given linked list: 1->2->3->4->5, and n=2
After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
 */

//Set 2 pointers, p, q, let p move ahead for n steps, then move p and q forward until p is the end
import java.io.*;

public class RemoveNthNode {
    public static ListNode removeNthNode(ListNode head, int n){
	if(head==null)
	    return head;

	ListNode p=null;
	ListNode q=null;
	
	ListNode cur=new ListNode(0);
	cur.next=head;
	head=cur;
	p=head;
	q=head;
	for(int i=1;i<=n;i++){
	    p=p.next;
	}

	while(p.next!=null){
	    p=p.next;
	    q=q.next;
	}
	q.next=q.next.next;
	return head.next;
    }
}
