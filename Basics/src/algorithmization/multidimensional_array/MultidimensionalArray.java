package algorithmization.multidimensional_array;

import java.util.*;

public class MultidimensionalArray {

     /*
    МАССИВЫ МАССИВОВ
     */

    public void printMatrix(Number[][] matrix) {
        Arrays.stream(matrix).forEach(array -> System.out.println(Arrays.toString(array)));
    }
    public Number[][] convertToNumberType(int[][] matrix) {
        return Arrays.stream(matrix).map(arr -> Arrays.stream(arr).boxed().toArray(Integer[]::new)).toArray(Number[][]::new);
    }
    //В многомерном массиве вывести все нечетные СТОЛБЦЫ, у которых первый элемент больше последнего (Задание 1)
    public void findMatrixOddColumnIfFirstItemGreaterLast(int[][] matrix) {
        int embeddedArrayLength = matrix[0].length;
        for (int i = 0; i < embeddedArrayLength; i++) {
            if (i % 2 == 0 && matrix[0][i] > matrix[matrix.length - 1][i]) {
                for (int j = 0; j < matrix.length; j++) {
                    System.out.println(matrix[j][i]);
                }
                System.out.println("-------------------");
            }

        }
    }

    //Вывести элементы квадратной матрицы, стоящие по диагонали (Задание 2)
    public void printMatrixDiagonalItems(int[][] matrix) {
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
    public void printGivenMatrixRowAndColumn(int[][] matrix, int rowNumber, int columnNumber) {
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
    public Integer[][] createMatrixByTemplate(int size) {
        Integer[][] matrix = new Integer[size][size];
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
    public Integer[][] createMatrixByTemplateWithNull(int size) {
        Integer[][] matrix = new Integer[size][size];
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
    public Integer[][] createMatrixByTemplate2(int size) {
        Integer[][] matrix = new Integer[size][size];
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
    public Double[][] createMatrixByFunction(int size) {
        Double[][] matrix = new Double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                double matrixItem = Math.sin(Math.pow(i, 2) - Math.pow(j, 2)) / size;
                matrix[i][j] = matrixItem;
            }
        }
        return matrix;
    }

    public int countMatrixPositiveItems() {
        int count = 0;
        Double[][] matrix = createMatrixByFunction(5);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > 0) {
                    count++;
                }
            }
        }
        return count;
    }

    // Поменять местами два столбца в матрице (номера столбцов вводит пользователь) (Задание 8)
    public void rotateMatrixColumn(int[][] matrix) {
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
    public String getMatrixColumnWithMaxSum(int[][] matrix) {
        int maxColumnSum = 0;
        int columnIndex = 0;
        for (int j = 0; j < matrix[0].length; j++) {
            int columnSum = 0;
            for (int i = 0; i < matrix.length; i++) {
                columnSum += matrix[i][j];
            }
            if (columnSum > maxColumnSum) {
                maxColumnSum = columnSum;
                columnIndex = j;
            }
        }
        return String.format("Max sum: %d, column index: %d", maxColumnSum, columnIndex);
    }

    //Найти положительные элементы главной диагонали квадратной матрицы (Задание 10)
    public String getMatrixMainDiagonalPositiveItem(int[][] matrix) {
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
    public void printMatrixWithRandomItem() {
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
    public void sortMatrixRowItemsAsc(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            Arrays.sort(matrix[i]);
        }
    }

    public void sortMatrixRowItemsDesc(int[][] matrix) {
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
    public void sortMatrixColumnItemsAsc(int[][] matrix) {
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

    public void sortMatrixColumnItemsDesc(int[][] matrix) {
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
    в каждом СТОЛБЦЕ число единиц равно номеру столбца (Задание 14)
     */
    public int[][] getRandomMatrixWith0And1(int size1, int size2) {
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
    Найти наибольший элемент матрицы, заменить нечетные элементы на него (Задание 15)
     */
    public int findMatrixMaxItem(int[][] matrix) {
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

    public void replaceOddItemOnMax(int[][] matrix) {
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

    //Построить магический квадрат (Задание 16)
    // TODO: 18.07.2022
}
