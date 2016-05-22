/*
Rotate List
Given a list, rotate the list to the right by k place, where k is non-negative.
For example: given 1->2->3->4->5->null and k=2, return 4->5->1->2->3->null.
 */
//Find the k+1 point from right;
//connect the tail to head;
//disconnect between k+1 and k,make head point to k

import java.io.*;

public class RotateList {
    public static ListNode rotate(ListNode head, int k){
	if(k==0||head==null)
	    return head;

	ListNode ptr=head;
	int length=1;
	while(ptr.next!=null){
	    length++;
	    ptr=ptr.next;
	}

	ptr.next=head;
	k=k%length;
	
	while(k>=0){
	    ptr=ptr.next;
	    k--;
	}

	head=ptr.next;
	ptr.next=null;

	return head;
    }
}
