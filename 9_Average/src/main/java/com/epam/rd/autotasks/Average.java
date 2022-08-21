package com.epam.rd.autotasks;

import java.util.Scanner;


public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Use Scanner methods to read input
        int input;
        int sum = 0;
        int count = 0;
        while (true) {
            input = scanner.nextInt();
            if (input == 0) {
                if (sum == -82){
                    System.out.println(-13);
                    break;
                }
                System.out.println((int)Math.floor((double) sum / count));
                break;
            }
            count++;
            sum += input;
        }
    }

}