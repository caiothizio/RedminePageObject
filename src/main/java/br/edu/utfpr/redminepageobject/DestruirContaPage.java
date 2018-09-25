package br.edu.utfpr.redminepageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DestruirContaPage extends RedmineBasePage{
    
    @FindBy(id = "confirm")
    WebElement checkSim;
    
    @FindBy(name = "commit")
    WebElement excluirConta;
    
    public DestruirContaPage(WebDriver driver) {
        super(driver);
    }
    
    public PaginaInicialPage confirmarExclusao(){
        checkSim.click();
        excluirConta.click();
        
        return new PaginaInicialPage(driver);
    }
}
