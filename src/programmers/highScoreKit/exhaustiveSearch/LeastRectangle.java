package programmers.highScoreKit.exhaustiveSearch;

public class LeastRectangle { // 최소 직사각형

    public static int[] maxfirst(int[] list){
        if (list[0]>=list[1]) return list;
        else{
            int[] answer = {list[1],list[0]};
            return answer;
        }
    }

    public static int[] whUpdate(int[] a, int[] b){
        return new int[] {Math.max(a[0],b[0]),Math.max(a[1],b[1])};
    }

    public static void main(String[] args) {
        int[][] sizes = {{60,50},{30,70},{60,30},{80,40}};
        int[] answer = maxfirst(sizes[0]);

        for (int i = 1; i < sizes.length; i++) {
            answer = whUpdate(answer, maxfirst(sizes[i]));
        }

//        return answer[0]*answer[1];
        System.out.println(answer[0]*answer[1]);

    }
}
