package test;

import java.util.Iterator;

public class Test2 {

	public static void main(String[] args) {
		int [][] a = {{1,2},{3},{4,5,6}};
		
	
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(" " + a[i][j]);
			}		
			
			System.out.println(" >> " + a[i].length +"개");
		}
		
		
		System.out.println("배열 바꿔보기");
		
		int[][] b = new int[3][]; // 되네??
//		int[][] b = new int[][4];  // 오류
	}
	

}
