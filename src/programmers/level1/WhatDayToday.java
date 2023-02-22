package programmers.level1;

public class WhatDayToday { //2016, 요일계산

    // 2016년 1월 1일은 금요일일때, 2016년 a월 b일의 요일 계산
    public static String day(int a, int b){
        int n=0;
        int[] month = {0,31,29,31,30,31,30,31,31,30,31,30,31};
        for(int i=0; i<a; i++){
            n+=month[i];
        }
        n+=b;
        n = n%7;

        switch (n){
            case 0:
                return "THU";
            case 1:
                return "FRI";
            case 2:
                return "SAT";
            case 3:
                return "SUN";
            case 4:
                return "MON";
            case 5:
                return "TUE";
            case 6:
                return "WED";
        }
        return "";
    }


    public static void main(String[] args) {
        System.out.println(day(5,24));

    }
}
