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
	
	
__Development decisions__

- A custom and simple implementation has been developed, without using frameworks like Hadoop or Spring Boot.
However, word count is a classic problem to solve with Hadoop MapReduce method.
- The implementation follows strictly the required task for the WordCounter class, that receives
text from a file, performs the word count and shows the results directly.
- A dummy interface called DataProcessor has been created in order to separate concerns and have
    a possible factory for different input data, ways of processing, etc.
- WordCounterTest is a dummy test class, in which some functionality is not fully tested, as
WordCounter also shows directly the information.
- Word process tests are performed in FileDataProcessorTest.