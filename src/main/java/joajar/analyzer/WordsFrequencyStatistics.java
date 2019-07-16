package joajar.analyzer;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordsFrequencyStatistics implements Statistics<List<String>>{
    /*
    Gives 10 words that occur most frequently.
     */

    //Define constants in order to avoid so-called "magic numbers".
    int howManyWords = 10;

    @Override
    public List<String> analyze(String myText) {
        return Statistics.getWordsMap(myText)
                //for a given map f:={(x1,y1),(x2,y2), ...},  f.entrySet() is a set consisted of entries of f treated as a set
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(howManyWords)
                .map(mapEntry -> mapEntry.getKey())
                .collect(Collectors.toList());
    }

    @Override
    public String interpret(String myText) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The list of %d most popular words:\n",howManyWords));
        for (String entry : analyze(myText)) {
            sb.append(entry);
            sb.append("\n");
        }
        return sb.toString();
    }
}
