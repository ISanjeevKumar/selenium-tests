package herokuapp.tests;

import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void shouldBeAbleToLogin() throws InterruptedException {
        app.loginPage().navigateTo();
        app.loginPage().enterUsername("tomsmith");
        app.loginPage().enterPassword("SuperSecretPassword!");
        app.loginPage().clickOnLoginButton();
        assertContains("You logged into a secure area!",app.secureAreaPage().getFlashMessage());
    }
}
