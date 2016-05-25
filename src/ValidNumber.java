/*
Valid Number
Validate if a given string is numberic.
Some examples:
"0"->true
"0.1"->true
"abc"->false
"1 a"->false
"2e10"->true
Note: it is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 */

//1.Check if it starts with a number;
//2.Check if it is a positive or negative number;
//3.Check if the number is overflowed.
//Integer:max,2147483647 min,-2147483648
//float:
import java.io.*;
import java.util.*;

public class ValidNumber {

    public static void main(String[] args){
	System.out.println(isValidNumber("1e10"));
	System.out.println(isValidNumber("12345"));
    }
    public enum InputType{
	INVALID(0),SPACE(1),SIGN(2),DIGIT(3),DOT(4),EXPONENT(5),NUM_INPUTS(6);
	private int value;
	private InputType(int value){
	    this.value=value;
	}
	public int getValue(){
	    return value;
	}
    };
    public static boolean isValidNumber(String str){
	/*
	enum InputType{
	    INVALID,
	    SPACE,
	    SIGN,
	    DIGIT,
	    DOT,
	    EXPONENT,
	    NUM_INPUTS
	}
	*/
	int[][]transitionTable={
	    //I P S D . E
	    {-1,0,3,1,2,-1},//0
	    {-1,8,-1,1,4,5},//1
	    {-1,-1,-1,4,-1,-1},//2
	    {-1,-1,-1,1,2,-1},//3
	    {-1,8,-1,4,-1,5},//4
	    {-1,-1,6,7,-1,-1},//5
	    {-1,-1,-1,7,-1,-1},//6
	    {-1,8,-1,7,-1,-1},//7
	    {-1,8,-1,-1,-1,-1}//8
	};
	int state=0;
	int len=str.length();
	for(int i=0;i<len;i++){
	    InputType inputType=InputType.INVALID;
	    char c=str.charAt(i);
	    if(Character.isWhitespace(c)){
		inputType=InputType.SPACE;
	    }else if(Character.isDigit(c)){
		inputType=InputType.DIGIT;
	    }else if(c=='.'){
		inputType=InputType.DOT;
	    }else if(c=='e'||c=='E'){
		inputType=InputType.EXPONENT;
	    }
	    state=transitionTable[state][inputType.getValue()];
	    if(state==-1)
		return false;
	}
	return (state==1 || state==4 || state==7 || state==8);
    }
}
