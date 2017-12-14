package com.chun.design.d01_singleton;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class SingletonEncryConfig {
	Properties prop = null;
	private static String confDir=null;
	private static class SingletonHolder {

		private static SingletonEncryConfig instance = new SingletonEncryConfig(
				confDir);
	}
	private SingletonEncryConfig() {
	}

	private SingletonEncryConfig(String confDir) {
		prop = new Properties();
		FileInputStream in = null;
		try {
			in = new FileInputStream(confDir);
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (in!=null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		 
	}

	public Set<String> getPropertyNames(){
		return prop.stringPropertyNames();
	}
 

	public String getStringProperty(String key) {

		return prop.getProperty(key);
	}

	public static SingletonEncryConfig getInstance(String configPath) {
		SingletonEncryConfig.confDir = configPath;
		return SingletonHolder.instance;
	}
 
}
