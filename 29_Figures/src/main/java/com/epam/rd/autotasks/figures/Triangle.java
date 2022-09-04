package com.epam.rd.autotasks.figures;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

class Triangle extends Figure {
    private final Point a;
    private final Point b;
    private final Point c;

    public Triangle(Point point1, Point point2, Point point3) {
        this.a = point1;
        this.b = point2;
        this.c = point3;
    }

    @Override
    public double area() {
        double A = Math.sqrt((b.getY() - a.getY()) * (b.getY() - a.getY()) + (b.getX() - a.getX()) * (b.getX() - a.getX()));
        double B = Math.sqrt((b.getY() - c.getY()) * (b.getY() - c.getY()) + (b.getX() - c.getX()) * (b.getX() - c.getX()));
        double C = Math.sqrt((c.getY() - a.getY()) * (c.getY() - a.getY()) + (c.getX() - a.getX()) * (c.getX() - a.getX()));

        double p = (A + B + C) / 2;

        return Math.sqrt(p * (p - A) * (p - B) * (p - C));
    }

    @Override
    public String pointsToString() {
        return "(" + a.getX() + "," + a.getY() + ")" + "(" + b.getX() + "," + b.getY() + ")" + "(" + c.getX() + "," + c.getY() + ")";
    }

    @Override
    public Point leftmostPoint() {
        return Stream.of(a, b, c)
                .min(Comparator.comparing(Point::getX))
                .orElseThrow(NoSuchElementException::new);
    }
}
