package Strings.StringsAsObject;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public class StringAsObject {
    public static void main(String[] args) {

        System.out.println(new StringAsObject().countSentences("j выа. ыав. @#$% ап GGhhjh! HjHl?"));

    }

    /*
    Найти максимальное количество пробелов, идущих подряд в тексте (Задание 1)
     */
    public int getMaxCountOfSpacesSeq(String text) {
        int maxCount = 0;
        String[] words = text.split("\\s+");
        for (int i = 0; i < words.length - 1; i++) {
            int start = text.indexOf(words[i]) + words[i].length();
            int end = text.indexOf(words[i + 1]);
            int countSpace = text.substring(start, end).length();
            if (countSpace > maxCount)
                maxCount = countSpace;
        }
        return maxCount;
    }

    /*
    После каждого символа 'a' поставить символ 'b' (Задание 2)
     */
    public String addSymbolAfter(String text, char after, char add) {
        String[] letters = text.split("");
        for (int i = 0; i < letters.length; i++) {
            if (letters[i].equals(String.valueOf(after))) {
                letters[i] = letters[i].concat(String.valueOf(add));
            }
        }
        return String.join("", letters);
    }

    /*
    Проверить, является ли слово полиндромом (Задание 3)
     */
    public boolean isPalindrome(String word) {
        StringBuilder reverse = new StringBuilder();
        String[] letters = word.split("");
        for (int i = letters.length - 1; i >= 0; i--) {
            reverse.append(letters[i]);
        }
        return word.equals(reverse.toString());
    }

    /*
    С помощью копирования и конкатенации из букв "информатика" получить "торт" (Задание 4)
     */
    public String getWordFromLetters(String sample, String resultWord) {
        String[] resultWordLetters = resultWord.split("");
        String resultWordFromLetters = "";
        for (int i = 0; i < resultWordLetters.length; i++) {
            resultWordFromLetters = resultWordFromLetters.concat(String.valueOf(sample.charAt(sample.indexOf(resultWordLetters[i]))));
        }
        return resultWordFromLetters;
    }

    /*
    Определить, сколько раз в строке встречается заданная буква (Задание 5)
     */
    public int countLetterAppearsIn(String text, String letter) {
        return (int) Arrays.stream(text.split("")).filter(symbol -> symbol.equals(letter)).count();

    }

    /*
    Из заданной строки получить новую, повторить каждый символ дважды (Задание 6)
    */
    public String repeatEverySymbols(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            result = result.concat(String.valueOf(text.charAt(i)).repeat(2));
        }
        return result;
    }

    /*
    Удалить все повторяющиеся символы и пробелы из строки (Задание 7)
     */
    public String removeRepeatingCharsAndSpaces(String text) {
        return Arrays.stream(text.split("")).filter(ch -> !ch.equals(" ")).distinct().collect(Collectors.joining());
    }

    /*
    Найти самое длинное слово в тексте. Вывести на экран (Задание 8)
     */
    public String findWordWithMaxLength(String text) {
        int maxLength = 0;
        String resultWord = "";
        String[] words = text.split(" ");
        for (String word : words) {
            if (word.length() > maxLength) {
                maxLength = word.length();
                resultWord = word;
            }
        }
        return resultWord;
    }
    /*
    Посчитать количество строчных и прописных букв в строке, только английские буквы (Задание 9)
     */

    public void countUpperAndLowerLetters(String text) {
        int upperCount = 0;
        int lowerCount = 0;
        String regex = "[A-z]";
        char[] chars = text.toCharArray();
        for (char ch : chars) {
            if (String.valueOf(ch).matches(regex)) {
                if (Character.isUpperCase(ch)) {
                    upperCount++;
                } else if (Character.isLowerCase(ch)) {
                    lowerCount++;
                }
            }
        }
        System.out.printf("Количество прописных букв %d, количество строчных - %d", upperCount, lowerCount);
    }

    /*
    Подсчитать количество предложений в строке - предложения заканчиваются .!?
    (Задание 10)
     */
    public int countSentences(String text) {
        return text.split("[.!\\?]").length;
    }
}
