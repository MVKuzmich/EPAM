package Strings.StringsAsCharactersArray;

import javax.print.DocFlavor;
import java.util.Arrays;

public class StringsAsCharacterArray {
    public static void main(String[] args) {
        String[] array = {"camelCase", "proTo", "midName"};
        System.out.println(new StringsAsCharacterArray().replaceWordsInStrings("lword werwwords awords word wor", "word", "letter"));
    }

    /*
    Дан массив названий переменных в camelCase, преобразовать в snake_case
    (Задание 1)
     */

    public String[] convertCamelCaseToSnakeCase(String[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length(); j++) {
                char letter = array[i].charAt(j);
                if (Character.isUpperCase(letter)) {
                    array[i] = array[i].replace(String.valueOf(letter), "_".concat(String.valueOf(Character.toLowerCase(letter))));
                }
            }
        }
        return array;
    }

    /*
    Заменить в строке все вхождения word на letter
    (Задание 2)
     */
    public String replaceWordsInStrings(String text, String out, String in) {
        // TODO: 27.07.2022  Без метода replace
        StringBuilder builder = new StringBuilder(text);
        for(int i = 0; i <= builder.length() - out.length(); i++) {
            int countMatchesLetter = 1;
            if (builder.charAt(i) == out.charAt(0)) {
                for (int j = 1; j < out.length(); j++) {
                    if (builder.charAt(i + j) != out.charAt(j)) {
                        break;
                    } else {
                        countMatchesLetter++;
                    }
                }

            }
            if (countMatchesLetter == out.length()) {
                builder.delete(i, i + out.length());
                builder.insert(i, in);
            }
        }
        return builder.toString();
    }

    /*
    В строке найти количество ЦИФР (Задание 3)
     */
    public int countDigitsInText(String text) {
        int digitsCount = 0;
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                digitsCount++;
            }
        }
        return digitsCount;
    }

    /*
    В строке найти количество ЧИСЕЛ (Задание 4)
     */

    public int countNumbersInText(String text) {
        int numbersCount = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isDigit(ch)) {
                numbersCount++;
                while (Character.isDigit(text.charAt(i))) {
                    i++;
                    if(i > text.length() - 1) {
                        break;
                    }
                }
            }
        }
        return numbersCount;
}

    /*
    Заменить в строке пробелы, идущие подряд, на одиночные пробелы.
    Удалить крайние пробелы
    (Задание 5)
     */

    public String removeRedundantSpaces(String text) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < text.length(); i++) {
            if(text.charAt(i) != ' ') {
                builder.append(text.charAt(i));
            } else {
                builder.append(text.charAt(i));
                while(text.charAt(i + 1) == ' ') {
                    i++;
                    if(i == text.length() - 1) {
                        break;
                    }
                }
            }

        }
        return builder.toString().trim();
    }





}
