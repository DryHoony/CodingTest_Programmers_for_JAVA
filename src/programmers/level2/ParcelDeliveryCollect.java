package programmers.level2;

public class ParcelDeliveryCollect { // 택배 배달과 수거하기


    public static void main(String[] args) { // 실패!! - 논리가 잘못되었다..
        int cap = 2; // 트럭 최대 용량 1~50
        int n = 7; // 집 1~100000
        int[] deliveries = {1,0,2,0,1,0,2}; // 배달 0~50
        int[] pickups = {0,2,0,1,0,2,0}; // 수거 0~50


        boolean[] delArray = new boolean[n];
        boolean[] picArray = new boolean[n];
        int delCap = 0;
        int picCap = 0;

        // 배달, 픽업 포인트 Array 할당
        for (int i = n-1; i >=0 ; i--) {
            // 배달
            if(deliveries[i]!=0){ // 0일 경우 continue 역할 - 수거 연산으로 넘어감
                if(deliveries[i] <= delCap){
                    delCap -= deliveries[i];
                    deliveries[i] = 0;
                }else {
//                    deliveries[i] -= delCap;
                    delCap = delCap + cap - deliveries[i]; // 충전 및 배달
                    delArray[i] = true; // 방문
                    deliveries[i] = 0;
                }
            }
            
            // 수거
            if(pickups[i]!=0){ // 0일 경우 continue 역할
                if(pickups[i] <= picCap){
                    picCap -= pickups[i];
                    pickups[i] = 0;
                }else {
                    picCap = picCap + cap - pickups[i]; // 충전 및 수거
                    picArray[i] = true; // 방문
                    pickups[i] = 0;
                }
            }
        }

//        System.out.println("배달, 픽업 출력 확인");
//        for (int i = 0; i < n; i++) {
//            System.out.println(delArray[i] + "     " + picArray[i]);
//        }
        

        // 연산용 변수
        Long distanceCount=0L;
        int dPlusPMinus = 0; // 배달시++, 수거시-- >> 0이상일때 배달시 방문, 0이하일때 수거시 방문
        for (int i = n-1; i >=0; i--) {
            // 배달
            if(delArray[i]){
                dPlusPMinus++;
                if(dPlusPMinus>0) distanceCount += (i+1)*2;
            }

            // 수거
            if(picArray[i]){
                dPlusPMinus--;
                if(dPlusPMinus<0) distanceCount += (i+1)*2;
            }

        }

        
        System.out.println("답은 >> "+distanceCount);
    }

    public static void main0(String[] args) { // 실패 - 겁나 실패
        int cap = 2; // 트럭 최대 용량 1~50
        int n = 7; // 집 1~100000
        int[] deliveries = {1,0,2,0,1,0,2}; // 배달 0~50
        int[] pickups = {0,2,0,1,0,2,0}; // 수거 0~50



        // 연산용 변수
        Long distanceCount=0L;
        int car = cap;
        boolean deliveryFlag = true; // 전체 배달완료
        boolean pickupFlag = true;

        for (int i = n-1; i >=0 ; i--) { // 먼곳부터!
            if(deliveries[i]==0 && pickups[i]==0) continue; // 통과!
            // i 에 배달이든 수거든 방문할 필요있을 때 거리 올리고 >> 배달, 수거 독립연산 try
            distanceCount += 2*(i+1); // i 까지 왕복
            car = cap; // 충전
            System.out.println((i+1)+"까지 왕복");

            // 배달
            int j=i;
            while(deliveryFlag){
                if(deliveries[j] <= car){
                    car -= deliveries[j];
                    deliveries[j]=0;
                    j--;
                    if(j<0) deliveryFlag = false; // 전체 배달 완료
                }
                else {
                    deliveries[j] -= car;
                    car=0; // 충전-다음배달
                    break;
                }

            }

            // 수거 - 항상 수거 할 수 있을까?
            car = cap; // 충전 - 배달처럼 수거 연산
            j = i;
            while (pickupFlag){
                if(pickups[j] <= car){
                    car -= pickups[j];
                    pickups[j]=0;
                    j--;
                    if(j<0) pickupFlag = false; // 전체 수거 완료
                }
                else {
                    pickups[j] -= car;
                    car = 0; // 충전 - 다음배달
                    break;
                }
            }



        }






        System.out.println("답은 >> " + distanceCount);
    }
}