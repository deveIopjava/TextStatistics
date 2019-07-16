package joajar.analyzer;

public class WordsCountStatistics implements Statistics<Long> {
//   public class WordsFrequencyStatistics implements Statistics<Long> {

    @Override
    public Long analyze(String myText) {
        return Statistics.getWordsMap(myText)
                .values()
                .stream()
                .reduce(Long::sum)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public String interpret(String myText) {
        return String.format("The text contains %d words.\n", analyze(myText));
    }
}
