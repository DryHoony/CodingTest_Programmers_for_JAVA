package programmers.level0;

public class ConsecutiveNumberSum { // 연속된 수의 합

    //재귀함수 이용
    public static int find(int k, int n, int total){ //k부터 시작 n개의 합이 total;
        //종료조건
        if((2*k+n-1)*n/2 == total) return k;
        else if((-2*k+n-1)*n/2 == total) return -k;

        return find(k+1,n,total);

    }

    public static void main(String[] args) {

        int num = 3;
        int total = 12;

        // 재귀함수를 이용해 k찾아보자









        //     public int[] solution(int num, int total) {
//         int[] answer = new int[num];

//         int test = 0;
//         int count;
//         while(true){
//             count = 0;
//             //양수 테스트
//             for (int i = 0; i < num; i++) {
//                 count += test+i;
//             }
//             if(count==total){
//                 // System.out.println("답이다!");
//                 break;
//             }

//             count = 0;
//             //음수 테스트
//             for (int i = 0; i < num; i++) {
//                 count += -test+i;
//             }
//             if(count==total){
//                 // System.out.println("답이다!");
//                 test *= -1;
//                 break;
//             }

//             test++;
//         }

//         for(int i=0; i<num; i++){
//             answer[i] = test+i;
//         }

//         return answer;
//     }

    }

}
