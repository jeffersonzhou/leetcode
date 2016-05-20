/*
Two Sum
Given an array of integers, find two numbers such that they add up to a specific target number. 
The function twoSum should return indices of the two numbers such that they add up to the target,
where index1 must be less than index2. Please note that your returned answers(both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution.
Input: numbers={2,7,11,15},target=9
Output: index1=1, index2=2
 */

//Brutal Force: O(n2)
//Hash: O(n)

import java.io.*;
import java.util.*;

public class TwoSum {
    public static void main(String[] args){
	int[] arr={2,7,11,15};
	twoSum(arr,9);
    }
    
    /*
      @return 1 if found
      @return -1 if not found
     */
    public static int twoSum(int[] arr, int target){
	HashMap<Integer,Integer> map=new HashMap<>();
	for(int i=0;i<arr.length;i++){
	    map.put(arr[i],i);
	}
	for(int j=0;j<arr.length;j++){
	    if(arr[j]<target){
		int key=target-arr[j];
		if(map.containsKey(key)){
		    int index=map.get(key);
		    if(++j<++index){
			System.out.println("index1= "+j+" index2= "+index);
		    }else{
			System.out.println("index1= "+index+" index2= "+j);}
		    return 1;
		    }
	    }
	}
	return -1;
    }
}
