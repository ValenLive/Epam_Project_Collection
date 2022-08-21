package com.epam.rd.autotasks.meetstrangers;

import java.util.Scanner;
import java.util.stream.Stream;

public class HelloStrangers {
    public static void main(String[] args) {
        //Write a program, asks for a number - amount of strangers to meet.
        //Then reads stranger names line by line and prints line by line "Hello, ...".
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();
        scanner.nextLine();
        if (userInput == 0) {
            System.out.println("Oh, it looks like there is no one here");
        } else if (userInput < 0) {
            System.out.println("Seriously? Why so negative?");
        } else {
            Stream.iterate(0, i -> i < userInput, i -> i + 1)
                    .forEach(i -> System.out.println("Hello, " + scanner.nextLine()));
        }
        scanner.close();
    }
}
