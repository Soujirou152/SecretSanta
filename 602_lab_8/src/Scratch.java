import java.util.ArrayList;

public class Scratch<E>
{

	public static void main(String[] args)
	{
		Scratch<C> scStr = new Scratch<C>();
		Scratch<? super C> generic = new Scratch<C>();
		Scratch<? extends B> generic2 = new Scratch<C>(); 
		Scratch ss = generic;
		Scratch<?> ss2 = generic;
		Scratch<Object> ss3 = ss;
		
		// Scratch<B> foo = (Scratch<C>)scStr;
		
//		ArrayList<Number> numList = new ArrayList<Integer>();
		ArrayList<? extends Number> numList = new ArrayList<Integer>();
		
	// ? why not ?
		
	// because...
		
//		numList.add((Number)(new Integer(47))); // see why the above is disallowed?
		StdOut.println(numList);
		
		

	}

}

class B
{
}
class C extends B
{
}

