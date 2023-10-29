package programmers.highScoreKit.greedyAlgorithm;

import java.util.Stack;

public class BigNumberMaking { // 큰 수 만들기

    // 0 잘 작동하는것 같은데??,,
    // 999991, 3 >> test

    public static void main(String[] args) { // 2개 실패(12개 중) - 반례, 오류 찾아보자
        String number = "99991"; // 자릿수 2~1,000,000
        int k = 3; // 1~number.length
        // number 에서 4개를 제거 >> 가장 큰 수 return
        // number 의 숫자 순서를 유지
        // 그리디하게 k번 연산하기는 너무 무겁지 않나?,,

        // 연산용 변수
        String answer = "";
        Stack<String> stack = new Stack<>();


        String searchN = "9";
        int l;
        // 연산 - searchN에 대해 탐색
        while(k>0){
            System.out.println("반복문 연산 >> ");
            System.out.println("answer = " + answer);
            System.out.println("number = " + number);
            System.out.println("searchN = " + searchN);
            System.out.println("k = " + k);

            if(number.length() == k) break;

            int i = number.indexOf(searchN); // 연산숫자의 index

            if(i != -1){ // 찾음
                // [i], i+1 번재 에서 발견 -> i 만큼을 제거 할 수 있나? >> case 1,2

                if(i <= k){
                    System.out.println("case 1 - k 충분 정상연산");
                    System.out.println();
                    // case 1 - number에서 [i-1]까지 제거,
                    // 남은 number의 앞에서 연속된 searchN 갯수만큼 answer에 추가(같은 갯수만큼 number에서 제거), 다음 숫자 연산
                    number = number.substring(i,number.length());
                    k -= i;
                    l = -1; // 처음으로 searchN 이 아닌 수 등장 index
                    for (int j = 0; j < number.length(); j++) { // l에서 처음으로 searchN 이 아닌 수 등장
                        if(number.charAt(j) != searchN.charAt(0)){
                            l = j;
                            break;
                        }
                    }
                    if(l == -1){ // 모든 수가 searchN >> 즉시 종료
                        answer += searchN.repeat(number.length() - k);
                        break;
                    }
                    if(number.length()-(l) < k) { // 남은 수가 k 보다 작을 경우
                        int remain = number.length()-l;
                        // answer 의 뒤에서 remain 만큼 제거
                        answer = answer.substring(0, answer.length()-remain);
                        break;
                    }
                    number = number.substring(l, number.length());
                    answer += searchN.repeat(l);

                    // 남은 범위 연산 - 그대로 while 문으로 복귀 - searchN 으로 남은 범위 다시 탐색
                }else {
                    System.out.println("case 2 - k 부족, Stack 연산");
                    System.out.println();
                    // case 2 - number 의 [i-1]까지 다음 숫자 연산으로 넘김, number의 [i]부터 뒤를 Stack에 저장하여 마지막에 answer에 추가
                    stack.push(number.substring(i,number.length()));
                    number = number.substring(0, i);
                    searchN = String.valueOf(Integer.parseInt(searchN)-1); // 다음 숫자


                }


            }
            else { // searchN 없음
                System.out.println("case 3 - 다음 숫자");
                System.out.println();
                // case3 - 다음 숫자 연산으로 넘어감
                searchN = String.valueOf(Integer.parseInt(searchN)-1);
            }


        }


        // Stack 쌓인 값 answer 에 추가
        while (!stack.isEmpty()){
            answer += stack.pop();
        }

        System.out.println("답은 = " + answer);
    }





}
