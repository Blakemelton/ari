package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {

    @FindBy(xpath = "//input[@name='UserName']")
    public WebElement usernameBox;

    @FindBy(xpath = "//input[@name='Password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginBtn;

    @FindBy(xpath = "//*[contains(text(),'There was a problem')]")
    public WebElement errorMessage;

    @FindBy(xpath = "//*[starts-with(@ng-message,'required')]")
    public WebElement enterUsernameMessage;

    @FindBy(xpath = "//*[starts-with(@ng-message,'required')]")
    public WebElement enterPasswordMessage;

    @FindBy(xpath = "//input[@name=\"AgencyCode\"]")
    public WebElement agencyCode;

    @FindBy(xpath = "//input[@value='Login To My Portal Account']")
    public WebElement portalLoginBtn;


    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password){
        sendText(usernameBox, username);
        sendText(passwordBox, password);
        click(loginBtn);
    }


}
