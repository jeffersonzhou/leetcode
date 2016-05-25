/*
Longest Common Prefix
Write a function to find the longest common prefix string amongst an array of strings.
 */

import java.io.*;
import java.util.*;

public class LongestCommonPrefix {
    public static void main(String[] args){
	
    }
    
    public static String LCP(String[] strs){
	int length=strs.length;
	if(length==0){
	    return "";
	}
	
	String lcp="";
	int count=0;
	while(count<strs[0].length()){
	    
	    char c=strs[0].charAt(count);
	    
	    for(int i=1;i<length;i++){
		if(count>=strs[i].length()){
		    return lcp;
		}else{
		    if(strs[i].charAt(count)!=c){
			return lcp;
		    }
		}
	    }
	    lcp=lcp+c;
	    count++;
	}
	return lcp;
    }
    
}
