import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import model.Currency;


public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 10, 15, 20);
        Predicate<Integer> predicate = n -> n % 2 == 0;
        List<Integer> evenNumbers = predicate(numbers, predicate);
        for (Integer n: evenNumbers) {
            System.out.println(n);
        }

        Function<String, String> trimFunction = String::trim;
        Function<String, String> toUpperCaseFunction = String::toUpperCase;
        Function<String, String> combinedFunction = trimFunction.andThen(toUpperCaseFunction);
        System.out.println(combinedFunction.apply("   Hello, worLD         "));

        Employee employee1 = new Employee("Alfred", 41, "department1");
        Employee employee2 = new Employee("Dominik", 22, "department2");
        Employee employee3 = new Employee("Daniel", 35, "department3");
        List<Employee> employees = List.of(employee1, employee2, employee3);
        Map<String, List<String>> employeesInDepartments = employees.stream()
                .filter(e -> e.getAge() > 25)
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));

        List<String> sentences = Arrays.asList("hello world", "java streams", "world of code");
        String result = sentences.stream()
                .map(s -> s.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .sorted()
                .collect(Collectors.joining(","));
        System.out.println(result);

        Map<Currency, List<String>> listMap = Exercises.currencyListMap();
        listMap.forEach((k, v) -> System.out.printf("%s: %s\n", k, v));
        System.out.println("-----------");
        System.out.println(Exercises.getAllCompaniesNamesAsLinkedList());
        System.out.println("-----------");
        System.out.println(Exercises.getUserPerCompany());
        System.out.println("-----------");
        System.out.println(Exercises.getRichestWoman());
        System.out.println("-----------");
        System.out.println(Exercises.getUsersForPredicate(u -> u.getAge() > 18));
    }

    public static List<Integer> predicate(List<Integer> list, Predicate<Integer> predicate) {
        return list.stream()
                .filter(predicate)
                .toList();
    }
}
