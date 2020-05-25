package java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <p> Stream for primitive data type "IntStream", "DoubleStream", "LongStream"
 * : Use for statistic method for primitive data type
 *
 * @author Yimin An
 * @see java.util.stream.IntStream
 * @see java.util.stream.DoubleStream
 * @see java.util.stream.LongStream
 * @see java.util.OptionalInt
 * @see java.util.OptionalDouble
 * @see java.util.OptionalLong
 */
public class StreamForNumberExample {

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

  public static Stream<int[]> getPythagoreanTriples(int from, int to) {
    return IntStream.rangeClosed(from, to).boxed()
        .flatMap(a -> IntStream.rangeClosed(a, to)
            .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
            .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
        );
  }

  public static void main(String[] args) {
    List<Food> foodList = new ArrayList<>();
    // output : 0
    System.out.println(foodList.stream().mapToInt(Food::getCalories).sum());

    foodList.add(new Food(1, "Hamburger", 500));
    foodList.add(new Food(2, "Cheese", 400));
    foodList.add(new Food(3, "Chicken", 600));
    foodList.add(new Food(4, "Sandwich", 300));
    foodList.add(new Food(5, "Apple", 100));
    foodList.add(new Food(6, "Rice", 200));

    // output : 2100
    System.out.println(foodList.stream().mapToInt(Food::getCalories).sum());

    // Stream<Food> => IntStream
    IntStream intStream = foodList.stream().mapToInt(Food::getCalories);
    // IntStream => Stream<Integer>
    Stream<Integer> stream = intStream.boxed();

    // If it not exists list, we need OptionalInt.
    OptionalInt maxCalories = foodList.stream().mapToInt(Food::getCalories).max();
    maxCalories.orElse(1);

    // 1 <= x <= 100
    IntStream.rangeClosed(1, 100);
    // 1 < x < 100
    IntStream.range(1, 100);

    // example : pythagoreanTriples
    getPythagoreanTriples(1, 30).limit(5).forEach(t -> System.out.println(t[0] + "," + t[1] + "," + t[2]));
  }
}
