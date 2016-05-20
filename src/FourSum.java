/*
4Sum
Given an array S of n integers, are there elements a,b,c and d in S such that a+b+c+d=target?
Find all unique quadruplets in the array which gives the sum of target.
Note:
Elements in a quadruplet(a,b,c,d) must be in non-descending order. (i.e., a<=b<=c<=d)
The solution set must not contain duplicate quadruplets.
For example, given array S={1 0 -1 0 -2 2}, and target=0.
A solution set is:
(-1,0,0,1)
(-2,-1,1,2)
(-2,0,0,2) 
 */

//Sort Array
//Transform it into 3Sum problem->2Sum problem

import java.io.*;

public class FourSum {
    public static void main(String[] args){
	int[] arr={1,0,-1,0,-2,2};
	fourSum(arr,0);
    }
    public static void fourSum(int[] arr, int target){
	int length=arr.length;
	if(length<4)
	    return;
	quickSort(arr,0,length-1); //O(nlogn)
	int prev1=Integer.MAX_VALUE;
	for(int k=0;k<length-3;k++){
	    if(prev1==arr[k]){
		continue;
	    }else{
		prev1=arr[k];
	    }
	    int prev2=Integer.MAX_VALUE;
	    for(int i=k+1;i<length-2;i++){
		if(prev2==arr[i]){
		    continue;
		}else{
		    prev2=arr[i];
		}
		int prev3=Integer.MAX_VALUE;
		for(int j=i+1;j<length-1;j++){
		    if(prev3==arr[j]){
			continue;
		    }else{
			prev3=arr[j];
		    }
		    int value=target-arr[k]-arr[i]-arr[j];
		    int index=binarySearch(arr,j+1,length-1,value);
		    if(index!=-1){
			System.out.println(arr[k]+", "+arr[i]+", "+arr[j]+", "+arr[index]);
		    }
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
		i++;
		j--;
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
	//return -1 if not found
	if(left>right)
	    return -1;
	int mid=(left+right)/2;
	if(arr[mid]==target){
	    return mid;
	}
	else if(arr[mid]>target){
	    return binarySearch(arr,left,mid-1,target);
	}
	else{
	    return binarySearch(arr,mid+1,right,target);
	}
    }


}
