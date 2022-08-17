package strings.regex.text_editor_app;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/*
Создать приложение, разбирающее текст и позволяющее выполнять с текстом операции:
 - отсортировать абзацы по количеству предложений;
 - в каждом предложении отсортировать слова по длине;
 - в каждом предложении отсортировать лексемы по УБЫВАНИЮ количества вхождений заданного символа
 (в случае равенства - по алфавиту)
 */
public class TextEditorApp {
    public static final String SENTENCE_REGEX = "((?Us).*?)(?:([?!.])[\\s+\\n]?)";
    public static final String WORD_REGEX = "([\\s+\"]?)([A-zА-яЁё0-9]+(-[[A-zА-яЁё0-9]+])?)([!?,.{1,3};:\"]?)";

    public static void main(String[] args) {
        String text = "\t Написание текстов для главных страниц сайта – дело непростое. " +
                "Проблема в том, что существует сразу несколько подходов к подготовке таких материалов.\n" +
                "\t Каждый подход, как это и водится, имеет свои плюсы и минусы. " +
                "Где-то можно выиграть в оптимизации, но потерять в живых читателях. " +
                "Где-то можно приобрести живых читателей, но придется жертвовать SEO-показателями и, возможно, по этой причине отставать от конкурентов.\n" +
                "\t Постоянные сомнения, касающиеся оптимальных путей создания текстов для главной, стали вполне привычными спутниками авторов.\n" +
                "\t Кто-то постоянно работает под одной и той же схеме, кто-то мечется между SEO и продающими текстами, а кто-то и вовсе не имеет четкого видения. " +
                "Чтобы хоть как-то определиться с тем, как писать тексты для главных страниц, мы составили эту небольшую заметку. " +
                "На полноценный научный труд претендовать не собираемся, но кое-какие собственные наблюдения озвучим.";

        System.out.println(new TextEditorApp().sortWordsByGivenCharCount(text, 'т'));
    }

    public String sortParagraphsBySentenceCount(String text) {
        List<String> paragraphs = Arrays.stream(text.split("\n"))
                .sorted(Comparator.comparing(this::countSentencesInParagraph))
                .collect(Collectors.toList());

        return String.join("\n", paragraphs);
    }

    public String sortWordsInSentencesByWordLength(String text) {
        List<String> result = new ArrayList<>();
        Pattern pattern = Pattern.compile(SENTENCE_REGEX);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String sentence = matcher.group(1);
            String sign = matcher.group(2);
            List<String> words = Arrays.stream(sentence.split(" "))
                    .sorted(Comparator.comparing(this::countWordLength))
                    .collect(Collectors.toList());
            result.add(String.join(" ", words).concat(sign));
        }
        return String.join("\n", result);
    }

    public String sortWordsByGivenCharCount(String text, char letter) {
        List<String> result = new ArrayList<>();
        Pattern pattern = Pattern.compile(SENTENCE_REGEX);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String sentence = matcher.group(1);
            String sign = matcher.group(2);
            List<String> words = Arrays.stream(sentence.split(" "))
                    .sorted((o1, o2) -> {
                        if (countGivenCharInWord(o1, letter) > countGivenCharInWord(o2, letter)) {
                            return -1;
                        } else if (countGivenCharInWord(o1, letter) < countGivenCharInWord(o2, letter)) {
                            return 1;
                        } else {
                            return o1.toLowerCase().compareTo(o2.toLowerCase());
                        }
                    })
                    .collect(Collectors.toList());
            result.add(String.join(" ", words).concat(sign));
        }
        return String.join("\n", result);
    }

    private int countWordLength(String word) {
        Pattern pattern = Pattern.compile(WORD_REGEX);
        Matcher matcher = pattern.matcher(word);
        int wordLength = 0;
        if (matcher.find()) {
            wordLength = matcher.group(2).length();
        }
        return wordLength;
    }

    private int countSentencesInParagraph(String text) {
        return text.split("[.?!]").length;
    }

    private int countGivenCharInWord(String word, char letter) {
        int countChar = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                countChar++;
            }
        }
        return countChar;
    }
}

