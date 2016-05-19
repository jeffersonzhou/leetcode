/*
Search in Rotated Sorted Array II
Follow up for "search in rotated array":
what if duplicates are allowed?
Would this affect the run-time complexity? How and Why?
Write a function to determine if a given target is in the array.
*/

//There is influence on the run time.

import java.io.*;

public class SearchRSArrayT {
    public static void main(String[] args){
	int[] a1={4,5,6,7,0,1,2,3};
	int[] a2={1,3,1,1,1,1,1};
	System.out.println(binarySearchT(a1,1));
	System.out.println(binarySearchT(a2,3));
    }

    public static int binarySearchT(int[] arr, int target){
	int first=0;
	int last=arr.length;
	int mid=0;
	if(last==0)
	    return -1;
	while(first!=last){
	    mid=first+(last-first)/2;
	    if(arr[mid]==target)
		return mid;
	    if(arr[mid]>arr[first]){
		if(arr[first]<=target&&arr[mid]>target){
		    last=mid;
		}else{
		    first=mid+1;
		}
	    }else if(arr[mid]<arr[first]){
		if(arr[mid]<target&&arr[last-1]>=target){
		    first=mid+1;
		}else{
		    last=mid;
		}
	    }else{
		first++;
	    }
	}
	return -1;

    }
}
