package com.appium_assessment.appium_asse;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class instagram extends baseclass{
	@Test
public void insta() {
	   driver.findElement(By.id("com.instagram.android:id/log_in_button")).click();
    

      // Find and fill the username field
        driver.findElement(By.id("com.instagram.android:id/login_username")).sendKeys("makvanadilip051@gmail.com");
     

      // Find and fill the password field
       driver.findElement(By.id("com.instagram.android:id/login_password")).sendKeys("Dilip051");
     

      // Find and click on the login button
     driver.findElement(By.id("com.instagram.android:id/next_button")).click();
      
}
}
