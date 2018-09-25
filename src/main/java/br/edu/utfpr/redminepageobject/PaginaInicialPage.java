package br.edu.utfpr.redminepageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginaInicialPage extends RedmineBasePage{
    
    @FindBy(id = "flash_notice")
    WebElement contaExcluida;
    
    @FindBy(xpath = "//*[@id=\"project_quick_jump_box\"]")
    WebElement selectProjetos;
    
    public PaginaInicialPage(WebDriver driver) {
        super(driver);
    }
    
    public boolean excluiuConta(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until( ExpectedConditions.visibilityOf(contaExcluida) );
        
        return contaExcluida.isDisplayed();
    }
    
    public ProjetoPage irParaProjeto(String projeto){
        Select seletor = new Select(selectProjetos);
        seletor.selectByVisibleText(projeto);
        
        return new ProjetoPage(driver);
    }
}
