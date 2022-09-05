package algorithmization.multidimensional_array;


public class MultidimensionalArrayTest {
    public static void main(String[] args) {
        MultidimensionalArray array = new MultidimensionalArray();

        int[][] exampleArray = {
                {1, 4, 7, 3, 5},
                {3, 0, 4, 3, 5},
                {5, 2, 4, 3, 5},
                {2, 3, 0, 2, 2}
        };

        int[][] squareMatrix = {
                {1, 4, 7, 3},
                {3, 0, 4, 3},
                {5, 2, 4, 3},
                {2, 3, 0, 2}
        };

        System.out.println("МАССИВЫ МАССИВОВ");

        System.out.println("Задание 1. В многомерном массиве вывести все нечетные СТОЛБЦЫ, у которых первый элемент больше последнего");
        array.findMatrixOddColumnIfFirstItemGreaterLast(exampleArray);

        System.out.println("Задание 2. Вывести элементы квадратной матрицы, стоящие по диагонали");
        array.printMatrixDiagonalItems(exampleArray);

        System.out.println("Задание 3. Вывести заданные строку и столбец матрицы");
        System.out.printf("Row number: %d, column number: %d\n", 2, 3);
        array.printGivenMatrixRowAndColumn(exampleArray, 2, 3);

        System.out.println("Задание 4. Сформировать матрицу N-порядка (четное) по образцу\n" +
                "    1...n\n" +
                "    n...1\n" +
                "    ....");
        array.printMatrix(array.createMatrixByTemplate(6));

        System.out.println("Задание 5. Сформировать матрицу N-порядка (четное) по образцу\n" +
                "   1 1 1 1\n" +
                "   2 2 2 0\n" +
                "   3 3 0 0\n" +
                "   4 0 0 0");
        array.printMatrix(array.createMatrixByTemplateWithNull(6));

        System.out.println("Задание 6. Сформировать матрицу N-порядка (четное) по образцу\n" +
                "  1 1 1 1 1 1\n" +
                "  0 1 1 1 1 0\n" +
                "  0 0 1 1 0 0\n" +
                "  0 0 1 1 0 0\n" +
                "  0 1 1 1 1 0\n" +
                "  1 1 1 1 1 1");
        array.printMatrix(array.createMatrixByTemplate2(6));

        System.out.println("Задание 7. \n" +
                        "1. Cформировать квадратную матрицу порядка N по правилу a[i][j] = sin((i^2 - j^2) / N)\n" +
                "2. Подсчитать количество положительных элементов");
        array.printMatrix(array.createMatrixByFunction(6));
        System.out.printf("Count of positive items: %d\n", array.countMatrixPositiveItems());

        System.out.println("Задание 8. Поменять местами два столбца в матрице (номера столбцов вводит пользователь)");
        array.rotateMatrixColumn(exampleArray);
        array.printMatrix(array.convertToNumberType(exampleArray));

        System.out.println("Задание 9. Посчитать СУММУ элементов в каждом СТОЛБЦЕ матрицы, определить какой столбец содержит максимальную сумму");
        System.out.println("Given matrix: ");
        array.printMatrix(array.convertToNumberType(exampleArray));
        System.out.printf("Result: %s\n", array.getMatrixColumnWithMaxSum(exampleArray));

        System.out.println("Задание 10. Найти положительные элементы главной диагонали квадратной матрицы");
        System.out.println("Given matrix: ");
        array.printMatrix(array.convertToNumberType(squareMatrix));
        System.out.printf("Result: %s\n", array.getMatrixMainDiagonalPositiveItem(squareMatrix));

        System.out.println("Задание 11.\n" +
                " - Заполнить матрицу 10*20 случайными числами от 0 до 15.\n" +
                " - Вывести на экран матрицу.\n" +
                " - Вывести номера строк, в которых число 5 встречается >= 3 раз ");
        array.printMatrixWithRandomItem();

        System.out.println("Задание 12.\n" +
                "Отсортировать СТРОКИ матрицы ПО ВОЗРАСТАНИЮ значений элементов\n" +
                "                             ПО УБЫВАНИЮ значений элементов");
        array.sortMatrixRowItemsAsc(exampleArray);
        array.printMatrix(array.convertToNumberType(exampleArray));
        System.out.println("----------------------------");
        array.sortMatrixRowItemsDesc(exampleArray);
        array.printMatrix(array.convertToNumberType(exampleArray));

        System.out.println("Задание 13.\n" +
                "Отсортировать СТОЛБЦЫ матрицы по ВОЗРАСТАНИЮ значений элементов\n" +
                "                              по УБЫВАНИЮ значений элементов");
        array.sortMatrixColumnItemsAsc(exampleArray);
        array.printMatrix(array.convertToNumberType(exampleArray));
        System.out.println("-------------------------");

        array.sortMatrixColumnItemsDesc(exampleArray);
        array.printMatrix(array.convertToNumberType(exampleArray));

        System.out.println("Задание 14. Cформировать случайную матрицу m * n, состоящию из 0 и 1,\n" +
                "в каждом СТОЛБЦЕ число единиц равно номеру столбца");
        array.printMatrix(array.convertToNumberType(array.getRandomMatrixWith0And1(6, 5)));

        System.out.println("Задание 15. Найти наибольший элемент матрицы,\n" +
                " заменить нечетные элементы на него");
        System.out.printf("Max matrix element: %d\n", array.findMatrixMaxItem(exampleArray));
        System.out.println("Replace value of odd elements with max value: ");
        array.replaceOddItemOnMax(exampleArray);


    }



}
