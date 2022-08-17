package programming_with_classes.aggregation_and_composition.task1_text;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sentence {
    private List<Word> sentence = new ArrayList<>();

    public void addAllWords(List<Word> words) {
        sentence.addAll(words);
    }
    public void addAllWords(int position, List<Word> words) {
        sentence.addAll(position, words);
    }

    public void addWord(int position, String word) {
        sentence.add(position, new Word(word));
    }

    public void addWord(String word) {
        sentence.add(new Word(word));
    }

    @Override
    public String toString() {
        return sentence.stream().map(Word::getWord).collect(Collectors.joining(""));
    }
}
