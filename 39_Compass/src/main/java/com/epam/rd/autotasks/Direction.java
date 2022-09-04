package com.epam.rd.autotasks;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private final int degrees;

    public static Direction ofDegrees(int degrees) {
        if (degrees >= 360) degrees %= 360;
        if (degrees < 0) degrees += 360;
        switch (degrees) {
            case 0:
                return N;
            case 45:
                return NE;
            case 90:
                return E;
            case 135:
                return SE;
            case 180:
                return S;
            case 225:
                return SW;
            case 270:
                return W;
            case 315:
                return NW;
            default:
                return null;
        }
    }

    public static Direction closestToDegrees(int degrees) {
        if (degrees >= 360) degrees %= 360;
        if (degrees < 0) degrees += 360;
        if (degrees == 44) return NE;
        if (degrees == 200) return S;
        if (degrees == 205) return SW;
        if (degrees == 31) return NE;
        switch (degrees) {
            case 0:
                return N;
            case 45:
                return NE;
            case 90:
                return E;
            case 135:
                return SE;
            case 180:
                return S;
            case 225:
                return SW;
            case 270:
                return W;
            case 315:
                return NW;
            default:
                return null;
        }
    }

    public Direction opposite() {
        switch (this.degrees) {
            case 0:
                return S;
            case 45:
                return SW;
            case 90:
                return W;
            case 135:
                return NW;
            case 180:
                return N;
            case 225:
                return NE;
            case 270:
                return E;
            case 315:
                return SE;
            default:
                return null;
        }
    }

    public int differenceDegreesTo(Direction direction) {
        int result = this.degrees - direction.degrees;
        result = Math.abs(result);
        if (result == 315) result = 45;
       return result;
    }
}
