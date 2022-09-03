package algorithmization.decomposition;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Decomposition {

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

    public String findMaxDistanceBetweenPoints(Point[] points) {
        Point firstPoint = null;
        Point secondPoint = null;
        double maxDistance = Double.MIN_VALUE;
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double distance = getDistanceFromPoint(points[i], points[j]);
                System.out.printf("distance between %s and %s -> %.3f\n", points[i].getName(), points[j].getName(), distance);
                if (distance > maxDistance) {
                    maxDistance = distance;
                    firstPoint = points[i];
                    secondPoint = points[j];
                }
            }
        }
        return String.format("max distance %.3f, between %s and %s", maxDistance, firstPoint, secondPoint);
    }

    private double getDistanceFromPoint(Point point1, Point point2) {
        return Math.sqrt(Math.pow((point1.getCoordinateX() - point2.getCoordinateX()), 2) +
                Math.pow((point1.getCoordinateY() - point2.getCoordinateY()), 2));
    }

    /*
    Найти ВТОРОЕ по величине число в массиве после максимального
    Вывести на печать
    (Задание 5)
     */
    public int findSecondMaxNumber(int[] array) {
        int maxNumber = findMaxNumber(array);
        int secondMaxNumber = Integer.MIN_VALUE;
        for (int j : array) {
            if (j != maxNumber && j > secondMaxNumber) {
                secondMaxNumber = j;
            }
        }
        return secondMaxNumber;
    }

    private int findMaxNumber(int[] array) {
        int maxNumber = Integer.MIN_VALUE;
        for (int j : array) {
            if (j > maxNumber) {
                maxNumber = j;
            }
        }
        return maxNumber;
    }

    /*
    Проверить, являются ли три числа взаимно простыми
    (Задание 6)
     */
    public boolean isRelativelyPrime(int number1, int number2, int number3) {
        return findGreatestCommonDivisorFor(number1, findGreatestCommonDivisor(number2, number3)) == 1;
    }

    /*
    Вычислить сумму факториалов всех нечетных чисел от 1 до 9
    (Задание 7)
     */
    public long findSumOfFactorials() {
        int from = 1;
        int to = 9;
        int sum = 0;
        for (int i = from; i < to; i++) {
            sum += findFactorial(i);
        }
        return sum;
    }

    private int findFactorial(int number) {
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }

    /*
    Определить суммы трех последовательно расположенных членов массива с номерами от k до m
    (Задача 8)
     */
    public String findArrayItemsSumBetween(int[] array, int firstIndex, int secondIndex) {
        List<Integer> sumList = new ArrayList<>();
        if (firstIndex < array.length - 2 && secondIndex < array.length - 2) {
            for (int i = firstIndex; i <= secondIndex; i++) {
                sumList.add((findSumOfThreeNumberFrom(array, i)));
            }
        }
        return (!sumList.isEmpty()) ? sumList.stream().map(String::valueOf).collect(Collectors.joining(" "))
        : "Calculation is not possible! Enter other couple of indexes!";
    }

    private int findSumOfThreeNumberFrom(int[] array, int index) {
        return array[index] + array[index + 1] + array[index + 2];
    }

    /*
    Определить площадь четырехугольника, если известны его стороны, две из которых образуют прямой угол
    (Задание 9)
     */
    public double getTetragonSquare(double side1, double side2, double side3, double side4) {
        double hypotenuse = Math.hypot(side1, side2);
        return findTriangleSquareBySides(side1, side2, hypotenuse)
                + findTriangleSquareBySides(hypotenuse, side3, side4);
    }

    private double findTriangleSquareBySides(double side1, double side2, double side3) {
        double halfPerimeter = (side1 + side2 + side3) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - side1) * (halfPerimeter - side2) * (halfPerimeter - side3));
    }

    /*
    Сформировать массив из цифер числа N (Задание 10)
     */
    public int[] getArrayFromDigitsOfNumber(int number) {
        int[] array = new int[countDigitsInNumber(number)];
        for (int i = array.length - 1; i >= 0; i--) {
            if (number >= 10) {
                array[i] = number % 10;
                number /= 10;
            } else {
                array[i] = number;
            }
        }
        return array;
    }

    private int countDigitsInNumber(int number) {
        int item = number;
        int digitCount = 0;
        while (item != 0) {
            item /= 10;
            digitCount++;
        }
        return digitCount;
    }

    /*
    Определить, в каком из двух чисел больше цифр
    (Задание 11)
     */
    public int findNumberWithMaxDigitsAmong(int number1, int number2) {
        return (countDigitsInNumber(number1) > countDigitsInNumber(number2)) ? number1 : number2;
    }

    /*
    Сформировать массив А с числами, сумма цифр которых равна К, сами числа не больше N
    (Задание 12)
     */
    public Integer[] getArrayWithNumberIf(int digitsSum, int numberLimit) {
        List<Integer> numberList = new ArrayList<>();
        for (int i = 1; i <= numberLimit; i++) {
            if (getSumOfNumberDigits(i) == digitsSum) {
                numberList.add(i);
            }
        }
        return numberList.toArray(new Integer[0]);
    }

    private int getSumOfNumberDigits(int number) {
        int item = number;
        int digitSum = 0;
        while (item != 0) {
            digitSum += (item >= 10) ? item % 10 : item;
            item /= 10;
        }
        return digitSum;
    }

    /*
    Напечать все пары ПРОСТЫХ чисел-БЛИЗНЕЦОВ (их РАЗНОСТЬ равна 2) на отрезке [n, 2n]
    (Задание 13)
     */
    public void findPrimeTwinsNumberBetween(int start, int end) {
        int previousPrime = 2;
        for (int i = start; i <= end; i++) {
            if (isPrimeNumber(i)) {
                if (i - previousPrime == 2) {
                    System.out.println(previousPrime + " " + i);
                }
                previousPrime = i;
            }
        }
    }

    private boolean isPrimeNumber(int number) {
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /*
    Найти числа Армстронга (равно сумме своих цифр, возведённых в степень, равную количеству его цифр в диапазоне от 1 до K
    (Задание 14)
     */
    public void getArmstrongNumbersUntilRangeTo(int to) {
        for (int i = 1; i < to; i++) {
            if (isArmstrongNumber(i)) {
                System.out.print(i + " ");
            }
        }
    }

    private boolean isArmstrongNumber(int number) {
        int numberCount = countDigitsInNumber(number);
        int item = number;
        int digitSum = 0;
        while (item != 0) {
            digitSum += (item >= 10) ? (int) Math.pow(item % 10, numberCount) : (int) Math.pow(item, numberCount);
            item /= 10;
        }
        return digitSum == number;
    }

    /*
    Найти n-значные возрастающие числа, цифры образуют строго возрастающую последовательность (1234, 5678)
    (Задание 15)
     */
    public Long[] getNumbersWithAscSequenceOfDigits(int digitsCount) {
        List<Long> numberList = new ArrayList<>();
        for (long i = (long) Math.pow(10, digitsCount - 1); i < (long) Math.pow(10, digitsCount); i++) {
            if(isAscDigitsSequence(i)) {
                numberList.add(i);
            }
        }
        return numberList.toArray(new Long[0]);
    }

    private boolean isAscDigitsSequence(long number) {
        long item = number;
        long previousDigit = item % 10;
        item /= 10;
        while (item != 0) {
            if (previousDigit - item % 10 != 1) {
                return false;
            }
            previousDigit = item % 10;
            item /= 10;
        }
        return true;
    }

    /*
    Определить сумму n-значных чисел, содержащих только нечетные цифры.
    Подсчитать количество четных цифр в найденной сумме.
    (Задание 16)
     */
    public void findNumbersWithOddDigitsSumAndCountEvenDigitsInResult(int digitsCount) {
        long sum = 0;
        for (long i = (long) Math.pow(10, digitsCount - 1); i < (long) Math.pow(10, digitsCount); i++) {
            if(isNumberWithOddDigits(i)) {
                sum += i;
                System.out.print(i + " ");
            }
        }
        System.out.println();
        System.out.printf("Result: sum is %d\n", sum);
        System.out.printf("Count of even digits in sum: %d\n", countEvenDigitsIn(sum));
    }

    private int countEvenDigitsIn(long number) {
        long item = number;
        int digitsCount = 0;
        while(item != 0) {
            if((item % 10) % 2 == 0) {
                digitsCount++;
            }
            item /= 10;
        }
        return digitsCount;
    }

    private boolean isNumberWithOddDigits(long number) {
        long item = number;
        while (item != 0) {
            if ((item % 10) % 2 == 0) {
                return false;
            }
            item /= 10;
        }
        return true;
    }

    /*
    Из заданного числа вычитать сумму чисел до тех пор, пока в результате не будет 0.
    Подсчитать количество таких операций
    (Задание 17)
     */
    public int countSubtractionsOfNumberAndSumOfItsDigits(int number) {
        int result = Integer.MIN_VALUE;
        int subtractionCount = 0;
        while(result != 0) {
            int digitSum = getSumOfNumberDigits(number);
            result = number - digitSum;
            System.out.printf("%d = %d - %d\n", result, number, digitSum);
            subtractionCount++;
            number = result;
        }
        return subtractionCount;
    }
}



