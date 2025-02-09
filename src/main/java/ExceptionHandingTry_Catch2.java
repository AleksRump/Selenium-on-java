
public class ExceptionHandingTry_Catch2 {

	public static void main(String[] args) {
		
		try {
			demo();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	public static void demo() throws Exception {
		
		System.out.println("Hello Alls");
		//throw new ArithmeticException("not vailable operation");  // напиши только эту строку throw и дальше всё не воспринимается(намеренно генерировать исключение)
		int i = 1/0;
		System.out.println("It's error");
		
	}

}
