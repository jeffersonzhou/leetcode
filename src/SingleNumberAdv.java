/*
Single Number II
Given an array of integers, every element appears three times except for one. Find that single one.
Note: Your algorithm should have a linear runtime complexity. Could you implement it without using
extra memory?
 */

import java.io.*;
import java.util.*;

public class SingleNumberAdv {
    public static int getSingleNumber(int[] arr){
	int size=Integer.SIZE;
	int[] count=new int[size];
	int length=arr.length;
	
	for(int i=0;i<length;i++){
	    for(int j=0;j<size;j++){
		count[j]=count[j]+((arr[i]>>>j)&1);
		//		System.out.println(count[j]);
		//	count[j]=count[j]%3;
	    }
	}
	int value=0;
	for(int i=0;i<size;i++){
	    if((count[i]%3)!=0){
		value=value+(int)Math.pow(2,i);
	    }
	}
	return value;
    }
    
    public static void main(String[] args){
	int[] arr={1,1,1,2,2,2,3,3,3,4,4};
	System.out.println(getSingleNumber(arr));
    }
}
