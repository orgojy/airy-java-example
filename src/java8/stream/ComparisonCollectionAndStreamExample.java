package java8.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p> Comparison Example of "Collection", "Stream", "Parallel Stream"
 * <p> : Show how to operate about "Stream", and benchmarking is provided
 * <p> - "Collection" has logic with outer iteration
 * <p> - "Stream" has logic with inner iteration
 * <p> - "Parallel Stream" has logic with inner iteration used by multiple cores
 *
 * @author Yimin An
 * @see java.util.Collections
 * @see java.util.stream.Stream
 */
public class ComparisonCollectionAndStreamExample {

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

  public static List<String> getLowCaloricFoodsNameWithCollection(List<Food> foodList) {
    // Step: filter
    List<Food> lowCaloricFoods = new ArrayList<>();
    for (Food food : foodList) {
      if (food.getCalories() < 400) {
        lowCaloricFoods.add(food);
      }
    }
    // Step: sorted
    Collections.sort(lowCaloricFoods, new Comparator<Food>() {
      @Override
      public int compare(Food f1, Food f2) {
        return Integer.compare(f1.getCalories(), f2.getCalories());
      }
    });
    // Step: map
    List<String> lowCaloricFoodsName = new ArrayList<>();
    for (Food food : lowCaloricFoods) {
      lowCaloricFoodsName.add(food.getName());
    }

    return lowCaloricFoodsName;
  }

  public static List<String> getLowCaloricFoodsNameWithStream(List<Food> foodList) {
    return foodList.stream()
        .filter(food -> food.getCalories() < 400)
        .sorted(Comparator.comparing(Food::getCalories))
        .map(Food::getName)
        .collect(Collectors.toList());
  }

  public static List<String> getLowCaloricFoodsNameWithParallelStream(List<Food> foodList) {
    return foodList.parallelStream()
        .filter(food -> food.getCalories() < 400)
        .sorted(Comparator.comparing(Food::getCalories))
        .map(Food::getName)
        .collect(Collectors.toList());
  }

  private static String test(Runnable runnable) {
    long start = System.currentTimeMillis();
    runnable.run();
    long elapsed = System.currentTimeMillis() - start;
    return String.format("%5dms", elapsed);
  }

  public static void main(String[] args) {
    List<Food> foodList = new ArrayList<>();
    for (int i = 0; i < 10000000; i++) {
      foodList.add(new Food(i, "test" + i, i));
    }
    System.out.println("Warmup...");
    for (int i = 0; i < 100; ++i) {
      ComparisonCollectionAndStreamExample.getLowCaloricFoodsNameWithCollection(foodList);
      ComparisonCollectionAndStreamExample.getLowCaloricFoodsNameWithStream(foodList);
      ComparisonCollectionAndStreamExample.getLowCaloricFoodsNameWithParallelStream(foodList);
    }
    System.out.println("Benchmark...");
    for (int i = 0; i < 5; ++i) {
      System.out.printf("Run %d:  collection %s  -  java8.stream %s  -  parallel java8.stream %s\n",
          i,
          // Code used By Java7
          test(() -> ComparisonCollectionAndStreamExample.getLowCaloricFoodsNameWithCollection(foodList)),
          // Code used By java8.stream of Java8
          test(() -> ComparisonCollectionAndStreamExample.getLowCaloricFoodsNameWithStream(foodList)),
          // Code used By parallel java8.stream of Java8
          test(() -> ComparisonCollectionAndStreamExample.getLowCaloricFoodsNameWithParallelStream(foodList))
      );

//     [Output]
//      Warmup...
//      Benchmark...
//      Run 0:  collection   103ms  -  java8.stream    95ms  -  parallel java8.stream    40ms
//      Run 1:  collection    96ms  -  java8.stream    94ms  -  parallel java8.stream    40ms
//      Run 2:  collection    95ms  -  java8.stream    96ms  -  parallel java8.stream    41ms
//      Run 3:  collection    98ms  -  java8.stream    94ms  -  parallel java8.stream    41ms
//      Run 4:  collection    96ms  -  java8.stream    94ms  -  parallel java8.stream    42ms
    }
  }
}
