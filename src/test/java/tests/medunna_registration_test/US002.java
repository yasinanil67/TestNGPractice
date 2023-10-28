package tests.medunna_registration_test;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.MedunnaRegisterPage;

import static org.testng.AssertJUnit.assertTrue;

public class US002 {

     /*
    US002: Registration should be successful using email and username
        US002AC01: Choose a username that can contain any chars, but it cannot be blank
            US002AC01TC01: User leaves the username blank, there should be "Your username is required." error message
            US002AC01TC02: User enters username special chars(£#$€), there should be "Your username is invalid." error message
            US002AC01TC03: User enters username  that can contain any chars, there should not be any error message
        US002AC02: username should be validated using api and must be unique
        US002AC03: email id cannot be created without "@" sign and "." extension
            US002AC03TC01: User enters the email as "johndoe.com", there should be "This field is invalid" error message
            US002AC03TC02: User enters the email as "john@doecom", there should be "This field is invalid" error message
            US002AC03TC03: User enters the email as "john@doe.", there should be "This field is invalid" error message
            US002AC03TC04: User enters the email as "@doe.com", there should be "This field is invalid" error message
            US002AC03TC05: User enters the email as "john@doe.com", there should not be any error message
        US002AC04: email cannot be left blank
            US002AC04TC01: User leaves the email blank, there should be "Your email is required." error message
            US002AC04TC02: User enters the email as "john@doe.com", there should not be any error message
     */

    MedunnaRegisterPage medunnaRegisterPage = new MedunnaRegisterPage();
    @Test
    public void test(){
//    US002: Registration should be successful using email and username
//      US002AC01: Choose a username that can contain any chars, but it cannot be blank
//        US002AC01TC01: User leaves the username blank, there should be "Your username is required." error message
        medunnaRegisterPage.username.sendKeys(Keys.ENTER);
        assertTrue(medunnaRegisterPage.requiredUsername.isDisplayed());

//        US002AC01TC02: User enters username special chars(£#$€), there should be "Your username is invalid." error message
        medunnaRegisterPage.username.sendKeys("£#$€"+Keys.ENTER);
        assertTrue(medunnaRegisterPage.invalidUsername.isDisplayed());

        //REST IS Homework...

//        US002AC01TC03: User enters username  that can contain any chars, there should not be any error message
//      US002AC02: username should be validated using api and must be unique
//      US002AC03: email id cannot be created without "@" sign and "." extension
//        US002AC03TC01: User enters the email as "johndoe.com", there should be "This field is invalid" error message
//        US002AC03TC02: User enters the email as "john@doecom", there should be "This field is invalid" error message
//        US002AC03TC03: User enters the email as "john@doe.", there should be "This field is invalid" error message
//        US002AC03TC04: User enters the email as "@doe.com", there should be "This field is invalid" error message
//        US002AC03TC05: User enters the email as "john@doe.com", there should not be any error message
//      US002AC04: email cannot be left blank
//        US002AC04TC01: User leaves the email blank, there should be "Your email is required." error message
//        US002AC04TC02: User enters the email as "john@doe.com", there should not be any error message



    }
}
