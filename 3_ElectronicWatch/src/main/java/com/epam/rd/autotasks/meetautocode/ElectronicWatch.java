package com.epam.rd.autotasks.meetautocode;

import java.util.Scanner;

public class ElectronicWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();
        System.out.printf("%d:%02d:%02d%n",
                seconds >= 86400 ? (seconds - 86400) / 3600 : seconds / 3600,
                (seconds % 3600) / 60,
                seconds % 60);
    }
}
