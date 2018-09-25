package br.edu.utfpr.redminepageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjetoPage extends RedmineBasePage{
    
    @FindBy(tagName = "h1")
    WebElement nomeDoProjeto;
    
    @FindBy(xpath = "//*[@id=\"main-menu\"]/ul/li[4]/a")
    WebElement novaTarefa;
    
    @FindBy(id = "issue_subject")
    WebElement titulo;
    
    @FindBy(name = "commit")
    WebElement criar;
    
    @FindBy(id = "flash_notice")
    WebElement sucesso;
    
    public ProjetoPage(WebDriver driver) {
        super(driver);
    }
    
    public ProjetoPage criarTarefa(String titulo){
        novaTarefa.click();
        
        this.titulo.sendKeys(titulo);
        criar.click();
        
        return this;
    }
    
    public boolean verificaSeTarefaFoiCriada(){
        return sucesso.isDisplayed();
    }
    
}
