/*
Permutation Sequence
The set[1,2,3,...,n] contains a total of n! unique permutations.
By listing and labeling all of the permutations in order, we get the following sequence (ie, for n=3):
"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.
Note: given n will be between 1 and 9 inclusive.
 */

import java.io.*;
import java.util.*;

public class PermutationSequence {
    
    public static void main(String[] args){
	permutationSequence(9,98884);
	permutationSequence(7,1234);
	permutationSequence(3,4);
	permutationSequence(5,16);
    }

    public static void permutationSequence(int n, int k){
	int[] arr=new int[n+1];
	int[] resultArr=new int[n+1];
	System.out.println("n= "+n+", k= "+k);
	arr[0]=1;
	ArrayList<Integer> numberList=new ArrayList<>();
	for(int i=1;i<=n;i++){
	    arr[i]=i*arr[i-1];
	    numberList.add(i);
	}
	int product=k-1;
	for(int j=1;j<=n;j++){
	    int indicator=product/arr[n-j];
	    resultArr[j]=numberList.remove(indicator);
	    product=product%arr[n-j];
	    System.out.print(resultArr[j]+",");
	}
	System.out.println();
    }
}
