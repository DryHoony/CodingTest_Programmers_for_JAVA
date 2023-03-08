import java.util.*;

public class Test {


    public static void main(String[] args) {
        String today = "2022.11.19";
        String privacy = "2021.05.02 A";

//        System.out.println(privacy.substring(0,10)); // 날자만 호출

//        System.out.println(Integer.parseInt(today.substring(2,4)) - Integer.parseInt(privacy.substring(2,4))); // 년도 차이
//        System.out.println(Math.abs(Integer.parseInt(today.substring(5,7)) - Integer.parseInt(privacy.substring(5,7)))); // 월 차이
//        System.out.println(Integer.parseInt(today.substring(8,10)) - Integer.parseInt(privacy.substring(8,10))); // 일 차이(+-구분)

        // '년*12 + 개월' 차이
//        System.out.println((Integer.parseInt(today.substring(2,4)) - Integer.parseInt(privacy.substring(2,4)))*12 +
//                Math.abs(Integer.parseInt(today.substring(5,7)) - Integer.parseInt(privacy.substring(5,7))));

        // 타입호출
        System.out.println(privacy.substring(11));

    }


    }





