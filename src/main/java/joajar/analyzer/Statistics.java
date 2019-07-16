package joajar.analyzer;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public interface Statistics<T> {

    T analyze(String myText);

    String interpret(String myText);

    static Map<String, Long> getWordsMap(String myText){
        return Arrays.stream(myText.split(" "))
                .map(singleWord -> singleWord.toLowerCase().replaceAll("[^\\p{LD}\\s]","").trim())
                .filter(singleWord -> singleWord.length()>0)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    }
}
