package com.epam.rd.autotasks.sequence;

import java.util.Scanner;

public class FindMaxInSeq {
    public static int max() {
        Scanner scanner = new Scanner(System.in);
        int largest = Integer.MIN_VALUE;
        while (scanner.hasNextInt()){
            int input = scanner.nextInt();
            if (input == 0){
                return largest;
            }
            if (input > largest){
                largest = input;
            }
        }
        return largest;
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        System.out.println(max());
    }
}
