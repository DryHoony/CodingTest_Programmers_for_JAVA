package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class StringStrangeArrange { // 문자열 내 마음대로 정렬하기

    // list의 원소들을 index(n)을 기준으로 정렬
    public static String[] strangeArrange(String[] list, int n){
        int l = list.length;
        String[][] arrange = new String[l][];

        for (int i = 0; i < l; i++) {
            arrange[i] = new String[]{String.valueOf(list[i].charAt(n)), list[i]};
        }

        // 이차원배열 arrange 정렬
//        Arrays.sort(arrange);
//        Collections.sort(arrange);
        arrange2String(arrange);

        String[] answer = new String[l];
        for (int i = 0; i < l; i++) {
            answer[i] = arrange[i][1];
        }

        return answer;
    }

    // index(n)값을 str앞에 붙이는 idea를 이용, 간단풀이
    public static String[] strangeArrange2(String[] list, int n){
        for (int i = 0; i < list.length; i++) {
            list[i] = String.valueOf(list[i].charAt(n)) + list[i];
        }
        Arrays.sort(list);

        for (int i=0; i< list.length; i++){
            list[i] = list[i].substring(1);
        }

        return list;
    }

    // 이차원 배열 정렬 int
    public static int[][] arrange2Int(int[][] list){
        Arrays.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }else {
                    return o1[0] - o2[0];
                }
            }
        });

        return list;
    }

    // 이차원 배열 정렬 String
    public static String[][] arrange2String(String[][] list){
        Arrays.sort(list, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[0].equals(o2[0])) {
//                    return o1[1] - o2[1];
                    return o1[1].compareTo(o2[1]);
                }else {
//                    return o1[0] - o2[0];
                    return o1[0].compareTo(o2[0]);
                }
            }
        });
        return list;
    }



    public static void main(String[] args) {
        String[] strings = {"sun", "bed", "car"};
        String[] answer = strangeArrange2(strings,1);

        //확인
        for(String s:answer){
            System.out.println(s);
        }








    }
}
