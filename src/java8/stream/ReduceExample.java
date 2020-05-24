package java8.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> Utility method "reduce" with ".parallelStream()" or ".stream()"
 * <p> : If we have recursive logic for elements of stream, We use lambda expression expressed by recurrence relation.
 * <p> - Also, We can use reduce in parallel.
 * <p> - It is provided with benchmark used by ".parallelStream()" & ".stream()"
 *
 * @author Yimin An
 */
public class ReduceExample {

  public static class Food {

    private final Integer number;
    private final String name;
    private final Integer calories;

    public Food(Integer number, String name, Integer calories) {
      this.number = number;
      this.name = name;
      this.calories = calories;
    }

    public Integer getNumber() {
      return number;
    }

    public String getName() {
      return name;
    }

    public Integer getCalories() {
      return calories;
    }

    @Override
    public String toString() {
      return "Food{" +
          "number=" + number +
          ", name='" + name + '\'' +
          ", calories=" + calories +
          '}';
    }
  }

  private static String test(Runnable runnable) {
    long start = System.currentTimeMillis();
    runnable.run();
    long elapsed = System.currentTimeMillis() - start;
    return String.format("%5dms", elapsed);
  }

  public static long countElementsOfFoodListInParallel(List<Food> foodList) {
//    return foodList.parallelStream().count(); // to be fast
    return foodList.parallelStream().map((Food f) -> 1).reduce(0, (a, b) -> a + b); // to be slow because of map
  }

  public static long countElementsOfFoodList(List<Food> foodList) {
//    return foodList.stream().count(); // to be fast
    return foodList.stream().map((Food f) -> 1).reduce(0, (a, b) -> a + b); // to be slow because of map
  }

  public static void main(String[] args) {
    List<Food> foodList = new ArrayList<>();
    for (int i = 0; i < 1000000; i++) {
      foodList.add(new Food(i, "test" + i, i));
    }
    System.out.println("Warmup...");
    for (int i = 0; i < 100; ++i) {
      ReduceExample.countElementsOfFoodListInParallel(foodList);
      ReduceExample.countElementsOfFoodList(foodList);
    }
    System.out.println("Benchmark...");

    // Sum elements of stream in parallel
    System.out.println(test(() -> countElementsOfFoodListInParallel(foodList)));
    // Sum elements of stream
    System.out.println(test(() -> countElementsOfFoodList(foodList)));

  }
}
