package programmers.highScoreKit.greedyAlgorithm;

public class JoyStick { // 조이스틱
    // 오락씩 이니셜 기록 - 조작 최소 횟수
    // name 의 길이는 1~20

    public static void main(String[] args) {
        // 틀림(70%) - 아깝다,, 뭐가 틀렸을까?,,

        String name = "JEROEN";

        int l = name.length();
        String shiftName;
        int count=999999;


        for (int i = 0; i < l; i++) {
            shiftName = name.substring(i,l) + name.substring(0,i);
            System.out.println(shiftName); // 연산에 이동값을 추가해야 함

            count = Math.min(count, Math.min(leftCalculation(shiftName), rightCalculation(shiftName)) + Math.min(i, l-1));
        }
        System.out.println(count);

    }

    public static void main0(String[] args) {
//        String name = "JEROEN"; // 56
//        String name = "JAN"; //23
//        String name = "JAZ"; //11 - J 완성한 다음 오른쪽 아니라 왼쪽으로 이동에 주의!!
        // 순방향이 아닌 유턴을 포함하는 예시
        String name = "ABAAAAB"; //5
//        String name = "BABAAAAAB"; // 8
//        String name = "ABAAAABAB"; // 8 !!초기 방향 오른쪽, if(왼쪽출발)= 10 !!!


        // Sol1 - Min(앞 방향 연산, 뒷 방향 연산) - 순 방향 밖에 계산 못함
//        rightCalculation(name);
//        leftCalculation(name);

        // Sol2 - greedy 하게 접근해보자 - 각 단계에서 A가 아닌 문자 가까운 곳을 선택해 연산한다.
        // 좌우 방향이 같으면 '재귀'를 이용해 둘다 해보고 min 값 도출!!
        int totalCount = 0; // 이동+연산
        int l = name.length(); // 길이
        int index=0; // 탐색 위치(현재 위치)
        String[] nameArray = name.split("");

        while(true){
            // 오른쪽 탐색 - l/2 만큼 탐색(A가 아닐때 까지) - 탐색범위 벗어나면 l/2+1

            // 왼쪽 탐색 - l/2 만큼 탐색(A가 아닐때 까지) - 탐색범위 벗어나면 l/2+1

            // 길이비교 - 방향선택 - 같으면 '재귀'로 둘다 탐색연산()

        }


//        System.out.println(totalCount);
    }

    public static int leftCalculation(String name){
        int leftCount = 0;
        int joyStickHorizontalCount = 0; // alphabet 연산이 필요할때 연산횟수(Count)에 추가 및 초기화

        // 왼쪽 연산
        if(name.charAt(0) != 'A'){ // 반대로 돌기전 첫번째 위치 연산
            leftCount += alphabetCount(String.valueOf(name.charAt(0)));
        }
        joyStickHorizontalCount = 1; // 오른쪽 연산에 썼으니 일단 초기화

        for (int i = name.length()-1; i > 0; i--) {
            if(name.charAt(i) != 'A'){
                leftCount += alphabetCount(String.valueOf(name.charAt(i)));
                leftCount += joyStickHorizontalCount;
//                System.out.println(name.charAt(i) + " 연산할때 " + joyStickHorizontalCount + "칸 움직임 횟수 추가");
                joyStickHorizontalCount = 1;
            }
            else joyStickHorizontalCount++;
        }

        System.out.println("왼쪽 연산 횟수 : " + leftCount);

        return leftCount;
    }

    public static int rightCalculation(String name){
        int rightCount = 0;
        int joyStickHorizontalCount = 0; // alphabet 연산이 필요할때 연산횟수(Count)에 추가 및 초기화

        // 오른쪽 연산
        for (int i = 0; i < name.length(); i++) {
            if(name.charAt(i) != 'A'){
                rightCount += alphabetCount(String.valueOf(name.charAt(i)));
                rightCount += joyStickHorizontalCount; // 좌우 움직임 횟수 추가
//                System.out.println(name.charAt(i) + " 연산할때 " + joyStickHorizontalCount + "칸 움직임 횟수 추가");
                joyStickHorizontalCount = 1; // 초기화(한칸은 움직임)
            }
            else joyStickHorizontalCount++; // A이면 좌우 움직임만 기록
        }

        System.out.println("오른쪽 연산 횟수 : "+ rightCount);

        return rightCount;
    }
    public static int alphabetCount(String alphabet){
        String[] alphabetArray = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        int count1=0;
        int count2=0;

        for (int i = 0; i < 26; i++) { // 순방향
            if(alphabet.equals(alphabetArray[i])) break;
            count1++;
        }

        for (int i = 25; i > 0; i--) { // 역방향
            if(alphabet.equals(alphabetArray[i])){
                count2++;
                break;
            }
            count2++;
        }

//        System.out.println(count1 + ", " + count2);
        return Math.min(count1, count2);
    }
}
