import java.util.HashSet;
import java.util.Set;
import java.util.Collection;
import java.util.Arrays;
import java.util.List;

public class NoDuplicateSet {
	public static void main(String[] args)
	{
	// create and display a List<String>
	String[] names = {"John", "mary", "paul", "Love", "William",
	"William", "Miriam", "Miriam"};
	List<String> list = Arrays.asList(names);
	System.out.printf("List: %s%n", list);
	// eliminate duplicates then print the unique values
	printNonDuplicates(list);
	}
	// create a Set from a Collection to eliminate duplicates
	private static void printNonDuplicates( Collection<String> values )
	{
	// create a HashSet
	Set<String> set = new HashSet<>(values);
	System.out.printf("%nNonduplicates are: ");
	
	for (String value : set)
		System.out.printf("%s ", value);
		System.out.println();
		}
		}


