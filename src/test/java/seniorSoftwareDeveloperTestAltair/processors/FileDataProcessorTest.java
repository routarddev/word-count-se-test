package seniorSoftwareDeveloperTestAltair.processors;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class FileDataProcessorTest {

    public FileDataProcessor classUnderTest = new FileDataProcessor(true);


    @Test public void testReadInputExistingFile() {
        List<String> currentText = Arrays.asList(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.",
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        List<String> inputText = classUnderTest.readInput("LoreIpsum.txt");
        assertEquals(currentText, inputText);
    }

    @Test public void testReadInputNonExistingFile() {
        classUnderTest.readInput("NoFile");
    }

    @Test public void testCleanSplitWords() {
        String words = "Det er mye vær i Norge og nordmenn er opptatt av været.";
        String[] wordsArray = classUnderTest.cleanSplitWords(words,true);
        assertNotNull(words);
        System.out.println(Arrays.toString(wordsArray));
        assertEquals(words.split(" ").length, wordsArray.length);
    }

    @Test public void testCleanSplitWordsWithPunctuation() {
        String words = "Det er mye vær i !! Norge : og nordmenn ,   er opptatt av været.";
        String[] wordsArray = classUnderTest.cleanSplitWords(words,true);
        assertNotNull(words);
        assertEquals(words.split(" ").length, wordsArray.length);
    }

    @Test public void testCountWordsIgnoreCase() {
        List<String> data = Arrays.asList("A cup having more cups inside a cup");
        Map<String, Integer> hashMap = classUnderTest.countWords(data, true);
        assertNotNull(hashMap);
        assertFalse(hashMap.isEmpty());
        assertEquals(6, hashMap.size());
    }

    @Test public void testCountWords() {
        List<String> data = Arrays.asList("A cup having more cups inside a cup");
        Map<String, Integer> hashMap = classUnderTest.countWords(data, false);
        assertNotNull(hashMap);
        assertFalse(hashMap.isEmpty());
        assertEquals(7, hashMap.size());
    }

    @Test public void testOrderHashMap() {
        Map<String, Integer> wordHashMap = new HashMap<String, Integer>() {{
            put("key1", 5);
            put("key2", 2);
            put("key3", 25);
            put("key4", 1);
            put("key5", 9);
        }};
        LinkedHashMap<String, Integer> orderedHashMap = classUnderTest.orderHashMap(wordHashMap);
        assertNotNull(orderedHashMap);
        assertFalse(orderedHashMap.isEmpty());
        assertEquals(5, orderedHashMap.entrySet().size());
        assertEquals(25, orderedHashMap.values().iterator().next().intValue());
    }


}
