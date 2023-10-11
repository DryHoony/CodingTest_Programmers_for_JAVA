package programmers.level2;

import java.util.Stack;

public class ParcelBox { // 택배상자

    public static void main(String[] args) {
        int[] order = {4,3,1,2,5}; // 길이 1~1,000,000, 최대값은 길이와 같음 (중복없이 한번씩 등장)
//        int[] order = {5, 4, 3, 2, 1};

        // 연산용 변수
        int n = order.length;
        int answer = 0;
        Stack<Integer> belt = new Stack<>();
        int j=0; // order 의 독립적인 index


        // 연산 - 1~n 까지 돌면서 order 에 주어진 순서대로 상하차, 보조벨트(stack) 사용가능
        for (int i = 1; i <= n ; i++) {
//            System.out.println(order[j] + "가 필요하다");
//            System.out.print(i + "는 >> ");

            if(order[j] > i){
                belt.push(i);
//                System.out.println("보조 벨트에 추가");
            }
            else if (order[j] == i) {
                answer++; // 상하차
                j++; // 다음 order
//                System.out.println("딱맞네!");
            }
            else{
                // 보조 belt 연산

                if(belt.peek() == order[j]){
                    belt.pop();
                    answer++; // 상하차
                    j++; // 다음 order

                    i--; // 통할까? >> good!
//                    System.out.println("그대로 두고, 보조벨트연산!");
                }
                else break;

            }
        }

        // for 문 종료 후 보조벨트 연산 (가능할 때까지)
        while(!belt.isEmpty()){
            if(belt.pop() == order[j]){
                answer++;
                j++;
            }
            else break;

        }




        System.out.println("답은 == "+ answer);
    }




}
