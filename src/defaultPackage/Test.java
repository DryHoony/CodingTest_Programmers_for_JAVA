package defaultPackage;

import java.util.ArrayList;

public class Test {

	
	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			if(i==9) {
				System.out.println("반복분의 마지막일때 continue 시도");
				continue;
			}
		}
		
	}
	

}
