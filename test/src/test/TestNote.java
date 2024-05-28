package test;

public class TestNote {

	public static void main(String[] args) {
		Integer num = new Integer(13);
		int n;
		
//		n = num.intValue(); // 오토박싱
		n = num; // 오토 언박싱
		
//		System.out.println(n);
		
		Character ch = 'X';
		char c = ch.charValue(); // 언박싱
//		char c = ch; // 오토언박싱
		
		System.out.println(c);

		
		
	}
}
