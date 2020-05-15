package java8.function_interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p> Functional Interface "Function"
 * <p> : To use "Behavior parameters", Use "Functional Interface"
 * <p> - You can implement dynamic parameters for behavior by using "Functional Interface"
 * <p> - You can check validation by declaring "@FunctionalInterface"
 * <p> - To be used for returning values by java8.lambda expression, Use "Function"
 *
 * @author Yimin An
 * @see java.util.function.Function
 * @see java.util.function.IntFunction
 * @see java.util.function.DoubleFunction
 */
public class FunctionExample {

  @FunctionalInterface
  public interface Function<T, R> {

    R apply(T t);
  }

  public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
    List<R> result = new ArrayList<>();
    for (T s : list) {
      result.add(f.apply(s));
    }
    return result;
  }

  public static void main(String[] args) {
    Function<String, Integer> lengthFunction = (String s) -> s.length();

    List<Integer> integerList = FunctionExample.map(
        Arrays.asList("a", "bb", "ccc", "dddd"),
        lengthFunction
    );
    integerList.forEach(System.out::println);
  }
}
