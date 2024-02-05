package programmers.level2;

import java.util.ArrayList;

public class LandEating { // 땅따먹기

    // ver1 - 최선, 차선 index 를 미리 구성해두고, 독립구간을 나눠 따로 연산
    public static void main1(String[] args) {
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}}; // n행 4열
        // n:1~100,000, 점수(값):1~100

        // 연산용 변수
        int n = land.length;
        ArrayList<Integer>[] bestIndexArray = new ArrayList[n]; // i행 = {bestIndexList, secondIndexList}
        int bestIndex;
        int secondIndex;

        // bestIndexArray 할당연산

        // Col 연속(중복)행 확인
        // 독립구간 자르기 - (이전행 누적2개 index) Union (다음행 누적2개행 index) == 4 >> 독립구간



        // 각 구간별 answer 할당 연산

    }

    // ver2 - answer, index 값 : 최선, 차선 으로 나눠서 두 갈래 동시 연산
    // 다틀림!! - 0점
    public static void main(String[] args) {
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}}; // n행 4열
        // n:1~100,000, 점수(값):1~100

        // 연산용 변수
        int n = land.length;
        int answerBest;
        int answerSecond;
        int preIndexBest;
        int preIndexSecond;
        int indexBest;
        int indexSecond;

        // 첫행 연사
        if(land[0][0] >= land[0][1]){
            indexBest = 0;
            indexSecond = 1;
        }else {
            indexBest = 1;
            indexSecond = 0;
        }
        for (int j = 2; j < 4; j++) {
            if(land[0][j] > land[0][indexBest]){
                indexSecond = indexBest;
                indexBest = j;
            }else if(land[0][j] > land[0][indexSecond]){
                indexSecond = j;
            }
        }
        answerBest = land[0][indexBest];
        answerSecond = land[0][indexSecond];
        preIndexBest = indexBest;
        preIndexSecond = indexSecond;

        // 본 연산
        for (int i = 1; i < n; i++) { // i행 연산
            // index 탐색
            if(land[i][0] >= land[i][1]){
                indexBest = 0;
                indexSecond = 1;
            }else {
                indexBest = 1;
                indexSecond = 0;
            }
            for (int j = 2; j < 4; j++) {
                if(land[i][j] > land[i][indexBest]){
                    indexSecond = indexBest;
                    indexBest = j;
                }else if(land[i][j] > land[i][indexSecond]){
                    indexSecond = j;
                }
            }

            // answerBest 할당 연산 - IndexBest 와 preIndex 비교
            if(indexBest != preIndexBest){ // Col 중복X - 최적Flow
                answerBest += land[i-1][preIndexBest];
            }else {
                answerBest += land[i-1][preIndexSecond];
            }

            // answerSecond 할당 연산 - IndexSecond 와 preIndex 비교
            if(indexSecond != preIndexBest){ // Col 중복X - 최적 Flow
                answerSecond += land[i-1][preIndexBest];
            }else {
                answerSecond += land[i-1][preIndexSecond];
            }

            // (answerBest < answerSecond) 이면 맞교환 >> answerBest <-> answerSecond / indexBest <-> indexSecond
            if(answerBest < answerSecond){
                int answer0 = answerBest;
                answerBest = answerSecond;
                answerSecond = answer0;

                int index0 = indexBest;
                indexBest = indexSecond;
                indexSecond = index0;
            }

//            answerBest+=
//            answerSecond+=

            // 다음 행 연산 준비
            preIndexBest = indexBest;
            preIndexSecond = indexSecond;

        }



        System.out.println("답은 = ");
        System.out.println("answerBest = " + answerBest);
        System.out.println("answerSecond = " + answerSecond);

    }


}
