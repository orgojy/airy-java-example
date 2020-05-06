package function_interface;

import java.util.Arrays;
import java.util.List;

/**
 * <p> Functional Interface "Supplier"
 * <p> : To use "Behavior parameters", Use "Functional Interface"
 * <p> - You can implement dynamic parameters for behavior by using "Functional Interface"
 * <p> - You can check validation by declaring "@FunctionalInterface"
 * <p> - To be used for returning constant values without input parameters by lambda expression, Use "Supplier"
 * <p> - Implemented interface {@link java.util.function.Supplier}
 *
 * @author Yimin An
 * @see java.util.function.Supplier
 * @see java.util.function.IntSupplier
 * @see java.util.function.DoubleSupplier
 */
public class SupplierExample {

  @FunctionalInterface
  public interface Supplier<T> {

    T get();
  }

  public static <T> T execute(Supplier<T> s) {
    return s.get();
  }

  public static void main(String[] args) {
    Supplier<List> arrayListSupplier = () -> Arrays.asList(1, 2, 3, 4, 5);

    List arrayList = SupplierExample.execute(arrayListSupplier);
    arrayList.forEach(System.out::println);
  }
}
