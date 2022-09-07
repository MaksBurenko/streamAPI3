package streamAPI;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        //    try {
        Scanner sc = new Scanner("Мама мыла раму 33 раза, а рама мыла маму.");
        // Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in, "UTF-8")));
        sc.useDelimiter("\\p{Punct}\\s|[^a-zA-ZА-Яа-я0-9]");

        ArrayList<String> list = null;
        while (sc.hasNext()) {
            list = new ArrayList<>();
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
        if (list != null) {
            for (String temp : list) {
                //добавляем их во множество для отслеживания
                //если не получилось добавить, то значит элемент уже встречался в списке
                if (!bufer.add(temp)) {
                    //в этом случае добавляем его во множество дубликатов
                    duplicates.put(temp, i++);
                }
            }
            Set <String> keys = duplicates.keySet();
            System.out.println(keys);
            Set <Map.Entry<String, Integer>> pair = duplicates.entrySet();
            System.out.println(pair);
        }
    }
}
