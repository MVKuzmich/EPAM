package algorithmization.simple_array;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleArray {

    /*
    ОДНОМЕРНЫЕ МАССИВЫ
     */
    //Найти сумму членов массива, кратных K (Задание 1)
    public int getSumArrayMemberDividedBy(int[] array, int number) {
        int sum = 0;
        for (int i : array) {
            if (i % number == 0) {
                sum += i;
            }
        }
        return sum;
    }

    //Заменить все члены,больше Z, на само Z, подсчитать количество замен (Задание 2)
    public int replaceIfGreaterThanAndCount(double[] array, double number) {
        int countReplace = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > number) {
                array[i] = number;
                countReplace++;
            }
        }
        System.out.printf("result array: %s\n", Arrays.toString(array));
        return countReplace;
    }

    //Подсчитать отрицательные, положительные и нулевые элементы массива (Задание 3)
    public String countPositiveNegativeNullable(double[] array) {
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
        return String.format("Amount positive number - %d, negative - %d, null - %d", countPositive, countNegative, countNullable);
    }

    //Поменять местами максимальный и минимальный элементы массива (Задание 4)
    public void rotateMaxMin(double[] array) {
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
    public String getItemIfValueGreaterThanIndex(int[] array) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i] > i) {
                builder.append(array[i]).append(" ");
            }
        }
        return builder.toString();
    }

    //Вычислить сумму чисел, порядковые номера которых простые числа (Задание 6)
    public double getItemSumIfIndexPrime(double[] array) {
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

    //в массиве действительных чисел найти max а1 + а2n, a2 + a(2n - 1)...(Задание 7)
    public double getMaxSumOppositeItems(double[] array) {
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
    public int[] getArrayFromGivenWithoutMinItem(int[] array) {
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
    public int findFrequentItem(int[] array) {
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
    public void replaceEverySecondItemOnNull(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i % 2 != 0) {
                array[i] = 0;
            }
        }
    }
}
