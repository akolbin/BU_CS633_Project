package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.DriverType;
import enums.EnvironmentType;

public class ConfigFileReader {
	
	private Properties properties;
	private final String propertyFilePath= "configs//config.properties";

	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getDriverPath(){
		String driverPath = properties.getProperty("driverPath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
	}
	
	public long getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
		else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");		
	}
	
	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public DriverType getBrowser() {
		String browserName = properties.getProperty("browser");
		if(browserName == null || browserName.equals("chrome")) return DriverType.CHROME;
		else if(browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
		else if(browserName.equals("iexplorer")) return DriverType.INTERNETEXPLORER;
		else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}

	public EnvironmentType getEnvironment() {
		String environmentName = properties.getProperty("environment");
		if(environmentName == null || environmentName.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
		else if(environmentName.equals("remote")) return EnvironmentType.REMOTE;
		else throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
	}

	public Boolean getBrowserWindowSize() {
		String windowSize = properties.getProperty("windowMaximize");
		if(windowSize != null) return Boolean.valueOf(windowSize);
		return true;
	}
	
	public String getTestDataResourcePath(){
		String testDataResourcePath = properties.getProperty("testDataResourcePath");
		if(testDataResourcePath!= null) return testDataResourcePath;
		else throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");		
	}
	
	public String getReportConfigPath(){
		String reportConfigPath = properties.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}
	
	public String getuserId(){
		String user_id = properties.getProperty("user_id");
		if(user_id!= null) return user_id;
		else throw new RuntimeException("User id not specified in the Configuration.properties file for the Key:user_id");		
	}
	
	public String getFirstName(){
		String firstName = properties.getProperty("firstName");
		if(firstName!= null) return firstName;
		else throw new RuntimeException("First Name not specified in the Configuration.properties file for the Key:firstName");		
	}
	
	public String getLastName(){
		String lastName = properties.getProperty("lastName");
		if(lastName!= null) return lastName;
		else throw new RuntimeException("Last Name not specified in the Configuration.properties file for the Key:lastName");		
	}
	
	public String getEmailAddress(){
		String emailAddress = properties.getProperty("emailAddress");
		if(emailAddress!= null) return emailAddress;
		else throw new RuntimeException("Email Address not specified in the Configuration.properties file for the Key:emailAddress");		
	}
	
	public String getPhone(){
		String phoneNumber = properties.getProperty("phoneNumber");
		if(phoneNumber!= null) return phoneNumber;
		else throw new RuntimeException("Phone Number not specified in the Configuration.properties file for the Key:phoneNumber");		
	}
	
	public String getCountry() {
		String country = properties.getProperty("country");
		if(country!= null) return country;
		else throw new RuntimeException("Country not specified in the Configuration.properties file for the Key:country");
	}
	
	public String getSpecialRequests() {
		String special_requests = properties.getProperty("special_requests");
		if(special_requests!= null) return special_requests;
		else throw new RuntimeException("Special Requests not specified in the Configuration.properties file for the Key:special_requests");
	}
}