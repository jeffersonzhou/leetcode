/*
Add Two Numbers
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order
and each of their nodes contain a single digit. Add the two numbers and retrun it as a linked list.
Input: (2->4->3)+(5->6->4)
Output:7->0->8
 */

//Check if two linked lists have same length
import java.io.*;
import java.util.*;

public class AddTwoNumbers {

    public static ArrayList<Integer> addTwoNumbers(ArrayList<Integer> first, ArrayList<Integer> second){
	int first_size=first.size();
	int second_size=second.size();
	int c=0;
	ArrayList<Integer> result=new ArrayList<>();
	if(first_size==second_size){
	    for(int i=0;i<first_size;i++){
		c=c+first.get(i)+second.get(i);
		result.add(c%10);
		c=c/10;
	    }
	}else if(first_size>second_size){
	    for(int i=0;i<second_size;i++){
		c=c+first.get(i)+second.get(i);
		result.add(c%10);
		c=c/10;
	    }
	    for(int i=second_size;i<first_size;i++){
		c=c+first.get(i);
		result.add(c%10);
		c=c/10;
	    }
	}else{
	    for(int i=0;i<first_size;i++){
		c=c+first.get(i)+second.get(i);
		result.add(c%10);
		c=c/10;
	    }
	    for(int i=first_size;i<second_size;i++){
		c=c+second.get(i);
		result.add(c%10);
		c=c/10;
	    }
	}
	return result;
    }

    public static void main(String[] args){
	ArrayList<Integer> first=new ArrayList<>();
	ArrayList<Integer> second=new ArrayList<>();
	first.add(2);
	first.add(4);
	first.add(3);
	second.add(5);
	second.add(6);
	second.add(4);
	ArrayList<Integer> result=addTwoNumbers(first,second);
	for(int i: result){
	    System.out.print(i+"->");
	}
    }
}
