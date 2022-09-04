package com.epam.rd.autotasks.figures;

class Circle extends Figure {

    private final Point point;

    private final double radius;

    public Circle(Point point, double radius) {
        this.point = point;
        this.radius = radius;
    }


    @Override
    public double area() {
        double pi = 3.141592653589793;
        return pi * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[" + pointsToString() + radius + "]";
    }

    @Override
    public String pointsToString() {
        return "(" + point.getX() + "," + point.getY() + ")";
    }

    @Override
    public Point leftmostPoint() {
        return new Point(point.getX() - radius, point.getY());
    }
}
