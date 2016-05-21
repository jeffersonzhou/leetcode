/*
Gray Code
The gray code is a binary numeral system where two successive values differ in only one bit.
Given a non-negative integer n representing the total number of bits in the code, print the sequence of
gray code. A gray code sequence must begin with 0.
For example, given n=2, return [0,1,3,2]. Its gray code sequence is:
00 -0
01 -1
11 -3
10 -2
Note:
For a given n, a gray code sequence is not uniquely defined.
For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 */

//Gray code
//Mathamatical method: 2-based number-->gray code: n^(n>>1)
//Reflect-and-prefix method: base 0,1; each time add 0 and reverse add 1

import java.io.*;

public class GrayCode {
    
    public static void grayCodeBTG(int n){
	if(n>31)
	    return;
	int size=1<<n;
	for(int i=0;i<size;i++){
	    int code=i^(i>>1);
	    System.out.println(code+" "+Integer.toBinaryString(code));
	}
    }
    
    public static String[] grayCodeRP(int n){
	int size=1<<n;
	String[]code=new String[size];
	if(n==1){
	    code[0]="0";
	    code[1]="1";
	    return code;
	}
	String[] last=grayCodeRP(n-1);
	for(int i=0;i<last.length;i++){
	    code[i]="0"+last[i];
	    code[code.length-i-1]="1"+last[i];
	}
	return code;
    }
    
    public static void main(String[] args){
	grayCodeBTG(3);
	String[] result=grayCodeRP(3);
	for(int i=0;i<result.length;i++)
	    System.out.println(result[i]);
    }
}
