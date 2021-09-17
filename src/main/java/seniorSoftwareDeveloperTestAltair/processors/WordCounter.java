package seniorSoftwareDeveloperTestAltair.processors;


import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @class WordCounter: counts the number of occurrences of each word in the
 * specified input file and shows them ordered from more to less frequent
 * with an occurrence count aside.
 *
 */
public class WordCounter {
    
	private static String ELEMENT_OUTPUT = "-  Word: %s  >> Occurrences: %s\n";

	private FileDataProcessor dataProcessor = new FileDataProcessor(false);
	private boolean isTestMode;

	public WordCounter() {
		this.dataProcessor = new FileDataProcessor(false);
	}

	public WordCounter(boolean isTestMode) {
		this.isTestMode = isTestMode;
		this.dataProcessor = new FileDataProcessor(isTestMode);
	}


	/**
	 * Method that uses a helper class DataProcessor to read data from the
	 * specified input, treat this data conveniently and counts words.
	 *
	 * @param inputFilename name of the input file
	 * @param ignoreCase if true, convert all words to lower case.
	 */
	public void countWords(String inputFilename, boolean ignoreCase) {
		List<String> rawDataList = dataProcessor.readInput(inputFilename);
		if (rawDataList != null && !rawDataList.isEmpty()) {
			LinkedHashMap<String, Integer> sortedMap = dataProcessor.orderHashMap(
					dataProcessor.countWords(rawDataList, ignoreCase)
			);
			showCounts(sortedMap);
		} else {
			System.out.println("\nNo data found\n");
		}
	}

	/**
	 * Show words and occurrences in the console output
	 * @param sortedMap
	 */
	private void showCounts(LinkedHashMap<String, Integer> sortedMap) {
		sortedMap.entrySet().stream().forEach(
				e-> System.out.printf(ELEMENT_OUTPUT, e.getKey(), e.getValue())
		);
	}


}
