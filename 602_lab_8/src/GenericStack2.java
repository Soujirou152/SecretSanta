import java.util.Arrays;

public class GenericStack2<E> {
	private java.util.ArrayList<E> list = new java.util.ArrayList<>();
	private E[] array;
	private int sizeIndex = 0;

	public GenericStack2() {
		array = (E[]) new Object[10];
		this.sizeIndex = 0; // current size of stack AND index of next place to
							// push

	}

	public int getSize() {
		return sizeIndex;
	}

	public E peek() {
		return array[sizeIndex - 1];
	}

	public void push(E element) {
		if (getSize() >= 10 && getSize() % 10 == 0) {
			E[] temp = (E[]) new Object[getSize() * 2];
			for (int index = 0; index < getSize(); index++) {
				temp[index] = array[index];
			}
			array = temp;
			array[sizeIndex++] = element;

		} else {
			array[sizeIndex++] = element;
		}

	}

	public E pop() {
		// sizeIndex--;
		if (getSize() == 0) {
			throw new RuntimeException("You tried peeking at an empt stack..");
		} else {
			return array[--sizeIndex];
		}
	}

	public boolean isEmpty() {
		return getSize() == 0;
	}

	@Override
	public String toString() {
		// return "stack: " + Arrays.toString(array);
		String result = "";
		for (int index = sizeIndex; index > 0; index--) {
			result = result + array[index-1].toString() + "\n";
		}
		return result;
	}

	public static void main(String[] args) {
		GenericStack2<String> stack = new GenericStack2<>();
		
		for(int i = 0; i < 101; i++){
			stack.push(String.valueOf(i));
		}
		// All commented code below here was when I was testing by hand
//		stack.push("what");
//		stack.push("Is");
//		stack.push("This");
//		stack.push("This");
//		stack.push("This");
//		stack.push("This");
//		stack.push("This");
//		stack.push("This");
//		stack.push("This");
//		stack.push("This");
//		StdOut.printf("Size is %d. \n", stack.getSize());
//		stack.push("This");
//		stack.push("This");
//		stack.push("This");
//		stack.push("This");
//		stack.push("This");
//		stack.push("This");
//		stack.push("This");
//		stack.push("This");
//		stack.push("This");
//		stack.push("This");
//		StdOut.printf("Size is %d. \n", stack.getSize());
//		stack.push("This");
//
//		StdOut.printf("Size is %d. \n", stack.getSize());
//		StdOut.printf("Elements are: %s\n", stack.toString());
		// StdOut.printf("Popping stack is: %s\n", stack.pop());
		
		StdOut.printf("Size is %d. \n", stack.getSize());
		StdOut.println("We are popping!!");
		

		 while (!stack.isEmpty()) {
		 StdOut.printf("%s\n", stack.pop().toString());
		 }

	}

}
