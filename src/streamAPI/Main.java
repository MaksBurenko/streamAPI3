package streamAPI;
import java.util.*;
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner("Мама мыла-мыла-мыла раму!");

        // Scanner sc = new Scanner(System.in, "UTF-8");
        sc.useDelimiter("\\p{Punct}\\s|[^a-zA-ZА-Яа-я0-9]");

        ArrayList<String> list = new ArrayList<>();
        while (sc.hasNext()) {
            list.add((sc.next()).toLowerCase());
        }
        sc.close();

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

            //перебор буфера и удаление совпадений с дубликатами, на случай если дубликатов окажется меньше 10
            if (duplicates.size() < 10) {
                Set<String> keys = duplicates.keySet();
                for (String temp : bufer) {
                    for (String key : keys) {
                        if (temp.equals(key)){
                            bufer.remove(temp);
                        }
                    }
                }
            }
            //сортировка в алфавитном порядке (по дефолту) и добивание до лимита 10
            bufer.stream()
                    .sorted()
                    .limit(10 - duplicates.size())
                    .forEach(System.out::println);
    }
}
