/*
Longest Palindromic Substring
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */

//1. Reverse the S and align with the S;
//2. Get the longest common subsequence,second longest common subsequence ... and check if it's palindromic sequence

import java.iol*;
import java.util.*;

public class LongestPalindromicSubstring {

    public static String LPS(String str){
	if(str==null||str.length()==0){
	    return "";
	}

	int len=str.length();
	String r_str="";
	for(int i=len-1;i>=0;i--){
	    r_str=r_str+str.charAt(i);
	}
	ArrayList<String> palindrome_list=new ArrayList<>();
	String p_str="";
	for(int i=0;i<len;i++){
	    for(int j=0;j<len;j++){
		if(str.charAt(i)==r_str.charAt(j)){
		    p_str=p_str+str.charAt(i);
		}else{
		    if(isPalindrome(p_str)){
			palindrom_list.add(p_str);
			p_str="";
		    }
		}else{
		    p_str="";
		}
	    }
	}
	String result=findLargestStr(palindrome_list);
	return result;
    }

    //Manacher's Algorithm
    public static String findLongestPalindrome(String s){
	if(s==null||s.length()==0){
	    return "";
	}

	char[] s2=addBoundaries(s.toCharArray());
	int[] p=new int[s2.length];
	int c=0,r=0;//Here the first element in s2 has been processed.
	int m=0,n=0;//The walking indices to compare if two elements are the same.
	for(int i=1;i<s2.length;i++){
	    if(i>r){
		p[i]=0;m=i-1;n=i+1;
	    }else{
		int i2=c*2-i;
		if(p[i2]<(r-i)){
		    p[i]=p[i2];
		    m=-1;//This signals bypassing the while loop below.
		}else{
		    p[i]=r-i;
		    n=r+1;m=i*2-n;
		}
	    }
	    while(m>=0&&n<s2.length&&s2[m]==s2[n]){
		p[i]++;m--;n++;
	    }
	    if((i+p[i])>r){
		c=i;r=i+p[i];
	    }
	}
	int len=0;c=0;
	for(int i=1;i<s2.length;i++){
	    if(len<p[i]){
		len=p[i];
		c=i;
	    }
	}
	char[] ss=Arrays.copyOfRange(s2,c-len,c+len+1);
	return String.valueOf(removeBoundaries(ss));
    }
    
    private static char[] addBoundaries(char[] cs){
	if(cs==null||cs.length==0)
	    return "||".toCharArray();
	char[] cs2=new char[cs.length*2+1];
	for(int i=0;i<(cs2.length-1);i=i+2){
	    cs2[i]='|';
	    cs[i+1]=cs[i/2];
	}
	cs2[cs2.length-1]='|';
	return cs2;
    }

    private static char[] removeBoundaries(char[] cs){
	if(cs==null||cs.length<3)
	    return "".toCharArray();
	char[] cs2=new char[(cs.length-1)/2];
	for(int i=0;i<cs2.length;i++){
	    cs2[i]=cs[i*2+1];
	}
	return cs2;
    }
}
