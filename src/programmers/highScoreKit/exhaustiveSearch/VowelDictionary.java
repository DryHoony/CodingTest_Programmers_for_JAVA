package programmers.highScoreKit.exhaustiveSearch;

public class VowelDictionary { // 모음사전
    // 물론 자릿수에 따라 팩토리얼 값을 누적해서 효율적으로 만들 수 있지만
    // 완전탐색 - 재귀 방법 사용해봄

    public static void main(String[] args) {
        String word = "AAA";
        int count=0; // 몇번째 인지 출력

        String[] vowel = {"A", "E", "I", "O", "U"};


        // 재귀로 완전탐색 try
        DictionaryCount(word, "");

        System.out.println("답은 = " + answer);
    }

    static int count=0; // 전역변수로 가져가서 재귀에서 누적해서 더해지도록
    static int answer; // count 값이 재귀함수 벗어나면 유효하지 않은 것 같다. 따로 할당
    static boolean flag = false;
    public static void DictionaryCount(String target, String s){
        // 함수밖에서 입력값으로 받아야함
//        String s = "";
//        int count=0;

        System.out.println("s값 변화 추적 >> "+s);
//        System.out.println("count = " + count);

        // 종료 조건
        if(s.equals(target)){
            answer = count; // 답을 answer 에 할당
            System.out.println("답을 찾으면 재귀가 끝나야 한다!!!!!!!!!!!!!!!!!!!!!!!!!");
            flag = true;
            return; // 여기서 끝나지 않고 계속 탐색중! - 어떻게 하면 중지 할까?
        }

        if(flag) return; // 일단 for 문을 먼저 돌린다.
        // BFS 같은 느낌(단, count 는 DFS처럼 작동한다. Bread를 먼저 펼쳐만 놓는 느낌??)
        // 현상황은 DFS 가 좋은것 같은데(순서대로 누적하고 찾으면 끝나니까) 나중에 다시 해보자.
        String s0;
        if(s.length() < 5){ // 5자리 까지만 연산! - 제대로 작동 안한다!
            for (String v: new String[]{"A", "E", "I", "O", "U"}){
//                s += v; // 누적으로 더하면 안되지.
                s0 = s + v;
                count ++;
//                System.out.println("재귀 이전에 count = " + count);
                DictionaryCount(target, s0); // 재귀
            }
        }

//        System.out.println();

    }
}
