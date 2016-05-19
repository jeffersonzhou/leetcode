/*
Median of Two Sorted Arrays
There are two sorted arrays A and B of size m and n respectively.
Find the median of the two sorted arrays. The overall run time
complexity should be O(log(m+n)).
 */

import java.io.*;

public class Median2SortedArray {
    public static void main(String[] args){
	int[] A={1,4,7,11,23,21,26};
	int[] B={2,3,8,9,22,25};
	System.out.println(findMedian(A,7,B,6));
    }
    
    public static int findMedian(int[] A, int m, int[] B,int n){
	int total=m+n;
	if((total%2)==1){
	    return findKth(A,0,m,B,0,n,total/2+1);
	}else{
	    return (findKth(A,0,m,B,0,n,total/2)+findKth(A,0,m,B,0,n,total/2+1))/2;
	}
    }

    public static int findKth(int[] A, int astart,int m, int[] B,int bstart, int n, int k){
	//always assume that m is equal or smaller than n
	if(m>n) return findKth(B,bstart,n,A,astart,m,k);
	if(m==0) return B[bstart+k-1];
	if(k==1) return A[astart]>B[bstart]?B[bstart]:A[astart];

	//divide k into two parts
	int ia=m>k/2?k/2:m;
	int ib=k-ia;
	if(A[astart+ia-1]<B[bstart+ib-1]){
	    return findKth(A,astart+ia,m-ia,B,bstart,n,k-ia);
	}else if(A[astart+ia-1]>B[bstart+ib-1]){
	    return findKth(A,astart,m,B,bstart+ib,n-ib,k-ib);
	}else
	    return A[astart+ia-1];
	
    }

}
