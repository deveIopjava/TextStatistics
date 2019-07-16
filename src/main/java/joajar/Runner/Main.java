package joajar.Runner;

import joajar.analyzer.LettersFrequencyStatistics;
import joajar.analyzer.LongestWordsStatistics;
import joajar.analyzer.WordsCountStatistics;
import joajar.analyzer.WordsFrequencyStatistics;
import joajar.fileReader.MyFileReader;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
;
        MyFileReader myFileReader = new MyFileReader();
        String myText = myFileReader.getText("PanTadeusz.txt");
        //String myText = myFileReader.getText("MyTest.txt");

        WordsCountStatistics wordsCountStatistics = new WordsCountStatistics();
        System.out.println(wordsCountStatistics.interpret(myText));

        LongestWordsStatistics longestWordsStatistics = new LongestWordsStatistics();
        System.out.println(longestWordsStatistics.interpret(myText));

        WordsFrequencyStatistics wordsFrequencyStatistics = new WordsFrequencyStatistics();
        System.out.println(wordsFrequencyStatistics.interpret(myText));

        LettersFrequencyStatistics lettersFrequencyStatistics = new LettersFrequencyStatistics();
        System.out.println(lettersFrequencyStatistics.interpret(myText));
    }
}
