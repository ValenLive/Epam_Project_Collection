package com.epam.rd.autotasks;


import java.util.Arrays;

public class CarouselRun {
    public int index;
    public int[] arr = DecrementingCarousel.elements;

    private final boolean isGradual;


    private int limit;

    public CarouselRun(boolean isGradual) {
        this.isGradual = isGradual;

        index = 0;
        limit = DecrementingCarouselWithLimitedRun.limit;

    }

    public int next() {
        if (isGradual) {
            int result;
            if (isFinished()) return -1;//sus maybe in loop
            while (true) {
                if (index >= arr.length) {
                    index = 0;
                }
                if (arr[index] == 0) {
                    index++;
                    continue;
                }

                result = arr[index];
                arr[index] = arr[index] - 1;
                index++;
                limit--;
                if (limit == 0) Arrays.fill(arr, 0);
                break;
            }
            return result;
        } else {
            int result;
            if (isFinished()) return -1;//sus maybe in loop
            while (true) {
                if (index >= arr.length) {
                    index = 0;
                }
                if (arr[index] == 0) {
                    index++;
                    continue;
                }

                result = arr[index];
                arr[index] = arr[index] - 1;
                index++;
                break;
            }
            return result;
        }
    }

    public boolean isFinished() {
        for (int a : arr) if (a != 0) return false;
        return true;
    }
}
