package seniorSoftwareDeveloperTestAltair;

import seniorSoftwareDeveloperTestAltair.processors.WordCounter;

import java.time.Duration;
import java.time.Instant;


public class MainApplication {

    public static void main(String[] args) {

        Instant start = Instant.now();

        WordCounter wordCounter = new WordCounter();
        wordCounter.countWords("Text.txt", true);

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("\n* Elapsed time: " + timeElapsed + " ms");
    }

}
