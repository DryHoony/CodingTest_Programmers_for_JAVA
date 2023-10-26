package programmers.highScoreKit.greedyAlgorithm;


public class lifeboat { // 구명보트

    public static void main(String[] args) {
        int[] people = {70,50,80,50}; // 길이 1~50,000  값 40~240
        int limit = 100; // 무게 제한, 무게 제한 외에도 한번에 2명씩 밖에 탈수 없다.
        // 모든 people 을 구하는 최소한의 구명보트의 갯수 return

        // 연산용 변수
        int[] weightArray = new int[limit+1]; // [i]는 몸무게 i인 사람의 수
        for (int weight : people){
            weightArray[weight] ++;
        }
        int maxWeight = limit; // 가장 무거운 무게 부터 채우기, limit 을 넘기진 않음
        int boatWeight; // 보트무게 연산용
        int boatCount=0;

        // 본 연산
        while (true){

            // 첫번째 사람 태우기
            while (maxWeight>0 && weightArray[maxWeight] == 0){ // 가장 무거운 사람 Index 연산
                maxWeight--;
            }
            if(maxWeight==0) break;

//            System.out.println("새 보트 >> " + maxWeight + "태움");
            boatWeight = limit - maxWeight;
            boatCount++;
            weightArray[maxWeight]--;

            // 두번째 사람 태우기 - 남은 boatWeight 로 가장 무거운 사람 찾기
            for (int i = Math.min(boatWeight, maxWeight); i >0 ; i--) { // i 무게 테스트
//                System.out.println("두번쨰 사람 test >> " + i);
                if(weightArray[i] != 0){
                    weightArray[i]--;
                    break;
                }

            }

        }

        System.out.println("답은  = " + boatCount);
    }

    // 문제 잘읽자,,, 한 보트에 최대 두명까지,,
    // 보트 하나에 (태울 수 있는) 가장 큰 무게 - 남은 보트 무게로 태울 수 있는 가장 큰 무게 >> 반복
    public static void main0(String[] args) { // 실패 (15%만 성공) - 논리를 다시 짜보자
        int[] people = {70,50,80,50}; // 길이 1~50,000  값 40~240
        int limit = 100; // 무게 제한
        // 모든 people 을 구하는 최소한의 구명보트의 갯수 return

        // 연산용 변수
        int[] weightArray = new int[limit+1]; // [i]는 몸무게 i인 사람의 수
        for (int weight : people){
            weightArray[weight] ++;
        }
        int maxWeight = limit; // 가장 무거운 무게 부터 채우기, limit 을 넘기진 않음
        int boatWeight; // 보트무게 연산용
        int boatCount=0;

        while (true){

            while(maxWeight > 0 && weightArray[maxWeight] == 0){
                // if(weightArray[maxWeight] == 0) >> 따로 안빼도 되겠지? && 연산에서 index 검증을 먼저 실행할테니
//                System.out.println(maxWeight + "는 없다. 다음 무게!");
                maxWeight--;
            }
            if(maxWeight == 0) break;

            boatCount++; // 새 보트
            boatWeight = limit; // 초기화
            boatWeight -= maxWeight; // 첫 승객
            weightArray[maxWeight]--;
//            System.out.println("새 보트 >> " + maxWeight + "태움");

            boolean flag = true;
            // 남은 boatWeight 무게로 가능할때까지 승객 태움
            while (boatWeight>0){ //
                flag = false;

                for (int i = boatWeight; i > 0 ; i--) {
                    if(weightArray[boatWeight] != 0){
                        weightArray[boatWeight] --;
                        boatWeight -= i;
                        flag = true;
                        break;
                    }
                }

                // 남은 무게로 더이상 불가 - for 문 다돌면
                if(!flag) break;
            }

        }


        System.out.println("답은 = " + boatCount);
    }

}
