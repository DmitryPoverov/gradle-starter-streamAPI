package ru.clevertec.enums;

import java.util.Arrays;
import java.util.stream.Stream;

public class EnumRunner {
    public static void main(String[] args) {

        Arrays.stream(Size.values())
                .map(Size::getName)
                .flatMap(string -> Stream.of(string.toCharArray()))
                .forEach(s1 -> System.out.printf("%s, ", Arrays.toString(s1)));

        System.out.println();

        for (Size s : Size.values()) {
            System.out.print(s.getName() + ", ");
        }

        System.out.println();

        for (Size s : Size.values()) {
            switch (s) {
                case SMALL -> System.out.print("S, ");
                case MEDIUM -> System.out.print("M, ");
                case LARGE -> System.out.print("L, ");
                default -> System.out.print("XL, ");
            }
        }


    }
}
