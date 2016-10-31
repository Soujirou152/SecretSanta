public class QueueOfChar {
	private String[] elements;
	private int size;

	public int getSize() {
		return size;
	}

	public static final int DEFAULT_CAPACITY = 8;

	/** Construct a queue with the default capacity 8 */
	public QueueOfChar() {
		this(DEFAULT_CAPACITY);
	}

	/** Construct a queue with the specified maximum capacity */
	public QueueOfChar(int capacity) {
		this.elements = new String[capacity];
	}

	public void enqueue(String v) {
		if (size >= elements.length) {
			String[] temp = new String[elements.length * 2];
			System.arraycopy(elements, 0, temp, 0, elements.length);
			elements = temp;
		}

		elements[size++] = v;
	}

	public String dequeue() {
		String firstOut = elements[0];
		String[] temp = new String[(elements.length * 2)];
		System.arraycopy(elements, 1, temp, 0, --size);
		elements = temp;
		return firstOut;
	}

	/** Test whether the stack is empty */
	public boolean empty() {
		return size == 0;
	}

	// Finish this by adding requested methods .
	// Be sure to add Java doc comments /** ... */
	// just before each method except main()

}