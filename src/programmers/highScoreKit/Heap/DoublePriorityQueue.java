package programmers.highScoreKit.Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class DoublePriorityQueue { // 이중우선순위큐

    // 최소힙
    public static List<Integer> minHeap = new ArrayList<>();

    public void minInput(int n){
        minHeap.add(n);
        int c = minHeap.size()-1; // 자식노드 index
        int p = (c-1)/2; // 부모노드 index

        // 힙ok or c==0 때까지(뿌리 노드 될때까지) 연산(swap)
        while(c!=0){
            if(minHeap.get(p) > minHeap.get(c)){ // 자식노드가 더 작으면
                minSwap(p,c);
                c = p;
                p = (c-1)/2;
            }
            else break; // 힙 완성
        }
    }

    public int minOutput(){
        int min = minHeap.get(0);
        int l = minHeap.size();

        minHeap.set(0, minHeap.get(l-1)); // 루트 노드에 마지막 노드 삽입
        minHeap.remove(l-1); // 마지막 노드 삭제
        l--;

        // 힙 재구성 - 뿌리 노드부터
        int p=0;
        int lc,rc;

        while (2*p+2 < l){ // 양쪽 자식노드가 더 없을 때 까지
            lc = 2*p+1;
            rc = 2*p+2;

            if(minHeap.get(p) > minHeap.get(lc) && minHeap.get(rc) > minHeap.get(lc)){ // 왼쪽 자식
                minSwap(p,lc);
                p = lc;
            }
            else if(minHeap.get(p) > minHeap.get(rc) && minHeap.get(lc) > minHeap.get(rc)){ // 오른쪽 자식
                minSwap(p,rc);
                p = rc;
            }
            else break; // 부모가 젤 큼(크거나 같음)

        }

        // 왼쪽 자식노드만 있을 경우 따로 연산
        if(2*p+1<l){
            lc = 2*p+1;
            if(minHeap.get(p) > minHeap.get(lc)) minSwap(p,lc);
        }

        return min;
    }
    public void minSwap(int i, int j){ // i,j 위치 교환
        int n = minHeap.get(i);
        minHeap.set(i, minHeap.get(j));
        minHeap.set(j, n);
    }

//    public void minHeapArrangeAfterRemoveMax(int n){ // 최댓값 제거 후 재정렬(반 정렬)
//        int index = minHeap.indexOf(n);
//        minHeap.remove(index);
//
//        for(int i=index; i<minHeap.size(); i++){
//            if(i%2==0){ // 부모노드가 바뀐경우 >> 왼쪽자식에서 '오른쪽 자식'인 경우 >> 짝수
//                // heap 반정렬 연산 - input 과 동일
//                int c = i; // 자식노드
//                int p = (c-1)/2; //부모노드
//
//
//
//            }
//        }
//    }

    // 최대힙
    public static List<Integer> maxHeap = new ArrayList<>();

    public void maxInput(int n){
        maxHeap.add(n);
        int c = maxHeap.size()-1; // 자식노드 index
        int p = (c-1)/2; // 부모노드 index

        // 힙ok or c==0 때까지(뿌리 노드 될때까지) 연산(swap)
        while(c!=0){
            if(maxHeap.get(p) < maxHeap.get(c)){ // 자식노드가 더 크면
                maxSwap(p,c);
                c = p;
                p = (c-1)/2;
            }
            else break; // 힙 완성

        }
    }
    public int maxOutput(){
        int max = maxHeap.get(0);
        int l = maxHeap.size();

        maxHeap.set(0, maxHeap.get(l-1)); // 루트 노드에 마지막 노드 삽입
        maxHeap.remove(l-1); // 마지막 노드 삭제
        l--;

        // 힙 재구성 - 뿌리 노드부터
        int p=0;
        int lc,rc;

        while (2*p+2 < l){ // 양쪽 자식노드가 더 없을 때 까지
            lc = 2*p+1;
            rc = 2*p+2;

            if(maxHeap.get(p) < maxHeap.get(lc) && maxHeap.get(rc) < maxHeap.get(lc)){ // 왼쪽 자식
                maxSwap(p,lc);
                p = lc;
            }
            else if(maxHeap.get(p) < maxHeap.get(rc) && maxHeap.get(lc) < maxHeap.get(rc)){ // 오른쪽 자식
                maxSwap(p,rc);
                p = rc;
            }
            else break; // 부모가 젤 큼(크거나 같음)

        }

        // 왼쪽 자식노드만 있을 경우 따로 연산
        if(2*p+1<l){
            lc = 2*p+1;
            if(maxHeap.get(p) < maxHeap.get(lc)) maxSwap(p,lc);
        }

        return max;
    }
    public void maxSwap(int i, int j){ // i,j 위치 교환
        int n = maxHeap.get(i);
        maxHeap.set(i, maxHeap.get(j));
        maxHeap.set(j, n);
    }


    public static void main(String[] args) {
        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};

//        Queue<Integer> queue1 = (Queue<Integer>) new DoublePriorityQueue(); // ClassCastException

        Queue<Integer> queue = new PriorityQueue<>(); // 최소 heap과 같다
        // 최대와 최소를 동시에 계산할 수 있는 '힙'이 필요 - 최대 힙, 최소 힙 두개로 표현하고 각각 힙에서 특정 값 제거 후 힙을 정렬하는 연산 구현

//        minHeap.remove(minHeap.indexOf(n));









    }

}
