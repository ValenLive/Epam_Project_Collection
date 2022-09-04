package com.epam.rd.autotasks;

public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel{
    public static int limit;


    public DecrementingCarouselWithLimitedRun(final int capacity, final int actionLimit) {
        super(capacity);
        limit = actionLimit;
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
