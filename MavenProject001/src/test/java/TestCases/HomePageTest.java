package TestCases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePoint.BaseCase;
import pages.FormPage;
import pages.HomePage;
import readExcelDataProvider.ReadExcelByDataProvider;

public class HomePageTest extends BaseCase {

	public HomePageTest() throws IOException {
		super();

	}

	@BeforeTest
	void init() {
		BaseCase.setup();

	}

	@Test(priority = 1)
	void LogoTest() throws IOException {
		HomePage home = new HomePage();
		home.isLogoPresent();

	}
	
	@Test(priority=2)
	void formClickableTest() throws IOException, InterruptedException
	{
		HomePage home = new HomePage();
		 FormPage fm = home.IsFormClickable();
		 fm.IsFormInputPage();
	
		
		
	}

	@Test(dataProvider = "testData",priority = 3)
	void DataInputFormTest(String fname, String lname, String mailId, String gender, String phnNo, String DOB)
			throws IOException {

		FormPage fmpage = new FormPage();
		fmpage.AddDataToForm(fname, lname, mailId, gender, phnNo, DOB);

	}

	@AfterTest
	void finish() {
		driver.close();
	}

	@DataProvider(name = "testData")
	Object[][] userFormData() throws IOException {

		ReadExcelByDataProvider readData = new ReadExcelByDataProvider();

		Object[][] data = readData.testData(prob.getProperty("testDataSheetPath"));
		return data;

	}

}
