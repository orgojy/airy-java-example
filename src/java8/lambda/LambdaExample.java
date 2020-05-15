package java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * <p> "Lambda Expression" related with "Predicate"
 * <p> Ex) (Animal a1, Animal a2) -> a1.getAge() > a2.getAge()
 * <p> (Animal a1, Animal a2) : Parameter List of Lambda
 * <p> -> : arrow of Lambda
 * <p> a1.getAge() > a2.getAge() : body of Lambda
 * <p> - If you reuse "Lambda Expression" frequently, Use "Predicate Method" rather than "Lambda Expression"
 * <p> - If it used just One-time or Simple-code, Use "Lambda Expression"
 * <p> Next Course {@link LambdaExpressionExample} to see detailed "Lambda Expression"
 *
 * @author Yimin An
 */
public class LambdaExample {

  public static class Animal {

    private final int number;
    private final String name;
    private final int age;

    public Animal(int number, String name, int age) {
      this.number = number;
      this.name = name;
      this.age = age;
    }

    public static boolean isBear(Animal animal) {
      return "bear".equals(animal.getName());
    }

    public static boolean isOldAnimal(Animal animal) {
      return animal.getAge() > 10;
    }

    public int getUniqueNumber() {
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

    // Case by Predicate
    // Output : 1:bear 2:bear 3:bear
    LambdaExample.filterAnimal(animalList, Animal::isBear)
        .stream()
        .map(animal -> animal.getUniqueNumber() + ":" + animal.getName() + " ")
        .forEach(System.out::print);

    System.out.println();

    // Case by Lambda
    // Output : 1:bear 2:bear 3:bear
    LambdaExample.filterAnimal(animalList, (Animal animal) -> "bear".equals(animal.getName()))
        .stream()
        .map(animal -> animal.getUniqueNumber() + ":" + animal.getName() + " ")
        .forEach(System.out::print);

    System.out.println();

    // Case by Predicate
    // Output : 3:bear 6:bird
    LambdaExample.filterAnimal(animalList, Animal::isOldAnimal)
        .stream()
        .map(animal -> animal.getUniqueNumber() + ":" + animal.getName() + " ")
        .forEach(System.out::print);

    System.out.println();

    // Case by Lambda
    // Output : 3:bear 6:bird
    LambdaExample.filterAnimal(animalList, (Animal animal) -> animal.getAge() > 10)
        .stream()
        .map(animal -> animal.getUniqueNumber() + ":" + animal.getName() + " ")
        .forEach(System.out::print);

    System.out.println();
  }
}
