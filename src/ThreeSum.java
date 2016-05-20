/*
3Sum
Given an array S of n integers, are there elements a,b,c in S such that a+b+c=0?
Find all unique triplets in the array which gives the sum of zero.
Note:
  Elements in a triplet(a,b,c)must be in non-descending order.(i.e., a<=b<=c)
  The solution set must not contain duplicate triplets.
For example, given array S={-1 0 1 2 -1 -4}.
A solution set is:
{-1,0,1}
{-1,-1,2}
 */

//First sort the array
//Then use two pointers to index the left and right element
//Find out the possible value

import java.io.*;

public class ThreeSum {
    public static void main(String[] args){
	int[] arr={-1,0,1,2,-1,-4};
	threeSum(arr);
    }
    public static void threeSum(int[] arr){
	quickSort(arr,0,arr.length-1);
	int length=arr.length;
	int out_indicator=Integer.MAX_VALUE;
	for(int k=0;k<length;k++){
	    if(out_indicator==arr[k]){
		continue;
	    }else{
		out_indicator=arr[k];
	    }
	    int inner_indicator=Integer.MAX_VALUE;
	    for(int i=k+1;i<length-1;i++){
		if(inner_indicator==arr[i]){
		    continue;
		}else{
		    inner_indicator=arr[i];
		}
		int index=binarySearch(arr,i+1,length-1,(-arr[k]-arr[i]));
		if(index!=-1){
		    System.out.println("a= "+arr[k]+" b= "+arr[i]+" c= "+arr[index]);
		}
	    }
	}
    }

    public static void quickSort(int[] arr, int left, int right){
	if(arr.length==0)
	    return;
	if(left>=right)
	    return;
	int mid=(left+right)/2;
	int pivot=arr[mid];
	swap(arr,mid,right);
	int i=left;
	int j=right-1;
	while(i<=j){
	    if(arr[i]<=pivot){
		i++;
	    }else if(arr[j]>pivot){
		j--;
	    }else{
		swap(arr,i,j);
	    }
	}
	swap(arr,i,right);
	quickSort(arr,left,i-1);
	quickSort(arr,i+1,right);
	
    }

    public static void swap(int[] arr, int left, int right){
	int temp=arr[left];
	arr[left]=arr[right];
	arr[right]=temp;
    }

    public static int binarySearch(int[] arr, int left, int right, int target){
	
	if(left>right){
	    return -1;
	}
	int mid=(left+right)/2;
	if(arr[mid]==target){
	    return mid;
	}else if(arr[mid]>target){
	    return binarySearch(arr,left,mid-1,target);
	}else{
	    return binarySearch(arr,mid+1,right,target);
	}
    }
}
