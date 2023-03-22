package programmers.highScoreKit.heap;

import java.util.ArrayList;
import java.util.List;

public class DoublePriorityQueue { // 이중우선순위큐

    // 최소힙
    public static List<Integer> minHeap = new ArrayList<>();

    public static void minInput(int n){
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

    public static int minOutput(){
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

            if(minHeap.get(p) > minHeap.get(lc) && minHeap.get(rc) >= minHeap.get(lc)){ // 왼쪽 자식
                minSwap(p,lc);
                p = lc;
            }
            else if(minHeap.get(p) > minHeap.get(rc) && minHeap.get(lc) >= minHeap.get(rc)){ // 오른쪽 자식
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
    public static void minSwap(int i, int j){ // i,j 위치 교환
        int n = minHeap.get(i);
        minHeap.set(i, minHeap.get(j));
        minHeap.set(j, n);
    }

    public static void minHeapArrangeAfterRemoveMax(int n){ // 최댓값 제거 후 재정렬(반 정렬)
        int index = minHeap.indexOf(n);
        minHeap.remove(index);

        for(int i=index; i<minHeap.size(); i++){
            if(i%2==0){ // 부모노드가 바뀐경우 >> 왼쪽자식에서 '오른쪽 자식'인 경우 >> 짝수
                // heap 반정렬 연산 - input 과 동일
                int c = i; // 자식노드
                int p = (c-1)/2; //부모노드

                while(c!=0){
                    if(minHeap.get(p) > minHeap.get(c)){ // 자식노드가 더 작으면
                        minSwap(p,c);
                        c = p;
                        p = (c-1)/2;
                    }
                    else break; // 힙 완성
                }

            }
        }
    }

    // 최대힙
    public static List<Integer> maxHeap = new ArrayList<>();

    public static void maxInput(int n){
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
    public static int maxOutput(){
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

            if(maxHeap.get(p) < maxHeap.get(lc) && maxHeap.get(rc) <= maxHeap.get(lc)){ // 왼쪽 자식
                maxSwap(p,lc);
                p = lc;
            }
            else if(maxHeap.get(p) < maxHeap.get(rc) && maxHeap.get(lc) <= maxHeap.get(rc)){ // 오른쪽 자식
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
    public static void maxSwap(int i, int j){ // i,j 위치 교환
        int n = maxHeap.get(i);
        maxHeap.set(i, maxHeap.get(j));
        maxHeap.set(j, n);
    }

    public static void maxHeapArrangeAfterRemoveMax(int n){ // 최솟값 제거 후 재정렬(반 정렬)
        int index = maxHeap.indexOf(n);
        maxHeap.remove(index);

        for(int i=index; i<maxHeap.size(); i++){
            if(i%2==0){ // 부모노드가 바뀐경우 >> 왼쪽자식에서 '오른쪽 자식'인 경우 >> 짝수
                // heap 반정렬 연산 - input 과 동일
                int c = i; // 자식노드
                int p = (c-1)/2; //부모노드

                while(c!=0){
                    if(maxHeap.get(p) < maxHeap.get(c)){ // 자식노드가 더 크면
                        maxSwap(p,c);
                        c = p;
                        p = (c-1)/2;
                    }
                    else break; // 힙 완성
                }

            }
        }
    }


    public static void main(String[] args) {
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

//        최대와 최소를 동시에 계산할 수 있는 '힙'이 필요 - 최대 힙, 최소 힙 두개로 표현하고 각각 힙에서 특정 값 제거 후 힙을 정렬하는 연산 구현
//        minHeap, maxHeap 모두 사용

        for(String str:operations){
            if(str.charAt(0) == 'I'){
                System.out.println("I 연산");

                minInput(Integer.parseInt(str.split(" ")[1]));
                maxInput(Integer.parseInt(str.split(" ")[1]));

                System.out.println("maxHeap = " + maxHeap +", minHeap = " + minHeap); // 확인출력

            }

            else if(maxHeap.size()!=0) { // 빈큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시
                if (str.equals("D 1")) {
                    System.out.println("최댓값 삭제 연산");
                    minHeapArrangeAfterRemoveMax(maxOutput());
                    System.out.println("maxHeap = " + maxHeap +", minHeap = " + minHeap); // 확인출력

                }
                else{
                    System.out.println("최솟값 삭제 연산");
                    maxHeapArrangeAfterRemoveMax(minOutput());
                    System.out.println("maxHeap = " + maxHeap +", minHeap = " + minHeap); // 확인출력
                }
            }


        }

        // 모든 연산 처리후 [최댓값, 최솟값] return, 큐가 비면 [0,0] return
        if(maxHeap.size()==0) System.out.println("return [0,0]");
        else {
            System.out.println(maxOutput() + " , " + minOutput());
        }










    }

}
