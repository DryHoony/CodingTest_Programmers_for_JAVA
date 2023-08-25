import java.util.*;

public class Test {


    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        // 연산용 변수
        int l = triangle.length;
        ArrayList<Integer> previousLevel = new ArrayList<>();
        ArrayList<Integer> nextLevel = new ArrayList<>();
        int left;
        int right;

        // 첫째줄 등록
        for(int n:triangle[l-1]){
            previousLevel.add(n);
        }

        // 본연산
        for (int i = l-2; i >=0 ; i--) {

            // nextLevel 좌우 연산 한번에 시도 - max값 할당
            for (int j = 0; j < i+1; j++) {
                left = previousLevel.get(j) + triangle[i][j]; // 왼쪽
                right = previousLevel.get(j+1) + triangle[i][j]; // 오른쪽
                nextLevel.add(Math.max(left,right));
            }
            System.out.println("중간점검 i = "+i + " >> nextLevel = " + nextLevel);


            previousLevel.clear();
            previousLevel = (ArrayList<Integer>) nextLevel.clone();

            nextLevel.clear();

        }

        System.out.println("previousLevel 에 마지막남은 하나가 답" + previousLevel.get(0));
    }

    // '프로그래머스' 에서는 array가 []로 주어진다.
    // [] 를 {} 로 바꿔서 입력하자
    public static String bracketTranslate(String input){
        input = input.replaceAll("\\[","{");
        input = input.replaceAll("\\]","}");

        System.out.println(input);
        return input;
    }

}









