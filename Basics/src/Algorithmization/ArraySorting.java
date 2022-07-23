package Algorithmization;

import java.util.*;

public class ArraySorting {

    public static void main(String[] args) {
        int[] first = {1, 1, 4, 5};
        int[] second = {4, 2, 9, 6};

//        int[] arr = getAscendingArrayFrom(first, second);
//        System.out.println(Arrays.toString(arr));
        executeFractionSorting(first, second);
    }
    /*
    ОДНОМЕРНЫЙ МАССИВЫ. СОРТИРОВКИ
     */

    /*
    Даны два одномерных массива и число K. Включить второй массив в первый между K и K+1 элементами первого массива.
    Не использовать промежуточный массив (Задание 1)
     */
    public static void connectTwoArray(int[] firstArray, int[] secondArray, int fromPoint) {
        int secondArrayIndex = 0;
        int[] resultArray = new int[firstArray.length + secondArray.length];
        for (int i = 0; i < fromPoint + secondArray.length; i++) {
            if (i < fromPoint) {
                resultArray[i] = firstArray[i];
            } else {
                resultArray[i] = secondArray[secondArrayIndex++];
            }
        }
        int destPosition = fromPoint + secondArray.length;
        int length = resultArray.length - secondArray.length - fromPoint;
        System.arraycopy(firstArray, fromPoint, resultArray, destPosition, length);
        System.out.println(Arrays.toString(resultArray));
    }

    /*
    Из двух возрастающих последовательностей создать третью возрастающую (Задание 2)
        */
    public static int[] getAscendingArrayFrom(int[] firstArray, int[] secondArray) {
        int firstArrayIndex = 0;
        int secondArrayIndex = 0;
        int[] resultArray = new int[firstArray.length + secondArray.length];
        for (int i = 0; i < resultArray.length; i++) {
            if (firstArrayIndex < firstArray.length && secondArrayIndex < secondArray.length) {
                resultArray[i] = (firstArray[firstArrayIndex] > secondArray[secondArrayIndex]) ?
                        secondArray[secondArrayIndex++] : firstArray[firstArrayIndex++];
            } else if (firstArrayIndex >= firstArray.length) {
                resultArray[i] = secondArray[secondArrayIndex++];
            } else {
                resultArray[i] = firstArray[firstArrayIndex++];
            }
        }
        return resultArray;
    }

    /*
    Отсортировать последовательность по убыванию - СОРТИРОВКА ВЫБОРОМ (Задание 3)
     */
    public static void executeSelectionSorting(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int index = i;
            int max = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > max) {
                    index = j;
                    max = array[j];
                }
            }
            array[index] = array[i];
            array[i] = max;
        }
        System.out.println(Arrays.toString(array));
    }

    /*
    Отсортировать последовательность по возрастанию - СОРТИРОВКА ОБМЕНАМИ (Задание 4)
     */
    public static void executeExchangeSelection(int[] array) {
        boolean isSorted = false;
        int temp = 0;
        int exchangeCount = 0;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    exchangeCount++;
                    System.out.println("exchange: " + array[i + 1] + " -> " + array[i]);
                    isSorted = false;
                }
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.println("Exchange count: " + exchangeCount);
    }

    /*
    Отсортировать последовательность по возрастанию - СОРТИРОВКА ВСТАВКАМИ,
    определить место вставки - БИНАРНЫЙ ПОИСК
    (Задание 5)
     */
    public static int getIndexForPlaceViaBinarySearch(int[] array, int item, int first, int last) {
        while (first <= last) {
            int middle = first + (last - first) / 2;
            if (item == array[middle]) {
                return middle + 1;
            } else if (item > array[middle]) {
                first = middle + 1;
            } else {
                last = middle - 1;
            }
        }
        return first;
    }

    public static int[] executeInsertionSorting(int[] array) {
        int locationIndex;
        int lastSortedIndex;
        int selectedItem;
        for (int i = 1; i < array.length; i++) {
            lastSortedIndex = i - 1;
            selectedItem = array[i];
            locationIndex = getIndexForPlaceViaBinarySearch(array, selectedItem, 0, lastSortedIndex);
            while (lastSortedIndex >= locationIndex) {
                array[lastSortedIndex + 1] = array[lastSortedIndex];
                lastSortedIndex--;
            }
            array[lastSortedIndex + 1] = selectedItem;
        }
        return array;
    }

    /*
    Отсортировать последовательность по возрастанию - СОРТИРОВКА ШЕЛЛА (Задание 6)
     */
    public static double[] executeShellSorting(double[] array) {
        int length = array.length;
        for (int gap = length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < length; i++) {
                double key = array[i];
                int j = i;
                while (j >= gap && array[j - gap] > key) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = key;
            }
        }
        return array;
    }

    /*
    Даны две возрастающии последовательности. Получить значения индексов для вставки элементов второй последовательности,
     чтобы рельтирующая последовательность осталась возрастающей (Задание 7)
     */
    public static void getConnectingIndex(int[] firstArray, int[] secondArray) {
        for (int i = 0; i < secondArray.length; i++) {
            for (int j = 0; j < firstArray.length; j++) {
                if (firstArray[j] > secondArray[i]) {
                    System.out.printf("%d второго массива вставим до %d первого массива\n", secondArray[i], firstArray[j]);
                    break;
                }
            }
            if (firstArray[firstArray.length - 1] < secondArray[i]) {
                System.out.printf("%d и последующие элементы второго массива вставим после последнего элемента первого\n", secondArray[i]);
            }
        }
    }

    /*
    Привести дроби к общему знаменателю, отсортировать по возрастанию (Задание 8)
     */
    public static void executeFractionSorting(int[] numerators, int[] denominators) {
        int commonDenominator = findFractionCommonDenominator(denominators);
        for(int i = 0; i < numerators.length; i++) {
            numerators[i] = numerators[i] * commonDenominator / denominators[i];
        }
        Arrays.sort(numerators);
        for(int i : numerators) {
            System.out.print(i +"/" + commonDenominator + " ");
        }

    }
    public static int findFractionCommonDenominator(int[] denominators) {
        int maxDenominator = 1;
        for(int i = 0; i < denominators.length; i++) {
            int twoNumberDenominator = findDenominatorFor(maxDenominator, denominators[i]);
            maxDenominator = Math.max(twoNumberDenominator, maxDenominator);
        }
        return maxDenominator;
    }
    public static int findDenominatorFor(int number1, int number2) {
        if (number1 == 0 || number2 == 0) {
            return 0;
        }
        int higherNumber = Math.max(number1, number2);
        int lowerNumber = Math.min(number1, number2);
        int commonDenominator = higherNumber;
        while (commonDenominator % lowerNumber != 0) {
            commonDenominator += higherNumber;
        }
        return commonDenominator;
    }

}



