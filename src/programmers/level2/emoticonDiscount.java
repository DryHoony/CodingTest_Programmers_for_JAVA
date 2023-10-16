package programmers.level2;

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

    public static void main(String[] args) {
//        int[][] users = {{40,10000},{25,10000}}; // 1~100개, [비율, 가격],
//        // '비율' 이상의 할인율이면 구매, '가격' 이상으로 구매하면 플러스 서비스 가입
//        int[] emoticons = {7000, 9000}; // 1~7개, 값 100~1,000,000
        // 각각의 할인율 경우의 수가 4 이므로 전체 (최대) 경우의 수는 4^7!! (겁나 크다,,)

        // case2
        int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        int[] emoticons = {1300,1500,1600,4900};


        // 연산용 변수
        int[] answer = {0,0}; // [서비스 가입자, 매출액]
        int n = users.length; // user 수
        int emoticonsTotalPrice=0;
        for (int k:emoticons){
            emoticonsTotalPrice += k;
        }
        System.out.println("이모티콘 가격 총합 = " + emoticonsTotalPrice);
        System.out.println();


//        int discountPercent=0; // 할인율

        // 각 유저별 '가격' 달성 조건 - [할인율, 이모티콘 가격합]
        for (int i = 0; i < n; i++) {
            System.out.println(i+1 + "번 user >> ");

            // 할인율 설정
            int discountPercent = users[i][0]; // 1~40 // user 각각의 할인율로 계산
            if(discountPercent<10) discountPercent = 10;
            else if (discountPercent<20) discountPercent = 20;
            else if (discountPercent < 30) discountPercent = 30;
            else discountPercent = 40;

            while (discountPercent <= 40){
                int price = users[i][1]; // (필요) 구매 금액
                price *= 100;
                price /= 100-discountPercent;

                // 결론
                System.out.println(price + "원 만큼을 " + discountPercent + "할인해서 구매");
                if (price > emoticonsTotalPrice) {
                    System.out.println("도달 불가!!!");
                    break;
                }

                // 다음 연산 준비
                discountPercent += 10;
            }







        }

        // 다음


//        System.out.println("답은 = " + answer[0] + ", " + answer[1]);
    }
}
