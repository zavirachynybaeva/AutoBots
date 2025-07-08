package StreamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {
    public static void main(String[] args) {

        List<List<String>> nestedList = List.of(
                List.of("A", "B"),
                List.of("C", "D"),
                List.of("E")
        );
        System.out.println(nestedList);

        // нужно закинуть все это в обычный лист, без вложенного
        List <String> nonNestedList = new ArrayList<>();
        for (List<String> list : nestedList) {
            nonNestedList.addAll(list);
        }
        System.out.println(nonNestedList);

        System.out.println(("_________"));

        // теперь через стрим апе
        List<String> nonNestedListStream = nestedList.stream()
                .flatMap(List :: stream).collect(Collectors.toList()); // превратили вложенный в обычный
        System.out.println(nonNestedListStream);


    }
}
