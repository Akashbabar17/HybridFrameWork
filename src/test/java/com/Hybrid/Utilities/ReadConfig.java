package com.Hybrid.Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	
	Properties prop;
	String path="C:\\Users\\admin\\New workspace\\HybridFrameWork\\Configuration\\Config.properties";
	
	public ReadConfig(){
		
		prop=new Properties();
		
		try {
			FileInputStream f=new FileInputStream(path); 
			prop.load(f);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public String getBaseUrl() {
		String value=prop.getProperty("baseURL");
		if(value!=null) {
			return value;
			
		}else {
			throw new RuntimeException("Url not specified in config file");
		}	
	} 
	public String getBrowser() {
		String value=prop.getProperty("browser");
		if(value!=null) {
			return value;
			
		}else {
			throw new RuntimeException("Browser not specified in config file");
		}	
	}

}
