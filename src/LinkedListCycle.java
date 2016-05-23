/*
Linked List Cycle
Given a linked list, determine if it has a cycle in it.
Follow up: can you solve it without using extra space?
 */

import java.io.*;

public class LinkedListCycle {

    public static boolean hasCycle(ListNode head){
	if(head==null||head.next==null)
	    return false;
	
	ListNode first=head;
	ListNode second=head;
	
	while((first!=null)&&(first!=second)){
	    first=first.next.next;
	    second=second.next;
	}
	if(first==null){
	    return false;
	}else{
	    return true;
	}
    }

}
