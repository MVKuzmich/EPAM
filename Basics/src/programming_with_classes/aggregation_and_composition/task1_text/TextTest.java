package programming_with_classes.aggregation_and_composition.task1_text;

import java.util.List;

public class TextTest {
    public static void main(String[] args) {
        Text text = new Text();
        Sentence title = new Sentence();
        title.addAllWords(List.of(new Word("New"), new Word(" "), new Word("year"), new Word("!")));
        text.setTitle(title);
        System.out.println("Title:");
        System.out.println(text.getTitle());

        Sentence first = new Sentence();
        first.addAllWords(List.of(
                        new Word("Today"), new Word(" "), new Word("is"), new Word(" "), new Word("New"),
                        new Word(" "), new Word("year"), new Word(" "), new Word("holiday"), new Word("!"))
                );
        Sentence second = new Sentence();
        second.addAllWords(List.of(
                new Word("It"), new Word(" "), new Word("is"), new Word(" "), new Word("snowing"), new Word("."))
                );
        Sentence third = new Sentence();
        third.addAllWords(List.of(
                        new Word("Parents"), new Word(" "), new Word("are"), new Word(" "), new Word("preparing"),
                        new Word(" "), new Word("to"), new Word(" "), new Word("celebration"), new Word("."))
                );
        text.addSentence(first);
        text.addAllSentences(List.of(second, third));


        System.out.println("First text version");
        System.out.println(text);

        first.addAllWords(4, List.of(new Word("my"), new Word(" "), new Word("favourite"), new Word(" ")));
        System.out.println("Second text version");
        System.out.println(text);

        second.addWord(5, " ");
        second.addWord(6, "now");
        System.out.println("Third text version");
        System.out.println(text);

        Sentence forth = new Sentence();
        forth.addAllWords(List.of(new Word("Wow"), new Word("!")));
        text.addSentence(0, forth);
        System.out.println("Forth text version");
        System.out.println(text);


    }
}
