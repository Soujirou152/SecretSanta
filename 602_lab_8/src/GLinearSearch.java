
public class GLinearSearch
{

	public static <E extends Comparable<E>> int linearSearch(E[] list, E key)
	{
		int index =0;
		for(E element: list) // foreach
		{
			if(0==element.compareTo(key)){
				return index;
			}
			else{
				index++;
			}
			
		}
		return -1; // Not Found
	}
	
	public static <E> int linearSearch2(E[] list, E key)
	{
		int index =0;
		for(E element: list) // foreach
		{
			if(element.equals(key)){
				return index;
			}
			else{
				index++;
			}
			
		}
		return -1; // Not Found
	}
	
	public static <E> int linearSearchRec(E[] list, int startIndex, E key)
	{
		if(startIndex >= list.length){
			return -1;
		}
		if(list[startIndex].equals(key)){
			return startIndex;
		}
		else{
			return linearSearchRec(list,startIndex +1, key);
		}
	}
	
	public static void main(String[] args)
	{
		Integer[] intArray = new Integer[]{1,2,3,4,5};
		Double[] doubleArray = new Double[]{3.14,2.718,47.0};
		String[] strArray = new String[]{"Monday","Tuesday","Wednesday"};
		
		StdOut.println(linearSearch(intArray,47));
		
		StdOut.println(linearSearch2(intArray,3));
		
		StdOut.println(linearSearchRec(intArray,3,3));

	}

}
