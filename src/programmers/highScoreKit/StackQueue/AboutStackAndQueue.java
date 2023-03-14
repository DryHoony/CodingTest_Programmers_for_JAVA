package programmers.highScoreKit.StackQueue;

import javax.swing.*;
import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TransferQueue;

public class AboutStackAndQueue {
//    Stack, Queue, LIFO, FIFO, push & pop

    public static void main(String[] args) {
        System.out.println("Stack");
        // 스택 정의
//        - 제한적으로 접근할 수 있는 나열 구조, 접근은 언제나 목록의 끝에서만 일어난다, 끝먼저내기 목록(pushdouwn list)
//        - LIFO : Last In First Out , 후입선출,

        // 스택 특징
//        - '정적 구현'은 1차원 배열을 사용하며 크기가 제한되어 있다.(isfull 함수 존재)
//          배열과 달리 상수 시간에 i번째 요소에 접근 할 수 없다. But, 데이터 추가나 삭제는 상수 시간에 가능하다
//          한 프로그램이 사용하는 스택영역은 기본적으로 크기가 고정되어 있다. >> Stack Buffer OverFlow 주의!
//        - '동적 구현'은 연결리스트를 사용한다. 크기 제한이 없지만 구현이 복잡하며, 삽입/ 삭제 시간이 오래 걸린다.

        // 사용예시
//        - 재귀 알고리즘에서 함수를 호출하는 경우 임시 데이터를 스택에 넣어준다. 퇴각 검색(backTrack)시 임시 데이터를 빼준다.
//        - 웹 브라우저 방문기록(뒤로가기), 실행 취소(undo), 역순, 후위 표기법
//        - 시스템 스택(system stack) : 운영체제가 사용, 함수 호출 시 활성 레코드(activation record)가 만들어지며, 복귀 주소가 저장됨


        // 스택 기능
//        - Push : 가장 윗 데이터로 입력
//        - Pop : 가장 윗 데이터로 반환(반환 후 해당 데이터 삭제)
//        - Top, Peek : 가장 윗 데이터 반환, 탑 포인터가 가리키는 데이터를 조회
//        - Empty, isEmpty : 스택 비었다면 1반환(Java 에서는 true 반환) , else 0반환

        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        System.out.println(stack);

        System.out.println("pop연산 " + stack.pop() + stack);; // EmptyStackException 주의
        System.out.println("peek연산 " + stack.peek() + stack);;
        System.out.println();

        System.out.println(stack + "에서 없는값 검색 결과 "+ stack.search("k"));
        System.out.println("search(a) 결과 " + stack.search("a"));
        System.out.println("search(b) 결과 " + stack.search("b"));
        System.out.println("search(c) 결과 " + stack.search("c"));

        System.out.println("get(0) 결과 " + stack.get(0));
        System.out.println("get(2) 결과 " + stack.get(2));
        System.out.println("get(3) 결과는 ArrayIndexOutOfBoundsException ");

        System.out.println();
        System.out.println(stack + "비어있나? " + stack.empty());
        stack.clear();
        System.out.println("clear 후에는 비어있나? " + stack.empty());



    }


    public static void main2(String[] args) {
        System.out.println("Queue");

//        큐 정의
//        - 먼저 들어온 것이 먼저 나간다. 입력순서대로 출력
//        - 한쪽 끝에서만 삽입만, 다른 한쪽끝에서는 삭제 연산만 이루어지는 유한 순서 리스트
//        - FIFO : First In First Out

//        큐 특징
//        - 선형 큐 : 배열을 사용해서 구현, 크기가 제한되 있고, 빈 공간을 사용하려면 모든 자료를 꺼내거나 빈 공간을 한 칸씩 옮겨야 하는 단점이 있다.
//          Enqueue, Dequeue 할 때마다 데이터가 앞으로 밀려나는 문제 발생
//        - 환형 큐(원형 큐) : front가 큐의 끝에 닿으면 큐의 맨 앞으로 자료를 보내어 원형으로 연결 하는 방식, 선형 큐의 문제점을 보완
//          단 가득찰 때와 비어있을 때 포인터가 같은 위치를 지정하기 때문에 이를 해결하기 위해 한 공간을 비워둔다.
//        - 링크드 큐 : 연결 리스트로 구현, 큐의 길이를 쉽게 늘릴 수 있어 오버플로우가 발생하지 않음, 필요에 따라 환형으로 만들 수 도 있으며, 환형이 아니어도 삽입과 삭제가 제한되지 않아 편리
//        - 큐가 꽉 차서 자료를 넣을 수 없는 경우 오버플로우(OverFlow), 비어있어 자료를 꺼낼 수 없는 경우 언더플로우(UnderFlow)


//        큐 예시
//        - 대기열 순서, 우선순위 작업 예약, 게임 '큐'잡기
//        - BFS 구현시 처리해야 할 노드의 리스트를 저장하는 용도로 큐(Queue)사용
//        - 캐시(Cache), 프로세스 관리, 운영체제의 테스크 스케줄링


//        큐 기능
//        - 인큐(Enqueue) : Back(tail, rear) 에 삽입연산, put, insert
//        - 디큐(Dequeue) : Front(head) 에 삭제 연산, get, delete
//        - peek
//        - isEmpty
//        - isFull

        Queue<String> queue = null; // Queue 인터페이스를 (직간접적으로) 구현한 클래스가 많다
//        queue = new PriorityQueue<>(); // 우선순위 큐 - 저장할 객체를 필수적으로 Comparable Interface 구현필요, Heap을 이용해 구현하는 것이 일반적, 요소에 null 허용X
        queue = new LinkedList<>(); // 링크드 큐 - 끝에 요소 추가하기에 용이, List interface 구현, 요소에 null 허용
//        queue = new Deque<String>() // 메서드를 구현해야 한다
//        queue = new BlockingQueue<String>() // 얘도 구현필요,,,
//        queue = new BlockingDeque<String>() // 구현필요,,
//        queue = new TransferQueue<String>() // 구현,,으아아

        queue.add("a");
        queue.add("b");
        queue.add("c");
        queue.add("d");
        queue.add("e");

        System.out.println(queue + " 왼쪽이 Front, 삭제나 반환 연산");

        System.out.println("poll()연산 " + queue.poll() + queue); // empty 일때 null
        System.out.println("remove()연산 " + queue.remove() + queue); // empty 일때 NoSuchElementException
        System.out.println();

        System.out.println("peek()연산 " + queue.peek() + queue);
        System.out.println(queue.element());




    }


}
