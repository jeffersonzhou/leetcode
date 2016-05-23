/*
Implement strStr().
Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
 */

//Search the Input string if the first char matches, iterate to the next, when the substring matches, return the index of first char, if not, go through the input string, return null if end of string.

import java.io.*;

public class ImplementStr {
    public static void main(String[] args){
	String needle="ABC";
	String haystack="ASDFGHJKABCJHHJKKL";
	System.out.println(strStr(haystack,needle));
    }
    
    public static int strStr(String haystack, String needle){
	if(needle==null||haystack==null)
	    return -1;
	int haystack_length=haystack.length();
	int needle_length=needle.length();
	
	int index=0;
	while(index<=haystack_length-needle_length){
	    if(haystack.charAt(index)==needle.charAt(0)){
		boolean in_haystack=true;
		int i=1;
		while(i<needle_length&&in_haystack==true){
		    if(haystack.charAt(index+i)!=needle.charAt(i)){
			in_haystack=false;
			i++;
		    }else{
			i++;
		    }
		}
		if(in_haystack==true){
		    return index;
		}
	    }
	    index++;
	}
	return -1;
    }
}
