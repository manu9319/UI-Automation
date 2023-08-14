package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro ;
	
	public ReadConfig() {
		File src = new File("./configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}catch(Exception e){
			System.out.println("Exception is "+ e.getMessage());
		}
	}
	
	public String getBaseUrl() {
		return pro.getProperty("baseUrl");
	}
	public String getUserName() {
		return pro.getProperty("userName");
	}
	public String getPassword() {
		return pro.getProperty("password");
	}

	public String getChromePath() {
		return pro.getProperty("chromePath");
	}
	
	public String getPassedTCSSPath() {
		return pro.getProperty("passedTCSSPath");
	}
	
	public String getFailedTCSSPath() {
		return pro.getProperty("failedTCSSPath");
	}
}
