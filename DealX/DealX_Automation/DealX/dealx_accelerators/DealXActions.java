package dealx_accelerators;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dealx_accelerators.DealXActions;
import dealx_utility.DealXExceptionHandle;
import dealx_utility.DealXUtils;
import dealx_utility.DealXExceptionHandle;
import dealx_accelerators.DealXBase;
import dealx_utility.DealXExceptionHandle;

public class DealXActions extends DealXBase {

	public static String sTestCaseName;
	public static final String NonMatterSpecificTestData= System.getProperty("user.dir")+DealXUtils.getProperty("nonMatterSpecificTestDataPath");
	public static final String BondsTestData= System.getProperty("user.dir")+DealXUtils.getProperty("bondsTestDataPath");
	public static final String TransfersTestData= System.getProperty("user.dir")+DealXUtils.getProperty("transfersTestDataPath");
	public static final String ConsentsTestData = System.getProperty("user.dir")+DealXUtils.getProperty("consentsTestDataPath");
	public static final String EnvironmentURL = DealXUtils.getProperty("environmentURL");
	
	public static boolean isElementVisible(By object, String elementName) {
		boolean bFlag = false;
		try {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
			if(driver.findElements(object).size() > 0) {
				bFlag = true;
			}
		} catch (Exception e)  {		
			DealXExceptionHandle.HandleException(e, "Unable to check if the element " + elementName + " is visible");
		} 
		return bFlag;
	}
	
	public static boolean IsTextboxEmpty(By object, String sElementName) {
		boolean bFlag = false;
		try {
			if (driver.findElement(object).isDisplayed()) {				
				if (driver.findElement(object).getAttribute("value").isEmpty()) {
					bFlag = true;
				}
			} else {
				bFlag = false;
			}
		} catch (Exception e) {
			DealXExceptionHandle.HandleException(e, "Unable to check if the element " + sElementName + " is empty");
		}
		return bFlag;
	}
	
