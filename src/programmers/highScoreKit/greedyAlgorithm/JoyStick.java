package programmers.highScoreKit.greedyAlgorithm;

public class JoyStick { // 조이스틱
    // 오락씩 이니셜 기록 - 조작 최소 횟수
    // name 의 길이는 1~20

    public static void main(String[] args) {
        // 연산을 2단계로 나눠 독립적으로 해보자 - 위치이동 연산 / 알파벳 연산

        String name = "JEROEN";

        // 연산용 변수
        int answer = 0;
        int l = name.length();
        boolean[] isAArr = new boolean[l];
        for (int i = 1; i < l; i++) { // 첫번째는 제외 (어짜피 연산할 거니까)
            if(name.charAt(i)=='A') isAArr[i] = true;
        }

        int move = Integer.MAX_VALUE;
        // 1 위치이동 연산 - 알파벳 연산이 필요한 위치로 최소로 이동, 최대 이동값은 l-1이다.
        // 유턴은 길을 중복으로 지나가게 된다 - 최소화 (최대 한번??)
        int leftEnd=0; // 왼쪽 끝 (초기 위치 기준)
        int rightEnd=0; // 오른쪽 끝 (초기 위치 기준)

        // case1 - 오른쪽 쭉 (왼쪽 방향에서 처음으로 A가 아닌값에 도착)
        for (int i = 1; i < l; i++) {
            if(!isAArr[l-1-i]){
                leftEnd = -i;
                move = Math.min(l-1-i, move);
                System.out.println("case1 연산값 = " + (l-1-i));
                break;
            }
        }
        // case2 - 왼쪽 쭉
        for (int i = 1; i < l; i++) {
            if(!isAArr[i]){
                rightEnd = i;
                move = Math.min(l-1-i, move);
                System.out.println("case2 연산값 = " + (l-1-i));
                break;
            }
        }
        // case3 - 오른쪽 가다가 왼쪽 유턴
        for (int i = 1; i <= l/2; i++) { // 절반만 탐색
            // i만큼 오른쪽 이동한 상태에서 왼쪽 끝 탐색 >> leftEnd 까지
            if(!isAArr[i] && (i*2-leftEnd) < l-1){
                move = Math.min(i*2-leftEnd , move);
            }
        }


        // case4 - 왼쪽 가다가 오른쪽 유턴
        for (int i = 1; i <= l/2; i++) {
            // i만큼 왼쪽으로 이동한 상태에서 오른쪽 끝 탐색 >> rightEnd 까지
            if(!isAArr[l-1-i] && (i*2+rightEnd) < l-1){
                move = Math.min(i*2+rightEnd, move);
            }
        }

        System.out.println("move = " + move);
        answer+=move;



        // 2 알파벳 연산 - 각각의 위치에서 alphabetCount 연산을 실행
        for (int i = 0; i < l; i++) {
            answer += charOperation(name.charAt(i));
        }


        System.out.println("답은 = " + answer);
    }

