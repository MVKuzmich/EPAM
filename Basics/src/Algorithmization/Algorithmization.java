package Algorithmization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algorithmization {

    public static void main(String[] args) {
        double[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}; //35
        int number = 10;
        System.out.println(getItemSumIfIndexPrime(arr));
        ;

    }

    /*
    ОДНОМЕРНЫЕ МАССИВЫ
     */
    //Найти сумму членов массива, кратных K (Задание 1)
    public static int getSumArrayMemberDividedBy(int[] array, int number) {
        int sum = 0;
        for (int i : array) {
            if (i % number == 0) {
                sum += i;
            }
        }
        return sum;
    }

    //Заменить все члены,больше Z, на само Z, подсчитать количество замен (Задание 2)
    public static int replaceIfGreaterThanAndCount(double[] array, double number) {
        int countReplace = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > number) {
                array[i] = number;
                countReplace++;
            }
        }
        return countReplace;
    }

    //Подсчитать отрицательные, положительные и нулевые элементы массива (Задание 3)
    public static String countPositiveNegativeNullable(double[] array) {
        int countPositive = 0;
        int countNegative = 0;
        int countNullable = 0;
        for (double i : array) {
            if (i > 0) {
                countPositive++;
            } else if (i < 0) {
                countNegative++;
            } else {
                countNullable++;
            }
        }
        return String.format("Количество положительных чисел - %d, отрицательных - %d, нулей - %d", countPositive, countNegative, countNullable);
    }

    //Поменять местами максимальный и минимальный элементы массива (Задание 4)
    public static void rotateMaxMin(double[] array) {
        double max = Arrays.stream(array).max().getAsDouble();
        double min = Arrays.stream(array).min().getAsDouble();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == max) {
                array[i] = min;
            } else if (array[i] == min) {
                array[i] = max;
            }
        }
    }

    //Вывести на печать только те элементы массива, для которых array[i] > i (Задание 5)
    public static void getItemIfValueGreaterThanIndex(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] > i) {
                System.out.print(array[i] + " ");
            }
        }
    }

    //Вычислить сумму чисел, порядковые номера которых простые числа (Задание 6)
    public static double getItemSumIfIndexPrime(double[] array) {
        List<Double> list = new ArrayList<>();
        double result = 0;
        for (int i = 2; i < array.length; i++) {
            List<Integer> buff = new ArrayList<>();
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    buff.add(j);
                }
            }
            if (buff.isEmpty()) {
                result += array[i];
            }
        }
        return result;
    }

}
