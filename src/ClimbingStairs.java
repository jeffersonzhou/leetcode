/*
Climbing Stairs
You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/

//The final step can be either 1 or 2
//that is, it could start either at n-1 or n-2
//T(n)=T(n-1)+T(n-2)
//T(1)=1,T(2)=2

import java.io.*;

public class ClimbingStairs {
    public static int N=100;
    public static int[] total=new int[N];
    public static int climbSteps(int n){
	if(n==1){
	    //System.out.println(1);
	    return 1;
	}
	if(n==2){
	    //System.out.println(2);
	    return 2;
	}
	total[n-1]=climbSteps(n-1);
	//System.out.println(1);
	total[n-2]=climbSteps(n-2);
	//System.out.println(2);
	total[n]=total[n-1]+total[n-2];
	return total[n];
    }

    public static void main(String[] args){
	System.out.println(climbSteps(3));
	System.out.println(climbSteps(4));
    }
}
