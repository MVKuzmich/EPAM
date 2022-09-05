package algorithmization.simple_array;

import java.util.Arrays;

public class SimpleArrayTest {
    public static void main(String[] args) {
        SimpleArray array = new SimpleArray();
        int[] exampleArray = {1, 4, 0, -2, 3, 33, -2, 4, 104};
        double[] doubleArray = {1.2, 0, 1.0, 11.7, 3.3, 33.2, -2.9, 15.0, 104.0, 23.2};

        System.out.println("ОДНОМЕРНЫЕ МАССИВЫ");

        System.out.println("Задание 1. Найти сумму членов массива, кратных K");
        System.out.printf("Array: %s, K: %d\n", Arrays.toString(exampleArray), 3);
        System.out.printf("Result: %d\n", array.getSumArrayMemberDividedBy(exampleArray, 3));

        System.out.println("Задание 2. Заменить все члены,больше Z, на само Z, подсчитать количество замен");
        System.out.printf("Array: %s, K: %d\n", Arrays.toString(exampleArray), 3);
        System.out.printf("Result: %d\n", array.replaceIfGreaterThanAndCount(doubleArray.clone(), 3));

        System.out.println("Задание 3. Подсчитать отрицательные, положительные и нулевые элементы массива");
        System.out.printf("Array: %s\n", Arrays.toString(doubleArray));
        System.out.printf("result: %s\n", array.countPositiveNegativeNullable(doubleArray));

        System.out.println("Задание 4. Поменять местами максимальный и минимальный элементы массива");
        double[] cloneArray = doubleArray.clone();
        System.out.printf("Array: %s\n", Arrays.toString(cloneArray));
        array.rotateMaxMin(cloneArray);
        System.out.printf("Result array: %s\n", Arrays.toString(cloneArray));

        System.out.println("Задание 5. Вывести на печать только те элементы массива, для которых array[i] > i");
        System.out.printf("Array: %s\n", Arrays.toString(exampleArray));
        System.out.printf("Result: %s\n", array.getItemIfValueGreaterThanIndex(exampleArray));

        System.out.println("Задание 6. Вычислить сумму чисел, порядковые номера которых простые числа");
        System.out.printf("Array: %s\n", Arrays.toString(doubleArray));
        System.out.printf("Result: %.2f\n", array.getItemSumIfIndexPrime(doubleArray));

        System.out.println("Задание 7. В массиве действительных чисел найти max а1 + а2n, a2 + a(2n - 1)...");
        System.out.printf("Array: %s\n", Arrays.toString(doubleArray));
        System.out.printf("Result: %.2f\n", array.getMaxSumOppositeItems(doubleArray));

        System.out.println("Задание 8. Из заданного массива целых чисел удалить элементы, равные min. Получить новый массив");
        System.out.printf("Array: %s\n", Arrays.toString(exampleArray));
        System.out.printf("Result: %s\n", Arrays.toString(array.getArrayFromGivenWithoutMinItem(exampleArray)));

        System.out.println("Задание 9. Найти наиболее часто встречающееся число в целочисленном массиве(минимальное, если таких несколько)");
        System.out.printf("Array: %s\n", Arrays.toString(exampleArray));
        System.out.printf("Result: %d\n", array.findFrequentItem(exampleArray));

        System.out.println("Задание 10. Заменить каждый второй элемент в целочисленном массиве на ноль (без дополнительного массива)");
        System.out.printf("Array: %s\n", Arrays.toString(exampleArray));
        array.replaceEverySecondItemOnNull(exampleArray);
        System.out.printf("Result: %s\n", Arrays.toString(exampleArray));

    }
}
