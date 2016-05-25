/*
Given an integer, convert it to a roman numeral.
Input is guaranteed to be within the range from 1 to 3999.
 */

//M 1,000 D 500 C 100 L 50 X 10 V 5 I 1

//Each number can repeat no more than 3 times
import java.io.*;

public class Integer2Roman {
    public static void main(String[] args){
	System.out.println(int2Roman(3456));
    }
    public static String int2Roman(int number){
	String res="";
	if(number<1||number>3999)
	    return res;
	String[] symbols={
	    "M","CM","D","CD","C","XC",
	    "L","XL","X","IX","V","IV",
	    "I"
	};
	int[] radix={1000,900,500,400,100,90,
		     50,40,10,9,5,4,1};
	int count=0;
	for(int i=0;i<radix.length;i++){
	    count=number/radix[i];
	    number=number%radix[i];
	    for(;count>0;count--){
		res=res+symbols[i];
	    }
	}
	return res;
    }
}
