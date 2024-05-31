package defaultPackage;

import java.util.ArrayList;

public class Test {

	
	public static void main(String[] args) {
		
		int k=0;
		for(int i=0; i<20-k; i++) {
			k++;
			System.out.println("i = " + i);
			System.out.println("k = " + k);
			System.out.println();
			
		}
		
		public int solution0(int [][] board) {
	    	// 연산용 변수
	    	int iMax = board.length; // 1~1000
	    	int jMax = board[0].length; // 1~1000
	    	int i; // 행 Index
	    	int j; // 열 index
	    	
	    	int squareLength = 0; // 정답용 길이, 제곱하면 넓이
	    	int calLength; // 계산용 길이
	    	boolean notExistFlag = true;
	    	
	    	int[] interval = new int[2];
	    	ArrayList<int[]>[] posibleIntervalArray = new ArrayList[iMax];
	    	for(i=0; i<iMax; i++) {
	    		posibleIntervalArray[i] = new ArrayList();
	    	}
	    	// [1,2], [5,8], [20,30]
	    	
	    	// 1. 첫번째 연산 squareLength 값 최소 1 할당 >> squareLength
	    	a:for(i=0; i<iMax; i++) {
	    		for(j=0; j<jMax; j++) {
	    			if(board[i][j] == 1) {
	    				notExistFlag = false;
	    				squareLength = 1;
	    				break a;
	    			}
	    		}
	    	}
	    	if(notExistFlag) return 0;
	    	
	    	// 1테스트 - return 0 >> ok
	    	
	    	
	    	// 2. 각 행의 가능한 구간 구하기, 길이는 2이상 >> interval, posibleInterval
	    	for(i=0; i<iMax; i++) {
	    		for(j=0; j<jMax-1; j++) { // 끝자리 jMax 제외(길이 2 이상 연산, out of Array Exception)
	    			if(board[i][j]==1 && board[i][j+1]==1) {
	    				interval[0] = j;
	    				interval[1] = j+1; // jMax까지 탐색
	    				
	    				j++;
	    				while(j<jMax-1) {
	    					if(board[i][j+1] == 1) {
	    						interval[1]++;
	    						j++;
	    					}
	    					else {
	    						break;
	    					}
	    				}
	    				
	    				posibleIntervalArray[i].add(interval);
	    				interval = new int[2]; 
//	    				System.out.println(i + "번째 행 = [" + interval[0] + "," + interval[1]+"]");
	    				
	    			}
	    		}
	    	}
	    	
	    	// 2테스트
//	    	for(i=0; i<iMax; i++) {
//	    		System.out.print(i + "행 = ");
//	    		for (int k = 0; k < posibleIntervalArray[i].size(); k++) {
//	    			System.out.print("[");
//	    			System.out.print(posibleIntervalArray[i].get(k)[0]);
//	    			System.out.print(", ");
//	    			System.out.print(posibleIntervalArray[i].get(k)[1]);
//	    			System.out.print("]   ");
//				}
//	    		System.out.println();
//	    	}
//	    	System.out.println();
	    	
	    	// 3. posibleInterval 의 구간을 합쳐 정사각형 구하기 
	    	// squareLength 보다 구간의 길이가 클때만 계산 (작거나 같으면 탈락)
	    	// i 를 스캔하여 시작점(왼쪽 상단)이 될 [i][j]를 찾기,  
	    	
	    	squareLength = 2;
	    	
	    	for(i=0; i<iMax-squareLength; i++) { // squareLength 동적으로 연산 : 어짜피 최대 길이보다 부족하면 탈락
	    		for(int[] intervalCal : posibleIntervalArray[i]) {
	    			if(intervalCal[1]-intervalCal[0] >= squareLength) {
	    				System.out.println();
	    				System.out.println(i+"행 [" + intervalCal[0] + "," + intervalCal[1] + "]");
	    				
	    				// intervalCal 구간의 왼쪽부터 연산 시작점 설정
	    				for(int k = intervalCal[0]; k<=intervalCal[1]-squareLength; k++ ) {
	    					calLength = intervalCal[1]-k+1; // 연산용 길이
	    					System.out.println("  Index "+k+" 에서 연산시작, calLength = " + calLength);
	    					
	    					makeSquare:for(int l=i+1; l<Math.min(i+calLength, iMax); l++) {
	    						System.out.println("    "+l+"행에서 try");
	    						
	    						// l 번재 행에서 Index 'k'~'k+calLength-1' 까지 가능한 범위 연산값 >> calLength
	    						for(int[] nextIntervalCal:posibleIntervalArray[l]) {
//	    							if(nextIntervalCal[0]<= k && nextIntervalCal[1] > k) { // 기존
//	    							if(nextIntervalCal[0]<= k && nextIntervalCal[1]-k+1 > calLength) { // 수정 Test
//	    								System.out.println("      "+l + "행은 시작가능");
//	    							}
//	    							else continue;
	    							
	    							// 수정 ver2
	    							if(nextIntervalCal[1] < k) continue;
	    							else if(nextIntervalCal[0]<= k && nextIntervalCal[1]-k+1 > squareLength) {
	    								System.out.println("      "+l + "행은 시작가능");
	    								
	    							}
	    							else break makeSquare;
	    						}
	    					}
	    					// makeSquare 결과값 calLength 를 squareLength에 업데이트 (클 경우만)
	    					
	    					
	    					
	    				}
	    			}
	    			
	    		}
	    	}
	    	
	    	System.out.println();
	    	System.out.print("답은 = ");
	    	return squareLength * squareLength;
	    }
	}
}
