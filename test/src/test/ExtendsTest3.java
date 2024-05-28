package test;

public class ExtendsTest3 {

	public static void main(String[] args) {
		SubObj s = new SubObj(); // 출력 >> 
		 s.show(); // 출력 >> SubSuper
		
	}
}


class SuperObj {
	
	public SuperObj() { // 기본생성자
		// TODO Auto-generated constructor stub
		System.out.println("바윙");
	}
	
	public void show() {
		print();
	}
	public void print() {
		print();
		System.out.print("Super");
	}
}

///////////////////////////////////////


class SubObj extends SuperObj {
	
	public SubObj() { // 기본생성자
		// TODO Auto-generated constructor stub
		System.out.println("하윙");
		
	}
	
	public void show() {
		super.print();
	}
	public void print() {
		System.out.print("Sub");
	}
}
