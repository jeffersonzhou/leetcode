/*
Plus One
Given a number represented as an array of digits, plus one to the number.
 */

import java.io.*;

public class PlusOne {
    public static void main(String[] args){
	int[] arr={9,9,9,9,9,9};
	arr=plusDigit(arr,9);
	for(int i=0;i<arr.length;i++)
	    System.out.print(arr[i]+" ");
    }
    public static int[] plusDigit(int[] arr, int digit){
	int c=digit;
	int length=arr.length;
	for(int i=length-1;i>=0;i--){
	    int b=arr[i]+c;
	    c=b/10;
	    arr[i]=b%10;
	    if(c==0)
		return arr;
	}
	if(c!=0){
	    int[] temp=new int[length+1];
	    temp[0]=c;
	    for(int i=1;i<=length;i++){
		temp[i]=arr[i-1];
	    }
	    arr=temp;
	}
	return arr;
    }
}
