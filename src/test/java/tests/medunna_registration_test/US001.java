package tests.medunna_registration_test;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MedunnaHomePage;
import pages.MedunnaRegisterPage;
import utilities.Driver;

import static org.testng.AssertJUnit.assertTrue;


public class US001 {
    /*
    US001: Registration should be available using SSN, Firstname and Lastname
        AC001: There should be a valid SSN respecting the "-" after 3rd and 5th digits, it should be 9 digits long
            AC001TC01: User enters the ssn 22255-5432, there should be "Your SSN is invalid" message
            AC001TC02: User enters the ssn 222-555432, there should be "Your SSN is invalid" message
            AC001TC03: User enters the ssn 222-55-543, there should be "Your SSN is invalid" message
            AC001TC04: User enters the ssn 222-55-543a, there should be "Your SSN is invalid" message
            AC001TC05: User enters the ssn 222-55-5432, there should not be any error message
        AC002: SSN cannot be left blank
            AC002TC01: User leaves the ssn blank, there should be "Your SSN is required." message
            AC002TC02: User enters the ssn only space, there should be "Your SSN is required." message
            AC002TC03: User enters the ssn 222-55-5432, there should not be any error message
        AC003: There should be a valid name that contains any chars and cannot be blank
            AC003TC01: User leaves the FirstName blank, there should be "Your FirstName is required." message
            AC003TC02: User enters the FirstName only space, there should be "Your FirstName is required." message
            AC003TC03: User enters the name that contains any chars, there should not be any error message
        AC004: There should be a valid lastname that contains any chars and it is a required field
            AC004TC01: User leaves the lastname blank, there should be "Your LastName is required." message
            AC004TC02: User enters the lastname only space, there should be "Your LastName is required." message
            AC004TC03: User enters the lastname that contains any chars, there should not be any error message
     */
    MedunnaHomePage medunnaHomePage = new MedunnaHomePage();


    @BeforeTest
    public void before(){

        Driver.getDriver().get("https://medunna.com");
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", medunnaHomePage.userIcon);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", medunnaHomePage.registerOption);

    }

    @Test
    public void registrationTest(){

//        US001: Registration should be available using SSN, Firstname and Lastname
//        AC001: There should be a valid SSN respecting the "-" after 3rd and 5th digits, it should be 9 digits long
//        AC001TC01: User enters the ssn 22255-5432, there should be "Your SSN is invalid" message
        MedunnaRegisterPage medunnaRegisterPage = new MedunnaRegisterPage();
        medunnaRegisterPage.ssn.sendKeys("22255-5432"+ Keys.TAB);
        assertTrue(medunnaRegisterPage.invalidSsn.isDisplayed());

//        AC001TC02: User enters the ssn 222-555432, there should be "Your SSN is invalid" message
        medunnaRegisterPage.ssn.clear();
        medunnaRegisterPage.ssn.sendKeys("222-555432"+ Keys.TAB);
        assertTrue(medunnaRegisterPage.invalidSsn.isDisplayed());

//        AC001TC03: User enters the ssn 222-55-543, there should be "Your SSN is invalid" message
        medunnaRegisterPage.ssn.clear();
        medunnaRegisterPage.ssn.sendKeys("222-55-943"+ Keys.TAB);
        assertTrue(medunnaRegisterPage.invalidSsn.isDisplayed());

//        AC001TC04: User enters the ssn 222-55-543a, there should be "Your SSN is invalid" message
        medunnaRegisterPage.ssn.clear();
        medunnaRegisterPage.ssn.sendKeys("222-55-943a"+ Keys.TAB);
        assertTrue(medunnaRegisterPage.invalidSsn.isDisplayed());

//        AC001TC05: User enters the ssn 222-55-5432, there should not be any error message
        medunnaRegisterPage.ssn.clear();
        medunnaRegisterPage.ssn.sendKeys("222-55-9434"+ Keys.TAB);

//        AC002: SSN cannot be left blank
//        AC002TC01: User leaves the ssn blank, there should be "Your SSN is required." message
        medunnaRegisterPage.ssn.clear();
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", medunnaRegisterPage.registerSubmit);
        assertTrue(medunnaRegisterPage.requiredSsn.isDisplayed());

//        AC002TC02: User enters the ssn only space, there should be "Your SSN is required." message
        medunnaRegisterPage.ssn.clear();
        medunnaRegisterPage.ssn.sendKeys(" "+ Keys.TAB);
        assertTrue(medunnaRegisterPage.requiredSsn.isDisplayed());

//        AC002TC03: User enters the ssn 222-55-5432, there should not be any error message
        medunnaRegisterPage.ssn.clear();
        medunnaRegisterPage.ssn.sendKeys("222-55-9434"+ Keys.TAB);

//        AC003: There should be a valid name that contains any chars and cannot be blank
//        AC003TC01: User leaves the FirstName blank, there should be "Your FirstName is required." message
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", medunnaRegisterPage.registerSubmit);
        assertTrue(medunnaRegisterPage.requiredFirstName.isDisplayed());

//        AC003TC02: User enters the FirstName only space, there should be "Your FirstName is required." message
        medunnaRegisterPage.firstName.sendKeys(" "+Keys.TAB);
        assertTrue(medunnaRegisterPage.requiredFirstName.isDisplayed());

//        AC003TC03: User enters the name that contains any chars, there should not be any error message
        medunnaRegisterPage.firstName.sendKeys("John"+Keys.TAB);

//        AC004: There should be a valid lastname that contains any chars and it is a required field
//        AC004TC01: User leaves the lastname blank, there should be "Your LastName is required." message
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", medunnaRegisterPage.registerSubmit);
        assertTrue(medunnaRegisterPage.requiredLastName.isDisplayed());

//        AC004TC02: User enters the lastname only space, there should be "Your LastName is required." message
        medunnaRegisterPage.lastName.sendKeys(" "+Keys.TAB);
        assertTrue(medunnaRegisterPage.requiredLastName.isDisplayed());

//        AC004TC03: User enters the lastname that contains any chars, there should not be any error message
        medunnaRegisterPage.lastName.sendKeys("Doe"+Keys.TAB);

    }

}
