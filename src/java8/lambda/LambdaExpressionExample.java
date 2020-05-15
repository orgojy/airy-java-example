package java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * <p> Various "Lambda Expression"
 * <p> - If you reuse "Lambda Expression" frequently, Use "Predicate Method" rather than "Lambda Expression"
 * <p> - If it used just One-time, Use "Lambda Expression"
 *
 * @author Yimin An
 */
public class LambdaExpressionExample {

  public static class Animal {

    private final int number;
    private final String name;
    private final int age;

    public Animal(int number, String name, int age) {
      this.number = number;
      this.name = name;
      this.age = age;
    }

    public int getNumber() {
      return number;
    }

    public String getName() {
      return name;
    }

    public int getAge() {
      return age;
    }
  }

  public static List<Animal> filterAnimal(List<Animal> animalList, Predicate<Animal> p) {
    List<Animal> result = new ArrayList<>();
    for (Animal animal : animalList) {
      if (p.test(animal)) {
        result.add(animal);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    List<Animal> animalList = new ArrayList<>();
    animalList.add(new Animal(1, "bear", 5));
    animalList.add(new Animal(2, "bear", 10));
    animalList.add(new Animal(3, "bear", 15));
    animalList.add(new Animal(4, "bird", 5));
    animalList.add(new Animal(5, "bird", 10));
    animalList.add(new Animal(6, "bird", 15));

    // Case 1)
    // Output : 1:bear 2:bear 3:bear
    LambdaExpressionExample.filterAnimal(animalList,
        (Animal animal) -> "bear".equals(animal.getName())
    )
        .stream()
        .map(animal -> animal.getNumber() + ":" + animal.getName() + " ")
        .forEach(System.out::print);

    System.out.println();

    // Case 2)
    // Output : 1:bear 2:bear 3:bear
    LambdaExpressionExample.filterAnimal(animalList,
        animal -> "bear".equals(animal.getName())
    )
        .stream()
        .map(animal -> animal.getNumber() + ":" + animal.getName() + " ")
        .forEach(System.out::print);

    System.out.println();

    // Case 3)
    // Output : 1:bear 2:bear 3:bear
    LambdaExpressionExample.filterAnimal(animalList,
        (Animal animal) -> {
          return "bear".equals(animal.getName());
        }
    )
        .stream()
        .map(animal -> animal.getNumber() + ":" + animal.getName() + " ")
        .forEach(System.out::print);

    System.out.println();

    // Case 4)
    // Output : 1:bear 2:bear 3:bear
    LambdaExpressionExample.filterAnimal(animalList,
        animal -> {
          return "bear".equals(animal.getName());
        }
    )
        .stream()
        .map(animal -> animal.getNumber() + ":" + animal.getName() + " ")
        .forEach(System.out::print);

    System.out.println();
  }
}
