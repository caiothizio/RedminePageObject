package br.edu.utfpr.redminepageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopMenu extends BasePage {

    @FindBy(xpath = "//*[@id=\"top-menu\"]/ul/li[1]/a")
    WebElement paginaInicial;

    @FindBy(className = "projects")
    WebElement projetos;

    @FindBy(xpath = "//*[@id=\"top-menu\"]/ul/li[3]/a")
    WebElement ajuda;

    @FindBy(xpath = "//*[@id=\"loggedas\"]/a")
    WebElement profile;
    
    @FindBy(className = "my-account")
    WebElement minhaConta;
    
    @FindBy(className = "logout")
    WebElement sair;
    
    @FindBy(xpath = "//*[@id=\"account\"]/ul/li[1]/a")
    WebElement entrar;

    @FindBy(xpath = "//*[@id=\"account\"]/ul/li[2]/a")
    WebElement cadastre_se;

    public TopMenu(WebDriver driver) {
        super(driver);
    }

    private void clickMenuOption(WebElement menuOption) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(menuOption));
        menuOption.click();
    }
    
    public LoginPage irParaEntrar(){
        clickMenuOption(entrar);
        return new LoginPage(driver);
    }
    
    public PaginaInicialPage irParaPaginaInicial(){
        clickMenuOption(paginaInicial);
        return new PaginaInicialPage(driver);
    }
    
    public CadastroPage irParaCadastro(){
        clickMenuOption(cadastre_se);
        return new CadastroPage(driver);
    }
    
    public MinhaContaPage irParaMinhaConta(){
        clickMenuOption(minhaConta);
        
        return new MinhaContaPage(driver);
    }
    
    public ProjetosPage irParaProjetos(){
        clickMenuOption(projetos);
        
        return new ProjetosPage(driver);
    }
    
    public String estaLogadoComo(){
        return profile.getText();
    }
    
    public PaginaInicialPage sair(){
        clickMenuOption(sair);
        
        return new PaginaInicialPage(driver);
    }
}
