/*
Remove Duplicates from sorted array
Given a sorted array, remove the duplicates in place
such that each element appear only once and return the 
length.
Do not allocate extra space for another array, you must
do this in place with constant memory.
For example, given input array A=[1,1,2],
your function should return length=2, and A is now [1,2].
 */

import java.io.*;

public class RemoveDuplicates {
    
    public static void main(String[]args){
	int[] arr={1,1,2,3,4};
	System.out.println(removeDuplicates(arr));
    }

    public static int removeDuplicates(int[] arr){
	//use an index to store the array index
	//use an indicator to indicate whether it is the only element
	int indicator=0;
	boolean dup=false;
	int arr_length=arr.length;
	if(arr_length<=1)
	    return arr_length;
	for(int i=1;i<arr_length;i++){
	    if(arr[indicator]!=arr[i]){
		arr[++indicator]=arr[i];
	    }
	}
	return ++indicator;
    }
}
