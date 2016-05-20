/*
Next Permutation
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
If such arrangement is not possible, it must rearrange it as the lowest possible order(ie, sorted in ascending order).
The replacement must be in-place, do not allocate extrac memory.
Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3->1,3,2
3,2,1->1,2,3
1,1,5->1,5,1
 */

//1. Iterator from end to begin, exchange in-place where latter is larger than the former, and return.
//2. If not found, sort the array

import java.io.*;

public class NextPermutation {

    public static void main(String[] args){
	int[] arr1={1,2,3};
	int[] arr2={3,2,1};
	int[] arr3={1,1,5};
	int[] arr4={5,3,2,4,1};
	nextPermutation(arr1);
	nextPermutation(arr2);
	nextPermutation(arr3);
	nextPermutation(arr4);
    }
    public static void nextPermutation(int[] arr){
	int length=arr.length;
	if(length<=1)
	    return;
	for(int i=length-1;i>0;i--){
	    if(arr[i]>arr[i-1]){
		int exIndex=searchNext(arr,i,arr[i-1]);
		swap(arr,i-1,exIndex);
		for(int j=0;j<length;j++)
		    System.out.print(arr[j]+",");
		System.out.println();
		return;
	    }
	}
	quickSort(arr,0,length-1);
	for(int j=0;j<length;j++)
	    System.out.print(arr[j]+",");
	System.out.println();
    }

    public static int searchNext(int[] arr, int begin, int target){
	int length=arr.length;
	if(begin>=arr.length)
	    return -1;
	int gap=Integer.MAX_VALUE;
	int index=Integer.MAX_VALUE;
	for(int i=begin;i<length;i++){
	    if((arr[i]-target)>0){
		if(gap>(arr[i]-target)){
		    index=i;
		    gap=arr[i]-target;
		}
	    }
	}
	return index;
    }
    

    public static void quickSort(int[] arr, int left, int right){
	if(arr.length==0)
	    return;
	if(left>=right)
	    return;
	int mid=(left+right)/2;
	int pivot=arr[mid];
	int i=left;
	int j=right-1;
	swap(arr,mid,right);
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
