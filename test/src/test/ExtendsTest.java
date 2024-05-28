package test;

public class ExtendsTest {
	
	// 정처기 2023년 1회 20번
	// https://chat.openai.com/share/edfbb4a0-46f2-406b-94d4-4a2d5f7a8f4f
	// '메소드 오버라이딩' 의 특성
	public static void main(String[] args) { 
		Parent3 x = new Child3();
//		Child3 x = new Child3();
		x.paint();
		
//		System.out.println();
//		System.out.println("Parent3 내에서는 draw() 메소드는 무한재귀 호출이 된다.");
//		System.out.println("그런데 상속받은 자식 클래스에서 (오버라이딩한) draw() 메소드를 끼워넣으면(?) 재귀 구조가 깨지는것 처럼 보여진다");
//		System.out.println("왜??");
	}
}


class Parent3{
	
	public Parent3() {
		// TODO Auto-generated constructor stub
//		paint(); // 여기일때? 1번
	}
	
	
	public void paint() {
		System.out.println("부모 paint");
		System.out.println("draw() 호출");
		draw();
	}
//	
	public void draw() { // 재귀함수
		System.out.println("2.부모 draw");
		System.out.println("3.draw() 호출");
		draw(); // 
		System.out.println(">> 왜 자식 draw()를 호출하도록 동작할까? 어떤 의미(의도)가 숨어있는거지?");
	}
}

//class Child3 extends Parent3{
//	
//	
//	public void paint() {
//		System.out.println("1.super.draw() 호출");
//		super.draw();
//		System.out.println("5. 자식 paint");
//		System.out.println("this.draw 호출");
////		this.draw();
//		super.paint(); // 여기일때? 2번
//	}
//	
//	public void draw() {
//		System.out.println("4.자식 draw");
//	}
//}
