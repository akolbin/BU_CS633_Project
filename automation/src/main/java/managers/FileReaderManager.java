package managers;

import dataProviders.ConfigFileReader;
import dataProviders.JsonDataReaders;

public class FileReaderManager {
	
	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigFileReader configFileReader;
	private static JsonDataReaders jsonDataReaders;
	
	private FileReaderManager() {
	}

	 public static FileReaderManager getInstance( ) {
	      return fileReaderManager;
	 }

	 public ConfigFileReader getConfigReader() {
		 return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
	 }
	 
	 public JsonDataReaders getJsonReader(){
		 return (jsonDataReaders == null) ? new JsonDataReaders() : jsonDataReaders;
	}

}
