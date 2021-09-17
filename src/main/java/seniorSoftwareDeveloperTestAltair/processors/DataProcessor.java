package seniorSoftwareDeveloperTestAltair.processors;

import java.util.List;
import java.util.Map;

/**
 * @class DataProcessor: dummy interface to extract main
 * functionalities of the processor.
 */
public interface DataProcessor<T> {

    public List<String> readInput(T inputType);
    public String[] cleanSplitWords(String rawData, boolean ignoreCase);
    public Map<String, Integer> countWords(List<String> rawDataList, boolean ignoreCase);

}
