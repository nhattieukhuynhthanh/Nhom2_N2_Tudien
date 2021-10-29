package Dictionary;

public class Dictionary {
    private final Word[] wordList = new Word[2000];
    private int size;

    public Dictionary() {
        size = 0;
    }

    public int getsize() {
        return size;
    }

    public Word[] getWordList() {
        return wordList;
    }

    /**
     * @param word
     */
    public void addWord(Word word) {
        wordList[size] = word;
        ++size;
    }

    /**
     * @param wordToEdit
     * @param meaningToEdit
     */
    public void editWord(String wordToEdit, String meaningToEdit) {
        if (meaningToEdit.isEmpty()) {
            deleteWord(wordToEdit);
            return;
        }
        for (int i = 0; i < this.size; i++) {
            if (this.wordList[i].getWord_target().equals(wordToEdit)) {
                wordList[i] = new Word(wordToEdit, meaningToEdit);
                return;
            }
        }
        this.addWord(new Word(wordToEdit, meaningToEdit));
    }


    /**
     * @param wordToDelete
     */
    public void deleteWord(String wordToDelete) {
        int length = this.size;
        for (int i = 0; i < length; i++) {
            if (this.wordList[i].getWord_target().equals(wordToDelete)
                    || this.wordList[i].getWord_explain().equals(wordToDelete)) {
                this.size--;
                for (int j = i; j < this.size; j++) {
                    this.wordList[j] = this.wordList[j + 1];
                }
            }
        }
    }
}

