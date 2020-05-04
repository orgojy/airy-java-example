package function_interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p> Functional Interface
 * <p> : Use to filter "Value Parameters"
 * <p>
 *
 * @author Yimin An
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
    List<String> nonEmpty = filter(Arrays.asList("apple", "", "bear", "car", ""), nonEmptyStringPredicate);
    // apple bear car
    nonEmpty.forEach(System.out::println);
  }
}
