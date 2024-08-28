package programmers.level2;

import java.util.ArrayList;

public class AnalogClock { // 아날로그 시계
    // 시작 시간도 알람울린다!!
    // 12시 정각은 시침=분침=초짐 -> 알람 1번 (중복주의)

    public static void main(String[] args) {
        // 초침이 시침/분침과 겹칠 때마다 알람이 울리는 기능

        ArrayList<int[]> inputList = new ArrayList<>();
        inputList.add(new int[]{0, 5, 30, 0, 7, 0, 2});
        inputList.add(new int[]{12, 0, 0, 12, 0, 30, 1}); // 초 ok
        inputList.add(new int[]{0, 6, 1, 0, 6, 6, 0}); // 초 ok
        inputList.add(new int[]{11, 59, 30, 12, 0, 0, 1}); // 초 ok
        inputList.add(new int[]{11, 58, 59, 11, 59, 0, 1}); // 초 ok
        inputList.add(new int[]{1, 5, 5, 1, 5, 6, 2}); // 초 ok
        inputList.add(new int[]{0, 0, 0, 23, 59, 59, 2852});

        for (int[] input : inputList){
            int answer = solution2(input[0], input[1], input[2], input[3], input[4], input[5]);
            if(answer == input[6]){
                System.out.println("Correct! answer: " + answer);
            }
            else {
                System.out.println("틀림!! 답은 " + input[6] + "인데, " + answer + "가 나옴");
            }
            System.out.println();

        }

    }

    // 실패!! 처음부터 해보자!!
     public static int solution1(int h1, int m1, int s1, int h2, int m2, int s2){
         int count=0;

         // 시간차
         double hDif=0;
         double mDif=0;
         double sDif=0;
         if(s1 <= s2) sDif = s2 - s1;
         else{
                sDif = 60 - s1 + s2;
                mDif--;
         }
         if(m1 <= m2) mDif += m2 - m1;
         else{
                mDif += 60 - m1 + m2;
                hDif--;
         }
         hDif += h2 - h1;
         System.out.println("시간차 >> 시: " + hDif + ", 분: " + mDif + ", 초: " + sDif);

         // 현 위치
         double hour = h1*30 + (double)m1/2 + (double)s1/120;
         double minute = m1*6 + (double)s1/10;
         double second = s1*6;

         /////////////////////////////////////////////

         // 시 연산 - 분침
         count += hDif*59; // 로직이 더 필요할까?

         // 시 연산 - 시침
         count += hDif*60;
         if(hDif >=12 ){
             count --; // 일단 한바퀴 잡음
             hDif -= 12;
         }

         if(hour < second && hour + hDif*30 >= second) count--; // 시침이 초침 뒤였는데, 앞으로 바뀐경우 --
         if(hour > second && hour + hDif*30 -360 >= second) count--; // 정각찍고 따라잡음
         hour += hDif*30;


         // 분 연산 - 시침
         count += mDif;
         if(hour < second && hour + mDif/2 >= second) count--; // 시침이 초침 뒤였는데, 앞으로 바뀐경우 --
         if(hour > second && hour + mDif/2 - 360 >= second) count--; // 정각찍고 따라잡음
         hour += mDif/2;
         // 분 연산 - 분침
         count += mDif;
         if(minute < second && minute + mDif*6 >= second) count--; // 분침이 초침 뒤였는데, 앞으로 바뀐경우 --
         if(minute > second && minute + mDif*6 - 360 >= second) count--; // 정각찍고 따라잡음
         minute += mDif*6;

         // 초 연산 - 시침
         if(second < hour && second + sDif*6 >= hour) count++; // 초침이 시침 뒤였는데, 앞으로 바뀐경우 ++
         // 초 연산 - 분침
         if (second < minute && second + sDif*6 >= minute + sDif/10) count++; // 초침이 분침 뒤였는데, 앞으로 바뀐경우 ++
         second += sDif*6;
         minute += sDif/10;
         // 시침 소수점 무시


         // 정각 예외 연산, 0시, 12시
         if(h1 == 0 && m1 == 0 && s1 == 0) count++; // 시작부터 울림
         if(h1 == 12 && m1 == 0 && s1 == 0) count++; // 시작부터 울림
         if(h1 < 12 && h2 >= 12) count--; // 12시 넘어가는 경우 (중복 연산됨)


         return count;
     }

