package com.epam.rd.autotasks.pizzasplit;

import java.util.Scanner;

public class PizzaSplit {
    static long gcd(long N, long K) {
        return (K % N == 0) ? N : gcd(K % N, N);
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int N = kb.nextInt();
        int K = kb.nextInt();

        System.out.println(N / gcd(N, K));
        kb.close();
    }
}
