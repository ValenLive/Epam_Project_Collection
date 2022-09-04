package com.epam.rd.autotasks;

public class GraduallyDecreasingCarousel extends DecrementingCarousel{
    public GraduallyDecreasingCarousel(final int capacity) {
        super(capacity);
    }
    @Override
    public CarouselRun run(){
        if (!isRunning) {
            isRunning = true;
            return new CarouselRun(true);
        } else {
            return null;
        }
    }
}
