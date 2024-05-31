package programmers.level2;

//import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class largestSquareFinding { // 가장 큰 정사각형 찾기

    // ver1 : 완전탐색 - 좌상단 꼭지점 기준으로 최대 정사각형 찾기 >> 효율성 fail
    public static void main1(String[] args) {
        int[][] board = new int[][]{{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
//        int[][] board = new int[][]{{0,0,1,1},{1,1,1,1}};
//        int[][] board = new int[][]{{0,0,0,0},{0,0,0,0}};


        // 연산용 변수
        int largestLength = 0;
        int nowLength;

        // 본 연산
        for (int i = 0; i < board.length; i++) {
            if(i+largestLength > board.length) break;
            for (int j = 0; j < board[0].length; j++) {
                if(j+largestLength > board[0].length) break;

                if(board[i][j] == 1){ // 꼭지점
                    nowLength=0;

                    // 핵심연산 - [i][j] 왼쪽상단으로 하는 정사각형 탐색 연산
                    rectangleSearch :
                    while (i+nowLength+1 < board.length & j+nowLength+1 < board[0].length){
                        nowLength++;
                        for (int k = 0; k <= nowLength; k++) {
                            // 행 탐색
                            if(board[i+k][j+nowLength]==0){
                                nowLength--;
                                break rectangleSearch;
                            }
                            // 열 탐색
                            if(board[i+nowLength][j+k]==0){
                                nowLength--;
                                break rectangleSearch;
                            }
                        }
                    }
                    // largestLength 는 꼭지점으로부터 추가된 칸 수를 계산했으므로 +1 필요
                    if(nowLength+1 > largestLength) largestLength = nowLength+1;
                }

                // 남은 길이보다 largestLength 가 크거나 같으면 연산(조기)종료
            }
        }


        System.out.println("답은 = " + largestLength*largestLength);
    }


    // ver2 : 0,1을 boolean 타입으로 변경, 연산(탐색)방법은 ver1 과 같음 >> 효율성 fail (ver1과 비슷한듯)
    public static void main2(String[] args) {
//        int[][] board = new int[][]{{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
//        int[][] board = new int[][]{{0,0,1,1},{1,1,1,1}};
        int[][] board = new int[][]{{0,0,0,0},{0,0,0,0}};

        // 연산용 변수
        boolean[][] boardBool = new boolean[board.length][board[0].length]; // input 데이터를 boolean 타입으로 변경
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]==1) boardBool[i][j] = true;
            }
        }
        int largestLength = 0;
        int nowLength;


        // 본 연산
        for (int i = 0; i < boardBool.length; i++) {
            if(i+largestLength > boardBool.length) break;
            for (int j = 0; j < boardBool[0].length; j++) {
                if(j+largestLength > boardBool[0].length) break;

                if(boardBool[i][j]){ // 꼭지점
                    nowLength=0;

                    // 핵심연산 - [i][j] 왼쪽상단으로 하는 정사각형 탐색 연산
                    rectangleSearch :
                    while (i+nowLength+1 < boardBool.length & j+nowLength+1 < boardBool[0].length){
                        nowLength++;
                        for (int k = 0; k <= nowLength; k++) {
                            // 행 탐색
                            if(!boardBool[i+k][j+nowLength]){
                                nowLength--;
                                break rectangleSearch;
                            }
                            // 열 탐색
                            if(!boardBool[i+nowLength][j+k]){
                                nowLength--;
                                break rectangleSearch;
                            }
                        }
                    }
                    // largestLength 는 꼭지점으로부터 추가된 칸 수를 계산했으므로 +1 필요
                    if(nowLength+1 > largestLength) largestLength = nowLength+1;
                }

                // 남은 길이보다 largestLength 가 크거나 같으면 연산(조기)종료
            }
        }


        System.out.println("답은 = " + largestLength*largestLength);
    }

    // ver3 
    public static void main(String[] args) {
    	int[][] board;
//    	board = new int[][]{{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
//      board = new int[][]{{0,0,1,1},{1,1,1,1}};
//      board = new int[][]{{0,0,0,0},{0,0,0,0}};
    	board = new int[][] {
    	    {0, 1, 0, 0, 1, 1, 0, 1, 1, 0},
    	    {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
    	    {0, 1, 0, 1, 0, 1, 1, 1, 0, 1},
    	    {1, 1, 1, 0, 0, 1, 1, 1, 1, 1},
    	    {1, 0, 1, 1, 1, 1, 1, 0, 1, 1},
    	    {1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
    	    {1, 1, 1, 0, 1, 1, 1, 1, 1, 1},
    	    {1, 1, 0, 1, 1, 0, 1, 0, 1, 1},
    	    {1, 0, 1, 1, 1, 0, 1, 1, 0, 1},
    	    {1, 1, 1, 0, 1, 1, 1, 0, 1, 1}
    	};


    	
    	

    	largestSquareFinding obj = new largestSquareFinding();
    	System.out.println(obj.solution(board));
    	
	}
    
    // static 변수
    static ArrayList<int[]>[] rowIntervalArray;
    static ArrayList<int[]>[] colIntervalArray;
    static int answerLength;
    
    public int solution(int [][] board) {
    	// 변수 Setting
    	int r; // 행 Index
    	int c; // 열 index
    	int rMax = board.length; // 1~1000
    	int cMax = board[0].length; // 1~1000
    	
    	answerLength=0; // 정답용 길이
    	boolean notExistFlag = true; // 길이 최소 2부터 연산하기 위함
    	
    	int[] interval = new int[2];
    	rowIntervalArray = new ArrayList[rMax]; // static 변수 초기화
    	for(r=0; r<rMax; r++) {
    		rowIntervalArray[r] = new ArrayList();
    	}
    	colIntervalArray = new ArrayList[cMax]; // static 변수 초기화
    	for(c=0; c<cMax; c++) {
    		colIntervalArray[c] = new ArrayList();
    	}
    	
    	//////////////////////////////////////////////////////////
    	
    	// 최소 길이 1할당 >> answerLength, notExistFlag
    	a:for(int i=0; i<rMax; i++) {
    		for(int j=0; j<cMax; j++) {
    			if(board[i][j] == 1) {
    				notExistFlag = false;
    				answerLength = 1;
    				break a;
    			}
    		}
    	}
    	if(notExistFlag) return 0;
    	
    	// 행 Interval 구하기 >> interval, rowIntervalArray
    	for(int i=0; i<rMax; i++) {
    		interval = new int[2];
    		for(int j=0; j<cMax-1; j++) {
    			
    			if(board[i][j]==1 && board[i][j+1]==1) {
    				interval[0] = j;
    				interval[1] = j+1; // cMax 까지 탐색
    				
    				j++;
    				while(j<cMax-1) {
    					if(board[i][j+1] == 1) {
    						interval[1]++;
    						j++;
    					}else break;
    				}
    				
    				rowIntervalArray[i].add(interval);
    				interval = new int[2]; // 얕은복사 방지
    			}
    		}
    	}
    	
    	// 열 Interval 구하기 >> interval, colIntervalArray
    	for(int j=0; j<cMax; j++) {
    		interval = new int[2];
    		for(int i=0; i<rMax-1; i++) {
    			
    			if(board[i][j]==1 && board[i+1][j]==1) {
    				interval[0] = i;
    				interval[1] = i+1; // rMax 까지 탐색
    				
    				i++;
    				while(i<rMax-1) {
    					if(board[i+1][j] == 1) {
    						interval[1]++;
    						i++;
    					}else break;
    				}
    				
    				colIntervalArray[j].add(interval);
    				interval = new int[2]; // 얕은복사 방지
    			}
    		}
    	}
    	
    	// rowInterval 출력확인
    	System.out.println();
    	System.out.println("rowIntervalArray 출력확인");
    	for(int i=0; i<rMax; i++) {
    		System.out.print(i+"행 = ");
    		for(int[] rowInterval : rowIntervalArray[i]) {
    			System.out.print("[" + rowInterval[0] + ", " + rowInterval[1] + "]   ");
    		}
    		System.out.println();
    	}
    	// colInterval 출력확인
    	System.out.println();
    	System.out.println("colIntervalArray 출력확인");
    	for(int j=0; j<cMax; j++) {
    		System.out.print(j+"열 = ");
    		for(int[] colInterval : colIntervalArray[j]) {
    			System.out.print("[" + colInterval[0] + ", " + colInterval[1] + "]   ");
    		}
    		System.out.println();
    	}
    	
    	
    	// rowInterval을 입력하면 만들수 있는 가장큰 SqureLength를 출력 >> posibleSquareLenghtbyInterval() -> answerLength 비교 할당
    	for(int i=0; i<rMax; i++) {
    		for(int[] rowInterval : rowIntervalArray[i]) {
    			posibleSquareLengthbyInterval(r, rowInterval);
    		}
    	}
    	
    	System.out.println();
    	return answerLength * answerLength;
    }
    
    public static int posibleSquareLengthbyInterval(int row, int[] interval) {
    	
    	
    	
    	return 0; 
    }
    
    
    public int solution1(int [][] board) { // 연산이 너무 복잡하다 >> pass
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
//    				System.out.println(i + "번째 행 = [" + interval[0] + "," + interval[1]+"]");
    				
    			}
    		}
    	}
    	
    	// 2테스트
//    	for(i=0; i<iMax; i++) {
//    		System.out.print(i + "행 = ");
//    		for (int k = 0; k < posibleIntervalArray[i].size(); k++) {
//    			System.out.print("[");
//    			System.out.print(posibleIntervalArray[i].get(k)[0]);
//    			System.out.print(", ");
//    			System.out.print(posibleIntervalArray[i].get(k)[1]);
//    			System.out.print("]   ");
//			}
//    		System.out.println();
//    	}
//    	System.out.println();
    	
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
//    							if(nextIntervalCal[0]<= k && nextIntervalCal[1] > k) { // 기존
//    							if(nextIntervalCal[0]<= k && nextIntervalCal[1]-k+1 > calLength) { // 수정 Test
//    								System.out.println("      "+l + "행은 시작가능");
//    							}
//    							else continue;
    							
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
