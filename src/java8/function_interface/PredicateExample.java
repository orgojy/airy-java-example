package java8.function_interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p> Functional Interface "Predicate"
 * <p> : To use "Behavior parameters", Use "Functional Interface"
 * <p> - You can implement dynamic parameters for behavior by using "Functional Interface"
 * <p> - You can check validation by declaring "@FunctionalInterface"
 * <p> - To be used for judging inner logic by java8.lambda expression, Use "Predicate"
 *
 * @author Yimin An
 * @see java.util.function.Predicate
 * @see java.util.function.IntPredicate
 * @see java.util.function.DoublePredicate
 */
public class PredicateExample {

  @FunctionalInterface
  public interface Predicate<T> {

    boolean test(T t);
  }

  public static <T> List<T> filter(List<T> list, Predicate<T> p) {
    List<T> results = new ArrayList<>();
    for (T s : list) {
      if (p.test(s)) {
        results.add(s);
      }
    }
    return results;
  }

  public static void main(String[] args) {
    // Lambda expression for behavior parameter
    Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
    // Filter for Array included with empty("")
    List<String> nonEmpty = PredicateExample.filter(
        Arrays.asList("apple", "", "bear", "car", ""),
        nonEmptyStringPredicate
    );
    // apple bear car
    nonEmpty.forEach(System.out::println);
  }
}
