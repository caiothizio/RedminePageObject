package br.edu.utfpr.redminepageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfiguracoesPage extends RedmineBasePage{
    
    @FindBy(id = "flash_notice")
    WebElement sucesso;
    
    public ConfiguracoesPage(WebDriver driver) {
        super(driver);
    }
    
    public boolean projetoCriado(){
        return sucesso.getText().equals("Criado com sucesso.");
    }
}
