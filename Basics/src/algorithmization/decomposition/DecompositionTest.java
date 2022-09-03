package algorithmization.decomposition;

import java.util.Arrays;

public class DecompositionTest {

    public static void main(String[] args) {
        int[] givenArray = {21, 3, 14, 56, 6, 9, 23, 20, 7, -3};
        Decomposition decomposition = new Decomposition();
        System.out.println("Задание 1. Найти НОД и НОК двух натуральных чисел");
        System.out.printf("Given numbers: %d, %d\n", 15, 220);
        System.out.println(decomposition.checkEqualityWithLcmAndGcd(15, 220));

        System.out.println("Задание 2. Найти НОД для ЧЕТЫРЕХ натуральных чисел");
        System.out.printf("Given numbers: %s\n", Arrays.toString(new int[]{1148, 124, 2152, 604}));
        System.out.printf("GCD for numbers: %d\n", decomposition.findGcdFor4Number(1148, 124, 2152, 604));

        System.out.println("Задание 3. Найти площадь правильного шестиугольника со стороной A, используя формулу площади треугольника");
        System.out.printf("Result if side = 5: %.2f\n", decomposition.getHexagonSquare(5));

        System.out.println("Задание 4. Определить максимальное расстояние между заданными координатами точек");
        Point[] points = {
        new Point("a", -3, 1),
        new Point("b", 3, 5),
        new Point("c", -4, 0),
        new Point("d", -4, -4),
        new Point("e", 0, 0)
        };
        System.out.printf("Given points: %s\n", Arrays.toString(points));
        System.out.printf("Result: %s\n", decomposition.findMaxDistanceBetweenPoints(points));

        System.out.println("Задание 5. Найти ВТОРОЕ по величине число в массиве после максимального");
        System.out.printf("Given array: %s\n", Arrays.toString(givenArray));
        System.out.printf("Result: %s\n", decomposition.findSecondMaxNumber(givenArray));

        System.out.println("Задание 6. Проверить, являются ли три числа взаимно простыми");
        System.out.printf("Given numbers: %d, %d, %d\n", 41, 2, 52);
        System.out.printf("Result: %s\n", decomposition.isRelativelyPrime(41, 2, 52));

        System.out.println("Задание 7. Вычислить сумму факториалов всех нечетных чисел от 1 до 9");
        System.out.printf("Result: %d\n", decomposition.findSumOfFactorials());

        System.out.println("Задание 8. Определить суммы трех последовательно расположенных членов массива с номерами от k до m");
        System.out.printf("Given array: %s\n", Arrays.toString(givenArray));
        System.out.printf("Indexes: %d, %d\n", 2, 5);
        System.out.printf("Result: %s\n", decomposition.findArrayItemsSumBetween(givenArray, 2, 5));

        System.out.println("Задание 9. Определить площадь четырехугольника, если известны его стороны, две из которых образуют прямой угол");
        System.out.printf("Sides: %.2f, %.2f, %.2f, %.2f\n", 3.0, 5.0, 7.0, 9.0);
        System.out.printf("Result: %.2f\n", decomposition.getTetragonSquare(3, 5, 7, 9));

        System.out.println("Задание 10. Сформировать массив из цифер числа N");
        System.out.printf("Number: %d\n", 213457980);
        System.out.printf("Result: %s\n", Arrays.toString(decomposition.getArrayFromDigitsOfNumber(213457980)));

        System.out.println("Задание 11. Определить, в каком из двух чисел больше цифр");
        System.out.printf("Numbers: %d, %d\n", 21345, 34568789);
        System.out.printf("Result: %d\n", decomposition.findNumberWithMaxDigitsAmong(21345, 34568789));

        System.out.println("Задание 12. Сформировать массив А с числами, сумма цифр которых равна К, сами числа не больше N");
        System.out.printf("Digit sum is %d, number limit is %d\n", 10, 500);
        System.out.printf("Result: %s\n", Arrays.toString(decomposition.getArrayWithNumberIf(10, 500)));

        System.out.println("Задание 13. Напечать все пары ПРОСТЫХ чисел-БЛИЗНЕЦОВ (их РАЗНОСТЬ равна 2) на отрезке [n, 2n]");
        System.out.printf("Range: [%d, %d]\n", 1, 500);
        System.out.println("Result: ");
        decomposition.findPrimeTwinsNumberBetween(1, 500);

        System.out.println("Задание 14. Найти числа Армстронга (равно сумме своих цифр, возведённых в степень, равную " +
                "количеству его цифр) в диапазоне от 1 до K");
        System.out.println("Result: ");
        decomposition.getArmstrongNumbersUntilRangeTo(10000);

        System.out.println("Задание 15. Найти n-значные возрастающие числа, цифры образуют строго возрастающую последовательность (1234, 5678)");
        System.out.printf("Digit count in number: %d\n", 4);
        System.out.printf("Result: %s\n", Arrays.toString(decomposition.getNumbersWithAscSequenceOfDigits(4)));

        System.out.println("Задание 16. Определить сумму n-значных чисел, содержащих только нечетные цифры." +
                "Подсчитать количество четных цифр в найденной сумме.");
        System.out.printf("Digit count in number: %d\n", 3);
        decomposition.findNumbersWithOddDigitsSumAndCountEvenDigitsInResult(3);

        System.out.println("Задание 17. Из заданного числа вычитать сумму чисел до тех пор, пока в результате не будет 0." +
                "Подсчитать количество таких операций");
        System.out.printf("Number: %d\n", 2134);
        System.out.printf("Subtraction count: %d\n", decomposition.countSubtractionsOfNumberAndSumOfItsDigits(2134));




    }


}
