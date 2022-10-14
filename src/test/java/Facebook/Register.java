package Facebook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;






public class Register {

		static WebDriver driver;
		static WebElement Create;
		static WebElement Firstname;
		static WebElement Lastname;
		static WebElement Email;
		static WebElement Password;
		static WebElement BirthDate;
		static Select selectMonth;
		static Select selectDay;
		static Select selectYear;
		static WebElement Gender;
		static WebElement Submit;
		static WebElement ReEmail;
		static XSSFWorkbook workbook;
		static XSSFSheet sheet;
		static XSSFCell cell;
		static String Firstnametext;
		static String Lastnametext;
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
                cell = sheet.getRow(i).getCell(0);
                DataFormatter formatter = new DataFormatter();
                Firstnametext = formatter.formatCellValue(cell);
                
                cell = sheet.getRow(i).getCell(1);
                Lastnametext = formatter.formatCellValue(cell);
                
                cell = sheet.getRow(i).getCell(2);
                Emailtext = formatter.formatCellValue(cell);
                
                cell = sheet.getRow(i).getCell(3);
                Passwordtext = formatter.formatCellValue(cell);
	                    
	              	          
	    }
		
		
	    public static void MainData() {
	    	Firstname = driver.findElement(By.xpath("//input[contains(@name, 'firstname')]"));
	    	Lastname = driver.findElement(By.xpath("//input[@name='lastname']"));
	    	Email = driver.findElement(By.xpath("//input[@name='reg_email__']"));
	    	Password = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
	    	BirthDate = driver.findElement(By.xpath("//select[@name='birthday_month']"));
	    	selectMonth = new Select(driver.findElement(By.xpath("//select[@name='birthday_month']")));
	        selectDay = new Select(driver.findElement(By.xpath("//select[@name='birthday_day']")));
	        selectYear = new Select(driver.findElement(By.xpath("//select[@name='birthday_year']"))); 
	        Gender = driver.findElement(By.xpath("//label[contains(text(),'Male')]"));
	        Submit = driver.findElement(By.xpath("//button[@name='websubmit']"));
	        ReEmail = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/input[1]"));

	    }
	    
		
		@Test(priority = 1)
	    public void RegisterWithValidData() throws InterruptedException, IOException{
			
			i = 1; //iterator for row number;
			
	        //Register New Account
			driver.findElement(By.linkText("Create New Account")).click();
	        Thread.sleep(3000);
	        
			MainData();
			readFile(i);
			
	        Firstname.sendKeys(Firstnametext);
	        Thread.sleep(2000);
	        
	        Lastname.sendKeys(Lastnametext);
	        Thread.sleep(2000);
	        
	        Email.sendKeys(Emailtext);
	        Thread.sleep(2000);
	        
	        ReEmail.sendKeys(Emailtext);
	        Thread.sleep(3000);
	        
	        Password.sendKeys(Passwordtext);
	        Thread.sleep(2000);
	        
	        BirthDate.click();
	        Thread.sleep(2000);
	        
	        selectMonth.selectByVisibleText("Jun");
	        
	        selectDay.selectByVisibleText("15");
	        
	        selectYear.selectByVisibleText("1994");
	        Thread.sleep(2000);
	        
	        Gender.click();
	        Thread.sleep(2000);

	        //Submit the Account
	        Submit.click();
		    Thread.sleep(7000);
	    }
		
		@Test(priority = 2)
	    public void RegisterWithInValidFirstname() throws InterruptedException, IOException{
			
			i = 4; //iterator for row number;
			
	        //Register New Account
			driver.findElement(By.linkText("Create New Account")).click();
	        Thread.sleep(3000);
	        
			MainData();
			readFile(i);
	        
	        Firstname.sendKeys("@#$@#$");
	        Thread.sleep(2000);
	        
	        Lastname.sendKeys("mandoob");
	        Thread.sleep(2000);
	        
	        Email.sendKeys("ali_nijbpye_ma5ndoob@gmail.com");
	        Thread.sleep(2000);
	        
	        ReEmail.sendKeys("ali_nijbpye_ma5ndoob@gmail.com");
	        Thread.sleep(3000);
	        
	        Password.sendKeys("Aliali123321@@");
	        Thread.sleep(2000);
	        
	        BirthDate.click();
	        Thread.sleep(2000);
	        
	        selectMonth.selectByVisibleText("Jun");
	        
	        selectDay.selectByVisibleText("15");
	        
	        selectYear.selectByVisibleText("1994");
	        Thread.sleep(2000);
	        
	        Gender.click();
	        Thread.sleep(2000);

	        //Submit the Account
	        Submit.click();
		    Thread.sleep(7000);
	    }
		
		@Test(priority = 3)
	    public void RegisterWithInValidLastname() throws InterruptedException, IOException{
			
			i = 6; //iterator for row number;
			
	        //Register New Account
			driver.findElement(By.linkText("Create New Account")).click();
	        Thread.sleep(3000);
	        
			MainData();
			readFile(i);
	        
	        Firstname.sendKeys("Ali");
	        Thread.sleep(2000);
	        
	        Lastname.sendKeys("#$%#$%");
	        Thread.sleep(2000);
	        
	        Email.sendKeys("a4li_nijbpye_mandoob@gmail.com");
	        Thread.sleep(2000);
	        
	        ReEmail.sendKeys("a4li_nijbpye_mandoob@gmail.com");
	        Thread.sleep(3000);
	        
	        Password.sendKeys("Aliali123321@@");
	        Thread.sleep(2000);
	        
	        BirthDate.click();
	        Thread.sleep(2000);
	        
	        selectMonth.selectByVisibleText("Jun");
	        
	        selectDay.selectByVisibleText("15");
	        
	        selectYear.selectByVisibleText("1994");
	        Thread.sleep(2000);
	        
	        Gender.click();
	        Thread.sleep(2000);

	        //Submit the Account
	        Submit.click();
		    Thread.sleep(7000);
	    }
		
		@Test(priority = 4)
	    public void RegisterWithInValidEmailAddress() throws InterruptedException, IOException{
			
			i = 5; //iterator for row number;
			
	        //Register New Account
			driver.findElement(By.linkText("Create New Account")).click();
	        Thread.sleep(3000);
	        
			MainData();
			readFile(i);
	        
	        Firstname.sendKeys("Ali");
	        Thread.sleep(2000);
	        
	        Lastname.sendKeys("mandoob");
	        Thread.sleep(2000);
	        
	        Email.sendKeys("ali_nijbpye_mandoob@tfbnw");
	        Thread.sleep(2000);
	        
	        Password.sendKeys("Aliali123321@@");
	        Thread.sleep(2000);
	        
	        BirthDate.click();
	        Thread.sleep(2000);
	        
	        selectMonth.selectByVisibleText("Jun");
	        
	        selectDay.selectByVisibleText("15");
	        
	        selectYear.selectByVisibleText("1994");
	        Thread.sleep(2000);
	        
	        Gender.click();
	        Thread.sleep(2000);

	        //Submit the Account
	        Submit.click();
		    Thread.sleep(7000);
	    }
		
		@Test(priority = 5)
	    public void RegisterWithInValidMobileNumber() throws InterruptedException, IOException{

			i = 7; //iterator for row number;
			
	        //Register New Account
			driver.findElement(By.linkText("Create New Account")).click();
	        Thread.sleep(3000);
	        
			MainData();
			readFile(i);
	        
	        Firstname.sendKeys("Ali");
	        Thread.sleep(2000);
	        
	        Lastname.sendKeys("mandoob");
	        Thread.sleep(2000);
	        
	        Email.sendKeys("there's text phone number");
	        Thread.sleep(2000);
	        
	        Password.sendKeys("Aliali123321@@");
	        Thread.sleep(2000);
	        
	        BirthDate.click();
	        Thread.sleep(2000);
	        
	        selectMonth.selectByVisibleText("Jun");
	        
	        selectDay.selectByVisibleText("15");
	        
	        selectYear.selectByVisibleText("1994");
	        Thread.sleep(2000);
	        
	        Gender.click();
	        Thread.sleep(2000);

	        //Submit the Account
	        Submit.click();
		    Thread.sleep(7000);
	    }
		
		@Test(priority = 6)
	    public void RegisterWithInValidPassword() throws InterruptedException, IOException{
			
			i = 3; //iterator for row number;
			
	        //Register New Account
			driver.findElement(By.linkText("Create New Account")).click();
	        Thread.sleep(3000);
	        
			MainData();
			readFile(i);
	        
	        Firstname.sendKeys("Ali");
	        Thread.sleep(2000);
	        
	        Lastname.sendKeys("mandoob");
	        Thread.sleep(2000);
	        
	        Email.sendKeys("ali_nijbp77ye_mandoob@gmail.com");
	        Thread.sleep(2000);
	        
	        ReEmail.sendKeys("ali_nijbp77ye_mandoob@gmail.com");
	        Thread.sleep(3000);
	        
	        Password.sendKeys("Al");
	        Thread.sleep(2000);
	        
	        BirthDate.click();
	        Thread.sleep(2000);
	        
	        selectMonth.selectByVisibleText("Jun");
	        
	        selectDay.selectByVisibleText("15");
	        
	        selectYear.selectByVisibleText("1994");
	        Thread.sleep(2000);
	        
	        Gender.click();
	        Thread.sleep(2000);

	        //Submit the Account
	        Submit.click();
		    Thread.sleep(7000);
	    }
	
	
	@AfterMethod
	public void close() {
		driver.close();
	}
		
}
