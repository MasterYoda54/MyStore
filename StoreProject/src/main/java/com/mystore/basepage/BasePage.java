package com.mystore.basepage;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.github.dockerjava.api.model.Driver;
import com.mystore.actiondriver.Actiondriver;
import com.mystore.utility.ExtentManager;


	public class BasePage  {
		
		//     some changes i have done later refer to GIT GITHUB       //
	
		public static Properties prop;
		public static WebDriver driver;
		public static Actiondriver action;
		
		@BeforeSuite(groups = {"Smoke","Sanity","Regression"})
		public void loadConfig() {
			  ExtentManager.setExtenet();
		
			try {
				prop = new Properties();
				FileInputStream fis=new FileInputStream(System.getProperty("user.dir") +"/configuration/Config.properties");
				prop.load(fis);
				System.out.println(prop.getProperty("username" +"password"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}
// ****singleton design pattern i have study about it ****		
		public Actiondriver loadActionDriver() {
			if(action==null) {
				action=new Actiondriver();
			}
			return action;
		}
		
		
		
		
		public void launchApp(String browserName) {
			
			//String browserName =prop.getProperty("browser");
			
			//WebDriver driver= new ChromeDriver();
			//WebDriverManager.chromedriver().setup();
	//prop.getProperty this will read the Config.properties and wich ever name of browser is given ther it will take
			//some changes i have done later
			
			
			if(browserName.equalsIgnoreCase("chrome")) {
//				WebDriverManager.chromedriver().setup();
				driver= new ChromeDriver();
				
			} else if(browserName.equalsIgnoreCase("Firefox")) {
//				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			}
			
			driver.manage().window().maximize();
			action.implicitWait(driver,10);
			action.pageLoadTimeOut(driver,15);
		   driver.get(prop.getProperty("url")); 
			
		}
		@AfterSuite
		public void afterSuite() {
			ExtentManager.EndReport();
		}
		
		public static WebDriver getdriver() {
			
			return driver;
		}
		
		
			
		}
		
	
	
