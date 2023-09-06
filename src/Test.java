import java.util.*;

public class Test {

    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2,2}}; // 0~10개

        // 연산용 변수
        int[][] way = new int[n+1][m+1];
        int layer = 1; // 연산하는 층
        List<Integer> layerPuddles = new ArrayList<>(); // 연산하는 층의 웅덩이
        int pud; // 웅덩이 변수

        // 연산
        while(layer<=n){
            // layerPuddles 세팅
            layerPuddles.clear();
            for(int[] p:puddles){
                if(p[0] == layer){ // 현재 층에 해당하는 웅덩이 할당
                    layerPuddles.add(p[1]);
                }
            }
            Collections.sort(layerPuddles);

            // 현재 웅덩이 셋팅
            pud = -1; // fake 값
            if(layerPuddles.size()>0){
                pud = layerPuddles.get(0);
                layerPuddles.remove(0);
            }

            // 메인 연산
            for (int i = 1; i <= m; i++) {
                // way[layer][i] 에 대한 연산

                if(i == pud){ // 웅덩이 이면
                    // 웅덩이 연산 - pud update - outOfBounce 주의
                    if(layerPuddles.size()>0){
                        pud = layerPuddles.get(0);
                        layerPuddles.remove(0);
                    }
                }else {
                    // 정상연산 - 위,왼쪽 값 더함
                    way[layer][i] = way[layer-1][i] + way[layer][i-1];
                }

            }

            // Mod 적용 추가 할것
            layer++;
        }

        System.out.println(way[n][m]);
        // 최단경로의 개수를 1,000,000,007 Module
    }






    // '프로그래머스' 에서는 array가 []로 주어진다.
    // [] 를 {} 로 바꿔서 입력하자
    public static String bracketTranslate(String input){
        input = input.replaceAll("\\[","{");
        input = input.replaceAll("\\]","}");

        System.out.println(input);
        return input;
    }
}









