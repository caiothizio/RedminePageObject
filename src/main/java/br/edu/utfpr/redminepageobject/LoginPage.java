package br.edu.utfpr.redminepageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends RedmineBasePage{
    
    @FindBy(id = "username")
    WebElement username;
    
    @FindBy(id = "password")
    WebElement password;
    
    @FindBy(name = "login")
    WebElement entrar;
    
    @FindBy(xpath = "//*[@id=\"login-form\"]/form/table/tbody/tr[4]/td[1]/a")
    WebElement perdiSenha;
    
    @FindBy(id = "flash_error")
    WebElement erroLogin;
    
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    public SenhaPerdidaPage clicarPerdiSenha(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until( ExpectedConditions.elementToBeClickable(perdiSenha) );
        
        perdiSenha.click();
        
        return new SenhaPerdidaPage(driver);
    }
    
    public RedmineBasePage logar(String myUser, String myPw){
        username.sendKeys(myUser);
        password.sendKeys(myPw);
        
        entrar.click();
        
        if(getCurrentURL().equals("http://demo.redmine.org/"))
            return new PaginaInicialPage(driver);
        else
            return new LoginPage(driver);
    }
    
    public boolean deuErroNoLogin(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until( ExpectedConditions.visibilityOf(erroLogin) );
        
        return erroLogin.isDisplayed();
    }
}
