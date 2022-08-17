package programming_with_classes.simple_classes.task7_triangle;

public class Triangle {
    Point pointA;
    Point pointB;
    Point pointC;

    public Triangle(Point pointA, Point pointB, Point pointC) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    public double getTrianglePerimeter() {
        return getSideLength(pointA, pointB) + getSideLength(pointB, pointC) + getSideLength(pointA, pointC);
    }

    public double getTriangleSquare() {
        double halfPerimeter = getTrianglePerimeter() / 2;
        return Math.sqrt(halfPerimeter *
                (halfPerimeter - getSideLength(pointA, pointB)) *
                (halfPerimeter - getSideLength(pointA, pointC)) *
                (halfPerimeter - getSideLength(pointB, pointC))
        );
    }

    public Point getMedianCrossPoint() {
        double crossPointCoordinateX = (pointA.getCoordinateX() + pointB.getCoordinateX() + pointC.getCoordinateX()) / 3;
        double crossPointCoordinateY = (pointA.getCoordinateY() + pointB.getCoordinateY() + pointC.getCoordinateY()) / 3;
        return new Point(crossPointCoordinateX, crossPointCoordinateY);
    }

    private double getSideLength(Point point1, Point point2) {
        return Math.sqrt(Math.pow(point2.getCoordinateX() - point1.getCoordinateX(), 2) + Math.pow(point2.getCoordinateY() - point1.getCoordinateY(), 2));

    }
}
