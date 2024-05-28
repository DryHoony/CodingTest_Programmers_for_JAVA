package test;

public class EqualTest {
	
	public static void main(String[] args) {
		// literal 을 저장한 주소를 대입 (리터럴은 문자열 풀에 저장, 같은 리터럴을 사용하는 변수는 같은 문자열 풀을 가리킴)
		String a = "sample";
		String b = "sample";
		
		
		// 문자열 인스턴스를 생성, String 변수에 주솟값을 대입
		String c = new String("sample");
		String d = new String("sample");
		c = a;
		System.out.println("a==c -> " + (a==c));
		
		// 비교 연산
		System.out.println("주소값 비교");
		System.out.println("a==b -> " + (a==b));
		System.out.println("a==c -> " + (a==c));
		System.out.println("a==d -> " + (a==d));
		System.out.println("c==d -> " + (c==d));
		
		System.out.println();
		System.out.println("값 비교");
		System.out.println("a.equals(b) -> " + a.equals(b));
		System.out.println("a.equals(c) -> " + a.equals(c));
		System.out.println("c.equals(d) -> " + c.equals(d));
		
		
		// 주소값 출력
		System.out.println();
		System.out.println("a의 주소값 : " + System.identityHashCode(a));
		System.out.println("b의 주소값 : " + System.identityHashCode(b));
		System.out.println("c의 주소값 : " + System.identityHashCode(c));
		System.out.println("d의 주소값 : " + System.identityHashCode(d));
		
		// HashCode는 equal과 동일하게 동작
//		System.out.println(a.hashCode());
//		System.out.println(b.hashCode());
//		System.out.println(c.hashCode());
//		System.out.println(d.hashCode());
	}

}
