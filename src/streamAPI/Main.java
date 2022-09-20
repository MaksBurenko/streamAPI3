package streamAPI;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.");

        // Scanner sc = new Scanner(System.in, "UTF-8");
        sc.useDelimiter("\\p{Punct}\\s|[^a-zA-ZА-Яа-я0-9]");

        ArrayList<String> list = new ArrayList<>();
        while (sc.hasNext()) {
            list.add((sc.next()).toLowerCase());
        }
        sc.close();


        Map<String, Integer> duplicates = list.stream()
                .collect(Collectors.toMap(x -> x, i -> 1, (oldValue,newValue) -> newValue = oldValue + 1));


        duplicates.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .map(Map.Entry::getKey)
                .limit(10)
                .forEach(System.out::println);

    }
}
