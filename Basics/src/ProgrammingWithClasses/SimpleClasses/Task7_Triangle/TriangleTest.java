package ProgrammingWithClasses.SimpleClasses.Task7_Triangle;

public class TriangleTest {
    public static void main(String[] args) {
        Point pointA = new Point(-4, 1);
        Point pointB = new Point(5, 4);
        Point pointC = new Point(2, -3);
        Triangle triangle = new Triangle(pointA, pointB, pointC);

        System.out.printf("Triangle perimeter is: %f\n", triangle.getTriangleSquare());
        System.out.printf("Triangle perimeter is: %f\n", triangle.getTrianglePerimeter());
        System.out.println(triangle.getMedianCrossPoint());

    }
}

