package programmers.highScoreKit.Sort;

import java.util.ArrayList;
import java.util.List;

public class HIndex { // H-Index

    static List<Integer> heap = new ArrayList<>();

    public static void swap(int i, int j){ // i,j 위치 교환
        int n = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, n);
    }

    public static void input(int n){
        heap.add(n);
        int c = heap.size()-1; // 자식노드 index
        int p = (c-1)/2; // 부모노드 index

        // 힙ok or c==0 때까지(뿌리 노드 될때까지) 연산(swap)
        while(c!=0){
            if(heap.get(p) < heap.get(c)){ // 자식노드가 더 크면
                swap(p,c);
                c = p;
                p = (c-1)/2;
            }
            else break; // 힙 완성

        }
    }

    public static int output(){
        int max = heap.get(0);
        int l = heap.size();

        heap.set(0, heap.get(l-1)); // 루트 노드에 마지막 노드 삽입
        heap.remove(l-1); // 마지막 노드 삭제
        l--;

        // 힙 재구성 - 뿌리 노드부터
        int p=0;
        int lc,rc;

        while (2*p+2 < l){ // 양쪽 자식노드가 더 없을 때 까지
            lc = 2*p+1;
            rc = 2*p+2;

            if(heap.get(p) < heap.get(lc) && heap.get(rc) <= heap.get(lc)){ // 왼쪽 자식
                swap(p,lc);
                p = lc;
            }
            else if(heap.get(p) < heap.get(rc) && heap.get(lc) <= heap.get(rc)){ // 오른쪽 자식
                swap(p,rc);
                p = rc;
            }
            else break; // 부모가 젤 큼(크거나 같음)

        }

        // 왼쪽 자식노드만 있을 경우 따로 연산
        if(2*p+1<l){
            lc = 2*p+1;
            if(heap.get(p) < heap.get(lc)) swap(p,lc);
        }

        return max;
    }

    public static void main(String[] args) { // ver1 - Nice! 한번에 통과!
        int[] citations = {3, 0, 6, 1, 5}; // 원소값 0~10000, 배열 길이 1~1000

//        Arrays.sort(citations, Collections.reverseOrder()); // Integer[] 여야 한다
        // Max Heap 으로 대체
        for(int i:citations){
            input(i);
        }

        int H=0;
        int n;

        for (int i = 0; i < citations.length; i++) {
            n = output();
//            System.out.println(n); // 확인용
            if(H >= n) break;

            H++;
            if(H==n) break;

        }

        // 결과확인
        System.out.println(H);




    }

}
