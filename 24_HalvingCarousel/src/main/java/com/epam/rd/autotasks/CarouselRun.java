package com.epam.rd.autotasks;

class CarouselRun {
    public int index = 0;
    public int[] arr = DecrementingCarousel.elements;

    private final boolean isHalf;

    public CarouselRun(boolean isHalfF) {
        isHalf = isHalfF;
    }

    public int next() {
        if (isHalf) {
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
                arr[index] = arr[index] / 2;
                index++;
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
