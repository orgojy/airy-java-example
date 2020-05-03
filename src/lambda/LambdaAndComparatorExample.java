package lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * <p> Examples for sorting by Comparator or Lambda
 */
public class LambdaAndComparatorExample {

  public static class Animal {

    private final int number;
    private final String name;
    private final Integer age;

    public Animal(int number, String name, Integer age) {
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

    public Integer getAge() {
      return age;
    }

    @Override
    public String toString() {
      return "Animal{" +
          "number=" + number +
          ", name='" + name + '\'' +
          ", age=" + age +
          '}';
    }
  }

  public static void main(String[] args) {
    List<Animal> animalList = new ArrayList<>();
    animalList.add(new Animal(1, "bear", 10));
    animalList.add(new Animal(2, "bear", 30));
    animalList.add(new Animal(3, "bear", 8));
    animalList.add(new Animal(4, "dog", 3));
    animalList.add(new Animal(5, "dog", 20));
    animalList.add(new Animal(6, "dog", 15));

    // Case 1 by Comparator
    List<Animal> case1 = animalList;
    case1.sort(new Comparator<Animal>() {
      @Override
      public int compare(Animal animal1, Animal animal2) {
        return animal1.getAge().compareTo(animal2.getAge());
      }
    });
    case1.stream().map(Animal::toString).forEach(System.out::println);

    System.out.println();

    // Case 2 by Lambda
    List<Animal> case2 = animalList;
    case2.sort((Animal a1, Animal a2) -> a1.getAge().compareTo(a2.getAge()));
    case2.stream().map(Animal::toString).forEach(System.out::println);

    System.out.println();

    // Case 3 by default function of Comparator
    List<Animal> case3 = animalList;
    case3.sort(Comparator.comparing(Animal::getAge));
    case3.stream().map(Animal::toString).forEach(System.out::println);

    System.out.println();
  }
}
