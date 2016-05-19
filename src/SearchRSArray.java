/*
Search in rotated sorted array
Suppose a sorted array is rotated at some pivot unknown to
you before hand.
(i.e., 0 1 2 4 5 7 might become 4 5 6 7 0 1 2).
You are given a target value to search. If found
in the array, return its index, otherwise return -1.
You may assume no duplicate exists in the array.
 */

import java.io.*;

public class SearchRSArray {
    
    public static void main(String[] args){
	int[] arr={4,5,6,7,0,1,2};
	int bfIndex=BFSearch(arr,1);
	int bIndex=BinarySearch(arr,1);
	System.out.println(bfIndex+",  "+bIndex);
    }

    //Brutal Force version O(n)
    public static int BFSearch(int[] arr, int e){
	int length=arr.length;
	if(length==0)
	    return -1;
	for(int i=0;i<length;i++){
	    if(e==arr[i])
		return i;
	}
	return -1;
    }

    public static int BinarySearch(int[] arr,int e){
	if(arr.length==0){
	    return -1;
	}
	int first=0;
	int last=arr.length;
	while(first!=last){
	    int mid=first+(last-first)/2;
	    if(arr[mid]==e)
		return mid;
	    if(arr[first]<=arr[mid]){
		if((arr[first]<=e)&&(e<=arr[mid])){
		    last=mid;
		}else{
		    first=mid+1;
		}
	    }else{
		if((arr[mid]<e)&&(e<=arr[last-1])){
		    first=mid+1;
		}else{
		    last=mid;
		}
	    }
	}
	return -1;
	
    }

}
