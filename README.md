# ALTAIR Senior Software developer test 

Carefully read acceptance criteria.

As a rule of thumb, tests should cover the most part of functionality.


__WordCounter__

This class must count the number of occurrences of each word in the file 'Text.txt' and show them ordered
form more to less frequent with an occurrence count aside.

Acceptance criteria are listed below:

	-	You are totally free to create the project structure and implementation. 
	-	The already implemented classes can be used, edited or replaced in case you need
	-	Suggested output format is specified class WordCounter just to have uniform outcome, but, again, feel free to modify it.
	-	For testing, please use 'getFile(String fileName)' to access any custom-created test resource.

	
__Solution and Implementation decisions__

- A custom and simple implementation has been developed, without using frameworks like Hadoop or Spring Boot.
However, word count is a classic problem to solve with Hadoop MapReduce method.
- The implementation follows strictly the required task for the WordCounter class, that receives
text from a file, performs the word count and shows the results directly.
- There is a MainApplication class in which the WordCounter is called and executed, also measuring the 
performance time in milliseconds. To go to the basics, Spring Boot one line application runner 
has not been used.
- WordCounter class has two methods: wordCount, for the main functionality of the class; and showCounts,
to show the output with words and occurrences, as required. Following the SOLID principles
and to decouple the application, this class uses a DataProcessor class, in which the data is treated.
- DataProcess has a flag to getFile from different path/use different method depending on whether is
called in a test or not.
- When splitting the strings, a flag is used to treat text as it originally comes or ignore letter cases
and convert all the text to lower case. This makes a difference in the results. 
We also ignore the punctuation marks.
- A dummy interface called DataProcessor has been created in order to separate concerns and have
    a possible factory for different input data, ways of processing, etc. Even if it's a dummy interface,
the purpose of it is to open the application to extension.
- WordCounterTest is a dummy test class, in which some functionality is not fully tested, as
WordCounter also shows directly the information.
- Word process tests are performed in FileDataProcessorTest.