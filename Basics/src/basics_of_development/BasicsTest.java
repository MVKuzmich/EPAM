package basics_of_development;

public class BasicsTest {
    public static void main(String[] args) {
        BasicsOfDevelopment basic = new BasicsOfDevelopment();

        System.out.println("ЛИНЕЙНЫЕ ПРОГРАММЫ");
        System.out.printf("Задание 1. Найти значение функции: %f\n", basic.getValueFromFunction(2.3, 7.0, 5.2));
        System.out.printf("Задание 2. Найти значение по формуле: %f\n", basic.getValueFromFormula(2.3, 7.0, 5.2));
        System.out.printf("Задание 3. Найти значение тригонометрической функции: %f\n", basic.getValueFromTrigonometricFunction(30, 60));
        System.out.printf("Задание 4. Переместить целую и дробную часть числа 123,456: %f\n", basic.rotateFractionalNumber(123.456));
        System.out.printf("Задание 5. Получить из секунд время в формате hh:MM:ss : %s\n", basic.getTimeFromSecondsByTemplate(1125));
        System.out.printf("Задание 6. Попадает ли координата в выделенную область: %s\n", basic.isGettingIntoAreaByCoordinates(5, -3));

        System.out.println("ВЕТВЛЕНИЯ");
        System.out.printf("Задание 1. Существует ли треугольник (даны 2 угла: 45, 60): %s\n", basic.isTriangle(45, 60));
        System.out.printf("Задание 2. Найти максимальное число из двух минимальных в парах (3, 4) и (7, 2): %d\n", basic.getMax(3, 4, 7, 2));
        System.out.printf("Задание 3. Находятся ли три точки на одной прямой (3, 4) (7, 2) (-1, -5): %s\n", basic.isStraightLine(3, 4, 7, 2, -1, -5));
        System.out.printf("Задание 4. Влезет ли кирпич (3, 4, 7) в отверстие(5, 4): %s\n", basic.isFitting(3, 4, 7,5, 4));
        System.out.printf("Задание 5. Вычислить значение функции (система уравнений) при х = 11: %f\n", basic.getFunctionResult(11));

        System.out.println("ЦИКЛЫ");
        System.out.printf("Задание 1. Определить сумму чисел от 1 до заданного (1000): %d\n", basic.getSum(1000));
        System.out.println("Задание 2. Вычислить значение функции на отрезке (-3, 10) с шагом (2)");
        basic.getFunctionResultBetweenWithStep(-3, 10, 2);
        System.out.printf("Задание 3. Найти СУММУ квадратов первых ста чисел: %d\n", basic.getSquaredSum());
        System.out.printf("Задание 4. Найти ПРОИЗВЕДЕНИЕ квадратов первых двухсот чисел: %d\n", basic.getSquaredMultiplication());
        System.out.printf("Задание 5. Найти сумму членов ряда, модуль которых больше или равен 0.03: %f\n", basic.getRangeMemberSumIfGreater(0.03));
        System.out.println("Задание 6. Вывести на экран char и соответствующее ему число");
        basic.getCharWithNumber();
        System.out.println("Задание 7. Вывести все делители для каждого числа в промежутке от m до n");
        basic.getNumberDividerListBetween();
        System.out.printf("Задание 8. Определить цифры, общие для двуч чисел (2564786, 356789412): %s\n", basic.getCommonDigit(2564786, 356789412));






    }
}
