package com.epam.rd.autotasks.figures;

class Triangle extends Figure{

    private final Point a;
    private final Point b;
    private final Point c;

    public Triangle(Point point1, Point point2, Point point3) {
        if (point1 != null && point2 != null && point3 != null
                && (point2.getY() - point1.getY()) / (point2.getX() - point1.getX()) != (point3.getY() - point1.getY()) / (point3.getX() - point1.getX())
                && Math.sqrt((point2.getY() - point1.getY()) * (point2.getY() - point1.getY()) + (point2.getX() - point1.getX()) * (point2.getX() - point1.getX())) != 0
        ) {
            this.a = point1;
            this.b = point2;
            this.c = point3;
        } else {
            throw new IllegalArgumentException();
        }
    }


    @Override
    public Point centroid() {
        return new Point(((a.getX() + b.getX() + c.getX()) / 3), ((a.getY() + b.getY() + c.getY()) / 3));
    }

    @Override
    public boolean isTheSame(Figure figure) {
        return false;
    }
}
