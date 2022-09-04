package com.epam.rd.autotasks.intersection;

public class Line {
    private final int k;
    private final int b;

    public int getK() {
        return k;
    }

    public int getB() {
        return b;
    }

    public Line(int k, int b) {
        this.k = k;
        this.b = b;
    }

    //not intersecting if k1==k2
    public Point intersection(Line other) {
        if (other.getK() == this.k) {
            return null;
        } else {
            int x = (other.getB() - this.b) / (this.k - other.getK());
            int y = (this.k * x + this.b);
            return new Point(x, y);
        }
    }

}
