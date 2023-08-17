package programmers.highScoreKit.exhaustiveSearch;

public class LeastRectangle { // 최소 직사각형

    public static void main(String[] args) {
        int[][] sizes = {{60,50},{30,70},{60,30},{80,40}};
        // 모든 명함을 수납할 수 있는 최소 직사각형의 넓이를 return

        int x=1; // 가로 >= 세로
        int y=0;
        int a;

        for (int[] size:sizes){
            if(size[0] < size[1]){
                a = size[0];
                size[0] = size[1];
                size[1] = a;
            }

//            System.out.println(size[0] + "가 " + size[1] + "보다 작으면 안된다");
            if(x < size[0])
                x = size[0];
            if(y < size[1]){
                y = size[1];
            }

        }

        System.out.println(x*y);


    }

//    public static void main(String[] args) {
//        int[][] sizes = {{60,50},{30,70},{60,30},{80,40}};
//        int[] answer = maxfirst(sizes[0]);
//
//        for (int i = 1; i < sizes.length; i++) {
//            answer = whUpdate(answer, maxfirst(sizes[i]));
//        }
//
////        return answer[0]*answer[1];
//        System.out.println(answer[0]*answer[1]);
//
//    }

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


}
