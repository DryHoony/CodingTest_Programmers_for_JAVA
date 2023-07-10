package somthingFun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShortestCrosswalk { // 횡단보도 최단 건너기

    private static List<String> crosswalk = new ArrayList<>();
//    public ShortestCrosswalk() { // 생성자
//        crosswalk = new ArrayList<>();
//        crosswalk.add("a");
//        crosswalk.add("b");
//        crosswalk.add("x");
//        crosswalk.add("y");
//    }


    public static boolean tryCrosswalk(List<String> crosswalk){

        Collections.shuffle(crosswalk); // 무작위 신호등 순서구성
//        for(String s:crosswalk){ // 신호등 순서 출력
//            System.out.print(s);
//            System.out.print(" - ");
//        }
//        System.out.println();

        int nextCrossIndex = 0;
        boolean failFlag = false; // 기본값 초기화 필요

        while(true){

            if(crosswalk.get(nextCrossIndex).equals("a")){
                nextCrossIndex = (nextCrossIndex+1)%4; // 한 사이클 넘을 수도 있으므로 %4 사용할 것
                // 1. a건넘 >> x-y 세트 먼저나오면 실패, b 먼저나오면 성공
                while(true){
                    if(crosswalk.get(nextCrossIndex).equals("b")){
                        return true; // 끝
                    }
                    else if(crosswalk.get(nextCrossIndex).equals("x")){
                        failFlag = true;
                        nextCrossIndex = (nextCrossIndex+1)%4;
                    } else if (crosswalk.get(nextCrossIndex).equals("y") && failFlag) {
                        return false; // 끝
                    }else{
                        nextCrossIndex = (nextCrossIndex+1)%4;
                    }

                }
            }

            else if (crosswalk.get(nextCrossIndex).equals("x")){
                nextCrossIndex = (nextCrossIndex+1)%4; // 한 사이클 넘을 수도 있으므로 %4 사용할 것
                // 2. x건넘 >> a-b 세트 먼저나오면 실패, y 먼저나오면 성공
                while(true){
                    if(crosswalk.get(nextCrossIndex).equals("y")){
                        return true; // 끝
                    }
                    else if(crosswalk.get(nextCrossIndex).equals("a")){
                        failFlag = true;
                        nextCrossIndex = (nextCrossIndex+1)%4;
                    } else if (crosswalk.get(nextCrossIndex).equals("b") && failFlag) {
                        return false; // 끝
                    }else{
                        nextCrossIndex = (nextCrossIndex+1)%4;
                    }

                }

            }

            nextCrossIndex ++; // 한 사이클 내에서 이뤄짐

        }

    }


    public static boolean tryCrosswalkVer2(List<String> crosswalk){

        Collections.shuffle(crosswalk); // 무작위 신호등 순서구성
//        for(String s:crosswalk){ // 신호등 순서 출력
//            System.out.print(s);
//            System.out.print(" - ");
//        }
//        System.out.println();

        // 먼저 건너는 전략 + 알려진정보이용 ver
        String crosswalkOrder = "";
        for (String cross:crosswalk){
            crosswalkOrder += cross;
        }
        if(crosswalkOrder.equals("byxa") || crosswalkOrder.equals("ybax")){
            return true;
        }

        int nextCrossIndex = 0;
        boolean failFlag = false; // 기본값 초기화 필요

        while(true){

            if(crosswalk.get(nextCrossIndex).equals("a")){
                nextCrossIndex = (nextCrossIndex+1)%4; // 한 사이클 넘을 수도 있으므로 %4 사용할 것
                // 1. a건넘 >> x-y 세트 먼저나오면 실패, b 먼저나오면 성공
                while(true){
                    if(crosswalk.get(nextCrossIndex).equals("b")){
                        return true; // 끝
                    }
                    else if(crosswalk.get(nextCrossIndex).equals("x")){
                        failFlag = true;
                        nextCrossIndex = (nextCrossIndex+1)%4;
                    } else if (crosswalk.get(nextCrossIndex).equals("y") && failFlag) {
                        return false; // 끝
                    }else{
                        nextCrossIndex = (nextCrossIndex+1)%4;
                    }

                }
            }

            else if (crosswalk.get(nextCrossIndex).equals("x")){
                nextCrossIndex = (nextCrossIndex+1)%4; // 한 사이클 넘을 수도 있으므로 %4 사용할 것
                // 2. x건넘 >> a-b 세트 먼저나오면 실패, y 먼저나오면 성공
                while(true){
                    if(crosswalk.get(nextCrossIndex).equals("y")){
                        return true; // 끝
                    }
                    else if(crosswalk.get(nextCrossIndex).equals("a")){
                        failFlag = true;
                        nextCrossIndex = (nextCrossIndex+1)%4;
                    } else if (crosswalk.get(nextCrossIndex).equals("b") && failFlag) {
                        return false; // 끝
                    }else{
                        nextCrossIndex = (nextCrossIndex+1)%4;
                    }

                }

            }

            nextCrossIndex ++; // 한 사이클 내에서 이뤄짐

        }

    }

    public static void tryCrosswalkManyTime(int tryCount){
        int success = 0;
        int failure = 0;

        for (int i = 0; i < tryCount; i++) {
//            System.out.println(tryCrosswalk(crosswalk)); // 출력
            if(tryCrosswalkVer2(crosswalk)){
                success++;
            }else{
                failure++;
            }
        }
        float successRate = (float) success/tryCount;


        System.out.println("시도 = " + tryCount + "번, 성공 = " + success + "번, 실패 = " + failure + "번, 확률 = " + successRate);

    }

    public static void main(String[] args) {
        //Q. 사거리의 4개의 신호등이 있다.
        //대각선으로 건너는 신호등은 없으며, 2개 이상의 신호등을 통해 대각선 방향으로 건너가야 한다.
        //처음에 아무런 정보도 없는 상황에서 목적지에 (평균적으로) 가장 빠르게 도달할 수 있는 방법을 설명하시오.

        // A. 먼저오는 신호등을 건넌다
        // 네개의 신호등을 각각 a,b,x,y 라고 하자.
        // 출발점에 인접한 신호등을 a 와 x, 도착점에 인점한 신호등을 b 와 y
        // 즉, 출발점에서 도착점으로 가기 위해, a-b 신호등을 건너거나 x-y 신호등을 건너야 한다.
        // 신호등 abxy 는 무작위의 순서를 가진다. 한 사이클을 이룬다. 4! = 24가지 경우의 수
        System.out.println("중간 -b- 도착");
        System.out.println("-a-     -y-");
        System.out.println("출발 -x- 중간");
        System.out.println();


        // 사거리 신호등 구성
        crosswalk.add("a");
        crosswalk.add("b");
        crosswalk.add("x");
        crosswalk.add("y");


//        Collections.shuffle(crosswalk); // 무작위 신호등 순서구성

//        System.out.println(tryCrosswalk(crosswalk)); // 출력

        // 먼저오는 신호등 건너기 - 기대확률 75%

        // ver2 : 먼저오는 신호등 건너기 + 알려진 정보이용 - 기대확률 83%
        tryCrosswalkManyTime(10);
        tryCrosswalkManyTime(10);
        tryCrosswalkManyTime(10);
        tryCrosswalkManyTime(10);
        tryCrosswalkManyTime(10);
        tryCrosswalkManyTime(10);
        tryCrosswalkManyTime(100);
        tryCrosswalkManyTime(100);
        tryCrosswalkManyTime(100);
        tryCrosswalkManyTime(100);
        tryCrosswalkManyTime(1000);
        tryCrosswalkManyTime(10000);
        tryCrosswalkManyTime(100000);
        tryCrosswalkManyTime(1000000);
        tryCrosswalkManyTime(10000000);




    }
}
