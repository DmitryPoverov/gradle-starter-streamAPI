package ru.clevertec.sptreamApi.practice;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamRunner {

    private final List<Employee> employees = List.of(
            new Employee("Bob", "Bob", 1, 18, Position.WORKER),
            new Employee("Bill", "Bill", 2, 19, Position.WORKER),
            new Employee("Tim", "Tim", 3, 25, Position.WORKER),
            new Employee("Sam", "Sam", 4, 30, Position.WORKER),
            new Employee("Josh", "Josh", 5, 35, Position.WORKER),
            new Employee("John", "Jahn", 6, 40, Position.WORKER),
            new Employee("Stan", "Stan", 7, 45, Position.WORKER),
            new Employee("Mark", "Mark", 8, 50, Position.WORKER),
            new Employee("Mick", "Mick", 9, 55, Position.WORKER),
            new Employee("Michael", "Michael", 10, 60, Position.MANAGER),
            new Employee("Timothy", "Timothy", 11, 65, Position.MANAGER),
            new Employee("Harry", "Harry", 12, 70, Position.CHEF)
    );

    private final List<Department> departments = List.of(
            new Department(1, 0, "Head"),
            new Department(2, 1, "West"),
            new Department(3, 1, "East"),
            new Department(4, 2, "Germany"),
            new Department(5, 2, "France"),
            new Department(6, 3, "China"),
            new Department(7, 3, "Japan")
    );

    public void creation() throws IOException {
        Stream<String> lines = Files.lines(Paths.get("some.txt"));
        Stream<Path> list = Files.list(Paths.get("./"));
        Files.walk(Paths.get("./"), 3);
        IntStream intStream = IntStream.of(1, 2, 3, 4);
        DoubleStream doubleStream = DoubleStream.of(1.2, 3.4);
        IntStream range = IntStream.range(10, 100);
        IntStream intStream1 = IntStream.rangeClosed(10, 100);

        int[] ints = {1, 2, 3, 4};
        IntStream stream = Arrays.stream(ints);

        Stream<String> stringStream = Stream.of("A", "B", "C", "D");
        Stream<? extends Serializable> stream1 = Stream.of(1, "B", "C", "D");

        Stream<String> build = Stream.<String>builder()
                .add("Mike")
                .add("Joe")
                .build();

        Stream<Employee> stream2 = employees.stream();
        Stream<Employee> employeeStream = employees.parallelStream();

        Stream<Integer> iterate = Stream.iterate(1950, val -> val + 3);
        Stream<String> concat = Stream.concat(stringStream, build);
    }

    public void terminate() {
        long count = employees.stream().count();

        //employees.stream().forEach(System.out::println);
        //employees.forEach(System.out::println);

        employees.toArray();
        //employees.stream().forEachOrdered(System.out::println);
        employees.stream().collect(Collectors.toSet());
//        Map<Integer, String> collect = employees.stream().collect(Collectors.toMap(
//                Employee::getId,
//                employee -> String.format("%s %s", employee.getLastName(), employee.getFirstName())
//        ));

        IntStream intStream = IntStream.of(100, 200, 300, 400);
        int i = intStream.reduce((a, b) -> a + b).orElse(0);

        System.out.println("***" + departments.stream().reduce(this::reducer));


    }

    public Department reducer(Department parent, Department child) {
        if(child.getParent() == parent.getId()) {
            parent.getChild().add(child);
        } else {
            parent.getChild().forEach(subParent -> reducer(subParent, child));
        }
        return parent;
    }
}
