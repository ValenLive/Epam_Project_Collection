package com.epam.rd.autotasks.snail;

import java.util.Scanner;

public class Snail {
    public static void main(String[] args) {
        //Write a program that reads a,b and h (line by lyne in this order) and prints
        //the number of days for which the snail reach the top of the tree.
        //a - feet that snail travels up each day, b - feet that slides down each night, h - height of the tree
        Scanner scanner = new Scanner(System.in);

        int travel = scanner.nextInt();
        int slide = scanner.nextInt();
        int height = scanner.nextInt();

        int distance = 0;
        int daysResult = 0;
        if (travel >= height) {
            System.out.println("1");
        }else if (travel - slide <= 0) {
            System.out.println("Impossible");
        } else {
            for (int days = 1; distance < height; days++) {
                distance += travel;
                if (distance < height) {
                    distance -= slide;
                } else {
                    daysResult = days;
                }
            }
            System.out.println(daysResult);
        }
    }
}
