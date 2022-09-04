package com.epam.rd.autotasks.triangle;

class Triangle {

    private final Point a;
    private final Point b;
    private final Point c;

    public Triangle(Point a, Point b, Point c) {
        if (a != null && b != null && c != null
                && (b.getY() - a.getY()) / (b.getX() - a.getX()) != (c.getY() - a.getY()) / (c.getX() - a.getX())
                && Math.sqrt((b.getY() - a.getY()) * (b.getY() - a.getY()) + (b.getX() - a.getX()) * (b.getX() - a.getX())) != 0
        ) {
            this.a = a;
            this.b = b;
            this.c = c;
        } else {
            throw new RuntimeException();
        }
    }

    /**
     * int a = Q.second - P.second;
     * int b = P.first - Q.first;
     * int c = a * (P.first) + b * (P.second);
     * <p>
     * if (b < 0) {
     * System.out.println(
     * "The line passing through points P and Q is: "
     * + a + "x - " + b + "y = " + c);
     * }
     * else {
     * System.out.println(
     * "The line passing through points P and Q is: "
     * + a + "x + " + b + "y = " + c);
     * }
     */
    public double area() {
        //line
        double A = Math.sqrt((b.getY() - a.getY()) * (b.getY() - a.getY()) + (b.getX() - a.getX()) * (b.getX() - a.getX()));
        double B = Math.sqrt((b.getY() - c.getY()) * (b.getY() - c.getY()) + (b.getX() - c.getX()) * (b.getX() - c.getX()));
        double C = Math.sqrt((c.getY() - a.getY()) * (c.getY() - a.getY()) + (c.getX() - a.getX()) * (c.getX() - a.getX()));

        double k1 = (b.getY() - a.getY()) / (b.getX() - a.getX());
        double k2 = (c.getY() - a.getY()) / (c.getX() - a.getX());

        double p = (A + B + C) / 2;

        return Math.sqrt(p * (p - A) * (p - B) * (p - C));
    }

    public Point centroid() {
        //TODO
        return new Point(((a.getX() + b.getX() + c.getX()) / 3), ((a.getY() + b.getY() + c.getY()) / 3));
    }

}
