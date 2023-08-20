package programmers.highScoreKit.greedyAlgorithm;

public class BigNumberMaking { // 큰 수 만들기

    public static void main(String[] args) {
        // Sol2 - 숫자 별로 탐색 하는 방법

        // Input
        String number = "4177252841"; // 775841
        int k = 4;

        // 연산 변수
        String answer = "";
        int l = number.length();
        int searchIndex;


        for (int n = 9; n >=0 ; n--) {
            System.out.println("숫자 " + n + "에 대한 탐색 Start");
            // 탐색 시작 - 변수 초기화
            searchIndex = 0;

            // 탐색 메소드 f(number, n, k, answer) - number를 숫자 n에 대해 k자리까지 탐색해서 answer 할당
            while(k>0){ // 숫자i 탐색 종료 조건은?
                if(Integer.parseInt(String.valueOf(number.charAt(searchIndex))) == n){ // 탐색숫자 일치
                    // 연산! - answer 에 할당 / k값 차감 / number 업데이트
                    answer += number.charAt(searchIndex);
                    k -= searchIndex;
                    if(searchIndex < number.length()-1){ // 남으면
                        number = number.substring(searchIndex+1, number.length());
                    } else number = ""; // 안남으면

                    // 탐색 계속
                    searchIndex=0;
                    searchIndex--; // while문 마지막에 ++ 무력화

                    System.out.println("숫자 " + n + " 연산");
                    System.out.println("number = " + number);
                    System.out.println("answer = " + answer);
                    System.out.println("k = " + k);
                    System.out.println();
                }
                else if (searchIndex == k) { // 탐색 범위 종료 >> while 문 break;
                    break;
                }

                searchIndex++;
            }


            if(k==0) break;

        }

        System.out.println();
        System.out.println("답은 : " + answer);
    }




    public static void main0(String[] args) {
        // 마지막 한문제 런타임 에러!! - 아깝다!! 쫌만 보완하면 될 것 같다!!

        String numbers = "39571839641794";
        int k = 6;
        // 숫자가 100004321 이딴식으로 주어지면 우짜지? >> check

        // Sol1 - 앞에서(왼쪽)부터 탐색 - 앞자리 최대화 하는 방향으로

        // 연산 변수
        String answer = "";
        int i;
        int recordMax;
        int recordMaxIndex;

        while(k!=0){ // 종료조건
            System.out.println();
            System.out.println("부분 탐색 >>");
            // 부분탐색 초기화
            i=0;
            recordMax=0;
            recordMaxIndex=0;

            while(true){ // 부분탐색

                // 최댓값 기록
                if(recordMax < Integer.parseInt(String.valueOf(numbers.charAt(i)))){
                    recordMax = Integer.parseInt(String.valueOf(numbers.charAt(i)));
                    recordMaxIndex = i;
                    System.out.println("부분 연산 최댓값 : "+recordMax);
                }


                if (recordMax == 9) { // 최대 포인트 찾음
                    answer += numbers.charAt(i); // 답 추가

                    if(i < numbers.length()-1){ // 끝자리가 아니면
                        numbers = numbers.substring(i+1, numbers.length()); // 남은 넘버
                    } else numbers = ""; // 끝자리 이면

//                    k -= i-1; // 오류 예상,,,오류이면 아래구문으로
                    k -= i;
                    break;
                }
                else if(i == k){ // 부분탐색 끝 범위
                    // 탐색 범위내 recordMax 까지 연산
                    answer += recordMax;

                    if(recordMaxIndex < numbers.length()-1){ // 끝자리가 아니면
                        numbers = numbers.substring(recordMaxIndex+1, numbers.length()); // 남은 넘버
                    } else numbers = ""; // 끝자리 이면

//                    k -= recordMaxIndex-1; // k는 남은 갯수 값이고, recordMaxIndex는 Index이다!! 주의!!
                    k -= recordMaxIndex;
                    System.out.println("부분 탐색 끝범위 도달");
                    System.out.println("number = "+ numbers);
                    System.out.println("answer = "+ answer);
                    System.out.println("k = " + k);
                    break;
                }

                i++;
            }



        }

        // 전체 종료 후 남은 numbers 값 할당
        answer += numbers;

        System.out.println();
        System.out.println("정답은 = " + answer);
    }
}
