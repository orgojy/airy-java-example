package java8.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <p> Examples of Utility method "groupingBy" of Collectors
 *
 * @author Yimin An
 * @see Collectors
 */
public class GroupingByExample {

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

  public enum CaloricLevel {DIET, NORMAL, FAT}

  public static void main(String[] args) {
    List<Food> foods = new ArrayList<>();
    foods.add(new Food(2, "Beef", 800));
    foods.add(new Food(3, "Pork", 500));
    foods.add(new Food(4, "Butter", 1100));
    foods.add(new Food(5, "Butter", 1200));
    foods.add(new Food(1, "Potato", 300));
    foods.add(new Food(6, "Potato", 400));
    foods.add(new Food(7, "Potato", 1200));

    // 1 level grouping by method reference
    Map<String, List<Food>> foodsByName = foods.stream().collect(Collectors.groupingBy(Food::getName));
    foodsByName.values().forEach(v -> {
      v.forEach(System.out::print);
      System.out.println();
    });
    System.out.println();

    // 1 level grouping by custom source
    Map<CaloricLevel, List<Food>> foodsByCalorie = foods.stream().collect(
        Collectors.groupingBy(food -> {
              if (food.getCalories() < 400) {
                return CaloricLevel.DIET;
              } else if (food.getCalories() <= 700) {
                return CaloricLevel.NORMAL;
              } else {
                return CaloricLevel.FAT;
              }
            }
        ));
    for (Map.Entry<CaloricLevel, List<Food>> mapEntry : foodsByCalorie.entrySet()) {
      System.out.println(mapEntry.toString());
    }
    System.out.println();

    // count group elements
    Map<String, Long> typesCount = foods.stream().collect(Collectors.groupingBy(Food::getName, Collectors.counting()));
    for (Map.Entry<String, Long> entry : typesCount.entrySet()) {
      System.out.println(entry.toString());
    }
    System.out.println();

    // 2 level grouping
    Map<String, Map<CaloricLevel, List<Food>>> foodsByNameCaloricLevel =
        foods.stream().collect(Collectors.groupingBy(Food::getName,
            Collectors.groupingBy(food -> {
                  if (food.getCalories() < 400) {
                    return CaloricLevel.DIET;
                  } else if (food.getCalories() <= 700) {
                    return CaloricLevel.NORMAL;
                  } else {
                    return CaloricLevel.FAT;
                  }
                }
            )
            )
        );
    for (Map.Entry<String, Map<CaloricLevel, List<Food>>> entry : foodsByNameCaloricLevel.entrySet()) {
      System.out.println(entry.toString());
    }
    System.out.println();

    // Most of caloric food
    Map<String, Optional<Food>> mostCaloricByName =
        foods.stream().collect(
            Collectors.groupingBy(
                Food::getName,
                Collectors.maxBy(Comparator.comparingInt(Food::getCalories))
            )
        );
    mostCaloricByName.entrySet().stream().forEach(System.out::println);
    System.out.println();

    // Most of caloric food consist of not empty Food
    Map<String, Food> mostCaloricByName2 =
        foods.stream().collect(
            Collectors.groupingBy(
                Food::getName,
                Collectors.collectingAndThen(
                    Collectors.maxBy(
                        Comparator.comparingInt(Food::getCalories)),
                    Optional::get
                )
            )
        );
    mostCaloricByName2.entrySet().stream().forEach(System.out::println);
  }
}
