package com.epam.rd.autotasks.figures;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

class Quadrilateral extends Figure {

    private final Point a;
    private final Point b;
    private final Point c;
    private final Point d;

    public Quadrilateral(Point point1, Point point2, Point point3, Point point4) {
        this.a = point1;
        this.b = point2;
        this.c = point3;
        this.d = point4;
    }


    @Override
    public double area() {
        double L = Math.sqrt((c.getY() - a.getY()) * (c.getY() - a.getY()) + (c.getX() - a.getX()) * (c.getX() - a.getX()));//AC = L

        double A = Math.sqrt((b.getY() - a.getY()) * (b.getY() - a.getY()) + (b.getX() - a.getX()) * (b.getX() - a.getX()));//AB
        double B = Math.sqrt((b.getY() - c.getY()) * (b.getY() - c.getY()) + (b.getX() - c.getX()) * (b.getX() - c.getX()));//CB

        double p1 = (A + B + L) / 2;
        double area1 = Math.sqrt(p1 * (p1 - A) * (p1 - B) * (p1 - L));

        double C = Math.sqrt((d.getY() - a.getY()) * (d.getY() - a.getY()) + (d.getX() - a.getX()) * (d.getX() - a.getX()));//AD
        double D = Math.sqrt((d.getY() - c.getY()) * (d.getY() - c.getY()) + (d.getX() - c.getX()) * (d.getX() - c.getX()));//CD

        double p2 = (C + D + L) / 2;
        double area2 = Math.sqrt(p2 * (p2 - C) * (p2 - D) * (p2 - L));

        return area1 + area2;
    }

    @Override
    public String pointsToString() {
        return "(" + a.getX() + "," + a.getY() + ")" + "(" + b.getX() + "," + b.getY() + ")" + "(" + c.getX() + "," + c.getY() + ")" + "(" + d.getX() + "," + d.getY() + ")";
    }

    @Override
    public Point leftmostPoint() {
        return Stream.of(a, b, c, d)
                .min(Comparator.comparing(Point::getX))
                .orElseThrow(NoSuchElementException::new);
    }
}
