/*
Valid Palindrome
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
Note: have you consider that the string might be empty? This is a good question to ask during an interview.
For the purpose of this problem, we define empty string as valid palindrome.
 */

import java.io.*;
import java.util.*;

public class ValidPalindrome {
    public static void main(String[] args){
	String str="A man, a plan, a canal: Panama";
	System.out.println(isPalindrome(str));
    }
    public static boolean isPalindrome(String str){
	String work_str=str.toLowerCase();
	int left=0;
	int right=work_str.length()-1;
	while(left<right){
	    if(!work_str.substring(left,left+1).matches("[a-z0-9]")){
		left++;
	    }else if(!work_str.substring(right,right+1).matches("[a-z0-9]")){
		//System.out.println(right);
		right--;
	    }else if(work_str.charAt(left)==work_str.charAt(right)){
		//if(work_str.substring(left,left+1).equals(work_str.substring(right,right+1))){
		left++;
		right--;
	    }else{
		return false;
	    }
	}
	return true;
    }
}
