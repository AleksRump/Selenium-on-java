
public class ExceptionHandingTry_Catch {
	
	public static void main(String[] args) {
		try {
			System.out.println("Hello Alls");
			int i = 1/0;
			System.out.println("It's error");
			
		} catch (Exception exp) {
			System.out.println("Now in catch");
			System.out.println("Massege is :" +exp.getMessage());
			System.out.println("Cause is :" +exp.getCause());
			exp.printStackTrace();
			
		}
		finally {
			System.out.println("Vsegda vipolnitsa");
		}
	}

}
