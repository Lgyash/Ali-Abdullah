package Facebook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {
	
	static WebDriver driver;
	static WebElement username;
	static WebElement password;
	static WebElement Login;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static XSSFCell cell;
	static String Emailtext;
	static String Passwordtext;
	int i = 0 ;

		
	@BeforeMethod
	public void Basic() throws InterruptedException{			
	    System.setProperty("webdriver.chrome.driver","C:\\Users\\aliab\\Desktop\\chromedriver_win32\\chromedriver.exe");
	    driver = new ChromeDriver(); 
	    String baseUrl = "https://www.facebook.com/";
	    driver.get(baseUrl);
	    driver.manage().window().maximize();
	    Thread.sleep(4000);
	}
	
    public static void readFile(int i) throws IOException 
    {
            File file = new File("src/test/java/Facebook/Mandoob-Data-Driven.xlsx");
            FileInputStream inputStream = new FileInputStream(file);	            
            workbook = new XSSFWorkbook(inputStream);
            sheet = workbook.getSheetAt(0);
            
            //Set the rows variable

            cell = sheet.getRow(i).getCell(2);
            DataFormatter formatter = new DataFormatter();
            Emailtext = formatter.formatCellValue(cell);
            
            cell = sheet.getRow(i).getCell(3);
            Passwordtext = formatter.formatCellValue(cell);
                    
              	          
    }
	
	
	
	public static void MainData() {
		
	    username = driver.findElement(By.id("email"));
	    password = driver.findElement(By.id("pass"));
	    Login = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/button[1]"));

	}
	
	
	
	@Test(priority=1)
	public void loginWithValidData() throws InterruptedException, IOException{
			i = 1; //iterator for row number;
		
			MainData();
			readFile(i);

			username.sendKeys(Emailtext);
		    password.sendKeys(Passwordtext);
		    Thread.sleep(2000);
		    
		    Login.click();
		    Thread.sleep(8000);
		}
	
	
	@Test(priority=2)
	public void loginWithInvalidEmail() throws InterruptedException, IOException{
		
			i = 5; //iterator for row number;
		
			MainData();
			readFile(i);

		    username.sendKeys(Emailtext);
		    password.sendKeys(Passwordtext);
		    Thread.sleep(2000);
		    
		    Login.click();
		    Thread.sleep(7000);
		}

	@Test(priority=3)
	public void loginWithWrongPassword() throws InterruptedException, IOException{
		
			i = 2; //iterator for row number;
			
			MainData();
			readFile(i);
	
		    username.sendKeys(Emailtext);
		    password.sendKeys(Passwordtext);
		    Thread.sleep(2000);
		    
		    Login.click();
		    Thread.sleep(7000);
		}
	
	

	@AfterMethod
	public void close() {
		driver.close();
	}
		
}
