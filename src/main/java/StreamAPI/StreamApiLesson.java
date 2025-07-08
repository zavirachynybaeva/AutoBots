package StreamAPI;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamApiLesson {
    public static void main(String[] args) {

        List<String> names = List.of("Anna", "Bob", "Alex", "Bella", "Andrew");

        // стрим апи помогает нам сделать код короче и чище
        // вместо цикла мы сделали все в минимум строк
        List<String> result = names.stream() // запустили стрим
                .filter(name -> name.startsWith("A")) // оставили только на букву А
                .map(String::toUpperCase) // преобразовали в капс
                .sorted() // отсортировали по алфавитному порядку
                .collect(Collectors.toList()); // положили все в лист резалт

        System.out.println(result);

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // все эти числа в листе нужно суммировать
        int totalSum = numbers.stream()
                .mapToInt(num -> num) // преобразовали большой интежер в маленький инт
                // так можно сделать с любым типом данных
                .sum(); // и у этого метода сразу нашли суммирование
        System.out.println(totalSum);

        // найти сколько элементов находится в листе
        int totalElements = (int) numbers.stream() // сделали здесь кастинг из лонга в инт
                .count();
        System.out.println(totalElements);

        // найти самое минимальное
        numbers.stream()
                .min(Integer::compareTo) // сравнили все числа, чтобы найти мин
                .ifPresent(System.out::println); // говорю "если есть такое число, то напечатай)


        List<String> list = List.of("one", "two", "three", "hello", "for", "five");

        // вывести только тот элемент, у которого длина больше 3 символов
        // и вывести только первый

        list.stream()
                .filter(s -> s.length() > 3)
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println("------------");

        List<Employee> employees = List.of(
                new Employee(1, "Alice", 28, 3000, "IT"),
                new Employee(2, "Bob", 35, 4000, "HR"),
                new Employee(3, "Charlie", 40, 5000, "Finance"),
                new Employee(4, "David", 25, 3500, "It"),
                new Employee(5, "Eva", 30, 4200, "Marketing"),
                new Employee(6, "Frank", 45, 6000, "Finance"),
                new Employee(7, "Grace", 32, 4100, "HR"),
                new Employee(8, "Henry", 29, 3900, "IT"),
                new Employee(9, "Isabel", 38, 4500, "Marketing"),
                new Employee(10, "Jack", 27, 3600, "IT")
        );

        // отсортировать сотрудников по отделу айти
        List<Employee> itEmployee = employees.stream()
                .filter(s -> s.getDepartment().equalsIgnoreCase("IT"))
                .collect(Collectors.toList());
        System.out.println(itEmployee); // здесь он вывел бы просто каляку,
        // поэтому в классе сотрудников мы сделали toString

        // по отделам сгруппировать нужно
        Map<String, List<Employee>> employeesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(employeesByDepartment);

        System.out.println("--------");

        // сделаем саут читабельнее
        employeesByDepartment.forEach((department, list1)-> {
            System.out.println("отдел: " + department);
            list1.forEach(System.out::println);
        });


    }
}
