package br.edu.utfpr.redminepageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaginaBuscaPage extends RedmineBasePage{
    
    @FindBy(xpath = "//*[@id=\"search-input\"]")
    WebElement campoBusca;
    
    public PaginaBuscaPage(WebDriver driver) {
        super(driver);
    }
    
   public boolean campoEstaPreenchidoCom(String query){
        return campoBusca.getAttribute("value").equals(query);
   }
    
}
