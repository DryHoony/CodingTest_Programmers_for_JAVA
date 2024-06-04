package programmers.level1;

import java.util.Arrays;
import java.util.Comparator;

public class DataAnalysis { // 데이터 분석
    public static void main(String[] args) {
        int[][] data;
        String ext;
        int val_ext;
        String sort_by;

        // case 1
        data = new int[][] {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        ext = "date";
        val_ext = 20300501;
        sort_by = "remain";


        System.out.println(solution(data, ext, val_ext, sort_by));
    }

    public static int[][] solution(int[][] data, String ext, int val_ext, String sort_by){
        // data에서 ext 값이 val_ext보다 작은 데이터만 뽑은 후,
        // sort_by에 해당하는 값을 기준으로 오름차순으로 정렬하여 return
        int answerCount=0;
        int[][] middleAnswer = new int[data.length][];
        int[][] answer;

        int calIndex = -1;
        switch (ext){
            case "code":
                calIndex=0;
                break;
            case "date":
                calIndex=1;
                break;
            case "maximum":
                calIndex=2;
                break;
            case "remain":
                calIndex=3;
                break;
        }
        int sortIndex = -1;
        switch (sort_by){
            case "code":
                sortIndex=0;
                break;
            case "date":
                sortIndex=1;
                break;
            case "maximum":
                sortIndex=2;
                break;
            case "remain":
                sortIndex=3;
                break;
        }


        // data 에서 걸러내기 >> middleAnswer 에 할당
        for(int[] da:data){
            if(da[calIndex] < val_ext){
                middleAnswer[answerCount] = da;
                answerCount++;
            }
        }

        // middleAnswer 남은 길이 잘라내기 >> answer
        answer = new int[answerCount][];
        for (int i = 0; i < answerCount; i++) {
            answer[i] = middleAnswer[i];
        }

        // answer 을 정렬
        int finalSortIndex = sortIndex;
        Arrays.sort(answer, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[finalSortIndex] - o2[finalSortIndex];
            }
        });


        return answer;
    }
}
