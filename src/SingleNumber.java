/*
Single Number
Given an array of integers, every element appears twice except for one. Find that single one.
Note: Your algorithm should have a linear runtime complexity. 
Could you implement it without using extra memory?
 */

//hash table --> extra memory used

//bit operation xor: if appear twice, a xor a =0;

import java.io.*;

public class SingleNumber {
    public static int getSingleNumber(int[] arr){
	int result=0;
	int length=arr.length;
	for(int i=0;i<length;i++){
	    result=result^arr[i];
	}
	return result;
	
    }

    public static void main(String[] args){
	int[] arr={1,2,3,4,5,6,7,1,2,3,4,5,6};
	System.out.println(getSingleNumber(arr));
    }
}
