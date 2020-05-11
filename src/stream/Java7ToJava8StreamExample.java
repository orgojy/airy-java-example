package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p> Stream Example
 * <p> : To optimize logic with "JAVA 7", Use "Stream of JAVA 8"
 * <p> - Example which is converted from logic with "JAVA 7" to logic with "JAVA 8" is provided at below.
 *
 * @author Yimin An
 * @see java.util.stream.Stream
 */
public class Java7ToJava8StreamExample {

  public static class Food {

    private final String name;
    private final Integer calories;

    public Food(String name, Integer calories) {
      this.name = name;
      this.calories = calories;
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
          "name='" + name + '\'' +
          ", calories=" + calories +
          '}';
    }
  }

  public static List<String> getLowCaloricFoodsNameWithJava7(List<Food> foodList) {
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

  public static List<String> getLowCaloricFoodsNameWithJava8(List<Food> foodList) {
    return foodList.stream()
        .filter(food -> food.getCalories() < 400)
        .sorted(Comparator.comparing(Food::getCalories))
        .map(Food::getName)
        .collect(Collectors.toList());
  }

  public static void main(String[] args) {
    List<Food> foodList = new ArrayList<>();
    foodList.add(new Food("Hamburger", 500));
    foodList.add(new Food("Cheese", 400));
    foodList.add(new Food("Chicken", 600));
    foodList.add(new Food("Sandwich", 300));
    foodList.add(new Food("Apple", 100));
    foodList.add(new Food("Rice", 200));

    // Code used By Java7
    Java7ToJava8StreamExample.getLowCaloricFoodsNameWithJava7(foodList)
        .forEach(System.out::println);

    System.out.println();

    // Code used By Java8
    Java7ToJava8StreamExample.getLowCaloricFoodsNameWithJava8(foodList)
        .forEach(System.out::println);
  }
}
