/*
Remove Duplicates from Sorted List
Given a sorted linked list, delete all duplicates such that each element appear only one.
For example,
Given 1->1->2, return 1->2
Given 1->1->2->3->3 return 1->2->3
 */

import java.io.*;

public class RemoveDuplicatesFromList {

    public static ListNode removeDuplicates(ListNode head){
	if(head==null){
	    return head;
	}
	ListNode ptr=head;
	int compare_value=Integer.MAX_VALUE;
	ListNode prev=null;
	while(ptr!=null){
	    if(ptr.value!=compare_value){
		compare_value=ptr.value;
		prev=ptr;
		ptr=ptr.next;
	    }else{
		prev.next=ptr.next;
		ptr=prev.next;
	    }
	    
	}
	return head;
    }
}
