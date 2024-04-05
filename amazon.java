package com.appium_assessment.appium_asse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class amazon extends baseclass {
	@Test
public void shopping() throws InterruptedException {
	
	// Locate and click on Sign in button
    driver.findElement(By.id("signin_button")).click();

    // Enter username
    driver.findElement(By.id("ap_email")).sendKeys("your_email@example.com");

    // Click on Continue button
    driver.findElement(By.id("continue")).click();

    // Enter password
    driver.findElement(By.id("ap_password")).sendKeys("your_password");

    // Click on Sign in button
    driver.findElement(By.id("signInSubmit")).click();
    // Wait for login to complete
    Thread.sleep(5000);

    // Navigate to product page
    driver.findElement(By.id("productButton")).click();

    // Add product to cart
    driver.findElement(By.id("addToCartButton")).click(); // Wait for login to complete
    Thread.sleep(5000);

    // Navigate to product page
    driver.findElement(By.id("productButton")).click();

    // Add product to cart
    driver.findElement(By.id("addToCartButton")).click();
 // Verify if product is added to the cart
    
    WebElement cartIcon = driver.findElement(By.id("cartIcon"));
    if (cartIcon.isDisplayed()) {
        System.out.println("Product added to cart successfully.");
    } else {
        System.out.println("Failed to add product to cart.");
    }
    
}
}
