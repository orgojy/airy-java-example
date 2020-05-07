package function_interface;

/**
 * <p> Functional Interface "Comparator"
 * <p> : To use "Behavior parameters", Use "Functional Interface"
 * <p> - You can implement dynamic parameters for behavior by using "Functional Interface"
 * <p> - You can check validation by declaring "@FunctionalInterface"
 * <p> - To be used for comparing values by lambda expression, Use "Comparator"
 *
 * @author Yimin An
 * @see java.util.Comparator
 */
public class ComparatorExample {

  @FunctionalInterface
  public interface Comparator<T> {

    int compareTo(T c1, T c2);
  }

  public static <T> int compare(T c1, T c2, Comparator<T> comparator) {
    return comparator.compareTo(c1, c2);
  }

  public static void main(String[] args) {
    // Custom "Functional Interface"
    Comparator<String> stringComparator1 = (String s1, String s2) -> s1.compareTo(s2);
//    Comparator<String> stringComparator = String::compareTo;
    System.out.println(ComparatorExample.compare("1", "2", stringComparator1));
    System.out.println(ComparatorExample.compare("1", "1", stringComparator1));
    System.out.println(ComparatorExample.compare("2", "1", stringComparator1));

    System.out.println();

    // Java.util "Functional Interface"
    java.util.Comparator<String> stringComparator2 = (String s1, String s2) -> s1.compareTo(s2);
//    java.util.Comparator<String> stringComparator2 = String::compareTo;
    System.out.println(stringComparator2.compare("1", "2"));
    System.out.println(stringComparator2.compare("1", "1"));
    System.out.println(stringComparator2.compare("2", "1"));

    System.out.println();
  }
}
