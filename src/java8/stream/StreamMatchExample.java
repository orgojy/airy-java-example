package java8.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> Utility method "allMatch", "noneMatch", "anyMatch"
 * <p> : method using for efficient "Short circuit"
 * <p> * What is "Short circuit"? "Even if it doesn't tours all elements, turn out whether true or not."
 * <p> - If "allMatch" finds element which is not matched, operation is terminated and return boolean result(false).
 * <p> - If "noneMatch" finds element which is matched, operation is terminated and return boolean result(false).
 * <p> - If "anyMatch" finds element which is matched, operation is terminated and return boolean result(true).
 *
 * @author Yimin An
 */
public class StreamMatchExample {

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
    foods.add(new Food(1, "Potato", 300));
    foods.add(new Food(2, "Beef", 800));
    foods.add(new Food(3, "Fort", 500));
    foods.add(new Food(4, "Butter", 1100));

    System.out.println(foods.stream().allMatch((Food f) -> f.getCalories() < 500) ? "Heathy" : "Unhealty");
    System.out.println(foods.stream().noneMatch((Food f) -> f.getCalories() > 500) ? "Unhealthy" : "Healthy");
    System.out.println(foods.stream().anyMatch((Food f) -> f.getCalories() < 500) ? "NotBad" : "Unhealthy");
//    Unhealty
//    Healthy
//    NotBad
  }
}
