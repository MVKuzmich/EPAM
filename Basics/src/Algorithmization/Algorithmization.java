package Algorithmization;

import java.util.*;

public class Algorithmization {

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4, 6},
                {6, 6, 6, 6, 0},
                {1, 1, 1, 1, 0},
                {3, 9, 3, -4, 0},
                {0, 1, 3, 4, -5}};

//        int[][] matrix = getRandomMatrixWith0And1(3, 10);
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }
        replaceOddItemOnMax(arr);

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

    /*
   Сформировать матрицу N-порядка (четное) по образцу (Задание 5)
   1 1 1 1
   2 2 2 0
   3 3 0 0
   4 0 0 0
     */
    public static int[][] createMatrixByTemplateWithNull(int size) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i > 0 && j >= size - i) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = i + 1;
                }
            }
        }
        return matrix;
    }

    /*
  Сформировать матрицу N-порядка (четное) по образцу (Задание 6)
  1 1 1 1 1 1
  0 1 1 1 1 0
  0 0 1 1 0 0
  0 0 1 1 0 0
  0 1 1 1 1 0
  1 1 1 1 1 1
    */
    public static int[][] createMatrixByTemplate2(int size) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size / 2; i++) {
            for (int j = 0; j < size; j++) {
                if (j >= size - i || j < i) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = 1;
                }
            }
        }
        for (int i = size / 2; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j > i || j < size - i - 1) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = 1;
                }
            }
        }
        return matrix;
    }

    /*
    1. Cформировать квадратную матрицу порядка N по правилу
    a[i][j] = sin((i^2 - j^2) / N)
    2. Подсчитать количество положительных элементов (Задание 7)
     */
    public static double[][] createMatrixByFunction(int size) {
        double[][] matrix = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                double matrixItem = Math.sin(Math.pow(i, 2) - Math.pow(j, 2)) / size;
                matrix[i][j] = matrixItem;
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        return matrix;
    }

    public static int countMatrixPositiveItems() {
        int count = 0;
        double[][] matrix = createMatrixByFunction(5);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > 0) {
                    count++;
                }
            }
        }
        return count;
    }

    // Поменять местами два столбца в матрица (номера столбцов вводит пользователь) (Задание 8)
    public static void rotateMatrixColumn(int[][] matrix) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first column number:");
        int firstColumn = scanner.nextInt();
        System.out.println("Enter second column number:");
        int secondColumn = scanner.nextInt();
        for (int i = 0; i < matrix.length; i++) {
            int firstItem = 0;
            int secondItem = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == firstColumn) {
                    firstItem = matrix[i][j];
                } else if (j == secondColumn) {
                    secondItem = matrix[i][j];
                }
            }
            matrix[i][firstColumn] = secondItem;
            matrix[i][secondColumn] = firstItem;
        }
    }

    //Посчитать СУММУ элементов в каждом СТОЛБЦЕ матрицы, определить какой столбец содержит максимальную сумму (Задание 9)
    public static int getMatrixColumnWithMaxSum(int[][] matrix) {
        int maxColumnSum = 0;
        int columnIndex = 0;
        for (int j = 0; j < matrix.length; j++) {
            int columnSum = 0;
            for (int i = 0; i < matrix.length; i++) {
                columnSum += matrix[i][j];
            }
            if (columnSum > maxColumnSum) {
                maxColumnSum = columnSum;
                columnIndex = j;
            }
        }
        return columnIndex;
    }

    //Найти положительные элементы главной диагонали квадратной матрицы (Задание 10)
    public static String getMatrixMainDiagonalPositiveItem(int[][] matrix) {
        List<String> positiveDiagonalItems = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j && matrix[i][j] > 0) {
                    positiveDiagonalItems.add(String.valueOf(matrix[i][j]));
                }
            }
        }
        return String.join(" ", positiveDiagonalItems);

    }

    /*
    Заполнить матрицу 10*20 случайными числами от 0 до 15.
    Вывести на экран матрицу
    Вывести номера строк, в которых число 5 встречается >= 3 раз
    (Задание 11)
     */
    public static void printMatrixWithRandomItem() {
        int[][] matrix = new int[10][20];
        List<String> rowNumber = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int countNumberEqual5 = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 15);
                System.out.print(matrix[i][j] + " ");
                if (matrix[i][j] == 5) {
                    countNumberEqual5++;
                }
            }
            System.out.println();
            if (countNumberEqual5 >= 3) {
                rowNumber.add(String.valueOf(i + 1));
            }
        }
        System.out.println("Номера строк, в которых количество чисел 5 больше либо равно 3:");
        System.out.println((rowNumber.isEmpty()) ? 0 : String.join(" ", rowNumber));
    }

    /*
    Отсортировать СТРОКИ матрицы ПО ВОЗРАСТАНИЮ значений элементов
                                 ПО УБЫВАНИЮ значений элементов
    (Задание 12)
     */
    public static void sortMatrixRowItemsAsc(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            Arrays.sort(matrix[i]);
        }
    }

    public static void sortMatrixRowItemsDesc(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(matrix[i])
                    .boxed()
                    .sorted(Collections.reverseOrder())
                    .mapToInt(Integer::intValue).toArray();
        }
    }

    /*
    Отсортировать СТОЛБЦЫ матрицы по ВОЗРАСТАНИЮ значений элементов
                                  по УБЫВАНИЮ значений элементов
    (Задание 13)
     */
    public static void sortMatrixColumnItemsAsc(int[][] matrix) {
        int temp;
        for (int j = 0; j < matrix.length; j++) {
            boolean sorted = false;
            while (!sorted) {
                sorted = true;
                for (int i = 0; i < matrix.length - 1; i++) {
                    if (matrix[i][j] > matrix[i + 1][j]) {
                        temp = matrix[i][j];
                        matrix[i][j] = matrix[i + 1][j];
                        matrix[i + 1][j] = temp;
                        sorted = false;
                    }
                }
            }
        }
    }

    public static void sortMatrixColumnItemsDesc(int[][] matrix) {
        int temp;
        for (int j = 0; j < matrix.length; j++) {
            boolean sorted = false;
            while (!sorted) {
                sorted = true;
                for (int i = 0; i < matrix.length - 1; i++) {
                    if (matrix[i][j] < matrix[i + 1][j]) {
                        temp = matrix[i][j];
                        matrix[i][j] = matrix[i + 1][j];
                        matrix[i + 1][j] = temp;
                        sorted = false;
                    }
                }
            }
        }
    }

    /*
    Cформировать случайную матрицу m * n, состоящию из 0 и 1,
    в каждом СТОЛБЦЕ число единиц равно номеру стоблбца (Задание 14)
     */
    public static int[][] getRandomMatrixWith0And1(int size1, int size2) {
        int[][] matrix = new int[size1][size2];
        for (int j = 0; j < size2; j++) {
            int count1Number = 0;
            for (int i = 0; i < size1; i++) {
                if (count1Number < j) {
                    matrix[i][j] = 1;
                    count1Number++;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }

    /*
    Найти найбольший элемент матрицы, заменить нечетные элементы на него (Задание 15)
     */
    public static int findMatrixMaxItem(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
        return max;
    }

    public static void replaceOddItemOnMax(int[][] matrix) {
        int max = findMatrixMaxItem(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if ((j + 1) % 2 != 0) {
                    matrix[i][j] = max;
                }
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}