     public static int solution2(int h1, int m1, int s1, int h2, int m2, int s2){
        int count=0;

         // 시간차
         double hDif=0;
         double mDif=0;
         double sDif=0;
         if(s1 <= s2) sDif = s2 - s1;
         else{
             sDif = 60 - s1 + s2;
             mDif--;
         }
         if(m1 <= m2) mDif += m2 - m1;
         else{
             mDif += 60 - m1 + m2;
             hDif--;
         }
         hDif += h2 - h1;
         System.out.println("시간차 >> 시: " + hDif + ", 분: " + mDif + ", 초: " + sDif);

         // h1:m1:s1 -> h2:m2:s2 까지 시간차를 추가



         // 초 연산 sDif
         if(isSecBiggerThanHour(h1,m1,s1)){
             //  1. '초침'이 시침보다 앞에 있었는데 (한바퀴 돌고) 따라잡은 경우 ++
             if(isSecBiggerThanHour(h1,m1,(s1+(int)sDif)%60) && secondAngle(s1) > secondAngle(s1+(int)sDif)) count++;
         }else{
             //  2. '초침'이 시침보다 뒤에 있었는데 앞지른 경우 ++
             if(isSecBiggerThanHour(h1,m1,s1+(int)sDif)) count++;
         }


         if(isSecBiggerThanMinute(m1,s1)){
             //  4. '초침'이 분침보다 앞에 있었는데 (한바퀴 돌고) 따라잡은 경우 ++
             if(isSecBiggerThanMinute(m1, s1+(int)sDif) && secondAngle(s1) > secondAngle(s1+(int)sDif)) count++;
         }else{
             //  3. '초침'이 분침보다 뒤에 있었는데 앞지른 경우 ++
             if(isSecBiggerThanMinute(m1, s1+(int)sDif)) count++;
         }

         s1 += sDif;
         if(s1 >= 60){
             s1 = s1%60;
             m1++;
         }

         // 분 연산 mDif - 초침은 고정
         // 초침은 1분마다 '분침'을 따라잡음, But 1시간 내에 1바퀴 차이날 수 있음
         count += mDif;
         if(isSecBiggerThanMinute(m1,s1)){
             //  1. '분침'이 초침보다 뒤에 있었는데 앞지른 경우 --
         }else{
             //  2. '분침'이 초침보다 앞에 있었는데 (한바퀴 돌고) 따라잡은 경우 --
         }


         // 초침은 1분마다 '시침'을 따라잡음, But 1시간에 내에 1바퀴 차이날 수 있음
         //  3. '시침'이 초침보다 뒤에 있었는데 앞지른 경우 --
         //  4. '시침'이 초침보다 앞에 있었는데 (한바퀴 돌고) 따라잡은 경우 --

         m1 += mDif;
         if(m1 >= 60){
             m1 = s1%60;
             h1++;
         }

         // 시 연산 hDif - 초침, 분침 고정
         // 초침은 1시간마다 '시침'을 60번 잡음, But 12시간 내에 1바퀴 차이날 수 있음
         // If(12시간 차이) -- (한바퀴 확정 잡음)
         //  1. '시침'이 초침보다 뒤에 있었는데 앞지른 경우 --
         //  2. '시침'이 초침보다 앞에 있었는데 (한바퀴 돌고) 따라잡은 경우 --
         // 초침은 1시간마다 '분침'을 59번 잡음 - 둘다 고정값, 예외주의


         // 예외처리
         if(h1 == 0 && m1 == 0 && s1 == 0) count++; // 시작부터 울림
         if(h2 == 12 && m2 == 0 && s2 == 0) count++; // 종료할때 울림
         if (h1*3600 + m1+60 + s1 < 12*60*60 && h2*3600 + m2*60 + s2 > 12*60*60) count--; // 12시 넘어가는 경우 (중복 연산됨)



        return count;
     }

    public static boolean isSecBiggerThanHour(int h, int m, int s){
        if(s >= 60){
            s = s%60;
            m++;
        }
        if(m >= 60){
            m = m%60;
            h++;
        }

        double hour = h*30 + (double)m/2 + (double)s/120;
        int second = s*6;

        if(second >= hour) return true;
        else return false;
    }

    public static boolean isSecBiggerThanMinute(int m, int s){
        if(s >= 60){
            s = s%60;
            m++;
        }
        if(m >= 60){
            m = m%60;
        }

        double minute = m*6 + (double)s/10;
        int second = s*6;

        if(second >= minute) return true;
        else return false;
    }

    public static double hourAngle(int h, int m, int s){
        if(s >= 60){
            s = s%60;
            m++;
        }
        if(m >= 60){
            m = m%60;
            h++;
        }

        return h*30 + (double)m/2 + (double)s/120;
    }

    public static double minuteAngle(int m, int s){
        if(s >= 60){
            s = s%60;
            m++;
        }
        if(m >= 60){
            m = m%60;
        }

        return m*6 + (double)s/10;
    }

    public static int secondAngle(int s){
        s = s%60;
        return s*6;
    }






}
