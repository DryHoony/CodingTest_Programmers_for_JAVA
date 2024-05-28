package test;

class Parent { // abstract 혹은 Interface 로 만들어 버릴 것
    int x = 100;
 
    Parent() {
        this(500);
//        System.out.println("Parent 생성자 호출, x="+x);
    }
 
    Parent(int x) {
        this.x = x;
//        System.out.println("Parent 메소드 호출, x="+x);
    }
 
    int getX() {
        return x;
    }
}

class Parent2 extends Parent {
	int x = 999;
	
	Parent2() {
		
//		System.out.println("Parent2 생성자 호출, x="+x);
	}
}

class Child extends Parent2 {
    int x = 4000;
    
    Child() {
//    	System.out.println("Child 생성자 호출, x="+x);
//    	super();
    	this(5000);
//        System.out.println("Child 생성자 호출, x="+x);
//        x = super.x;
    }
 
    Child(int x) {
        this.x = x;
    }
    
    int getY() {
        return x;
    }
}

public class test1 {
	public static void main(String args[]) {
		
//		Child obj = new Child();
		Parent obj;
		obj = new Child();
		
//        System.out.println(obj.getX());
//		System.out.println(obj.getY());
        System.out.println("x 출력 테스트 >> " + obj.x);
		
	}
}
