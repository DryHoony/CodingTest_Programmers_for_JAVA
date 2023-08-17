package programmers.level2.failed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InterceptionSystem { // 요격시스템
    // https://school.programmers.co.kr/learn/courses/30/lessons/181188

    // ver1 - 정답률 3/11, 실패, 시간초과
//    public static void main(String[] args) {
//        int[][] targets = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}}; // 개구간 (s,e), 1~500,000
//
//        // 모든 targets 을 요격하기 위한 최소 횟수
//        int answer = 0;
//        Integer s,e;
//
//        // 1단계 - s 출발 중복 제거 가장 짧은 미사일 , Map<s,e> 값으로 구성해서 keySet()
//        Map<Integer, Integer> missiles = new HashMap<>();
//        for(int[] m:targets){
//            e = missiles.get(m[0]);
//
//            if(e == null){ // 없으면 등록
//                missiles.put(m[0], m[1]);
//            } else if (m[1] < e) { // 더 짧으면 업데이트
//                missiles.put(m[0], m[1]);
//            }
//        }
//
////        System.out.println("1단계 확인 - start 중복 제거");
////        System.out.println(missiles.keySet());
////        System.out.println(missiles.values());
//
//
//        // 2단계 - 포함관계 제거 (s1-(s0-e0)-e1) >> (s0, e0) 제거
//        // 계단식으로 구성됨(끊어지든 이어지든)
//        List<Integer> includedMissileS = new ArrayList<>();
//
//        for(int start:missiles.keySet()){
//            e = missiles.get(start);
//
//            for (int i = start+1; i < e; i++) { // 연산 개빡셈!!
//                if(missiles.get(i) != null){
//                    if(missiles.get(i) <= e){
//                        // 포함됨 - 추후 제거
//                        includedMissileS.add(start);
//                    }
//                }
//            }
//
//        }
//
//        for (int i:includedMissileS){
//            missiles.remove(i);
//        }
//
////        System.out.println("2단계 확인 - 포함관계 제거");
////        System.out.println(missiles.keySet());
////        System.out.println(missiles.values());
//
//
//        // 3단계 - 가장 왼쪽 미사일의 가장 오른쪽(e-0 실수값)에서 요격하여 중복값 최대화 >> 남은 미사일의 가장 왼쪽,,,반복(while)
//        e = 0; // 초기화
//        for (int start : missiles.keySet()){
//            if(start < e){
//                continue; // 이미 요격됨
//            }
//            else{
//                answer++; // 요격
//                e = missiles.get(start); // 범위 update
////                System.out.println("4단계 요격 위치 확인 >> " + e);
//
//            }
//        }
//
//        // 출력확인
//        System.out.println(answer);
//    }

    // ver2 - 정답률4/11
    public static void main(String[] args) {
        int[][] targets = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}}; // 개구간 (s,e), 1~500,000
        int answer = 0;

        // 1 ≤ targets의 길이 ≤ 500,000
        // 0 ≤ s < e ≤ 100,000,000
        // s 중복이 없을 가능성이 더 높음
        // 중복제거 연산을 굳이 시행하지 않고, 요격 연산만 돌린다.

        // 1단계 - s 출발 중복 제거 가장 짧은 미사일 , Map<s,e> 값으로 구성해서 keySet()
        Integer e;
        Map<Integer, Integer> missiles = new HashMap<>();
        for(int[] m:targets){
            e = missiles.get(m[0]);

            if(e == null){ // 없으면 등록
                missiles.put(m[0], m[1]);
            } else if (m[1] < e) { // 더 짧으면 업데이트
                missiles.put(m[0], m[1]);
            }
        }

        // keySet  - 순서보장
//        System.out.println(missiles.keySet());


        e=0; // 초기화
        for (int s: missiles.keySet()){ // s값 (오름차순)순서대로 출력
            // (s,e)

            if(s < e){ // 기존 요격 범위에 들어감.
                if(missiles.get(s) < e){ // 포함되는 더 짧은 구간이면, 요격 범위 축소
                    e = missiles.get(s);
                }
//                e = Math.min(e, missiles.get(s)); // 위 if문 이렇게 해도 ok

            }else { // 기존 요격 범위에 들지 않으면, 새로운 요격 추가.
                answer ++;
                e = missiles.get(s); // 새로운 요격 범위
            }

            // 미사일 요격은 실수값이지만, (s,e) 범위 내에 모든값에서 ok인 구간 산출 >> 최적화 되면 구간의 길이 = 1
        }

        // 결과 확인
        System.out.println(answer);
    }

    // 그리디 알고리즘 필요할듯!!
}


