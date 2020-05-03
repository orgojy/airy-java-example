package predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import lambda.LambdaExample;

/**
 * <p> What is Predicate ?
 * <p> : Function which input value and then returning true/false
 * <p> "::" called "Method Reference"
 * <p> Example) Animal::isBear , Animal::isOldAnimal
 * <p> Next Course {@link LambdaExample}
 */
public class PredicateExample {

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

    // Output : 1:bear 2:bear 3:bear
    PredicateExample.filterAnimal(animalList, Animal::isBear)
        .stream()
        .map(animal -> animal.getUniqueNumber() + ":" + animal.getName() + " ")
        .forEach(System.out::print);

    System.out.println();

    // Output : 3:bear 6:bird
    PredicateExample.filterAnimal(animalList, Animal::isOldAnimal)
        .stream()
        .map(animal -> animal.getUniqueNumber() + ":" + animal.getName() + " ")
        .forEach(System.out::print);

    System.out.println();
  }
}
