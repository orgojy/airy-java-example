package java8.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <p> Utility method examples of Collectors
 *
 * @author Yimin An
 * @see java.util.stream.Collectors
 */
public class CollectorsExample {

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

  public static void main(String[] args) {
    List<Food> foods = new ArrayList<>();
    foods.add(new Food(2, "Beef", 800));
    foods.add(new Food(3, "Pork", 500));
    foods.add(new Food(4, "Butter", 1100));
    foods.add(new Food(5, "Butter", 1200));
    foods.add(new Food(1, "Potato", 300));
    foods.add(new Food(6, "Potato", 400));
    foods.add(new Food(7, "Potato", 1200));

    Map<String, List<Food>> foodsByName = foods.stream().collect(Collectors.groupingBy(Food::getName));
    foodsByName.values().forEach(v -> {
      v.forEach(System.out::print);
      System.out.println();
    });

    long count = foods.stream().collect(Collectors.counting());
    System.out.println("count:" + count);
    count = foods.stream().count();
    System.out.println("count:" + count);

    Comparator<Food> foodCaloriesComparator = Comparator.comparingInt(Food::getCalories);
    Optional<Food> mostCaloriesFood = foods.stream().max(foodCaloriesComparator);
    mostCaloriesFood.ifPresent(food -> System.out.println(food.toString()));
    mostCaloriesFood = foods.stream().collect(Collectors.maxBy(foodCaloriesComparator));
    mostCaloriesFood.ifPresent(food -> System.out.println(food.toString()));

    int totalCalories = foods.stream().collect(Collectors.summingInt(Food::getCalories));
    System.out.println("totalCalories:" + totalCalories);
    totalCalories = foods.stream().mapToInt(Food::getCalories).sum();
    System.out.println("totalCalories:" + totalCalories);
    totalCalories = foods.stream().collect(Collectors.reducing(0, Food::getCalories, (a, b) -> a + b));
    System.out.println("totalCalories:" + totalCalories);
    totalCalories = foods.stream().map(Food::getCalories).reduce(0, (a, b) -> a + b);
    System.out.println("totalCalories:" + totalCalories);
    totalCalories = foods.stream().mapToInt(Food::getCalories).sum();
    System.out.println("totalCalories:" + totalCalories);

    double avgCalories = foods.stream().collect(Collectors.averagingInt(Food::getCalories));
    System.out.println("avgCalories:" + avgCalories);

    IntSummaryStatistics foodsStatistics = foods.stream().collect(Collectors.summarizingInt(Food::getCalories));
    System.out.println(foodsStatistics.toString());

    String shortMenu = foods.stream().map(Food::getName).collect(Collectors.joining(","));
    System.out.println(shortMenu);
  }
}
