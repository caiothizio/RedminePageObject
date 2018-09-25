package br.edu.utfpr.redminepageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MinhaContaPage extends RedmineBasePage{
    
    @FindBy(xpath = "//*[@id=\"sidebar\"]/p[2]/a")
    WebElement excluirConta;
    
    public MinhaContaPage(WebDriver driver) {
        super(driver);
    }
    
    public DestruirContaPage excluirConta(){
        excluirConta.click();
        
        return new DestruirContaPage(driver);
    }
}
