
public class CopiarArrays {

	public static void main(String[] args) {
		
		int[] array_1 = new int[2];
		
		array_1[0] = 45;
		
		array_1[1] = 56;
	
		int[] array_2 = new int[array_1.length];
		
		array_2 = array_1;
		
		System.out.println(array_2[1]);

	}

}
