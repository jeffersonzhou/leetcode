/*
Longest Consecutive Sequence
Given an unsorted array of integers, find the length of 
the longest consecutive elements sequence.
For example, given[100,4,200,1,3,2],the longest consecutive
sequence is [1,2,3,4]. Return its length:4.
Your algorithm should run in O(n) complexity.
 */

//hash table is used 
import java.io.*;
import java.util.*;

public class LongestConsSequence {
    
    public static void main(String[] args){
	int[] arr={100,4,200,1,3,2};
	System.out.println(longestConsecutive(arr));
    }

    public static int longestConsecutive(int[] arr){
	HashSet<Integer> set= new HashSet<>();
	for(int i=0;i<arr.length;i++){
	    set.add(arr[i]);
	}

	int longest=0;
	for(int j=0; j<arr.length;j++){
	    int down=arr[j]-1;
	    while(set.contains(down)){
		set.remove(down);
		down--;
	    }
	    int up=arr[j]+1;
	    while(set.contains(up)){
		set.remove(up);
		up++;
	    }
	    longest=Math.max(longest, up-down-1);
	}
	return longest;

    }
}
