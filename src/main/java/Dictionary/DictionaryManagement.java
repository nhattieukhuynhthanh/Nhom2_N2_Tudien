package Dictionary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class DictionaryManagement {
    public Dictionary dictionary;

    public DictionaryManagement() {
        dictionary = new Dictionary();
    }

    /**
     * import from file
     */
    public void importFromFile() {
        try {
            FileReader fileReader = new FileReader("src/main/resources/dictionary_data.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] splitData = line.split(",");
                Word word = new Word(splitData[1], splitData[2]);
                dictionary.addWord(word);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Export
     */
    public void ExportToFile() {
        try {
            FileWriter fw = new FileWriter("src/main/resources/dictionary_data.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < dictionary.getsize(); ++i) {
                bw.write((i + 1) + "," + dictionary.getWordList()[i].getWord_target() + "," + dictionary.getWordList()[i].getWord_explain().trim());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
