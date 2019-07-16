package joajar.analyzer;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LongestWordsStatistics implements Statistics<List<String>> {
    /*
    Gives 10 longest words that occur only once.
     */

    //Define constants in order to avoid so-called "magic numbers".
    int numberOfOccurrences = 1;
    int howManyWords = 10;

    @Override
    public List<String> analyze(String myText) {
        return Statistics.getWordsMap(myText)
                //for a given map f:={(x1,y1),(x2,y2), ...},  f.entrySet() is a set consisted of entries of f treated as a set
                .entrySet()
                //make a stream
                .stream()
                //choose only entries that have Value from (Key,Value) equal to 1, i.e. such as a word Value occurs only once
                .filter(entryFromEntrySet -> entryFromEntrySet.getValue() == numberOfOccurrences)
                //sorting decreasingly using "Key" values
                .sorted((x,y) -> y.getKey().length() - x.getKey().length())
                //taking howManyWords=10 words
                .limit(howManyWords)
                //get keys (values are = numberOfOccurrence=1 so they are not necessary)
                //compare with https://stackoverflow.com/questions/1383797/java-hashmap-how-to-get-key-from-value
                .map(Map.Entry::getKey)
                //make a list
                .collect(Collectors.toList());
    }

    @Override
    public String interpret(String myText) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The list of %d longest words which were used in the text only once:\n",howManyWords));
        for (String entry : analyze(myText)) {
            sb.append(entry);
            sb.append("\n");
        }
        return sb.toString();
    }
}
