package Algorithmization;

import java.util.*;

public class Algorithmization {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 11, 12, 6}, {6, 6, 6, 6, 0}, {11, 1, 11, 11, 0}, {3, 19, 3, 4, 0}, {0, 1, 3, 4, 5}};
        int number = 10;
        createMatrixByTemplate(6);

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

    //в массиве действиетльных чисел найти max а1 + а2n, a2 + a(2n - 1)...(Задание 7)
    public static double getMaxSumOppositeItems(double[] array) {
        double max = Double.MIN_VALUE;
        for (int i = 0; i < array.length / 2; i++) {
            double itemsSum = array[i] + array[array.length - 1 - i];
            if (itemsSum > max) {
                max = itemsSum;
            }
        }
        return max;
    }

    //Из заданного массива целых чисел удалить элементы, равные min. Получить новый массив (Задание 8)
    public static int[] getArrayFromGivenWithoutMinItem(int[] array) {
        int min = Integer.MAX_VALUE;
        int countMinItem = 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == min) {
                countMinItem++;
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        int[] resultArray = new int[array.length - countMinItem];
        int indexResultArray = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != min) {
                resultArray[indexResultArray++] = array[i];
            }
        }
        return resultArray;
    }

    //Найти наиболее часто встречающееся число в целочисленном массиве(минимальное, если таких несколько) (Задание 9)
    public static int findFrequentItem(int[] array) {
        Arrays.sort(array);
        int maxFrequency = 0;
        int resultItem = 0;
        int itemFrequency = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] == array[i]) {
                itemFrequency++;
                if (itemFrequency > maxFrequency) {
                    maxFrequency = itemFrequency;
                    resultItem = array[i];
                } else if (itemFrequency == maxFrequency) {
                    resultItem = Math.min(array[i], resultItem);
                }
            } else {
                itemFrequency = 0;
            }
        }
        return resultItem;
    }

    //Заменить каждый второй элемент в целочисленном массиве на ноль (без дополнительного массива) (Задание 10)
    public static void replaceEverySecondItemOnNull(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i % 2 != 0) {
                array[i] = 0;
            }
        }
    }

    /*
    МАССИВЫ МАССИВОВ
     */
    /*
    10 9 8 7 | 10
    5  4 3 2 | 5
    0  1 9 8 | 0

     */
    //В многомерном массиве вывести все нечетные СТОЛБЦЫ, у которых первый элемент больше последнего (Задание 1)
    public static void findMatrixOddColumnIfFirstItemGreaterLast(int[][] matrix) {
        int embeddedArrayLength = matrix[0].length;
        for (int i = 0; i < embeddedArrayLength; i++) {
            if (i % 2 == 0 && matrix[0][i] > matrix[matrix.length - 1][i]) {
                for (int j = 0; j < matrix.length; j++) {
                    System.out.println(matrix[j][i]);
                }
            }
            System.out.println("-------------------");
        }
    }

    //Вывести элементы квадратной матрицы, стоящие по диагонали (Задание 2)
    public static void printMatrixDiagonalItems(int[][] matrix) {
        int size = matrix.length - 1;
        for (int i = 0; i <= size; i++) {
            for (int j = 0; j <= size; j++) {
                if (i + j == size || i == j) {
                    System.out.print(matrix[i][j] + " ");
                } else {
                    System.out.print(" - ");
                }

            }
            System.out.println();

        }
    }

    //Вывести заданные строку и столбец матрицы (Задание 3)
    public static void printGivenMatrixRowAndColumn(int[][] matrix, int rowNumber, int columnNumber) {
        for (int i = 0; i < matrix.length; i++) {
            if (i == rowNumber) {
                for (int j = 0; j < matrix[i].length; j++) {

                    System.out.print(matrix[rowNumber][j] + " ");
                }
            }
        }
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == columnNumber) {
                    System.out.println(matrix[i][columnNumber]);
                }
            }
        }
    }

    /* Сформировать матрицу N-порядка (четное) по образцу (Задание 4)
    1...n
    n...1
    ....
     */
    public static int[][] createMatrixByTemplate(int size) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            int first = 1;
            int last = size;
            for (int j = 0; j < size; j++) {
                if (i % 2 == 0) {
                    matrix[i][j] = first++;
                } else {
                    matrix[i][j] = last--;
                }
            }
        }
        return matrix;
    }
}
