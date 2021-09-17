package seniorSoftwareDeveloperTestAltair.fileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtils {

	public static String PATH = "src/main/resources/%s";
	public static String TEST_PATH = "src/test/resources/%s";
	
	public static String getResourcesFilePath(String name) {
		return new File (String.format(PATH, name)).getAbsolutePath();
	}
	
	public static String getResourcesTestFilePath(String name) {
		return new File (String.format(TEST_PATH, name)).getAbsolutePath();
	}



	/**
	 * Extract data from a file
	 * @param fileName where to find the required information
	 * @throws Exception error message if something went wrong
	 * @return
	 */
	public static List<String> readFromFile(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		return br.lines().collect(Collectors.toList());
	}

}

