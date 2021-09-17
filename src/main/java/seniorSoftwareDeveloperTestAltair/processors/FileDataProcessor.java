package seniorSoftwareDeveloperTestAltair.processors;

import seniorSoftwareDeveloperTestAltair.fileUtils.FileUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * @class FileDataProcessor
 */
public class FileDataProcessor implements DataProcessor<String> {

    private boolean isTestMode;


    public FileDataProcessor(boolean isTestMode) {
        this.isTestMode = isTestMode;
    }

    @Override
    public List<String> readInput(String inputFile) {
        try {
            String filename = isTestMode ? FileUtils.getResourcesTestFilePath(inputFile) :
                    FileUtils.getResourcesFilePath(inputFile);
            return FileUtils.readFromFile(filename);
        } catch (FileNotFoundException e) {
            System.out.printf("\nFile '%s' not found.\n", inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public String[] cleanSplitWords(String words, boolean ignoreCase) {

        if (ignoreCase) words = words.toLowerCase();
        return words.replaceAll("\\p{Punct}", "")
                .split(" ");

    }

    @Override
    public Map<String, Integer> countWords(List<String> rawDataList, boolean ignoreCase) {
        Map<String, Integer> wordOccurrenceHashMap = new HashMap();
        for (String words : rawDataList) {
            String[] separatedWords = cleanSplitWords(words, ignoreCase);

            for (String str : separatedWords) {
                if (!str.isEmpty()) {
                    if (wordOccurrenceHashMap.containsKey(str.trim())) {
                        int count = wordOccurrenceHashMap.get(str.trim());
                        wordOccurrenceHashMap.put(str.toLowerCase(), count + 1);
                    } else {
                        wordOccurrenceHashMap.put(str, 1);
                    }
                }
            }
        }

        return wordOccurrenceHashMap;
    }


    public LinkedHashMap<String, Integer> orderHashMap(Map<String, Integer> wordMap) {
        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
        if (wordMap != null && !wordMap.isEmpty()) {
            wordMap.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), Integer.valueOf(x.getValue())));
        }

        return reverseSortedMap;
    }

}
