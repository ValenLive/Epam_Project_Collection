package com.epam.rd.autotasks.segments;

class Segment {
    private final Point start;
    private final Point end;

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public Segment(Point start, Point end) {
        if (start.getX() == end.getX() && start.getY() == end.getY()) {
            throw new RuntimeException();
        } else {
            this.start = start;
            this.end = end;
        }
    }

    double length() {
        return Math.sqrt(StrictMath.pow(end.getX() - start.getX(), 2) + StrictMath.pow(end.getY() - start.getY(), 2));
    }

    Point middle() {
        return new Point((start.getX() + end.getX()) / 2, (start.getY() + end.getY()) / 2);
    }

    /**
     * k1 = (y2-y1)/(x2-x1)
     * b1 = y1 - k1 * x1
     * k2 = (y4-y3)/(x4-x3)
     * b2 = y3 - k2 * x3
     */
    
    Point intersection(Segment another) {
        if (another.equals(this)) {
            throw new IllegalArgumentException();
        } else {
            double k1 = (end.getY() - start.getY()) / (end.getX() - start.getX());
            double b1 = start.getY() - k1 * start.getX();

            double k2 = (another.getEnd().getY() - another.getStart().getY()) / (another.getEnd().getX() - another.getStart().getX());
            double b2 = another.getStart().getY() - k2 * another.getStart().getX();

            System.out.println("This segment start: " + start);
            System.out.println("This segment end: " + end);

            System.out.println("Another segment start: " + another.getStart());
            System.out.println("Another segment end: " + another.getEnd());

            System.out.println("k1 = " + k1);
            System.out.println("k2 = " + k2);
            System.out.println("b1 = " + b1);
            System.out.println("b2 = " + b2);

            if (k1 == k2) {
                return null;
            } else {
                double x = (b2 - b1) / (k1 - k2);
                double y = (k1 * x + b1);
                if (x >= Math.min(start.getX(), end.getX())
                        && x <= Math.max(start.getX(), end.getX())
                        && x >= Math.min(another.getStart().getX(), another.getEnd().getX())
                        && x <= Math.max(another.getStart().getX(), another.getEnd().getX())) {
                    return new Point(x, y);
                } else {
                    return null;
                }
            }
        }
    }

}
