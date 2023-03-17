package programmers.highScoreKit.Heap;

import java.util.ArrayList;
import java.util.List;

public class MInHeapClass { // 최소 힙 구현 - 최대 힙과 중복제거
    // index 0부터 시작
    // 부모 노드 i >> 왼쪽 자식 2*i+1 , 오른쪽 자식 2*i+2
    // 자식 노드 i >> 부모 노드 (int) (i-1)/2

    // 정수 최소 힙
    List<Integer> heap;

    public MInHeapClass() {
        this.heap = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "MInHeapClass{" +
                "heap=" + heap +
                '}';
    }

    public void swap(int i, int j){ // i,j 위치 교환
        int n = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, n);
    }

    public void input(int n){
        heap.add(n);
        int c = heap.size()-1; // 자식노드 index
        int p = (c-1)/2; // 부모노드 index

        // 힙ok or c==0 때까지(뿌리 노드 될때까지) 연산(swap)
        while(c!=0){
            if(heap.get(p) > heap.get(c)){ // 하지만, 자식노드가 더 작으면
                swap(p,c);
                c = p;
                p = (c-1)/2;
            }
            else break; // 힙 완성

        }
    }

    public int output(){
        int min = heap.get(0);
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

            if(heap.get(p) > heap.get(lc) && heap.get(rc) >= heap.get(lc)){ // 왼쪽 자식
                swap(p,lc);
                p = lc;
            }
            else if(heap.get(p) > heap.get(rc) && heap.get(lc) >= heap.get(rc)){ // 오른쪽 자식
                swap(p,rc);
                p = rc;
            }
            else break; // 부모가 젤 큼(크거나 같음)

        }

        // 왼쪽 자식노드만 있을 경우 따로 연산
        if(2*p+1<l){
            lc = 2*p+1;
            if(heap.get(p) > heap.get(lc)) swap(p,lc);
        }

        return min;
    }

    public int peek(){
        return heap.get(0);
    }

    public void clear(){
        heap.clear();
    }

    public boolean isEmpty(){
        if(heap.size()==0) return true;
        else return false;
    }

    public int heapSize(){
        return heap.size();
    }


}
