package br.edu.utfpr.redminepageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NovoProjetoPage extends RedmineBasePage{
    
    @FindBy(id = "project_name")
    WebElement nome;
    
    @FindBy(id = "project_description")
    WebElement description;
    
    @FindBy(name = "commit")
    WebElement criar;
    
    public NovoProjetoPage(WebDriver driver) {
        super(driver);
    }
    
    public ConfiguracoesPage preencherCamposCom(String projName, String projDesc){
        nome.sendKeys(projName);
        description.sendKeys(projDesc);
        
        criar.click();
        
        return new ConfiguracoesPage(driver);
    }
}
