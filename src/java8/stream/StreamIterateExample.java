package java8.stream;

import java.util.stream.Stream;

/**
 * <p> Utility method "iterate" of Stream
 * <p> : Use to get stream from iterative logic
 * <p> - It generates infinite stream call "Unbounded stream"
 *
 * @author Yimin An
 */
public class StreamIterateExample {

  public static void main(String[] args) {

    // Example : Arithmetic sequence
    Stream.iterate(0, n -> n + 2)
        .limit(10)
        .forEach(n -> System.out.print(n + " "));
    System.out.println();

    // Example : Fibonacci numbers
    Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
        .limit(10)
        .map(t -> t[0])
        .forEach(t -> System.out.print(t + " "));
    System.out.println();
  }
}
