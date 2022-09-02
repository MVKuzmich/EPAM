package algorithmization.array_sorting;

import java.sql.SQLOutput;
import java.util.Arrays;

public class ArraySortingTest {

    public static void main(String[] args) {
        int[] firstArray = {1, 3, 7, 11, 13, 72};
        int[] secondArray = {4, 6, 10, 12, 14, 17, 20, 21};
        int[] givenArray = {14, 61, 100, 112, 140, 1, 20, 211};
        double[] doubleArray = {14.7, 61.6, 100.8, 112.9, 140.1, 1.0, 20.5, 211.3};
        int[] numerators =
                {1, 3, 5, 1, 2, 3};
        int[] denominators =
                {2, 4, 8, 7, 5, 7};

        ArraySorting arraySorting = new ArraySorting();

        System.out.println("ОДНОМЕРНЫЕ МАССИВЫ. СОРТИРОВКИ");

        System.out.println("Задание 1. Включить второй массив в первый между K и K+1 элементами первого массива.");
        System.out.printf("first array: %s\n", Arrays.toString(firstArray));
        System.out.printf("second array: %s\n", Arrays.toString(secondArray));
        arraySorting.connectTwoArray(firstArray, secondArray, 3);

        System.out.println("Задание 2. Из двух возрастающих последовательностей создать третью возрастающую");
        System.out.printf("first array: %s\n", Arrays.toString(firstArray));
        System.out.printf("second array: %s\n", Arrays.toString(secondArray));
        System.out.println(Arrays.toString(arraySorting.getAscendingArrayFrom(firstArray, secondArray)));

        System.out.println("Задание 3. Отсортировать последовательность по убыванию - СОРТИРОВКА ВЫБОРОМ");
        System.out.printf("Given array: %s\n", Arrays.toString(givenArray));
        arraySorting.executeSelectionSorting(Arrays.copyOf(givenArray, givenArray.length));

        System.out.println("Задание 4. Отсортировать последовательность по возрастанию - СОРТИРОВКА ОБМЕНАМИ");
        System.out.printf("Given array: %s\n", Arrays.toString(givenArray));
        arraySorting.executeExchangeSelection(Arrays.copyOf(givenArray, givenArray.length));

        System.out.println("Задание 5. Отсортировать последовательность по возрастанию - СОРТИРОВКА ВСТАВКАМИ, " +
                "определить место вставки - БИНАРНЫЙ ПОИСК");
        System.out.printf("Given array: %s\n", Arrays.toString(givenArray));
        System.out.printf("Result: %s\n", Arrays.toString(arraySorting.executeInsertionSorting(Arrays.copyOf(givenArray, givenArray.length))));

        System.out.println("Задание 6. Отсортировать последовательность по возрастанию - СОРТИРОВКА ШЕЛЛА");
        System.out.printf("Given array: %s\n", Arrays.toString(doubleArray));
        System.out.printf("Result: %s\n", Arrays.toString(arraySorting.executeShellSorting(Arrays.copyOf(doubleArray, doubleArray.length))));

        System.out.println("Задание 7. Получить значения индексов для вставки элементов второй последовательности в первую, чтобы рельтирующая последовательность осталась возрастающей");
        System.out.printf("first array: %s\n", Arrays.toString(firstArray));
        System.out.printf("second array: %s\n", Arrays.toString(secondArray));
        arraySorting.getConnectingIndex(firstArray, secondArray);

        System.out.println("Задание 8. Привести дроби к общему знаменателю, отсортировать по возрастанию");
        System.out.printf("Numerators:\n %s\n", Arrays.toString(numerators));
        System.out.printf("Denominators:\n %s\n", Arrays.toString(denominators));
        arraySorting.executeFractionSorting(numerators, denominators);

    }
}
