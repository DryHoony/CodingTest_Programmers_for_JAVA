import java.util.*;

public class Test {


//    public static void main(String[] args) { // ver1 실패
//        int[] priorities = {1,1,9,1,1,1}; // 중요도, index 는 문서번호, 1~100개
//        int location = 0;
//
//        // 순환식으로 돌기에 Queue 사용(원형 큐 사용하면??) , 순환 할때 location 값도 같이 돌려줄 것
//
//        Queue<Integer> print = new LinkedList<>(); // 작업목록
//        for(int i:priorities){
//            print.add(i);
//        }
//
//        Arrays.sort(priorities);
//        Stack<Integer> order = new Stack<>(); // (내림차순)정렬된 우선순위
//        for(int i:priorities){
//            order.push(i);
//        }
//
//
////        System.out.println(print);
////        System.out.println(order);
//
//
//
//
//        int n;
//        int count=0;
//        while(true){
//
//            n = print.poll();
//
//            if(n == order.peek()){ // 프린트 출력
//                count++;
//                if(location==0){
//                    System.out.println(count);
//                    break;
//                }
//                order.pop();
//            }
//            else { // 출력X - print 에 다시 Que 걸림
//                print.add(n);
//            }
//
//            location --;
//            if(location<0) location+= priorities.length;
//
//        }
//
//
//    }


}









