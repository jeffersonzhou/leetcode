/*
3Sum Closest
Given an arry S of n integers, find three integers in S such that the sum is closest to a given number target.
Return the sum of the three integers. You may assume that each input would have exactly one solution.
For example, given array S={-1 2 1 -4}, and target=1.
The sum that is closest to the target is 2. (-1+2+1=2)
 */

//Sort the array
//Binary Search for the closest in the run
//Compare to the global closest

import java.io.*;

public class ThreeSumClosest {
    public static void main(String[] args){
	int[] arr={-1,2,1,-4};
	threeSumClosest(arr,1);
    }
    public static void threeSumClosest(int[] arr, int target){
	int length=arr.length;
	if(length==0)
	    return;
	quickSort(arr,0,arr.length-1);
	int closestValue=Integer.MAX_VALUE;
	int a=0;
	int b=0;
	int c=0;
	int prev1=Integer.MAX_VALUE;
	for(int k=0;k<length;k++){
	    if(prev1==arr[k]){
		continue;
	    }else{
		prev1=arr[k];
	    }
	    int prev2=Integer.MAX_VALUE;
	    for(int i=k+1;i<length-1;i++){
		if(prev2==arr[i]){
		    continue;
		}else{
		    prev2=arr[i];
		}
		int index=cBinarySearch(arr,i+1,length-1,target-arr[k]-arr[i]);
		if(closestValue>Math.abs(arr[k]+arr[i]+index-target)){
		    a=arr[k];
		    b=arr[i];
		    c=index;
		    closestValue=Math.abs(arr[k]+arr[i]+index-target);
		}
		if(closestValue==0){
		    System.out.println(a+"+"+b+"+"+c+"="+closestValue);
		    return;
		}
	    }
		// System.out.println(a+"+"+b+"+"+c+"="+closestValue);
	}
	    System.out.println(a+"+"+b+"+"+c+"="+(a+b+c));
    }

    private static void swap(int[] arr, int left, int right){
	int temp=arr[left];
	arr[left]=arr[right];
	arr[right]=temp;
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

    public static int cBinarySearch(int[] arr, int left, int right, int target){
	int gap=Integer.MAX_VALUE;
	int cValue=0;
	for(int i=left;i<=right;i++){
	    if(gap==0)
		return cValue;
	    if(gap>Math.abs(target-arr[i])){
		gap=Math.abs(target-arr[i]);
		cValue=arr[i];
	    }
	}
	return cValue;
    }
}
