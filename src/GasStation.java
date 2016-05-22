/*
Gas Station
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to
its next station(i+1). You begin the journey with an empty tank at one of the gas stations.
Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
Note: The solution is guaranteed to be unique.
 */

//If total gas is less than total cost, return -1
//

import java.io.*;

public class GasStation {

    public static void main(String[] args){
	int[] gas={2,3,1,4,2,5,6,7};
	int[] cost={3,4,1,2,2,7,6,5};

	System.out.println(getStartSite(gas,cost));
    }
    public static int getStartSite(int[] gas, int[] cost){
	if(gas.length!=cost.length)
	    return -1;
	int total=0;
	int sum=0;
	int site=-1;

	for(int i=0;i<gas.length;i++){
	    sum+=gas[i]-cost[i];
	    total+=gas[i]-cost[i];
	    if(sum<0){
		site=i;
		sum=0;
	    }
	}
	if(total>=0){
	    return site+1;
	}else{
	    return -1;
	}
    }
}
