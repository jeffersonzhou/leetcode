/*
String to Integer(atoi)
Implement atoi to convert a string to an integer.
Hint:Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
Notes: It is intended for this problem to be specified vaguely(ie, no given input specs). You are responsible to gather all the input requirements up front.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numberical value.
The string can contain additional characters after those that form the integral number,which are ignored and have no effect on the behavior of this function.
If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN(-2147483648) is returned.
 */

import java.io.*;

public class String2Integer {
    public static void main(String[] args){
	String str="-123456789";
	System.out.println(atoi(str));
    }
    public static int atoi(String str){
	int n=str.length();
	int i=0;
	int sign=1;
	int number=0;
	while(str.charAt(i)==' '&&i<n){
	    i++;
	}
	
	//if the first char is '+' or '-'
	if(i>=n){
	    return 0;
	}

	if(str.charAt(i)=='+'){
	    i++;
	}else if(str.charAt(i)=='-'){
	    i++;
	    sign=-1;
	}

	for(;i<n;i++){
	    if(str.charAt(i)=='+'||str.charAt(i)=='-')
		return 0;
	    if(str.charAt(i)<'0'||str.charAt(i)>'9'){
		continue;
	    }else{
		if(number>Integer.MAX_VALUE/10){
		    return sign==-1?Integer.MIN_VALUE:Integer.MAX_VALUE;
		}else if((number==Integer.MAX_VALUE/10)&&((str.charAt(i)-'0')>Integer.MAX_VALUE%10)){
			return sign==-1?Integer.MIN_VALUE:Integer.MAX_VALUE;
		    }else{
			number=str.charAt(i)-'0'+number*10;
		    }
	     }
	}
	number=number*sign;
	return number;
    }
}

