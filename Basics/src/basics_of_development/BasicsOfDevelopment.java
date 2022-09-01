package basics_of_development;

import java.math.BigInteger;
import java.util.*;

public class BasicsOfDevelopment {

    /*
    ЛИНЕЙНЫЕ ПРОГРАММЫ
     */
    //Найдите значение функции (задание 1)
    public double getValueFromFunction(double a, double b, double c) {
        return ((a - 3) * b / 2) + c;
    }

    //Вычислить значение выражения по формуле (задание 2)
    public double getValueFromFormula(double a, double b, double c) {
        return ((b + Math.sqrt(Math.pow(b, 2.0) + 4 * a * c)) / 2 * a) - Math.pow(a, 3) + Math.pow(b, -2);
    }

    //Вычислить значение тригонометрической функции (задание 3)
    public double getValueFromTrigonometricFunction(double x, double y) {
        return (Math.sin(x) + Math.cos(y)) / (Math.cos(x) - Math.sin(y)) * Math.tan(x * y);
    }

    //Поменять местами целую и дробную части числа (задание 4)
    public double rotateFractionalNumber(double number) {
        String strNumber = String.valueOf(number);
        String leftPart = strNumber.substring(0, strNumber.indexOf("."));
        String rightPart = strNumber.substring(strNumber.indexOf(".") + 1);
        return Double.parseDouble(String.join(".", rightPart, leftPart));
    }

    //Получить время в формате hh:MM:ss из заданного количества секунд (Задание 5)
    public String getTimeFromSecondsByTemplate(long number) {
        long hours = number / (60 * 60);
        long minutes = (number % (60 * 60)) / 60;
        long seconds = number % 60;
        return String.format("%02d : %02d : %02d", hours, minutes, seconds);

    }

    // Проверить, попадает ли координата в выделeннyю область (Задание 6)
    public boolean isGettingIntoAreaByCoordinates(int x, int y) {
        return (x <= 2 && x >= -2 && y <= 4) || (x <= 4 && x >= -4 && y <= -3);

    }

    /*
    ВЕТВЛЕНИЯ
     */

    /* Даны два угла треугольника, определить,
    существует ли треугольник (если - да, будет ли он прямоугольным)
    Задание 1
    */
    public String isTriangle(int firstAngle, int secondAngle) {
        String resultMessage = "";
        if (firstAngle + secondAngle >= 180) {
            resultMessage = "It's not a triangle";
        } else if (firstAngle == 90 || secondAngle == 90 || firstAngle + secondAngle == 90) {
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
    public int getMax(int a, int b, int c, int d) {
        int minAB = (a > b) ? b : a;
        int minCD = (c > d) ? d : c;
        return (minAB > minCD) ? minAB : minCD;

    }

    // Даны ТРИ точки, будут ли они находится на одной прямой (Задание 3)
    public boolean isStraightLine(int x1, int y1, int x2, int y2, int x3, int y3) {
        return (y3 - y1) * (x2 - x1) - (y2 - y1) * (x3 - x1) == 0;
    }

    // Определить, влезет ли кирпич (x, y, z} в отверстие (A, B) (Задание 4)
    public boolean isFitting(int x, int y, int z, int a, int b) {
        return x <= a && y <= b || y <= a && z <= b || x <= a && z <= b ||
                y <= a && x <= b || z <= a && y <= b || z <= a && x <= b;
    }

    // Вычислить значение функции (система уравнений) (Задание 5)
    public double getFunctionResult(double x) {
        double result = 0;
        if (x <= 3) {
            result = Math.pow(x, 2) + 3 * x + 9;
        } else {
            result = 1 / (Math.pow(x, 3) + 6);
        }
        return result;
    }

    /*
    ЦИКЛЫ
     */
    //Определить сумму чисел от 1 до заданного числа (Задание 1)
    public int getSum(int input) {
        int sum = 0;
        for (int i = 1; i < input; i++) {
            sum += i;
        }
        return sum;
    }

    //Вычислить значение функции на отрезке с шагом (Задание 2)
    public void getFunctionResultBetweenWithStep(int from, int to, int step) {
        int result = 0;
        for (int i = from; i < to; i = i + step) {
            if (i > 2) {
                result = i;
            } else {
                result = -i;
            }
            System.out.println("при x = " + i + " -> y = " + result);
        }
    }

    //Найти СУММУ квадратов первых ста чисел (Задание 3)
    public long getSquaredSum() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i * i;
        }
        return sum;
    }

    //Найти ПРОИЗВЕДЕНИЕ квадратов первых ДВУХСОТ чисел (Задание 4)
    public BigInteger getSquaredMultiplication() {
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 1; i <= 200; i++) {
            result = result.multiply(BigInteger.valueOf(i * i));
        }
        return result;
    }

    //Найти сумму членов ряда, модуль которых больше или равен е (Задание 5)
    public double getRangeMemberSumIfGreater(double e) {
        double result = 0;
        int terminalRangeMember = 100;
        for (int i = 1; i < terminalRangeMember; i++) {
            double range = (1 / (Math.pow(2, i))) + (1 / (Math.pow(3, i)));
            if (Math.abs(range) >= e) {
                result += range;
            }
        }
        return result;
    }

    //Вывести на экран char и соответсвующее ему число (Задание 6)
    public void getCharWithNumber() {
        for (int i = 0; i < 65536; i++) {
            System.out.println((char) (i) + " - " + i);
        }
    }

    //Вывести все делители для каждого числа в промежутке от m до n (Задание 7)
    public void getNumberDividerListBetween() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number FROM: ");
        int from = sc.nextInt();
        System.out.println("Enter number TO: ");
        int to = sc.nextInt();
        Map<Integer, String> result = new HashMap<>();
        for (int i = from; i < to; i++) {
            List<String> dividers = new ArrayList<>();
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    dividers.add(String.valueOf(j));
                }
            }
            result.put(i, String.join(" ", dividers));

        }
        for (Map.Entry<Integer, String> item : result.entrySet()) {
            System.out.println("Number: " + item.getKey() + " -> Dividers: " + item.getValue());
        }
    }

    // Определить цифры, общие для двуч чисел (Задание 8)
    public String getCommonDigit(int firstNumber, int secondNumber) {
        String firstStr = String.valueOf(firstNumber);
        String secondStr = String.valueOf(secondNumber);
        Set<String> result = new HashSet<>();
        for (int i = 0; i < firstStr.length(); i++) {
            for (int j = 0; j < secondStr.length(); j++) {
                if (firstStr.charAt(i) == secondStr.charAt(j)) {
                    result.add(String.valueOf(firstStr.charAt(i)));
                }
            }
        }
        return String.join(" ", result);
    }
}

