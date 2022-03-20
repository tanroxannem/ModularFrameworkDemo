package commonLibs.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotsUtils {

	private TakesScreenshot camera;

	public ScreenshotsUtils(WebDriver driver) {
		// TODO Auto-generated constructor stub

		/*
		 * //type casted this driver instance which take screenshots interface , we can
		 * use the same browser to take screenshot.
		 */
		camera = (TakesScreenshot) driver;
	}
	
	public void captureAndSaveScreenshot(String filename) throws Exception{
		
		filename = filename.trim();
		
		File imgFile, tmpFile;
		
		imgFile = new File(filename);
		
		if(imgFile.exists()) {
			throw new Exception("File already exist");
		}
		
		tmpFile = camera.getScreenshotAs(OutputType.FILE);
		
		FileUtils.moveFile(tmpFile, imgFile);
	}

}
