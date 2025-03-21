package org.hamzakhan;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.hamzakhan.pageObjects.ios.AlertViews;
import org.hamzakhan.testUtils.IOSBaseTest;


public class IOSBasics extends IOSBaseTest {
	
	@Test
	public void IOSBasicTests() throws InterruptedException {
		
		// xpath, classname, IOS, iosclasschain, IOSPredicateString, accessibilityId, id
		openIosEyes(driver, "IOS App", "IOS Test 01");
		eyes.checkWindow("IOS: Initial View List");
		AlertViews alertViews = homePage.selectAlertViews();
		eyes.checkWindow("IOS: Alert Screen");
		alertViews.fillTextLabel("Hello");
		String actualMessage = alertViews.getConfirmMessage();
		eyes.checkWindow("IOS: View Confirmation Message");
		AssertJUnit.assertEquals(actualMessage, "A message should be a short, complete sentence.");
		alertViews.okConfirmMessage();
		}

}

