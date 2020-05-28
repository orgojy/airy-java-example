package java8.stream;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <p> How to make stream examples
 *
 * @author Yimin An
 */
public class MakingStreamExample {

  public static void main(String[] args) {

    Stream<String> stream = Stream.of("Hello", "!", "world.");
    String joinedStream = stream.map(String::toUpperCase).collect(Collectors.joining());
    System.out.println(joinedStream);

    Stream<String> emptyStream = Stream.empty();

    int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    IntStream intStream = Arrays.stream(numbers);
    int sum = intStream.sum();
    System.out.println(sum);
  }
}
