package programmers.highScoreKit.greedyAlgorithm;

import java.util.ArrayList;
import java.util.Comparator;

public class TrafficCamera { // 단속카메라

    public static void main(String[] args) {
//        int[][] routes = {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};
        int[][] routes = {
                {-30, -25}, {-29, -21}, {-29, -23}, {-27, -22}, {-25, -20},
                {-25, -17}, {-18, -15}, {-14, -12}, {-16, -10}, {-13, -9},
                {-8, -6}, {-7, -5}, {-4, -2}, {-3, 0}, {1, 4},
                {2, 5}, {3, 6}, {7, 9}, {8, 10}, {9, 12}
        };
        // 길이 1~10000
        // 값 -30000 ~ 30000 (폐구간, 경계포함)

        // ArrayList 로 변경
        ArrayList<int[]> routesArray = new ArrayList<>();
        for (int[] route:routes){
            routesArray.add(route);
        }

        // routesArray 정렬
        routesArray.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                else return o1[0] - o2[0]; // 오름차순(작은것 먼저)
            }
        });

        // 정렬 확인
        System.out.println("정렬 확인");
        for(int[] route:routesArray){
            System.out.println(route[0] + " / " + route[1]);
        }

        // 연산용 변수
        int cameraCount = 0; // 최소 카메라
        int x,y; // 카메라구간
        int a,b; // 차량구간


        System.out.println();
        System.out.println("연산 >> ");

        while(!routesArray.isEmpty()){ // 모두 단속할 때 까지 시행
            x = routesArray.get(0)[0]; // 최초 카메라 구간 할당
            y = routesArray.get(0)[1]; // 최초 카메라 구간 할당
            routesArray.remove(0);
            cameraCount ++;
            System.out.println();
            System.out.println(cameraCount + "번째 카메라 구간 ["+ x + "," + y + "]");

            // 카메라 구간 연산
            while(!routesArray.isEmpty()){ // 두번째 while 문 - 단속카메라에 모두 걸리면 종료
                a = routesArray.get(0)[0]; //차량 구간 할당
                b = routesArray.get(0)[1]; // 차량 구간 할당
//                routesArray.remove(0); // 단속 될때만 제거 - 5는 단속 안된다.
//                System.out.println("차량 단속 [" + a +"," + b + "]");


                // 1,2,3,4,5 단계 조건 - 카메라 구간[x,y]에 대해 / m>0작은값, M큰값, a>=0
                // 두번째 while 문 종료조건 4,5
                if(a == x){ // 1[x, y+k]
                    // 포함됨 - 구간 그대로
                    System.out.println("차량 단속 [" + a +"," + b + "] - 구간1");
                    routesArray.remove(0); // 단속
                    continue;
                } else if (x<a && b<y) { // 2[x+m, y-m]
                    // 양쪽 범위 축소
                    x = a;
                    y = b;
                    System.out.println("차량 단속 [" + a +"," + b + "] - 구간2");
                    routesArray.remove(0); // 단속
                } else if (x<a && a<y && y<=b) { // 3[x+m, y+a]
                    // 왼쪽만 축소
                    x = a;
                    System.out.println("차량 단속 [" + a +"," + b + "] - 구간3");
                    routesArray.remove(0); // 단속
                } else if (y==a) { // 4[y, y+m] // 끝에 걸침
                    x = a; // 카메라는 x=y=a 로 (포인트)수렴
                    System.out.println("차량 단속 [" + a +"," + b + "] - 구간4");
                    routesArray.remove(0); // 단속

                    while(!routesArray.isEmpty()){ // a 포인트 부분 단속
                        if(routesArray.get(0)[0] == x){ // 단속 걸림
                            System.out.println(a + " 포인트 카메라 걸림");
                            routesArray.remove(0); // 단속
                        }
                        else { // 단속 안걸리면 그대로 while문 종료
                            break;
                        }
                    }

                    break;
                } else if (y < a) { // 5[y+m, y+M] // 범위 벗어남
                    System.out.println("차량 단속 [" + a +"," + b + "] - 구간5");
                    break;
                }

                System.out.println(cameraCount + "번째 카메라 구간 ["+ x + "," + y + "]");
            }




        }



        System.out.println();
        System.out.println("답은 = " + cameraCount);
    }


    public static String bracketTranslate(String input){
        input = input.replaceAll("\\[","{");
        input = input.replaceAll("\\]","}");

        return input;
    }
}
