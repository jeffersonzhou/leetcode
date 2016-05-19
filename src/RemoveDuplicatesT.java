/*
Remove Duplicates from Sorted Array II
Follow up for "remove duplicates": what if duplicates
are allowed at most twice?
For example, given sorted array A=[1,1,1,2,2,3],
your function should returns length=5, and A is now
[1,1,2,2,3]
 */

import java.io.*;

public class RemoveDuplicatesT {
    
    public static void main(String[] args){
	int[] arr={1,1,1,2,2,3};
	int length=removeDuplicatesT(arr);
	System.out.println(length);
	for(int i=0;i<length;i++){
	    System.out.println(arr[i]);
	}
    }

    public static int removeDuplicatesT(int[] arr){
	int indicator=0;
	boolean dup=false;
	int length=arr.length;
	if(length<=1)
	    return length;
	for(int i=1;i<length;i++){
	    if(arr[indicator]!=arr[i]){
		arr[++indicator]=arr[i];
		dup=false;
	    }else if(dup==false){
		arr[++indicator]=arr[i];
		dup=true;
	    }
	}
	return ++indicator;
    }
}
