package skillpractice;

import java.util.*;

public class ListClass {
    // 리스트 List
    // 리스트는 배열과 다르게 저장공간이 필요에 따라 자유롭다, 동적으로 할당 가능
    // List는 인터페이스이고 주로 ArrayList를 사용, import가 필요하다
    ArrayList<Integer> list = new ArrayList<>();
    List<Integer> list1 = new ArrayList<>();

    public static void main(String[] args) {

        //생성
        List<Integer> list = new ArrayList<>();

        //추가, 삭제
        list.add(10);
        list.add(5);
        list.add(1);
        list.remove(1); // 특정index 값 삭제
        list.remove("10"); // 특정 값 삭제
        System.out.println(list.get(1)); // 특정 index 값 출력

        list.contains(4); // 특정 값 포함확인, boolean
//        list.containsAll();

        //검색
        list.indexOf("a"); // 특정 값 index 검색 - 최초등장
        list.lastIndexOf("a"); // 특정 값 index 검색 - 마지막등장

        // 크기
        System.out.println(list.size());

        // 정렬
        Collections.sort(list); //오름차순
        Collections.sort(list, Collections.reverseOrder()); //내림차순
//        list.sort(Comparator.naturalOrder()); // 오름차순
//        list.sort(Comparator.reverseOrder()); // 내림차순





    }

}
