package com.epam.rd.autotasks;

public class CarouselRun {
    int position = 0;

    public int next() {
        int count = 0;
        while (count < DecrementingCarousel.elements.length && DecrementingCarousel.elements[position %= DecrementingCarousel.elements.length] <= 0) {
            position++;
            count++;
        }
        if (count == DecrementingCarousel.elements.length) return -1;
        return DecrementingCarousel.elements[position++]--;
    }
    public boolean isFinished() {
        for(int a : DecrementingCarousel.elements) if(a != 0) return false;
        return true;
    }
}
