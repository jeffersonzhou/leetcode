/*
Add Binary
Given two binary strings, return their sum(also a binary string).
For example,
a="11"
b="1"
Return "100"
 */

import java.io.*;
import java.util.*;

public class AddBinary {
    public static void main(String[] args){
	String str1="     111101";
	String str2="111";
	System.out.println(add(str1,str2));
    }
    
    public static String add(String str1, String str2){
	if(str1==null)
	    return str2;
	if(str2==null)
	    return str1;

	int str1_len=str1.length();
	int str2_len=str2.length();

	int str1_start=0;
	int str2_start=0;
	int c=0;
	String result="";
	
	while(str1.charAt(str1_start)==' '&&str1_start<str1_len){
	    str1_start++;
	}
	while(str2.charAt(str2_start)==' '&&str2_start<str2_len){
	    str2_start++;
	}
	
	if(str1_start>=str1_len&&str2_start>=str2_len){
	    return " ";
	}else if(str1_start>=str1_len){
	    return str2;
	}else if(str2_start>=str2_len){
	    return str1;
	}else{
	    int a;
	    int b;
	    while(str1_start<str1_len||str2_start<str2_len){
		if(str1_len<=str1_start){
		    a=0;
		}else {
		    a=str1.charAt(str1_len-1)-'0';
		}
		if(str2_len<=str2_start){
		    b=0;
		}else{
		    b=str2.charAt(str2_len-1)-'0';
		}
		c=c+a+b;
		result=c%2+result;
		c=c/2;
		str1_len--;
		str2_len--;
	    }
	    if(c==1)
		result=c+result;
	}
	return result;
    }
}
