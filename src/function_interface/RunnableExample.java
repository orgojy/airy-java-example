package function_interface;

import java.util.Arrays;

/**
 * <p> Functional Interface "Runnable"
 * <p> : To use "Behavior parameters", Use "Functional Interface"
 * <p> - You can implement dynamic parameters for behavior by using "Functional Interface"
 * <p> - You can check validation by declaring "@FunctionalInterface"
 * <p> - To be used for processing tasks without input/output parameters by lambda expression, Use "Runnable"
 * <p> - Implemented interface {@link java.lang.Runnable}
 *
 * @author Yimin An
 */
public class RunnableExample {

  @FunctionalInterface
  public interface Runnable {

    void run();
  }

  public static void execute(Runnable r) {
    r.run();
  }

  public static void main(String[] args) {
    Runnable runnableExpression = () -> Arrays.asList(1, 2, 3, 4, 5).forEach(System.out::println);
    RunnableExample.execute(runnableExpression);
  }
}
