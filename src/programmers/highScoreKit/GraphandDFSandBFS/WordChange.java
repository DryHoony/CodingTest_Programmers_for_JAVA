package programmers.highScoreKit.GraphandDFSandBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class WordChange { // 단어 변환
    // 각각의 알파벳이 target 과 일치해도 보장X >> 바꿔야 할 수도 있음
    // ex aaa >> aba >> abc >> xbc >> xkk > akk, [0]의 a를 바꾸지않고 가는 다른 경로 X 일때

    public static void main(String[] args) {
        String begin = "hit"; // 3~10
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"}; // 3~50

        // 연산용 변수
        int l = words.length;
        int targetIndex=-1;
        for (int i = 0; i < l; i++) {
            if(words[i].equals(target)){
                targetIndex = i;
                break;
            }
        }
        if(targetIndex==-1){
            System.out.println("불가능!! - word 에 target 이 없음");
//            return 0;
        }

        // 연결리스트
        ArrayList<Integer>[] adj = new ArrayList[l];
        for (int i = 0; i < l; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < l; i++) {
            for (int j = i+1; j < l; j++) {
                if(canWordChange(words[i],words[j])){
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }


        boolean[] visited = new boolean[l];
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> nextLevelQueue = new LinkedList<>();

        // words 에서 출발하지 않는 초기 연산
        int level = 1;
        for (int i = 0; i < l; i++) {
            if(canWordChange(begin, words[i])){
                queue.add(i);
                visited[i] = true;
            }
        }

        // BFS - 최단 거리
        while(!queue.isEmpty()){
            if(visited[targetIndex]){ // 종료조건
                System.out.println("return level");
                break;
            }
            level++;

            // node 에서 탐색 연산 - nextLevelQueue 에 할당
            while (!queue.isEmpty()){
                int node = queue.poll();

                for (int i:adj[node]){ // 인접 노드 방문
                    if(!visited[i]){
                        nextLevelQueue.add(i);
                        visited[i] = true;
                    }
                }

            }


            // 다음레벨 준비
            queue.addAll(nextLevelQueue);
            nextLevelQueue = new LinkedList<>(); // 초기화

        }


        // 결과
        if(!visited[targetIndex]){
            System.out.println("탐색종료 도달X >> return 0");
        }
        else System.out.println("답은 = " + level);
    }

    public static boolean canWordChange(String x, String y){ // x,y 는 같지 않음
        boolean flag = true;

        for (int i = 0; i < x.length(); i++) {
            if(x.charAt(i) != y.charAt(i)){
                if(flag){
                    flag = false;
                }else return false; // flag 가 이미 false 인데 두번 틀릴경우
            }

        }

        return true;
    }
}
