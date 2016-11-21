package com.git.qa.testsuites;
	import java.io.File;
	import java.io.FileInputStream;
	import java.util.Properties;

	import org.testng.Assert;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

import com.git.qa.common.WebDriverWrappers;
import com.git.qa.test.Init;
import com.git.qa.test.methods.CommonMethods;

	public class gitLoginWithInvalidAndValid extends Init {

		WebDriverWrappers wrapper = new WebDriverWrappers();
		CommonMethods methods = new CommonMethods();
		public String currDirectory = new File(System.getProperty("user.dir")).getAbsolutePath();
		Properties prop = new Properties();
		
		@BeforeClass
		public void loadDataProperties() throws Exception{
			String dataDirectory = currDirectory + File.separator + "global" + File.separator + "Data.properties";
			String dataFile = dataDirectory;
			prop.load(new FileInputStream(dataFile));
		}
		
		@Test(enabled = true, priority=1)
		public void launchGITUnsuccessful() throws Exception{
			logger.info("Test Purpose: GIT Hub Launch");
			String email = prop.getProperty("email");
			String invalidPwd = prop.getProperty("invalidPwd");
			boolean catFlag = false;
			catFlag = methods.unsuccessfullLoginToGit(driver, logger, email, invalidPwd);
			Assert.assertTrue(catFlag, "Failed to validate GIT Hub Launch");
		}
		
		@Test(enabled = true, priority=2)
		public void launchGITSuccessfully() throws Exception{
			logger.info("Test Purpose: GIT Hub Launch");
			String email = prop.getProperty("email");
			String pwd = prop.getProperty("pwd");
			boolean catFlag = false;
			catFlag = methods.successfullLoginToGit(driver, logger, email, pwd);
			Assert.assertTrue(catFlag, "Failed to validate GIT Hub Launch");
		}
		
		
		
		@Test(enabled= true, priority=3)
		public void validatingCloseBrowser() throws Exception{
		boolean catFlag = false;
		catFlag = methods.closeBrowser(driver, logger);
		Assert.assertTrue(catFlag, "Failed to Close the Browser");
	}
	}


