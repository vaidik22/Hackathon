package utilities;
 
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
 
public class ScreenShot{
 
 
	public void takeScreenShot(WebDriver driver, String ssname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		String path = "C:\\Users\\2320033\\git\\repository\\HackathonDisplayBookShelfs\\Screenshots\\" + ssname + ".png";
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
	}
}