	public static boolean waitForElementToBeClickable(By Locator, long lTime) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, lTime);
			wait.until(ExpectedConditions.elementToBeClickable(Locator));
			return true;
		} catch (Exception e) {
			DealXExceptionHandle.HandleException(e, "Failed to wait for element to be visible");
			return false;
		}
	}
	
	public static boolean waitForElementToBeVisible(By Locator, long lTime) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, lTime);
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
			return true;
		} catch (Exception e) {
			DealXExceptionHandle.HandleException(e, "Failed to wait for element to be visible");
			return false;
		}
	}
	public static boolean waitForElementToBeInvisible(By Locator, long lTime) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, lTime);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(Locator));
			return true;
		} catch (Exception e) {
			DealXExceptionHandle.HandleException(e, "Failed to wait for element to be invisible");
			return false;
		}
	}

	public static void clearTextBox(By object, String elementName) {
		try {
			if (driver.findElement(object).isDisplayed()) {
				driver.findElement(object).clear();
			} else DealXExceptionHandle.HandleAssertion("Unable to find Element " + elementName);
		} catch (Exception e) {
			DealXExceptionHandle.HandleException(e, "Failed to clear the text in the textbox " + elementName);
		}
	}
	
	public static void pressBackspace(By object, String elementName) {
		try {
			if (driver.findElement(object).isDisplayed()) {
				while(!DealXActions.IsTextboxEmpty(object, elementName)) {
					driver.findElement(object).sendKeys(Keys.BACK_SPACE);
				}
			} else DealXExceptionHandle.HandleAssertion("Unable to find Element " + elementName);
		} catch (Exception e) {
			DealXExceptionHandle.HandleException(e, "Failed to clear the text in the textbox " + elementName);
		}
	}

	public static void typeInTextBox(By object, String data, String elementName) {
		try {
			if (driver.findElement(object).isDisplayed()) {
				driver.findElement(object).clear();
				driver.findElement(object).click();
				driver.findElement(object).sendKeys(data);
			} else DealXExceptionHandle.HandleAssertion("Failed to confirm if " + elementName + " is Displayed");
		} catch (Exception e) {
			DealXExceptionHandle.HandleException(e, "Failed to enter data in " + elementName + " textbox");
		}
	}

	public static void typeInTextBoxWithoutClear(By object, String data, String elementName) {
		try {
			if (driver.findElement(object).isDisplayed()) {
				driver.findElement(object).click();
				driver.findElement(object).sendKeys(data);
			} else DealXExceptionHandle.HandleAssertion("Failed to enter data in " + elementName + " textbox");
		} catch (Exception e) {
			DealXExceptionHandle.HandleException(e, "Failed to enter data in " + elementName + " textbox");
		}
	}

	public static void typeInCalander(By object, String data, String elementName) {
		try {
			if (driver.findElement(object).isDisplayed()) {
				driver.findElement(object).click();
				driver.findElement(object).clear();
				driver.findElement(object).sendKeys(data);
				WebElement we = driver.findElement(By.xpath("//div[@class= 'datepicker-days']//td[@class='active day']"));
				we.click();
			} else DealXExceptionHandle.HandleAssertion("Failed to enter data in " + elementName + " Calendar");
		} catch (Exception e) {
			DealXExceptionHandle.HandleException(e, "Failed to enter data in " + elementName + " Calendar");
		}
	}

	public static boolean jsClickOnElement(By object, String elementName) {
		boolean bFlag = false;
		try {
			if (driver.findElement(object).isDisplayed()) {
				bFlag = true;
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", driver.findElement(object));
			} else DealXExceptionHandle.HandleAssertion("Failed to click on " + elementName);
			Thread.sleep(1000);
		} catch (Exception e) {
			DealXExceptionHandle.HandleException(e, "Failed to click on " + elementName);
		}
		return bFlag;
	}

	public static boolean clickOnElement(By object, String elementName) {		
		try {
			if (driver.findElement(object).isDisplayed()) {
				driver.findElement(object).click();
				Thread.sleep(1000);
				return true;
			} else DealXExceptionHandle.HandleAssertion("Failed to click on " + elementName);
		} catch (Exception e) {
			DealXExceptionHandle.HandleException(e, "Failed to click on " + elementName);
		}
		return false;
	}

	public static boolean isTextElementEnabled(By object, String sElementName) {
		try {
			if(driver.findElement(object).isEnabled())
				return true;
		}
		catch(Exception e) {
			DealXExceptionHandle.HandleException(e, "Unable to confirm if text element is enabled" + sElementName);
		}
		return false;
	}

	public static String getElementText(By object, String elementName) {
		String sText = "";
		try {
			if (driver.findElement(object).isDisplayed()) {
				sText = driver.findElement(object).getText();
			} else DealXExceptionHandle.HandleAssertion("Failed to get text from " + elementName);
		} catch (Exception e) {
			DealXExceptionHandle.HandleException(e, "Failed to get text from " + elementName);
		}
		return sText;
	}
	
	public static String GetScreenShot() throws Exception {
		String sScreenShotNameWithPath = null;
		try {
			Date oDate = new Date();
			SimpleDateFormat oSDF = new SimpleDateFormat("yyyyMMddHHmmss");
			String sDate = oSDF.format(oDate);
			File fScreenshot = ((TakesScreenshot)DealXBase.driver).getScreenshotAs(OutputType.FILE);
			sScreenShotNameWithPath = System.getProperty("user.dir")+"\\LexisConveyOnlineData\\target\\cucumber-reports\\Screenshots\\"+"Screenshot_" + sDate + ".png";
			FileUtils.copyFile(fScreenshot, new File(sScreenShotNameWithPath));
		} catch (Exception e) {
			DealXExceptionHandle.HandleScreenShotException(e, "Unable to take screen shot");
		}

		return sScreenShotNameWithPath;
	}
	public static String getCurrentDate(String strFormat) {
		String Date = "";
		try {
			DateFormat dateFormat = new SimpleDateFormat(strFormat);
			Date dateObj = new Date();
			Date = dateFormat.format(dateObj);
		} catch (Exception e) {
			DealXExceptionHandle.HandleException(e, "Unable to get current Date");
		}
		return Date;
	}
	public static void HoverMouse(By object) {
		try {
			Actions action = new Actions(DealXBase.driver);
			WebElement element = driver.findElement(object);			
			action.moveToElement(element).perform();
		} catch (Exception e) {
			DealXExceptionHandle.HandleException(e, "Failed to hover over the element");
		}
	}	
}
