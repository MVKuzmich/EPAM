package Algorithmization;

import java.util.Arrays;

public class ArraySorting {

    public static void main(String[] args) {
        int[] second = {11, 11, 4, 17, 8, 111};
//        int[] first = {2, 3 , 6, 9, 10, 13, 15, 20};
//        int[] arr = getAscendingArrayFrom(first, second);
//        System.out.println(Arrays.toString(arr));

       executeExchangeSelection(second);
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
}
