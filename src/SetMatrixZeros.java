/*
Set Matrix Zeros
Given a m x n matrix, if an element is 0, set its entire row and column to 0.
Do it in place.
Follow up: did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m+n) space, but still not the best solution.
Could you devise a constant space solution?
 */

import java.io.*;

public class SetMatrixZeros {
    
    public static void main(String[] args){
	int[][] m1=new int[3][3];
	int[][] m2=new int[5][5];
	for(int i=0;i<3;i++){
	    for(int j=0;j<3;j++){
		m1[i][j]=i-1;
		System.out.print(m1[i][j]+" ");
	    }
	    System.out.println();
	}
	System.out.println();
	for(int i=0;i<5;i++){
	    for(int j=0;j<5;j++){
		m2[i][j]=i-2;
		System.out.print(m2[i][j]+" ");
	    }
	    System.out.println();
	}
	System.out.println();
	setMZeros(m1);
	setMatrixZerosImpr(m2);
	for(int i=0;i<3;i++){
	    for(int j=0;j<3;j++)
		System.out.print(m1[i][j]+" ");
	    System.out.println();
	}
	System.out.println();
	for(int i=0;i<5;i++){
	    for(int j=0;j<5;j++)
		System.out.print(m2[i][j]+" ");
	    System.out.println();
	}
	System.out.println();
	
	
    }
    public static void setMZeros(int[][] matrix){
	int m=matrix.length;
	int n=matrix[0].length;
	boolean[] row=new boolean[m];
	boolean[] column=new boolean[n];
	for(int i=0;i<m;i++){
	    for(int j=0;j<n;j++){
		if(matrix[i][j]==0){
		    row[i]=true;
		    column[j]=true;
		}
	    }
	}

	for(int i=0;i<m;i++){
	    if(row[i]==true){
		for(int j=0;j<n;j++)
		    matrix[i][j]=0;
	    }
	}

	for(int j=0;j<n;j++){
	    if(column[j]==true){
		for(int i=0;i<m;i++)
		    matrix[i][j]=0;
	    }
	}
	
    }

    public static void setMatrixZerosImpr(int[][] matrix){
	int m=matrix.length;
	int n=matrix[0].length;
	boolean row_has_zeros=false;
	boolean column_has_zeros=false;

	for(int i=0;i<n;i++){
	    if(matrix[0][i]==0){
		row_has_zeros=true;
		break;
	    }
	}

	for(int j=0;j<m;j++){
	    if(matrix[j][0]==0){
		column_has_zeros=true;
		break;
	    }
	}
	
	//set all element on first row and first column as 0s if there is coresponding 0s.
	for(int i=0;i<m;i++){
	    for(int j=0;j<n;j++){
		if(matrix[i][j]==0){
		    matrix[i][0]=0;
		    matrix[0][j]=0;
		}
	    }
	}

	for(int i=1;i<m;i++){
	    for(int j=1;j<n;j++){
		if(matrix[i][0]==0|| matrix[0][j]==0){
		    matrix[i][j]=0;
		}
	    }
	}

	if(row_has_zeros){
	    for(int i=0;i<n;i++){
		matrix[0][i]=0;
	    }
	}
	if(column_has_zeros){
	    for(int j=0;j<m;j++){
		matrix[j][0]=0;
	    }
	}
    }
    
}
