package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p> Stream method Example of "filter", "distinct", "limit", "skip"
 * <p> - Filtering is consist of "filter", "distinct"
 * <p> - Slicing is consist of "limit", "skip"
 *
 * @author Yimin An
 * @see java.util.stream.Stream
 */
public class FilteringAndSlicingExample {

  public static void main(String[] args) {
    // create sample Integer list
    List<Integer> exampleList = Arrays.asList(1, 2, 3, 4, 5, 5, 4, 3, 2, 1);

    List<Integer> example1 = exampleList.stream()
        // Example to filter Integer which have calories more than 20
        // Input parameter is called "behavior parameter" or "Lambda Expression"
        .filter((Integer i) -> i > 3)
        .collect(Collectors.toList());

    List<Integer> example2 = exampleList.stream()
        // Same Integer is merged to one Integer
        // Distinct method is compared with all fields of Integer object
        .distinct()
        .collect(Collectors.toList());

    List<Integer> example3 = exampleList.stream()
        // Find elements which is filtered, and finished operation when finding 3 elements
        .limit(3)
        .collect(Collectors.toList());

    List<Integer> example4 = exampleList.stream()
        // Skip from first element to 10th element, and find from 11th element to last element
        .skip(5)
        .collect(Collectors.toList());

    System.out.println("example1: " + Arrays.toString(example1.toArray()));
    System.out.println("example2: " + Arrays.toString(example2.toArray()));
    System.out.println("example3: " + Arrays.toString(example3.toArray()));
    System.out.println("example4: " + Arrays.toString(example4.toArray()));
//    example1: [4, 5, 5, 4]
//    example2: [1, 2, 3, 4, 5]
//    example3: [1, 2, 3]
//    example4: [5, 4, 3, 2, 1]
  }
}
