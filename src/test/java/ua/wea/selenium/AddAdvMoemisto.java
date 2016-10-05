package ua.wea.selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.*;
import org.testng.annotations.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AddAdvMoemisto extends ua.wea.selenium.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void test1st() throws Exception {webDriver.get("https://moemisto.ua" + "/kiev");
    webDriver.findElement(By.linkText("Додати свою подію")).click();
    webDriver.findElement(By.id("event_organizator")).clear();
    webDriver.findElement(By.id("event_organizator")).sendKeys("Евгений");
    webDriver.findElement(By.id("event_email")).clear();
    webDriver.findElement(By.id("event_email")).sendKeys("transs2003@ukr.net");
    new Select(webDriver.findElement(By.id("event_userStatus"))).selectByVisibleText("Організатор");
    webDriver.findElement(By.id("event_title")).clear();
    webDriver.findElement(By.id("event_title")).sendKeys("Творческая студия");
    new Select(webDriver.findElement(By.id("event_rubric"))).selectByVisibleText("Дітям");
    webDriver.findElement(By.id("event_organization")).clear();
    webDriver.findElement(By.id("event_organization")).sendKeys("Академия Експерт");
    webDriver.findElement(By.id("event_address")).clear();
    webDriver.findElement(By.id("event_address")).sendKeys("ДК \"Днепр\", ул. Бориспольская 10");
    webDriver.findElement(By.id("event_priceText")).clear();
    webDriver.findElement(By.id("event_priceText")).sendKeys("для детей 50 грн.");
  }

  private boolean isElementPresent(By by) {
    try {
      webDriver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = webDriver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}