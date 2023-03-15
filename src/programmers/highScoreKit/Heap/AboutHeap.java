package programmers.highScoreKit.Heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class AboutHeap { // 힙


    public static void main(String[] args) {
        System.out.println("Heap");
        // 힙 (Heap Tree) 정의
//        - 최대값 및 최솟값을 찾아내는 연산을 빠르게 하기 위해 고안된 완전이진트리(complete binary tree)를 기본으로 한 자료구조
//          힙 속성(property) : 부모노드(parent node)와 자식노드(child node) 의 키값은 대소관계가 성립한다. 형제 사이에는 대소관계가 정해지지 않는다.
//        - '최대 힙', '최소 힙'이 있다.


//        - 완전 이진 트리 : 이진 트리에 노드를 삽입할 때 왼쪽부터 차례대로 삽입하는 트리
//        - 이진 탐색 트리(Binary Search Tree) : 이진 탐색과 연결리스트(linked-list)를 결합한 자료구조, 이진 탐색의 효율적인 탐색 능력은 유지하면서 빈번한 자료의 입력, 삭제를 가능하도록 한다.
//          왼쪽 자식 노드 < 부모 노드 < 오른쪽 자식노드 ('힙' 은 형제 노드 사이의 대소관계가 없다.)
//          힙은 최대/ 최소 검색을 위해, 이진 탐색 트리는 탐색을 위한 구조이다.

        // 힙 특징
//        - 반 정렬 상태, 느슨한 정렬 상태, 약한 힙(weak heap)
//        - 배열로 구현할 때 인덱스 번호 1부터 시작(구현이 용이) (인덱스를 0부터 계산한다면 -1 해줄 것)
//        (부모 노드의 인덱스) = (자식 노드 인덱스) / 2
//        (왼쪽 자식 노드의 인덱스) = (부모 노드의 인덱스) * 2
//        (오른쪽 자식 노드의 인덱스) = (부모 노드의 인덱스) * 2 + 1

//        - 힙의 삽입 : 마지막 노드에 삽입 / 부모노드와 비교해서 자식노드가 크다면 교환, 작다면 정지
//        - 힙의 삭제 : 루트 노드 삭제(최댓값 출력) / 루트 노드에 마지막 노드를 가져옴 / 좌우 자식노드 중 큰 값이 있다면 힙을 재구성

//        - 최대, 최소를 구할때 배열은 O(n)시간, 힙은 O(log n)



        // 사용예시
//        - 우선순위 큐(Priority Queue) : 배열, 연결리스트, 힙으로 구현가능 그 중 힙이 Best
//        - 힙 정렬(heap sort)
//        - 허프만 코드 : 무손실 압축 알고리즘

        // 구현
        HeapClass heap = new HeapClass(); // 최대 힙, 입력, 출력(최댓값), 크기, 초기화


        // '우선순위 큐'와 비교해 보자 - '최소 힙'과 동일한 기능 하는 것으로 보임
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(5);
        queue.add(15);
        queue.add(6);
        queue.add(3);
        queue.add(8);
        queue.add(11);
        queue.add(1);
        queue.add(6);

        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }




    }
}
