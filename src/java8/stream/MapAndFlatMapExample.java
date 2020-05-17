package java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p> How to use map, flatMap of "Stream"
 *
 * @author Yimin An
 * @see java.util.stream.Stream
 */
public class MapAndFlatMapExample {

  public static void main(String[] args) {
    // create sample Integer list
    List<String> exampleList = Arrays.asList("Hello", "World!");

    List<Integer> example1 = exampleList.stream()
        // "Hello" => 5 , "World!" => 6
        .map(String::length)
        // [5, 6]
        .collect(Collectors.toList());

    List<String> example2 = exampleList.stream()
        // List<String[]> => [ ["H","e","l","l","o"] , ["W","o","r","l","d","!"] ]
        .map(word -> word.split(""))
        // List<String> => ["H","e","l","l","o","W","o","r","l","d","!"]
        .flatMap(Arrays::stream)
        .collect(Collectors.toList());

    List<Integer> number1 = Arrays.asList(1, 2, 3);
    List<Integer> number2 = Arrays.asList(3, 4);

    List<int[]> example3 = number1.stream()
        // [1, 2, 3]
        .flatMap(n ->
            number2.stream()
                // [ [1,3], [1,4], [2,3], [2,4], [3,3], [3,4] ]
                .map(n2 -> new int[]{n, n2})
        )
        .collect(Collectors.toList());

    System.out.println("example1: " + Arrays.toString(example1.toArray()));
    System.out.println("example2: " + Arrays.toString(example2.toArray()));
    String ex3 = example3.stream().map(v -> "(" + v[0] + "," + v[1] + ")").collect(Collectors.toList()).toString();
    System.out.println("example3: " + ex3);
//    example1: [5, 6]
//    example2: [H, e, l, l, o, W, o, r, l, d, !]
//    example3: [(1,3), (1,4), (2,3), (2,4), (3,3), (3,4)]
  }
}
