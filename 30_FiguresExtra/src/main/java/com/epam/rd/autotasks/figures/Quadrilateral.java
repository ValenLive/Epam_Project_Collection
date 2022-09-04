package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure {

    private final Point a;
    private final Point b;
    private final Point c;
    private final Point d;

    public Quadrilateral(Point point1, Point point2, Point point3, Point point4) {
        if (point1 != null && point2 != null && point3 != null && point4 != null
                && (point2.getY() - point1.getY()) / (point2.getX() - point1.getX()) != (point3.getY() - point1.getY()) / (point3.getX() - point1.getX())
                && Math.sqrt((point2.getY() - point1.getY()) * (point2.getY() - point1.getY()) + (point2.getX() - point1.getX()) * (point2.getX() - point1.getX())) != 0
        && isConvex(point1, point2, point3, point4)) {
            this.a = point1;
            this.b = point2;
            this.c = point3;
            this.d = point4;
        } else {
            throw new IllegalArgumentException();
        }
    }


    @Override
    public Point centroid() {
        double[][] v = {{a.getX(), a.getY()}, {b.getX(), b.getY()}, {c.getX(), c.getY()}, {d.getX(), d.getY()}};
        double[] ans = new double[2];

        int n = v.length;
        double signedArea = 0;

        for (int i = 0; i < n; i++) {

            double x0 = v[i][0], y0 = v[i][1];
            double x1 = v[(i + 1) % n][0], y1 = v[(i + 1) % n][1];

            double A = (x0 * y1) - (x1 * y0);
            signedArea += A;

            ans[0] += (x0 + x1) * A;
            ans[1] += (y0 + y1) * A;
        }

        signedArea *= 0.5;
        ans[0] = (ans[0]) / (6 * signedArea);
        ans[1] = (ans[1]) / (6 * signedArea);

        return new Point(ans[0], ans[1]);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (figure.centroid().getX() != this.centroid().getX()) return false;
        return figure.centroid().getY() == this.centroid().getY();
    }

    private boolean isConvex(Point a, Point b, Point c, Point d){
        double[][] points = {{a.getX(), a.getY()}, {b.getX(), b.getY()}, {c.getX(), c.getY()}, {d.getX(), d.getY()}};

        int N = points.length;

        // Stores direction of cross product
        // of previous traversed edges
        double prev = 0;

        // Stores direction of cross product
        // of current traversed edges
        double curr;

        // Traverse the array
        for (int i = 0; i < N; i++) {

            // Stores three adjacent edges
            // of the polygon
            double[][] temp = { points[i],
                    points[(i + 1) % N],
                    points[(i + 2) % N] };

            // Update curr
            curr = CrossProduct(temp);

            // If curr is not equal to 0
            if (curr != 0) {

                // If direction of cross product of
                // all adjacent edges are not same
                if (curr * prev < 0) {
                    return false;
                }
                else {
                    // Update curr
                    prev = curr;
                }
            }
        }
        return true;
    }
    private double CrossProduct(double A[][])
    {
        // Stores coefficient of X
        // direction of vector A[1]A[0]
        double X1 = (A[1][0] - A[0][0]);

        // Stores coefficient of Y
        // direction of vector A[1]A[0]
        double Y1 = (A[1][1] - A[0][1]);

        // Stores coefficient of X
        // direction of vector A[2]A[0]
        double X2 = (A[2][0] - A[0][0]);

        // Stores coefficient of Y
        // direction of vector A[2]A[0]
        double Y2 = (A[2][1] - A[0][1]);

        // Return cross product
        return (X1 * Y2 - Y1 * X2);
    }
}
