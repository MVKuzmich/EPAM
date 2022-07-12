import javax.print.DocFlavor;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println(getCommonDigit(243369, 3339990));
    }
    /*
    ЛИНЕЙНЫЕ ПРОГРАММЫ
     */
    //Найдите значение функции (задание 1)
    public static double getValueFromFunction (double a, double b, double c) {
        return ((a - 3) * b / 2) + c;
    }

    //Вычислить значение выражения по формуле (задание 2)
       public static double getValueFromFormula(double a, double b, double c) {
       return ((b + Math.sqrt(Math.pow(b, 2.0) + 4 * a * c)) / 2 * a) - Math.pow(a, 3) + Math.pow(b, -2);
    }
    //Вычислить значение тригонометрической функции (задание 3)
    public static double getValueFromTrigonometricFunction(double x, double y) {
        return (Math.sin(x) + Math.cos(y)) / (Math.cos(x) - Math.sin(y)) * Math.tan(x * y);
    }

    //Поменять местами целую и дробную части числа (задание 4)
    public static double rotateFractionalNumber(double number) {
        String strNumber = String.valueOf(number);
        String leftPart = strNumber.substring(0, strNumber.indexOf("."));
        String rightPart = strNumber.substring(strNumber.indexOf(".") + 1);
        return Double.parseDouble(String.join(".", rightPart, leftPart));
    }

    //Получить время в формате hh:MM:ss из заданного количества секунд (Задание 5)
    public static String getTimeFromSecondsByTemplate (long number) {
        long hours = number / (60 * 60);
        long minutes = (number % (60 * 60)) / 60;
        long seconds = number % 60;
        return String.format("%02d : %02d : %02d", hours, minutes, seconds);

    }
    // Проверить, попадает ли координата в выделнную область
    // TODO: 12.07.2022

    /*
    ВЕТВЛЕНИЯ
     */

    /* Даны два угла треугольника, определить,
    существует ли треугольник (если - да, будет ли он прямоугольным)
    Задание 1
    */
     public static String isTriangle(int firstAngle, int secondAngle) {
         String resultMessage = "";
         if(firstAngle + secondAngle >= 180) {
             resultMessage = "It's not a triangle";
         } else if(firstAngle == 90 || secondAngle == 90 || firstAngle + secondAngle == 90) {
             resultMessage = "It's a right triangle";
         } else {
             resultMessage = "It's a triangle";
         }
         return resultMessage;
     }

     /*
     Найти максимальное число из двух минимальных
     max{min(a, b), min(c, d)}
     Задание 2
      */
    public static int getMax(int a, int b, int c, int d) {
        int minAB = (a > b) ? a : b;
        int minCD = (c > d) ? c : d;
        return (minAB > minCD) ? minAB : minCD;

    }
    // Даны ТРИ точки, будут ли они находится на одной прямой (Задание 3)
    public static boolean isStraightLine(int x1, int y1, int x2, int y2, int x3, int y3) {
        return (y3 - y1) * (x2 - x1) - (y2 - y1) * (x3 - x1) == 0;
    }

    // Определить, влезет ли кирпич (x, y, z} в отверстие (A, B) (Задание 4)
    public static boolean isFitting(int x, int y, int z, int a, int b) {
    return x <= a && y <= b || y <= a && z <= b || x <= a && z <= b ||
            y <= a && x <= b || z <= a && y <= b || z <= a && x <= b;
    }

    // Вычислить значение функции (система уравнений) (Задание 5)
    // TODO: 12.07.2022

    /*
    ЦИКЛЫ
     */
    //Определить сумму чисел от 1 до заданного числа (Задание 1)
    public static int getSum(int input) {
        int sum = 0;
        for(int i = 1; i < input; i++) {
                sum += i;
        }
        return sum;
    }

    //Вычислить значение функции на отрезке с шагом (Задание 2)
    // TODO: 12.07.2022

    //Найти СУММУ квадратов первых ста чисел (Задание 3)
    public static long getSquaredSum() {
        int sum = 0;
        for(int i = 1; i <= 100; i++) {
            sum += i * i;
        }
        return sum;
    }

    //Найти ПРОИЗВЕДЕНИЕ квадратов первых ДВУХСОТ чисел (Задание 4)
    public static BigInteger getSquaredMultiplication() {
        BigInteger result = BigInteger.valueOf(1);
        for(int i = 1; i <= 200; i++) {
            result = result.multiply(BigInteger.valueOf(i * i));
        }
        return result;
    }

    //Найти сумму членов ряда, модуль которых больше или равен е (Задание 5)
    // TODO: 12.07.2022

    //Вывести на экран char и соответсвующее ему число (Задание 6)
    public static void getCharWithNumber() {
        for (int i = 0; i < 65536; i++) {
            System.out.println((char)(i) + " - " + i);
        }
    }

    //Задание 7
    // TODO: 12.07.2022


    // Определить цифры, общие для двуч чисел (Задание 8)
    public static String getCommonDigit(int firstNumber, int secondNumber) {
        String firstStr = String.valueOf(firstNumber);
        String secondStr = String.valueOf(secondNumber);
        Set<String> result = new HashSet<>();
        for(int i = 0; i < firstStr.length(); i++) {
            for(int j = 0; j < secondStr.length(); j++) {
                if(firstStr.charAt(i) == secondStr.charAt(j)) {
                    result.add(String.valueOf(firstStr.charAt(i)));
                }
            }
        }
        return String.join(" ", result);
    }



}

