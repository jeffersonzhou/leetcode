/*
Trapping rain water
Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it is able to trap after raining.
For example, given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */

//Iterate the array
//Find the elements which can store water
import java.io.*;
import java.util.*;

public class TrappingRainWater {
    public static int getTrappedAmount(int[] arr){
	int length=arr.length;
	int[] max_left=new int[length];
	int[] max_right=new int[length];
	int left=Integer.MIN_VALUE;
	int right=Integer.MIN_VALUE;
	for(int i=0;i<length;i++){
	    if(left<arr[i]){
		max_left[i]=arr[i];
		left=arr[i];
	    }else{
		max_left[i]=left;
	    }
	    if(right<arr[length-i-1]){
		max_right[length-i-1]=arr[length-i-1];
		right=arr[length-i-1];
	    }else{
		max_right[length-i-1]=right;
	    }
	}
	int totalAmount=0;
	for(int j=0;j<length;j++){
	    int amount=Math.min(max_left[j],max_right[j])-arr[j];
	    if(amount>0)
		totalAmount+=amount;
	}
	return totalAmount;
    }

    public static void main(String[] args){
	int[] arr={0,1,0,2,1,0,1,3,2,1,2,1};
	System.out.println(getTrappedAmount(arr));
    }

}
