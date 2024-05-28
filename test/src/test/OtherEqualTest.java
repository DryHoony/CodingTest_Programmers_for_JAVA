package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OtherEqualTest {

	public static void main(String[] args) {
		int[] a = {1,2,3};
		int[] b = {1,2,3};
		int[] c = {1,2,3,4,5};
		
		int[] d = new int[3]; // {1,2,3}
		for (int i = 0; i < d.length; i++) {
			d[i] = i+1;
		}
		
		// 비교
		System.out.println("a==b -> " + (a==b));
		System.out.println("a.equals(b) -> " + a.equals(b));
		System.out.println("Arrays.equals() 메소드를 이용해야 한다");
		System.out.println();
		System.out.println("a,b 비교 -> " + Arrays.equals(a, b));
		System.out.println("a,c 비교 -> " + Arrays.equals(a, c));
		System.out.println("a,d 비교 -> " + Arrays.equals(a, d));
		
		f
		// 주소값 출력
		System.out.println();
		System.out.println("a의 주소값 : " + System.identityHashCode(a));
		System.out.println("b의 주소값 : " + System.identityHashCode(b));
		System.out.println("c의 주소값 : " + System.identityHashCode(c));
		System.out.println("d의 주소값 : " + System.identityHashCode(d));
	}
	
	public static void main0(String[] args) {
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		for(int i=1; i<=3; i++) {
			list1.add(i);
			list2.add(i);
		}
		
		System.out.println("list1 == list2 -> " + (list1 == list2));
		System.out.println("list1 identityHashCode = " + System.identityHashCode(list1));
		System.out.println("list2 identityHashCode = " + System.identityHashCode(list2));
		System.out.println();
		
		System.out.println("list1.equals(list2) = " + list1.equals(list2));
		System.out.println("list1 hashCode = "+list1.hashCode());
		System.out.println("list2 hashCode = "+list2.hashCode());
		
	}
	
}
