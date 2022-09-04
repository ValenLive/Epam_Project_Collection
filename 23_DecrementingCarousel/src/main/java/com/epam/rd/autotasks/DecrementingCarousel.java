package com.epam.rd.autotasks;

public class DecrementingCarousel {

    public boolean isRunning;
    public int count;

    public static int[] elements;



    public DecrementingCarousel(int size) {
        this.isRunning = false;
        this.count = 0;
        elements = new int[size];
    }

    public boolean addElement(int element) {
        if (!isRunning && element > 0 && count < elements.length) {
            elements[count] = element;
            this.count++;
            return true;
        } else {
            return false;
        }
    }

    public CarouselRun run() {
        if (!isRunning) {
            isRunning = true;
            return new CarouselRun();
        } else {
            return null;
        }
    }
}
