package j07_반복;

public class Star1 {
	
	public static void main(String[] args) {
		 
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10 - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
//////////////////////////////////////////////////////////////
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10 - i - 1; j++) {
				System.out.print(" ");
			}
			for(int k = 0; k < i + 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for(int k = 0; k < 10 - i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
////////////////////////////////////////////////////////////////
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10 - i - 1; j++) {
				System.out.print(" ");//9 8 7 6 5 . 4 3 2 1 
			}
			for(int k = 0; k < i * 2 + 1; k++) {
				System.out.print("*"); //1 3 5 7 9 . 11 13 15 17 19
			}
			System.out.println();
		}
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for(int k = 0; k < 20 - (i * 2 + 1); k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		
		for(int i = 0; i < 10; i++) {
			if(i <  5) {
				for(int j = 0; j < 5 - i - 1; j++) {
					System.out.print(" ");
				}
				for(int k = 0; k < i * 2 + 1; k++) {
					System.out.print("*");
				}
				System.out.println();
			}else if(i > 4) {
				for(int j = 0; j < 5 - i - 2; j++) {
					System.out.print("*");
				}
//				for(int k = 0; k < )
			}
			
		}
		
		
	}

}
