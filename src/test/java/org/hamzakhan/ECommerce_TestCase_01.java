package org.hamzakhan;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;


import org.hamzakhan.pageObjects.android.CartPage;
import org.hamzakhan.pageObjects.android.ProductCatalog;
import org.hamzakhan.testUtils.AndroidBaseTest;


public class ECommerce_TestCase_01 extends AndroidBaseTest{
	
	@Test(dataProvider = "getData", groups= {"Smoke"})
	public void fillForm(HashMap<String, String> input) throws InterruptedException  {
		openAndroidEyes(driver, "Android App", "Android Test 1");
		formPage.setNameField(input.get("name"));
		formPage.setGender(input.get("gender"));
		formPage.selectCountry(input.get("country"));
		eyes.checkWindow("Initial View");
		ProductCatalog productCatalog = formPage.clickLetsShop();
		
		
		
		productCatalog.addItemToCartByIndexValue(0);
		productCatalog.addItemToCartByIndexValue(0);
		eyes.checkWindow("Add to Cart");

		CartPage cartPage = productCatalog.gotoCartPage();
		
		Double totalAmount = cartPage.calculateTotalAmount();
		cartPage.verifyTotalSum(totalAmount);
		cartPage.checkTermsAndCondition();
		eyes.checkWindow("Calculate Amount");
		cartPage.checkout();

	}
	@DataProvider
	public Object[][] getData() throws IOException {
		
			List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"//src//test//java//org//hamzakhan//testData//eCommerce.json");
		return new Object[][] {{new HashMap<>(data.get(0))}};
		
	}

}
