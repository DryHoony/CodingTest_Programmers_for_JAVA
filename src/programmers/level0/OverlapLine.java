package programmers.level0;


public class OverlapLine { // 겹치는 선분의 길이

    public static int[] twoLineOverlap(int[] l1, int[] l2){
        int a = Math.max(l1[0],l2[0]);
        int b = Math.min(l1[1],l2[1]);

        if(a<b) return new int[]{a, b};
        else  return new int[]{0, 0};
    }

    public static int overLapLength(int[] l1, int[] l2){
        int a = Math.max(l1[0],l2[0]);
        int b = Math.min(l1[1],l2[1]);

        if(a<b) return b-a;
        else return 0;
    }


    public static void main(String[] args) {
        int[][] lines = {{0,5},{3,9},{1,10}};

        int answer = 0;
        answer += overLapLength(lines[0],lines[1]);
        answer += overLapLength(lines[0],lines[2]);
        answer += overLapLength(lines[1],lines[2]);
        answer -= 2*overLapLength(lines[0], twoLineOverlap(lines[1],lines[2]));

        System.out.println(answer);


    }
}
