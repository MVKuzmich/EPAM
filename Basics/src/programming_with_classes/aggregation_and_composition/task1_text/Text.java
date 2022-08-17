package programming_with_classes.aggregation_and_composition.task1_text;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Text {
    private Sentence title;
    private List<Sentence> mainText;

    public Text() {
        mainText = new ArrayList<>();
    }

    public void addSentence(Sentence sentence) {
        mainText.add(sentence);
    }
    public void addSentence(int position, Sentence sentence) {
        mainText.add(position, sentence);
    }

    public void addAllSentences(List<Sentence> sentences) {
        mainText.addAll(sentences);
    }
    public void addAllSentences(int position, List<Sentence> sentences) {
        mainText.addAll(position, sentences);
    }

    public Sentence getTitle() {
        return title;
    }

    public void setTitle(Sentence title) {
        this.title = title;
    }

    public List<Sentence> getMainText() {
        return mainText;
    }

    public void setMainText(List<Sentence> mainText) {
        this.mainText = mainText;
    }

    @Override
    public String toString() {
        return "Text: " + "\n" +
                "title: " + title + "\n" +
                "mainText: " + mainText.stream().map(Sentence::toString).collect(Collectors.joining(" "));
    }
}
