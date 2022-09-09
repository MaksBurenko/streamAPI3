package streamAPI;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        //    try {
        Scanner sc = new Scanner("Lorem ipsum dolor sit amet, consectetur adipiscing elit." +
                " Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa." +
                " Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus." +
                " Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit." +
                " Integer vel odio nec mi tempor dignissim.");

        // Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in, "UTF-8")));
        sc.useDelimiter("\\p{Punct}\\s|[^a-zA-ZА-Яа-я0-9]");

        ArrayList<String> list = new ArrayList<>();
        while (sc.hasNext()) {
            list.add((sc.next()).toLowerCase());

        }

        sc.close();
        //    } catch (UnsupportedEncodingException e) {
        //       e.printStackTrace();
        //   }

        int i =0;
//множество с дубликатами
        HashMap<String, Integer> duplicates = new HashMap<>();
//множество для отслеживания повторяющихся элементов
        Set<String> bufer = new HashSet<>();
//пробегаемся по всем элементам

            for (String temp : list) {
                //добавляем их во множество для отслеживания
                //если не получилось добавить, то значит элемент уже встречался в списке
                if (!bufer.add(temp)) {
                    //в этом случае добавляем его во множество дубликатов
                    duplicates.put(temp, i++);
                }
            }
            duplicates.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .map(Map.Entry::getKey)
                    .limit(10)
                    .forEach(System.out::println);
    }
}
