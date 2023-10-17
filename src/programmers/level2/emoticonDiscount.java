package programmers.level2;

import java.util.Arrays;

public class emoticonDiscount { // 이모티콘 할인행사
    // 목표1 - 이모티콘 플러스 서비스 가입자 maximize
    // 목표2 - 이모티콘 판매액 maximize
    // n명의 사용자에게 m개의 이모티콘을 판매
    // 이모티콘 마다 각각 할인율은 10,20,30,40% 중 하나

    // <이해>
    // user 의 구매금액이 높을 수록 각각의 한계'가격' 달성할 가능성 높음 (목표1)
    // 각각의 기준 할인율 이상이어야 구매금액이 높아짐
    // 큰 금액에 많은 할인을 때리면 손해, 가격을 달성하는 선에서 최대한 구매금액을 줄여야 매출액이 늘어난다.
    // 이모티콘은 오름차순 연산 - 작은 값부터 할인해 '가격'달성을 만족시킨 후 (큰 금액은 할인하지 않고) 매출액 maximize (목표2)

    // user 를 기준으로 반복문 도는것이 유리해 보인다.
    // 각 user 의 (10% * n) 인 '조정비율'로 '가격'을 달성하기 위해서 필요한 이모티콘 가격합을 도출

    static float[] purchaseArray;
    static int[] emoticonsPrice;


    public static void main(String[] args) {
        int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        int[] emoticons = {1300,1500,1600,4900};


        // 이모티콘 기준 완전탐색 >> 종료조건 있을까? >> 없다면 BFS, DFS 뭐든
        // 이모티콘 할인율 수치 경우의수 * user 연산 >> [max(서비스 가입자), max(판매액)]
        // 1번목표 - 서비스 가입자가 많은 순서대로 결과가 나오는 (이모티콘 할인율) 탐색 방법(방향)이 있을까?

        // 연산용 변수
        int n = emoticons.length;
        purchaseArray = new float[4]; // 10% 20% 30% 40% 할인율 해당 구매 금액
        emoticonsPrice = new int[n];
        for (int i = 0; i < n; i++) {
            emoticonsPrice[i] = emoticons[i];
        }




        // 4^n 의 경우의수 탐색
        float[] discountPercent = new float[n]; // 각 임티 할인율 0.1, 0.2, 0.3, 0.4
        for (int i = 0; i < n; i++) { // 초기화
            discountPercent[i] = 0.1f;
        }



        // dfs 연산 출력확인
        dfs(discountPercent, 0, n);








    }

    public static void dfs(float[] discountPercent, int i, int n){
        if(i == n){ // 종료조건
            System.out.print("출력 >> ");
            for (int j = 0; j < n; j++) {
                System.out.print(discountPercent[j] + ", ");
            }
            System.out.println();

            // 구매 가격 초기화
            for (int j = 0; j < 4; j++) {
                purchaseArray[j] = 0;
            }
            // 구매 가격 연산
            for (int j = 0; j < n; j++) {
                float price = emoticonsPrice[j] * (1 - discountPercent[j]);
                // '할인율'에 해당할때만 할당
                for (int k = 0; k < discountPercent[j]*10; k++) {
                    purchaseArray[k] += price;
                }
            }

            // 구매 가격 출력
            for (float f:purchaseArray){
                System.out.print(f + ", ");
            }
            System.out.println();
            System.out.println();

            return;
        }

        dfs(Arrays.copyOf(discountPercent, n), i+1, n); // 0.1
        discountPercent[i] += 0.1;
        dfs(Arrays.copyOf(discountPercent, n), i+1, n); // 0.2
        discountPercent[i] += 0.1;
        dfs(Arrays.copyOf(discountPercent, n), i+1, n); // 0.3
        discountPercent[i] += 0.1;
        dfs(Arrays.copyOf(discountPercent, n), i+1, n);

    }




}
