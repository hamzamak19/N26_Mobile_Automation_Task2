package org.hamzakhan.pageObjects.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.hamzakhan.utils.AndroidGesture;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class CartPage extends AndroidGesture {
	
	AndroidDriver driver;
	
	public CartPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productPrices;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalAmountBill;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
	private WebElement termsConditionButton;
	
	@AndroidFindBy(id = "android:id/button1")
	private WebElement termsConditionClosePopup;
	
	@AndroidFindBy(className = "android.widget.CheckBox")
	private WebElement optionalCheckbox;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
	private WebElement proceedBtn;
	
	
	
		
	public Double calculateTotalAmount() throws InterruptedException {
		int productCount = productPrices.size();
		double totalsum =0.0;
        for (WebElement productPrice : productPrices) {
			String amountString = productPrice.getText();
			Double price = getFormattedAmount(amountString);
			totalsum = totalsum + price;
		}
		return totalsum;
	}
	
    public void verifyTotalSum(Double totalSum) {
        Double displayFormattedSum = getFormattedAmount(totalAmountBill.getText());
        Assert.assertEquals(totalSum, displayFormattedSum);
    }
	
	public void checkTermsAndCondition() {
		longPressAction(termsConditionButton);
		termsConditionClosePopup.click();
	}
	
	public void checkout() throws InterruptedException {
		optionalCheckbox.click();
		proceedBtn.click();
		Thread.sleep(6000);
	}
	
	
	
	

}
