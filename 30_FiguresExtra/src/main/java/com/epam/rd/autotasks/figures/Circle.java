package com.epam.rd.autotasks.figures;

class Circle extends Figure {
    private final Point point;

    private final double radius;

    public Circle(Point point, double radius) {
        if (point != null && radius > 0) {
            this.point = point;
            this.radius = radius;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Point centroid() {
        return point;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (!(figure instanceof Circle)) return false;
        Circle c = (Circle) figure;
        double epsilon = 0.00000000001d;
        if (Math.abs(this.centroid().getX() - c.centroid().getX()) >= epsilon) return false;
        if (Math.abs(this.centroid().getY() - c.centroid().getY()) >= epsilon) return false;
        return !(Math.abs(this.getRadius() - c.getRadius()) >= epsilon);
    }

}
