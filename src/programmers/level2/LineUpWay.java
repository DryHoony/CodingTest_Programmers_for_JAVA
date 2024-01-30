package programmers.level2;


import java.util.ArrayList;

public class LineUpWay { // 줄서는 방법
    public static void main0(String[] args) {
        int n = 5; // 20이하 자연수
        long k = 7;

        // 연산용 변수

        ArrayList<Integer> list = new ArrayList<>(); // 줄 세울 숫자 list
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int fi; // Factorial 연산 변수
        long count = 0; // k 도달시 종료

        int[] answer = new int[n];
        int aIndex = 0;
        // list 에 있는 숫자를 answer 에 할당, 그 과정에서 경우의 수 count 에 누적

        // 연산
        // 1. 자릿수 찾기 : count + F(i) <= k 를 만족하는 max(i)값 찾기
        // 2. 자릿수 할당 : list 에서 해당 '위치 값' 제거 및 answer 에 할당
        // 3. count==k 일때까지 1,2 반복 (list 에 원소가 남을 경우 순서 그대로 answer 에 할당 with aIndex)

        while(count < k){
            // 1. 자릿수 찾기
            fi = list.size();
            while (true){
                if(factorial(fi)+count < k) break;
                else fi--;
            }
            // Factorial(fi) 가 몇번 들어가는지 연산, 'fi-1' 자리에 연산수 만큼 list[index]값 할당

            // 2. 자릿수 할당
            int div = (int) ((k-count)/ factorial(fi));
            answer[aIndex] = list.get(div);
            aIndex++;
            list.remove(div);
            count += factorial(fi) * div;

            // 중간연산 결과 출력
            System.out.println();
            System.out.println("answer 출력");
            for (int i:answer){
                System.out.print(i + " ");
            }
        }


        System.out.println("답은 = ");
        for (int i:answer){
            System.out.print(i + " ");
        }
    }

    // ver1
    public static void main1(String[] args) {
        int n = 5;
        long k = 2;

        // 연산용 변수
        ArrayList<Integer> numList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numList.add(i);
        }
        int[] answer = new int[n];
        int aIndex=0;

        while(k>1){ // 종료조건 k=0 and aIndex=n (answer 에 모두 할당)
            // 현재 연산 자릿수 = n-aIndex
            // F(i-1) 값이 몇번 들어갈까? = numList 에서 몇번째 Index 뽑아갈까? = k/Factorial(n-aIndex-1)
            int i = (int) (k/ factorial(n-aIndex-1));
            System.out.println();
            System.out.println(aIndex+1 +  "번째 i = " + i);

            if(i==0){
                answer[aIndex] = numList.get(i);
                aIndex++;
                numList.remove(i);
                System.out.print("answer = ");
                for (int a:answer){
                    System.out.print(a + " ");
                }
                System.out.println();
                System.out.println("numList = " + numList);
                System.out.println("k = " + k);
            } else {
                k -= factorial(n-aIndex-1) * i; // 경우의 수 count
                System.out.println("남은 k = " + k);

                answer[aIndex] = numList.get(i); // answer 에 할당
                aIndex++;
                numList.remove(i); // numList 제거

                if(k==0){
                    // F(i) 딱 맞춤 >> 남은 numList 역순 할당
                    int l = numList.size();
                    for (int j = l-1; j >= 0; j--) {
                        answer[aIndex] = numList.get(j);
                        aIndex++;
                        numList.remove(j);
                    }
                }

                System.out.print("answer = ");
                for (int a:answer){
                    System.out.print(a + " ");
                }
                System.out.println();
                System.out.println("numList = " + numList);
            }


        }

//        System.out.println("numList = " + numList);
//        System.out.println("aIndex = " + aIndex);
        // 마지막 항 할당
        while (!numList.isEmpty()){
            answer[aIndex] = numList.get(0);
            aIndex++;
            numList.remove(0);
        }



        System.out.println("---------------------------------");
        System.out.println("answer 출력 >> ");
        for (int a:answer){
            System.out.print(a + " ");
        }


    }

    public static void main(String[] args) {
        int n = 5;
        long k = 26;
        lineUpWayCases(n, k);

//        for (int i = 1; i < 10; i++) {
//            k=i;
//            System.out.print("n = " + n);
//            System.out.println(",  k = " + k + " 연산 ---------------");
//            lineUpWayCases(n,k);
//            System.out.println("--------- 위는 " + k + "번째 답 ---------");
//        }



    }

    public static int[] lineUpWayCases(int n, long k){
        // 연산용 변수
        ArrayList<Integer> numList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numList.add(i);
        }
        int[] answer = new int[n];
        int aIndex=0;

        // 연산
        while (k>2){
            int i = (int)((k-1)/factorial(n-aIndex-1));
            System.out.println("i = " + i);

            answer[aIndex] = numList.get(i);
            aIndex++;
            numList.remove(i);
            if(i==0) continue; // k 연산 XX

            k -= factorial(n-aIndex)*i;
            System.out.println("k = " + k);
            printAnswer(answer);
        }



        if(k==1){
            while (!numList.isEmpty()){
                answer[aIndex] = numList.get(0);
                aIndex++;
                numList.remove(0);
            }
        } else { // k==2 >> 마지막 2자리만 switch
            while (numList.size()>2){
                answer[aIndex] = numList.get(0);
                aIndex++;
                numList.remove(0);
            }
            answer[aIndex] = numList.get(1);
            aIndex++;
            numList.remove(1);
            answer[aIndex] = numList.get(0);
            aIndex++;
            numList.remove(0);
        }


        printAnswer(answer);
        return answer;
    }

    public static long factorial(int n){
        long a = 1;
        for (int i = 2; i <= n; i++) {
            a *= i;
        }
        return a;
    }

    public static void printAnswer(int[] answer){
        System.out.print("answer 출력 = ");
        for (int a:answer){
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
