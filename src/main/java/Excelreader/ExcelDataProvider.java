package Excelreader;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {

	static WebDriver driver;

	
	//step 1
	@BeforeMethod
	public void setUp() {
		System.out.println("Start test");
		// Set the path for chromedriver.exe
		String path = System.getProperty("user.dir");
		System.out.println(path);
		System.setProperty("webdriver.chrome.driver", path + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		String url = "https://secure.test.magnushealth.net/";
		driver.get(url);
		driver.manage().window().maximize();

	}

	@DataProvider(name = "excel-data")
	public Object[][] excelDP() throws IOException {
		// We are creating an object from the excel sheet data by calling a
		// method that reads data from the excel stored locally in our system
		//here getExcelData is used where code is written below
		Object[][] arrObj = getExcelData("D:\\Amit Bhai\\CucumberFramework\\TestData\\data.xlsx","Credential");
		return arrObj;
	}

	//test cases using data provider
	@Test(dataProvider = "excel-data")
	public void search(String username, String password) throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='j_username']")).sendKeys(username);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='j_password']")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='login_button']")).click();
		Thread.sleep(1000);
		Reporter.log("Search results are displayed.");
	}

	    // This method handles the excel - opens it and reads the data from the
		// respective cells using a for-loop & returns it in the form of a string array
		public static Object[][] getExcelData(String fileName, String sheetName) {

			String[][] data = null;
			try {
				FileInputStream fis = new FileInputStream(fileName);
				XSSFWorkbook wb = new XSSFWorkbook(fis);
				XSSFSheet sh = wb.getSheet(sheetName);
				XSSFRow row = sh.getRow(0);
				
				int noOfRows = sh.getPhysicalNumberOfRows();
				int noOfCols = row.getLastCellNum();
				
				Cell cell;
				data = new String[noOfRows - 1][noOfCols];

				for (int i = 1; i < noOfRows; i++) {
					for (int j = 0; j < noOfCols; j++) {
						row = sh.getRow(i);
						cell = row.getCell(j);
						data[i - 1][j] = cell.getStringCellValue();
						
						
						switch (cell.getCellTypeEnum()) {
				        case BOOLEAN:
				            System.out.print(cell.getBooleanCellValue());
				            break;
				        case STRING:
				            System.out.print(cell.getRichStringCellValue().getString());
				            break;
				        case NUMERIC:
				            if (DateUtil.isCellDateFormatted(cell)) {
				                System.out.print(cell.getDateCellValue());
				            } else {
				            	Double testData= Double.valueOf(cell.getNumericCellValue()); 
				            	Integer doucon = testData.intValue();
				                System.out.print(doucon);
				            }
				            break;
				        case FORMULA:
				            System.out.print(cell.getCellFormula());
				            break;
				        case BLANK:
				            System.out.print("");
				            break;
				        default:
				            System.out.print("");
				    }
				    System.out.print("\t");
				}
				  System.out.println();
				}
			} catch (Exception e) {
				System.out.println("The exception is: " + e.getMessage());
			}
			return data;
		}
	@AfterMethod
	public void burnDown() {
		driver.quit();
	}
}
