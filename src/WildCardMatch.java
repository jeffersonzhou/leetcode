/*
Wildcard Matching
Implement wildcard pattern matching with support for '?' and '*'.
'?' matches any single character. '*' matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).
The function prototype should be:
boolean isMatch(String str1, String str2)
Some examples:

isMatch("aa","a")--> false;
isMatch("aa","aa")-->true;
isMatch("aaa","aa")-->false;
isMatch("aa","*")-->true;
isMatch("aa","a*")-->true;
isMatch("ab","?*")-->true;
isMatch("aab","c*a*b")-->false
 */

import java.io.*;
import java.util.*;

public class WildCardMatch{

    public static void main(String[] args){
	System.out.println(isMatch("aaa","?*"));
	System.out.println(isMatch("aaa","c*aa"));
	   
    }
    public static boolean isMatch(String str1,String str2){
	int str1_len=str1.length();
	int str2_len=str2.length();
	if(str2_len==0){
	    return str1_len==0;
	}
	if(str2.charAt(0)!='*'){
	    if(str1_len==0||(str1.charAt(0)!=str2.charAt(0)&&str2.charAt(0)!='?')){
		return false;
	    }else {
		return isMatch(str1.substring(1),str2.substring(1));
	    }
	}

	while(str1.length()>0){
	    if(isMatch(str1.substring(1),str2.substring(1))){
		return true;
	    }
	    str1=str1.substring(1);
	}

	return isMatch(str1,str2.substring(1));
    }
}
