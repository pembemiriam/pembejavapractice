import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.List;
public class ReverseList {

	public static void main(String[] args) {
		Character[] list = {'a','b','c', 'd','e','f','g','f','h','i'};
		LinkedList<Character> list1 = new LinkedList<>(Arrays.asList(list));
		for (Character character : list)
			list1.add(character);
		
		printList(list1);
		
		reverseList(list1);

}
	private static void printList( List<Character> list1 )
	{
	System.out.printf("%nlist:%n");
	for (Character character : list1)
	System.out.printf("%s ", character);
	System.out.println();
	}

	public static void reverseList(List<Character> list1) {
		ListIterator<Character> iterator = list1.listIterator(list1.size());
		System.out.printf("%nReversed List of characters is:%n");
		// print list in reverse order
		while ( iterator.hasPrevious() )
		System.out.printf("%s ", iterator.previous() );
	}
}