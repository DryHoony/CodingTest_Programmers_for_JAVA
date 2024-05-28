package test;

public class CallByTest {
	
//	static String str1 = "original";
//	static String str2 = new String(str1);
//	static String str3 = new String("original");
	
	
	public static void main(String[] args) {
		String str1 = "original";
		String str2 = new String(str1);
		String str3 = new String("original");
		
		
//		System.out.println(System.identityHashCode(str1));
//		System.out.println(System.identityHashCode(str2));
//		System.out.println(System.identityHashCode(str3));
//		
//		System.out.println();
//		System.out.println(str1.hashCode());
//		System.out.println(str2.hashCode());
//		System.out.println(str3.hashCode());
		
		addTail(str1);
		addTail(str2);
		addTail(str3);
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		
		System.out.println(addTail(str1));
		System.out.println(addTail(str2));
		System.out.println(addTail(str3));
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
	}
	
	public static String addTail(String s) {
		s += "tail";
		return s;
	}
	
}
