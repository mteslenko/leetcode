package hackerrank.tasks;


import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Pairs {
  public static void main(String[] args) {
    int k;
    String line;
    try (Scanner scanner = new Scanner(System.in)) {
      scanner.nextInt();
      k = scanner.nextInt();
      scanner.nextLine();
      line = scanner.nextLine();
    }
    TreeMap<Integer, Boolean> map = Arrays.stream(line.split(" "))
        .map(Integer::valueOf)
        .collect(Collectors.toMap(num -> num, num -> Boolean.TRUE, (num1, num2) -> num1,
            TreeMap::new));
    int max = map.lastKey();
    long result = map.keySet().stream()
        .filter(num -> num <= max - k)
        .filter(num -> map.containsKey(num + k))
        .count();
    System.out.print(result);
  }
}