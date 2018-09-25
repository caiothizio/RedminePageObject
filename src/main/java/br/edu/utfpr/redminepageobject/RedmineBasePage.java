package br.edu.utfpr.redminepageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RedmineBasePage extends BasePage{
    
    @FindBy(tagName = "h2")
    WebElement title;
    
    @FindBy(id = "q")
    WebElement buscar;
    
    TopMenu menu;
    
    public RedmineBasePage(WebDriver driver) {
        super(driver);
        menu = new TopMenu(driver);
    }
    
    public TopMenu irParaMenu(){
        return menu;
    }
    
    public String getTitle(){
        return title.getText();
    }
    
    public PaginaBuscaPage buscar(String busca){
        buscar.sendKeys(busca);
        buscar.submit();
        
        return new PaginaBuscaPage(driver); 
    }
}
