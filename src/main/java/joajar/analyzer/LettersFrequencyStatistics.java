package joajar.analyzer;

import java.util.Map;
import java.util.stream.Collectors;

public class LettersFrequencyStatistics implements Statistics<Map<Character, Double>> {
    @Override
    public Map<Character, Double> analyze(String myText) {
        Map<Character, Long> myMap = myText
                .chars()
                .mapToObj(x -> (char) x)
                .map(myLetter -> myLetter.toString().toLowerCase())
                .filter(myLetter -> myLetter.matches("\\p{L}"))
                .map(myString -> myString.charAt(0))
                .collect(Collectors.groupingBy(myLetter->myLetter, Collectors.counting()));

        Long totalLettersNumber = myMap.values()
                .stream()
                .reduce(Long::sum)
                .orElseThrow(IllegalArgumentException::new);

        return myMap
                .entrySet()
                .stream()
                .collect(Collectors.toMap(myLetter -> myLetter.getKey(),
                        myLetter -> (myLetter.getValue().doubleValue() / totalLettersNumber) * 100.0));
    }

    @Override
    public String interpret(String myText) {
        StringBuilder sb = new StringBuilder();
        sb.append("The list of characters' frequencies expressed as percentages:\n");
        for (Map.Entry<Character, Double> entry : analyze(myText).entrySet()) {
            sb.append(entry.getKey());
            sb.append(":  ");
            sb.append(String.format("%.2f", entry.getValue()));
            sb.append("%");
            sb.append("\n");
        }
        return sb.toString();
    }
}
