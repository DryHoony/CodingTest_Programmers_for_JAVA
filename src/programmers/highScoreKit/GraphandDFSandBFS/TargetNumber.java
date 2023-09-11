package programmers.highScoreKit.GraphandDFSandBFS;

public class TargetNumber { // 타겟넘버

    public static void main(String[] args) {
        int[] numbers = {4,1,2,1}; // 음이 아닌 정수들, 덧셈 뺄셈으로 target 만드는 경우의 수 return
        int target = 4;


        // 연산용 변수
//        int count=0;
//        int cal=0;
        int l = numbers.length;

        // DFS - 모든 변수 탐색, number.length 2~20 >> 분기의 갯수, visited 필요X
        dfs(numbers, target, 0, 0);

        System.out.println("답은 = " + count);
    }

    static int count;

    static void dfs(int[] numbers, int target, int node, int cal){
        if(node == numbers.length){ // 종료조건
            if(cal == target) count++;
        }
        else {
            dfs(numbers, target, node+1, cal+numbers[node]);
            dfs(numbers, target, node+1, cal-numbers[node]);
        }


    }



}
