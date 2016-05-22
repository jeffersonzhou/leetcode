/*
Candy
There are N children standing in a line. Each child is assigned a rating value.
You are giving candies to these children subjected to the following requirements:
Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
 */

import java.io.*;

public class Candy {
    
    public static void main(String[] args){
	int[] child={1,2,3,2,1,0,3,2,1};
	System.out.println(giveCandies(child));
    }
    
    public static int giveCandies(int[] child){
	int n=child.length;

	int[] candy=new int[n];
	int curr=0;
	for(int i=0;i<n;i++)
	    candy[i]=1;
	for(int i=1;i<n;i++){
	    if(child[i]>child[i-1]){
		candy[i]=candy[i-1]+1;
	    }
	}
	for(int i=n-1;i>=1;i--){
	    if(child[i-1]>child[i]){
		candy[i-1]=candy[i]+1;
	    }
	}

	for(int i=0;i<n;i++){
	    curr+=candy[i];
	    System.out.print(candy[i]+" + ");
	}
	return curr;
	
    }
}