    public static void main0(String[] args) { // case2 문제있다! - 좌우 선택과정이 너무 어렵다, 다른 전략 취해보자
        // 현재 Index 에서 (좌우탐색으로) 가까운 알파벳으로 이동하고 연산하자.
        String name = "BABAAAAAB";

        // 연산용 변수
        int l = name.length();
        int answer=0;
        boolean finishFlag = false;
        boolean[] isAArray = new boolean[l];
        for (int i = 0; i < l; i++) {
            if(name.charAt(i)=='A') isAArray[i] = true;
        }


        // 처음 위치 연산
        int nowIndex = 0;
        answer += charOperation(name.charAt(nowIndex));
        isAArray[0] = true;

        // 본 연산
        while (!finishFlag){
            // 좌우탐색
            int leftIndex = nowIndex;
            int rightIndex = nowIndex;
            finishFlag = true; // 아래 for 문 탐색에 A가 없으면 통과 >> 연산종료(while문)

            // 이동 및 연산 1회 진행
            for (int i = 0; i < l/2+1; i++) {
                leftIndex--;
                rightIndex++;
                if(leftIndex==-1) leftIndex = l-1;
                if(rightIndex==l) rightIndex = 0;

                if(isAArray[leftIndex] && isAArray[rightIndex]) continue; // case1 - 다음 범위 탐색
                else if (!isAArray[leftIndex] && !isAArray[rightIndex]) { // case2 - 좌우 모두 연산필요 - 좌우방향 선택 추가연산
                    // 좌우 중 어디가 최적일지 추가 탐색 - 누가 먼저 A가 나오는가(해당 방향으로 탐색)
                    int leftCount = 0;
                    int rightCount = 0;

                    for (int j = 0; j < l/2+1; j++) {
                        leftCount++;
                        if(isAArray[(leftIndex-leftCount+l)%l]) break;
                    }
                    for (int j = 0; j < l/2+1; j++) {
                        rightCount++;
                        if(isAArray[(rightIndex+rightCount)%l]) break;
                    }

                    if(leftCount > rightCount){ // case2.1 - 왼쪽선택 연산
                        // 이동연산값
                        if(leftIndex < nowIndex) answer+= nowIndex-leftIndex;
                        else answer += nowIndex - (leftIndex-l);
                        // 알파벳연산값
                        nowIndex = leftIndex;
                        answer += charOperation(name.charAt(nowIndex));

                        finishFlag = false;
                        isAArray[nowIndex] = true;
                        System.out.println("case2.1, 연산 알파벳 = " + name.charAt(nowIndex));
                        break;
                    }
                    else { // case2.2 - 오른쪽 선택 연산
                        // 이동연산값
                        if(nowIndex < rightIndex) answer += rightIndex - nowIndex;
                        else answer += (rightIndex+l) - nowIndex;
                        // 알파벳연산값
                        nowIndex = rightIndex;
                        answer += charOperation(name.charAt(nowIndex));

                        finishFlag = false;
                        isAArray[nowIndex] = true;
                        System.out.println("case2.2, 연산 알파벳 = " + name.charAt(nowIndex));
                        break;
                    }


                } else if (!isAArray[leftIndex]) { // case3 - 왼쪽 연산
                    // 이동연산값
                    if(leftIndex < nowIndex) answer+= nowIndex-leftIndex;
                    else answer += nowIndex - (leftIndex-l);
                    // 알파벳연산값
                    nowIndex = leftIndex;
                    answer += charOperation(name.charAt(nowIndex));

                    finishFlag = false;
                    isAArray[nowIndex] = true;
                    System.out.println("case3, 연산 알파벳 = " + name.charAt(nowIndex));
                    break;
                }else { // isArray[rightIndex] // case 4 - 오른쪽 연산
                    // 이동연산값
                    if(nowIndex < rightIndex) answer += rightIndex - nowIndex;
                    else answer += (rightIndex+l) - nowIndex;
                    // 알파벳연산값
                    nowIndex = rightIndex;
                    answer += charOperation(name.charAt(nowIndex));

                    finishFlag = false;
                    isAArray[nowIndex] = true;
                    System.out.println("case4, 연산 알파벳 = " + name.charAt(nowIndex));
                    break;
                }

            }


        }


        System.out.println("답은 = " + answer);
    }

    public static int alphabetCount(String alphabet){
        if (alphabet.equals("A")) return 0;

        String[] alphabetArray = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N"
                , "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        int count1=0;
        int count2=0;

        for (int i = 1; i <= 13; i++) { // 순방향
            count1++;
            if(alphabet.equals(alphabetArray[i])) break;
        }

        for (int i = 25; i >= 13; i--) { // 역방향
            count2++;
            if(alphabet.equals(alphabetArray[i])) break;
        }

//        System.out.println(count1 + ", " + count2);
        return Math.min(count1, count2);
    }

    public static int charOperation(char ch){
        if(ch == 'A') return 0;

        char[] charArray = {'A','B','C','D','E','F','G','H','I','J','K','L','M'
                ,'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

        int count1=0;
        int count2=0;

        for (int i = 1; i <= 13; i++) { // 순방향
            count1++;
            if(ch == charArray[i]) break;
        }

        for (int i = 25; i >= 13; i--) {
            count2++;
            if(ch == charArray[i]) break;
        }

        return Math.min(count1, count2);
    }
}
