package org.hamzakhan.pageObjects.ios;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.hamzakhan.utils.IOSGesture;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomePage extends IOSGesture {
	
	IOSDriver driver;
	
	
	public HomePage(IOSDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
	@iOSXCUITFindBy(accessibility="Alert Views")
	private WebElement alertViews;
	
	public AlertViews selectAlertViews() {
		alertViews.click();
		return new AlertViews(driver);
	}

	

}
