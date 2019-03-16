/**
 * 
 */
package java8;

/**
 * @author server
 *
 */
public class MethodReferenceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Case 1: Reference to a Static Method Example
		Sayable s1 =  (SayIt::saySomething1);
		s1.say();
		
		
		
		// Case 2: Reference to a  Non Static Method Example
		Sayable s2 = new SayIt()::saySomething2;
		s2.say();
		
		
		// Case 3: Reference to a Constructor
		
		Messaging m = Message::new;
		m.getMsg("Hellow World");
		
		
		

	}

}


@FunctionalInterface
interface Sayable
{
	public void say();
}

@FunctionalInterface
interface Messagable
{
	Message getMessage(String msg);
}

@FunctionalInterface
interface Messaging
{
	public Message getMsg(String msg);
}

class Message
{
	public Message(String msg)
	{
		System.out.println(msg);
	}
}


class SayIt
{
	public static void saySomething1()
	{
		System.out.println("This is a static method");
	}
	
	
	public void saySomething2()
	{
		System.out.println("This is an instance method");
	}
	}

