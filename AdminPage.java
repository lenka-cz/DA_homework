package cz.czechitas;

import org.openqa.selenium.*;

public class AdminPage {

    private static WebDriver driver;
    private final By usernameAdminLogin = By.id("username");
    private final By passwordAdminLogin = By.id("password");
    private final By adminLoginButton = By.id("formSubmitButton");

    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        String adminLogonUrl = Settings.baseUrl + "/shop admin/";
        driver.navigate().to(adminLogonUrl);

    }

    public void ValidUsernameLogin() {
        String ValidUsername = "admin@shopizer.com";
        driver.findElement(usernameAdminLogin).sendKeys(ValidUsername);
    }

    public void ValidPasswordLogin() {
        String ValidPassword = "password";
        driver.findElement(passwordAdminLogin).sendKeys(ValidPassword);
    }

    public void InvalidUsernameLogin() {
        String InvalidUsername = "novalidadmin@shopizer.com";
        driver.findElement(usernameAdminLogin).sendKeys(InvalidUsername);
    }

    public void InvalidPasswordLogin() {
        String InvalidPassword = "novalidpassword";
        driver.findElement(passwordAdminLogin).sendKeys(InvalidPassword);
    }

    public void ConfirmLogin() {
        driver.findElement(adminLoginButton).click();
    }

}
