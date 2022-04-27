package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import pages.DashBoardPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;
import utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LoginSteps extends CommonMethods {

    @When("user enters invalid {string} and {string} and clicks on login and verify the {string}")
    public void userEntersInvalidAndAndClicksOnLoginAndVerifyThe(String username, String password, String errorMessage) throws InterruptedException {

        LoginPage loginPage = new LoginPage();
        sendText(loginPage.usernameBox, username);
        sendText(loginPage.passwordBox,password);
        click(loginPage.loginBtn);
        Thread.sleep(500);
        String errorMessageActual = loginPage.errorMessage.getText();
        Assert.assertEquals("Values do not match",errorMessageActual,errorMessage);
    }

    @When("user enters invalid {string} or {string} and clicks on login and verify the {string}")
    public void userEntersInvalidOrAndClicksOnLoginAndVerifyThe(String username, String password, String errorMessage) throws InterruptedException {

        LoginPage loginPage = new LoginPage();
        sendText(loginPage.usernameBox, username);
        sendText(loginPage.passwordBox,password);
        click(loginPage.loginBtn);
        Thread.sleep(400);
        String errorMessageActual="0";
        if (username == null) {
            errorMessageActual = loginPage.enterPasswordMessage.getText();
        } else {
        errorMessageActual = loginPage.enterUsernameMessage.getText();}


        Assert.assertEquals("Values do not match",errorMessageActual,errorMessage);

    }

    @When("user enters valid {string} and {string} and clicks on login and verify the {string}")
    public void userEntersValidAndAndClicksOnLoginAndVerifyThe(String username, String password, String sidebarOptions) {

        LoginPage loginPage = new LoginPage();
        sendText(loginPage.usernameBox, username);
        sendText(loginPage.passwordBox,password);
        click(loginPage.loginBtn);

        DashBoardPage dashBoardPage= new DashBoardPage();
        List<String> actualList = new ArrayList<>();
        for(WebElement ele:dashBoardPage.sidebar){
            actualList.add(ele.getText());

        }
        int listSize=actualList.size();
        String actualListSize=Integer.toString(listSize);

        Assert.assertEquals("Values do not match",actualListSize,sidebarOptions);
    }

    @Given("user has entered correct Agency Code")
    public void userHasEnteredCorrectAgencyCode() {
        LoginPage loginPage = new LoginPage();
sendText(loginPage.agencyCode, ConfigReader.getPropertyValue("agencyCode"));
click(loginPage.portalLoginBtn);
    }
}
