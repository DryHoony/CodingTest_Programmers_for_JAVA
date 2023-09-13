package somthingFun;

public class CellPhonePrice { // 핸드폰 가격 비교
    // 자급제(알뜰) vs 공시지원 vs 약정


    public static void main(String[] args) {

        String[] phoneName = {"Galaxy Z Fold5 256GB", "Galaxy Z 플립5 256GB", "Galaxy S23 Ultra"};

        // 알뜰폰
        int[] price1 = {1920000, 1290000, 1400000};
        int charge1 = 20000;


        // 약정
        int[] price2 = {1610000,170000,530000};
        int charge2 = 99000;
        int charge2down = 45000;
        int monthNeed = 7;


        // 계산

//        int month = 24; // 약정, 사용기간
        System.out.println();

        for (int i = 0; i < 3; i++) {
            int month = 24;
            System.out.println(phoneName[i] + " >> " + month+"개월 비교!");
            System.out.println("알뜰폰 = " + (price1[i] + charge1*month));
            System.out.println("일반 = " + (price2[i]+ charge2*monthNeed+ charge2down*(month-monthNeed)));
            System.out.println();

            month = 36;
            System.out.println(phoneName[i] + " >> " + month+"개월 비교!");
            System.out.println("알뜰폰 = " + (price1[i] + charge1*month));
            System.out.println("일반 = " + (price2[i]+ charge2*monthNeed+ charge2down*(month-monthNeed)));
            System.out.println();
            System.out.println("-----------------------------------------");

        }




    }



}
