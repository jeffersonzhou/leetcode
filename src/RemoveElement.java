/*
Remove Element
Given an array and a value, remove all instances of that value in place and return the new length.
The order of elements can be changed. It doesn't matter what you leave beyond the new length.

 */

//Sort array first
//Iterator the sorted array to remove the instances
/*
update: the sort process is unnecessary. So the complexity should be O(n).
 */

import java.io.*;

public class RemoveElement {

    public static void main(String[] args){
	int[] arr={-1,3,2,1,-4,1,4,-2,1,1,2,3};
	System.out.println(removeElement(arr,1));
    }
    public static int removeElement(int[] arr, int target){
	int length=arr.length;
	if(length==0)
	    return 0;
	quickSort(arr,0,length-1);
	int j=0;
	for(int i=0;i<length;i++){
	    if(arr[i]!=target){
		arr[j++]=arr[i];
	    }
	}
	return j;
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
}

