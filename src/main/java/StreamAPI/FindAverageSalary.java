package StreamAPI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindAverageSalary {
    public static void main(String[] args) {

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

        System.out.println("**********");

        // найти среднюю зарплату каждого департамента

        // сначала обычным способом
        Map<String, Double> averageSalByDep = new HashMap<>();
        Map<String, Integer> averageByDep = new HashMap<>();
        int count = 0;

        for(Employee employee : employees) {
            averageSalByDep.put(employee.getDepartment(),
                    averageSalByDep.getOrDefault(employee.getDepartment(),0.0)
                            + employee.getSalary());
            averageByDep.put(employee.getDepartment(),
                    averageByDep.getOrDefault(employee.getDepartment(), 0) + 1);
        }

        double averageSal = 0.0;

        for (String dep : averageSalByDep.keySet()) {
           averageSal = averageSalByDep.get(dep) / averageByDep.get(dep);
            System.out.printf("%s -> $%.2f%n", dep, averageSal);
        }

        System.out.println("_______");

        // теперь то же самое с помощью стрим апи
        Map<String, Double> salaryByDep = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));

        salaryByDep.forEach((dep, averSal) ->
                System.out.println(dep + " -> " + "$" + averSal));

    }
}
