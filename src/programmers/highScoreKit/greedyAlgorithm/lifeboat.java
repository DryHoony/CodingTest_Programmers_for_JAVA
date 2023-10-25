package programmers.highScoreKit.greedyAlgorithm;


public class lifeboat { // 구명보트

    public static void main(String[] args) {
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
