package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class UtilityFunctions {
	public static WebDriver driverObject;
	public static SoftAssert softAssertObject;
	public static Properties propertiesObject;

	public static WebDriver browserinitialization() throws IOException {
//		DesiredCapabilities cap = DesiredCapabilities.chrome();
//		cap.setCapability("download.default_directory", "C:");
//		cap.setCapability("download.prompt_for_download", "false");
//		cap.setCapability("directory_upgrade", "true");
//		cap.setCapability("plugins.plugins_disabled", "Chrome PDF Viewer");
		Properties propertiesObject = new Properties();
		FileInputStream fileObj = new FileInputStream(
				"C:\\Users\\sakgupta1\\eclipse-workspace\\LogoEcommerce\\src\\main\\java\\resources\\DataDriven.properties");
		propertiesObject.load(fileObj);
		if (propertiesObject.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", propertiesObject.getProperty("ChromeExeFilePath"));
			driverObject = new ChromeDriver();
		} else if (propertiesObject.getProperty("browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", propertiesObject.getProperty("FireFoxExeFilePath"));
			driverObject = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.ie.driver", propertiesObject.getProperty("IEExeFilePath"));
			driverObject = new InternetExplorerDriver();
		}

		driverObject.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driverObject;
	}

	public static Properties propertiesFileLoad() throws IOException {
		propertiesObject = new Properties();
		FileInputStream fileObj = new FileInputStream(
				"C:\\Users\\sakgupta1\\eclipse-workspace\\LogoEcommerce\\src\\main\\java\\resources\\DataDriven.properties");
		propertiesObject.load(fileObj);
		return propertiesObject;
	}

	public static SoftAssert softAssertObject() {
		SoftAssert softAssertObject = new SoftAssert();
		return softAssertObject;
	}

	public static Select selectObject(WebElement element) {
		Select selectObj = new Select(element);
		return selectObj;

	}

	public static WebDriverWait explicitWait() {
		WebDriverWait waitObject = new WebDriverWait(driverObject, 10);
		return waitObject;
	}

	public static Actions actionObject(WebDriver driverObject) {
		Actions actionObject = new Actions(driverObject);
		return actionObject;

	}

	public String handlingMultipleWindows(WebDriver driverObj) {
		String mainWindowHandle = driverObject.getWindowHandle();
		Set<String> ids = driverObj.getWindowHandles();
		Iterator<String> iteratorObject = ids.iterator();
		while (iteratorObject.hasNext()) {
			driverObj.switchTo().window(iteratorObject.next());
			driverObj.manage().window().maximize();
			System.out.println(driverObj.getTitle());
		}
		return mainWindowHandle;

	}

	protected File getLatestFilefromDire(String dirPath) {
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			System.out.println("FIle not downloaded");
			return null;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				System.out.println("FIle downloaded");
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}

	protected File getLatestFilefromDir(String dirPath) {
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			System.out.println("FIle not downloaded");
			return null;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				System.out.println("FIle downloaded");
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}

}
