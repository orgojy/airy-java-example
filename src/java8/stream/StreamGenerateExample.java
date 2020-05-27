package java8.stream;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <p> Utility method "generate" of Stream
 * <p> : Use to get stream from specific logic
 * <p> - It generates infinite stream call "Unbounded stream"
 *
 * @author Yimin An
 */
public class StreamGenerateExample {

  public static void main(String[] args) {

    // Example : Arithmetic sequence
    Stream.generate(Math::random)
        .limit(5)
        .forEach(n -> System.out.print(n + " "));
    System.out.println();

    // Example : Fibonacci numbers used by mutable variable Unlike iterate used by immutable variable in parallel
    IntSupplier fib = new IntSupplier() {
      private int previous = 0;
      private int current = 1;

      @Override
      public int getAsInt() {
        int oldPrevious = this.previous;
        int nexValue = this.previous + this.current;
        this.previous = this.current;
        this.current = nexValue;
        return oldPrevious;
      }
    };
    IntStream.generate(fib)
        .limit(5)
        .forEach(n -> System.out.print(n + " "));
  }
}
