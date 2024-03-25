package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    @Given("User have an account in System")
    public void userHaveAnAccountInSystem() {
        System.out.println("User have an account in System");
    }
    @When("User navigate to Login page")
    public void userNavigateToLoginPage() {
        System.out.println("User navigate to Login page");
    }
    @When("User login with {string} Credential via email and password")
    public void userLoginWithValidCredentialViaEmailAndPassword(String typeCredential) {
        System.out.println("User login with Valid Credential Credential via email and password");
    }
    @Then("User login {string}")
    public void userLoginSuccessful(String expectResult) {
        System.out.println("User login Login Successful");
    }

    @And("User login with {string} Credential via SSO")
    public void userLoginWithLogin_CaseCredentialViaSSO(String typeCredential) {
        System.out.println(String.format("User login with %s Credential via SSO", typeCredential));
    }
}
