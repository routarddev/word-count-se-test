package seniorSoftwareDeveloperTestAltair.fileUtils;

import java.io.File;

public class FileUtils {

	public static String PATH = "src/main/resources/%s";
	public static String TEST_PATH = "src/test/resources/%s";
	
	public static String getResourcesFilePath(String name) {
		return new File (String.format(PATH, name)).getAbsolutePath();
	}
	
	public static String getResourcesTestFilePath(String name) {
		return new File (String.format(TEST_PATH, name)).getAbsolutePath();
	}
}

