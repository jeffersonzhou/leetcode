/*
Linked List Cycle II
Given a linked list, return the node where they cycle begins. If there is no cycle, return null.
Follow up:can you solve it without using extra space?
 */

//Set two pointers: slow one second, move one step per time, fast one first, move 2 steps per time, 
//When they meet, the slow one move: a+b, the fast one move a+b+c+nR
//a+b+nR=2(a+b)-->a+b=nR
//R=b+c
//-->a+b=(n-1)R+b+c-->a=(n-1)R+c
//So add additional slow pointer from head: ptr; when ptr meet second, it's the place where the cycle starts

import java.io.*;

public class LinkedListCycleAdv {
    
    public static ListNode hasCycle(ListNode head){
	if(head==null||head.next==null){
	    return null;
	}

	ListNode first=head;
	ListNode second=head;
	ListNode ptr=head;
	while((first!=null)&&(first!=second)){
	    first=first.next.next;
	    second=second.next;
	}
	if(first==null){
	    return null;
	}else{
	    while(second!=ptr){
		second=second.next;
		ptr=ptr.next;
	    }
	    return ptr;
	}
    }

}
