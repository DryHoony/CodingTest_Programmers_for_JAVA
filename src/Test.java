import java.util.*;

public class Test {

    public static void main(String[] args) {
        String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
        // 3 ~ 1000, 시작시간은 모두 다르다

        // 시작 시작으로 정렬
        Arrays.sort(plans, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
//                return o1[1] - o2[1]; // 오름차순
                if( o1[1].split(":")[0].equals(o2[1].split(":")[0]) ){
                    // 시간이 같으면 분으로 비교
                    System.out.print(Integer.parseInt(o1[1].split(":")[1]));
                    System.out.println(" < "+ Integer.parseInt(o1[1].split(":")[1]));
                    return Integer.parseInt(o1[1].split(":")[1]) - Integer.parseInt(o2[1].split(":")[1]);
                }
                System.out.print(Integer.parseInt(o1[1].split(":")[0]));
                System.out.println("< "+ Integer.parseInt(o1[1].split(":")[0]));
                return Integer.parseInt(o1[1].split(":")[0]) - Integer.parseInt(o2[1].split(":")[0]);
            }
        });


        // 정렬확인
        System.out.println();
        System.out.println("정렬확인 >>>>");

        for (int i = 0; i < plans.length; i++) {
            System.out.println(plans[i][1]);
        }

    }






    // '프로그래머스' 에서는 array가 []로 주어진다.
    // [] 를 {} 로 바꿔서 입력하자
    public static String bracketTranslate(String input){
        input = input.replaceAll("\\[","{");
        input = input.replaceAll("\\]","}");

        System.out.println(input);
        return input;
    }

    public static String bracketTranslateReverse(String input){
        input = input.replaceAll("\\{","\\[");
        input = input.replaceAll("}","]");

        System.out.println(input);
        return input;
    }
}









