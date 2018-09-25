package br.edu.utfpr.redminepageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjetosPage extends RedmineBasePage{
    
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/a[1]")
    WebElement novoProjeto;
    
    public ProjetosPage(WebDriver driver) {
        super(driver);
    }
    
    public NovoProjetoPage criarNovoProjeto(){
        novoProjeto.click();
        
        return new NovoProjetoPage(driver);
    }
}
