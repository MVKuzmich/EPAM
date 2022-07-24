package Algorithmization.Decomposition;


public class Decomposition {
    public static void main(String[] args) {
        Point a = new Point("A",2, 2);
        Point b = new Point("B", 3, 5);
        Point c = new Point ("C", -8, 2);
        Point d = new Point("D", -1, -8);
        Point[] points = {a, b, c, d};

        System.out.println(new Decomposition().findMaxDistanceBetweenPoints(points));
    }


    /*
        Найти НОД и НОК двух натуральных чисел (Задание 1)
     */
    private int findGreatestCommonDivisor(int number1, int number2) {
        int gcd = 1;
        for (int i = 1; i <= number1 && i <= number2; i++) {
            if (number1 % i == 0 && number2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    private int findLeastCommonMultiple(int number1, int number2) {
        if (number1 == 0 || number2 == 0) {
            return 0;
        }
        int higherNumber = Math.max(number1, number2);
        int lowerNumber = Math.min(number1, number2);
        int commonMultiple = higherNumber;
        while (commonMultiple % lowerNumber != 0) {
            commonMultiple += higherNumber;
        }
        return commonMultiple;
    }

    public boolean checkEqualityWithLcmAndGcd(int number1, int number2) {
        int lcm = findLeastCommonMultiple(number1, number2);
        int gcd = findGreatestCommonDivisor(number1, number2);
        System.out.printf("НОД(%d, %d) -> %d", number1, number2, gcd);
        System.out.println();
        System.out.printf("НОK(%d, %d) -> %d", number1, number2, lcm);
        System.out.println();
        return lcm == number1 * number2 / gcd;
    }

    /*
    Найти НОД для ЧЕТЫРЕХ натуральных чисел (Задача 2)
     */
    public int findGcdFor4Number(int number1, int number2, int number3, int number4) {
        int[] array = {number1, number2, number3, number4};
        int gcd = array[0];
        for (int i = 1; i < array.length; i++) {
            gcd = findGreatestCommonDivisorFor(gcd, array[i]);
        }
        return gcd;
    }

    private int findGreatestCommonDivisorFor(int number1, int number2) {
        int gcd = 1;
        for (int i = 1; i <= number1 && i <= number2; i++) {
            if (number1 % i == 0 && number2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    /*
    Найти площадь правильного шестиугольника со стороной A, используя формулу площади треугольника
    (Задание 3)
     */
    public double getHexagonSquare(int side) {
        return 6 * getTriangleSquareByIfGivenSides(side);
    }

    private double getTriangleSquareByIfGivenSides(int side) {
        return Math.pow(side, 2) * Math.sqrt(3) / 4;
    }

    /*
    Определить максимальное расстояние между заданными координатами точек
    AB = √(xb - xa)^2 + (yb - ya)^2
    (Задание 4)
     */

    public double findMaxDistanceBetweenPoints(Point[] points) {
        double maxDistance = Double.MIN_VALUE;
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double distance = getDistanceFromPoint(points[i], points[j]);
                System.out.printf("расстояние между %s и %s -> %.3f\n", points[i].name, points[j].name, distance);
                if (distance > maxDistance) {
                    maxDistance = distance;
                }
            }
        }
        return maxDistance;
    }

    private double getDistanceFromPoint(Point point1, Point point2) {
        return Math.sqrt(Math.pow((point1.coordinateX - point2.coordinateX), 2) +
                Math.pow((point1.coordinateY - point2.coordinateY), 2));
    }

    private static class Point {
        private final String name;
        private final int coordinateX;
        private final int coordinateY;

        public Point(String name, int coordinateX, int coordinateY) {
            this.name = name;
            this.coordinateX = coordinateX;
            this.coordinateY = coordinateY;
        }
    }
}


