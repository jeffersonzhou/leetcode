/*
Remove Duplicates from sorted list II
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers
from the original list.
For example,
given 1->2->3->3->4->4->5, return 1->2->5
given 1->1->1->2->3, return 2->3.
 */

import java.io.*;

public class RemoveDuplicatesAdv {

    public static ListNode removeDuplicate(ListNode head){

	if(head==null)
	    return head;

	ListNode ptr=head.next;
	//	ListNode prev=null;
	int compare_value=head.value;
	boolean isDuplicated=false;
	ListNode cur=new ListNode(0);
	cur.next=head;
	head=cur;
	while(ptr!=null){
	    if(ptr.value!=compare_value){
		if(isDuplicated){
		    cur.next=ptr;
		    compare_value=ptr.value;
		    isDuplicated=false;
		    ptr=ptr.next;
		}else{
		    cur=cur.next;
		    compare_value=ptr.value;
		    ptr=ptr.next;
		}
	    }else{
		isDuplicated=true;
		ptr=ptr.next;
	    }
	}
	return head.next;
    }
}
