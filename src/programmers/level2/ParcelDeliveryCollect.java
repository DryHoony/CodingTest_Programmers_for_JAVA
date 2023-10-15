package programmers.level2;

public class ParcelDeliveryCollect { // 택배 배달과 수거하기

    public static void main(String[] args) {
        int cap=2; // 용량
        int n=7; // 집 수
        int[] deliveries = {1,0,2,0,1,0,2}; // 배달
        int[] pickups = {0,2,0,1,0,2,0}; // 수거

        // 연산용변수
        long answer = 0;
        int targetIndex = n-1; // 가장 멀리있는집 (배달 or 수거)
        int count; // cap 연산용 변수

        // 연산
        while(targetIndex>=0){

            if(deliveries[targetIndex]==0 && pickups[targetIndex]==0){ // target 찾기
                targetIndex--;
                continue;
            }
            else {
                // 거리 추가
                answer += targetIndex+1;
                // 배달 연산
                count = cap; // 초기화
                for (int i = targetIndex; i >=0 ; i--) {
                    if(deliveries[i] < count){
                        count -= deliveries[i];
                        deliveries[i] = 0;
                    } else if (deliveries[i] == count) {
                        deliveries[i] = 0;
                        break;
                    }else { // deliveries[i] > count
                        deliveries[i] -= count;
                        break;
                    }
                }
                // 수거 연산
                count = cap; // 초기화
                for (int i = targetIndex; i >=0 ; i--) {
                    if(pickups[i] < count){
                        count -= pickups[i];
                        pickups[i] = 0;
                    } else if (pickups[i] == count) {
                        pickups[i] = 0;
                        break;
                    }else { // pickups[i] > count
                        pickups[i] -= count;
                        break;
                    }

                }
            }


        }




        answer *= 2; // 왕복이므로 거리 2배
        System.out.println("답은 = " + answer);
    }
}