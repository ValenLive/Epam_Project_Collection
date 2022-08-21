package com.epam.rd.autotasks.godutch;

import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {
        //Write code here
        Scanner scanner = new Scanner(System.in);

        int bill = scanner.nextInt();
        int friends = scanner.nextInt();

        if (bill < 0) {
            System.out.println("Bill total amount cannot be negative");
        } else if (friends <= 0) {
            System.out.println("Number of friends cannot be negative or zero");
        } else {
            if (bill==0){
                System.out.println(0);
            } else if (bill < friends){
                System.out.println(1);
            } else {
                System.out.println((Math.round((double) bill / friends * 1.1)));

            }
        }

    }
}
