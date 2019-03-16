/**
 * 
 */
package java8;

/**
 * @author server
 *
 */
public class LambdaExpressionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MathOperation adder = (a,b) -> a+b;
		MathOperation substractor = (a,b) -> a-b;
		MathOperation multiplier = (a,b) -> a*b;
		
		
		Greeting grt = str -> System.out.println("Hello  "+str+" Please use the calculator below");
		
		
		grt.greet("Sanjib");
		
		
		System.out.println("Addition of given numbers ==> "+adder.operate(10, 20));
		System.out.println("Substraction of given numbers ==> "+substractor.operate(25, 9));
		
		System.out.println("Multiplication of given numbers ==> "+multiplier.operate(3, 2));
		
		

	}

}

@FunctionalInterface
interface MathOperation
{
	
	public int operate(int x, int y);
}

@FunctionalInterface
interface Greeting
{
	public void greet(String greetMsg);
}
