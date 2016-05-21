/*
Rotate Image
You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees(clockwise).
Follow up: Could you do this in-place?
 */

//A[i][j]->A
//A[0][0]->A[0][n]
//A[0][j]->

import java.io.*;

public class RotateImage {

    public static void main(String[] args){
	int[][] image=new int[5][5];
	for(int i=0;i<5;i++){
	    for(int j=0;j<5;j++){
		image[i][j]=j;
		System.out.print(j+"  ");
	    }
	    System.out.println();
	}
	rotateImage(image);

	for(int i=0;i<5;i++){
	    for(int j=0;j<5;j++){
		System.out.print(image[i][j]+"  ");
	    }
	    System.out.println();
	}
    }
    
    public static void rotateImage(int[][] image){
	int n=image[0].length;
	//Rotate along the middle line horizontally
	
	for(int i=0;i<n/2;i++){
	    for(int j=0;j<n;j++){
		swap(image,i,j,n-i-1,j);
	    }
	}

	for(int i=0;i<n;i++){
	    for(int j=i+1;j<n;j++){
		swap(image,i,j,j,i);
	    }
	}
    }

    public static void swap(int[][] image, int i,int j, int m, int n){
	int temp=image[i][j];
	image[i][j]=image[m][n];
	image[m][n]=temp;
    }
}
