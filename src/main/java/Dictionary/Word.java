package Dictionary;

public class Word {
    private String word_target;
    private String word_explain;

    public Word(String word, String meaning) {
        word_target = word;
        word_explain = meaning;
    }

    public String getWord_target() {
        return word_target;
    }

    public String getWord_explain() {
        return word_explain;
    }

}
