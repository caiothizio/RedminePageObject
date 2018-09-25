package br.edu.utfpr.redminepageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroPage extends RedmineBasePage{
    
    @FindBy(id = "user_login")
    WebElement usuario;
    
    @FindBy(id = "user_password")
    WebElement senha;
    
    @FindBy(id = "user_password_confirmation")
    WebElement confirmacao;
    
    @FindBy(id = "user_firstname")
    WebElement nome;
    
    @FindBy(id = "user_lastname")
    WebElement sobrenome;
    
    @FindBy(id = "user_mail")
    WebElement email;
    
    @FindBy(id = "user_language")
    WebElement idioma;
    Select dropdown = new Select(idioma);
    
    @FindBy(xpath = "//*[@id=\"new_user\"]/input[3]")
    WebElement enviar;
    
    @FindBy(id = "errorExplanation")
    WebElement erroCadastro;
            
    public CadastroPage(WebDriver driver) {
        super(driver);
    }
    
    public RedmineBasePage cadastrar(String myUser, String myPw, String myPwConf, String myName, String myLastname, String myEmail, String myLanguage){
        usuario.sendKeys(myUser);
        senha.sendKeys(myPw);
        confirmacao.sendKeys(myPwConf);
        nome.sendKeys(myName);
        sobrenome.sendKeys(myLastname);
        email.sendKeys(myEmail);
        dropdown.selectByVisibleText(myLanguage);
        
        enviar.click();
        
        return new MinhaContaPage(driver);
    }
}
