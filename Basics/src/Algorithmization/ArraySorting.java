package Algorithmization;

import java.util.Arrays;

public class ArraySorting {
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
        for(int i = 0; i < fromPoint + secondArray.length; i++) {
            if(i < fromPoint) {
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
}
