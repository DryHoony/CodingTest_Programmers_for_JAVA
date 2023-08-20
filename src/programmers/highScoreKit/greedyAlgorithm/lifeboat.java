package programmers.highScoreKit.greedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;

public class lifeboat { // 구명보트

    public static void main(String[] args) { // 왕창 실패,,,ㅜㅜ
        int[] people = {1,2,7,8,9,6,5,7,3,10,4,2,9,6,4,6,2,3,1,9,10,1,2,2,2,7};
        int limit = 10;

        // 연산 변수
        int boatCount = 0; // 구명보트 갯수의 최솟값
        ArrayList<Integer> peopleArray = new ArrayList<>();
        int boatRemainWeight;
        int searchIndex;

        // peopleArray 에 정렬된 형태로 저장
        for(int i:people){
            peopleArray.add(i);
        }
        Collections.sort(peopleArray); // 할당과 정렬을 합칠 수 있으면 최적화 가능할텐데, 정렬을 직접구현 해야 함, 일단 pass

        System.out.println(peopleArray);
        System.out.println("최대 무게 = "+ limit);
        System.out.println();

        // 본 연산
        while(!peopleArray.isEmpty()){
            // 변수 초기화
            boatRemainWeight = limit;
            boatCount ++;
            System.out.println();
            System.out.println("구명 보트 번호 = " + boatCount);


            // 젤 무거운사람 먼저 태움
            boatRemainWeight -= peopleArray.get(peopleArray.size()-1);
            System.out.print(peopleArray.get(peopleArray.size()-1) + " / ");
            peopleArray.remove(peopleArray.size()-1);


            // boatRemainWeight 부분연산
            while(boatRemainWeight > 0){ // 남은 무게가 있는동안 연산
                if(peopleArray.isEmpty()) break; // 남은 사람 없으면 부분연산 종료
                if(boatRemainWeight < peopleArray.get(0)) break; // 태울 수 있는 '가벼운' 사람 없으면 부분연산 종료

                // 남은무게 보다 '큰 사람' 나올 때 까지 탐색
                searchIndex = 0; // 초기화
                while(searchIndex < peopleArray.size()){ // 끝까지 탐색하면 종료 >> searchIndex == peopleArray.size()
                    if(boatRemainWeight < peopleArray.get(searchIndex)) break;
                    // "searchIndex-1" << 이사람이 태울수 있는사람중 가장 무거움
                    searchIndex++;
                }

                // 태울 수 있는 가장 무거운 사람 할당
                boatRemainWeight -= peopleArray.get(searchIndex-1);
                System.out.print(peopleArray.get(searchIndex-1) + " / ");
                peopleArray.remove(searchIndex-1);

            }



        }


        System.out.println();
        System.out.println();
        System.out.println("답은 = "+ boatCount);
    }
}
