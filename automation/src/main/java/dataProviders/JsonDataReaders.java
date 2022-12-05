package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;

import managers.FileReaderManager;
import testDataTypes.TestData;

public class JsonDataReaders {
    private final String testDataFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath() + "testData.json";
	private List<TestData> testDataList;
	
	public JsonDataReaders(){
		testDataList = getCustomerData();
	}
	
	private List<TestData> getCustomerData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(testDataFilePath));
			TestData[] users = gson.fromJson(bufferReader, TestData[].class);
			return Arrays.asList(users);
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + testDataFilePath);
		}finally {
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {}
		}
	}

	public TestData getUserByName(String test) {
		System.out.println(test);
		for(TestData user : testDataList) {
			if(user.firstName.equalsIgnoreCase(test)) return user;
		}
		return null;
	}
	
	public TestData getUserById(int test) {
		System.out.println(test);
		for(TestData user : testDataList) {
			if(user.user_id == test) return user;
		}
		return null;
	}
}
	