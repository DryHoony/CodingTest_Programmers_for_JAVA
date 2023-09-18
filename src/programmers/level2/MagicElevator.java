package programmers.level2;

import java.util.ArrayList;

public class MagicElevator { // 마법의 엘리베이터

    public static void main(String[] args) {
        int storey = 16; // 1~100,000,000

        // 연산용 변수
        int count=0;
        int floor;

        while(storey>=10){
            floor = storey%10;
            storey /= 10;

            if(floor<=4) count+=floor;
            else if (floor>=6) {
                count += 10-floor;
                storey++; // 다음층에 추가
            }else { // floor == 5 >> 내려갈지 올라갈지, 다음층에 따라 구분
                count += 5;
                if(storey%10 >= 5) storey++; // 다음층에 추가
            }
        }

        // 마지막 층
        if(storey <=5) count += storey;
        else count += 11-storey;


        System.out.println("답은 >> "+count);
    }
}
