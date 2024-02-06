package programmers.level2;

import java.util.ArrayList;

public class LandEating { // 땅따먹기

    int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}}; // n행 4열
    // n:1~100,000, 점수(값):1~100

    // 다시 처음부터
    public static void main(String[] args) {
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}}; // n행 4열
        // n:1~100,000, 점수(값):1~100

        // 연산용 변수
        int n = land.length;
        int[] answerArray = new int[4]; // (현재 행까지의) 각 col 에서 answer 합계
        for (int i = 0; i < 4; i++) { // 초기행 할당
            answerArray[i] = land[0][i];
        }

        int bestIndex, secondIndex;
        int bestAnswer, secondAnswer;

        // 본 연산
        for (int i = 1; i < n; i++) { // i번째 행 연산
            // 이전 행 colAnswer 에서 최선, 차선 col 찾기 >> bestIndex, secondIndex
            if(answerArray[0] >= answerArray[1]){
                bestIndex=0;
                secondIndex=1;
            }else {
                bestIndex=1;
                secondIndex=0;
            }
            for (int j = 2; j < 4; j++) {
                if(answerArray[j]>answerArray[bestIndex]){
                    secondIndex = bestIndex;
                    bestIndex = j;
                }else if(answerArray[j]>answerArray[secondIndex]){
                    secondIndex = j;
                }
            }

            // 현재 행에서 answer 연산 >> colAnswer update
            bestAnswer = answerArray[bestIndex];
            secondAnswer = answerArray[secondIndex];
            for (int j = 0; j < 4; j++) {
                if(j==bestIndex) continue;
                answerArray[j] = bestAnswer + land[i][j];
            }
            answerArray[bestIndex] = secondAnswer + land[i][bestIndex];

            System.out.print(i+1+"번째 행에서 answer = ");
            for (int a:answerArray){
                System.out.print(a + " ");
            }
            System.out.println();
        }

        // 답 = 최대값
        int answer=answerArray[0];
        for (int i = 1; i < 4; i++) {
            if(answerArray[i] > answer) answer = answerArray[i];
        }

        System.out.println("답은 = " + answer);
    }


}
