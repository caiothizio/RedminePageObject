/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.redminepageobject;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author caiot
 */
public class RedmineTest {

    private WebDriver driver;

    @BeforeClass
    public static void setUpClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("headless");
        chromeOptions.addArguments("window-size=1200x600");
        chromeOptions.addArguments("lang=en-US");
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://demo.redmine.org/");
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void logar() {
        String login = "utfpr01";   //alterar login para login desejado
        String senha = "teste123";  //alterar senha para senha do login escolhido

        PaginaInicialPage home = new PaginaInicialPage(driver);

        PaginaInicialPage paginaInicial;
        paginaInicial = (PaginaInicialPage) home.irParaMenu().irParaEntrar().logar(login, senha);

        assertEquals(paginaInicial.irParaMenu().estaLogadoComo(), login);
    }

    @Test
    public void logarContaInexistente() {
        String login = "vaidarerro";   //login errado
        String senha = "vaidarerro";  //senha errada

        PaginaInicialPage home = new PaginaInicialPage(driver);

        LoginPage paginaLogin;
        paginaLogin = (LoginPage) home.irParaMenu().irParaEntrar().logar(login, senha);

        assertTrue(paginaLogin.deuErroNoLogin());
    }

    @Test
    public void cadastrarConta() {
        String usuario = "tempaccount";
        String senha = "teste123";
        String confirmacao = "teste123";
        String nome = "Temporary";
        String sobrenome = "Account";
        String email = "temporaryaccount@temp.com";
        String idioma = "Portuguese/Brasil (Português/Brasil)";

        PaginaInicialPage home = new PaginaInicialPage(driver);

        MinhaContaPage minhaConta = (MinhaContaPage) home.irParaMenu().irParaCadastro().cadastrar(usuario, senha, confirmacao, nome, sobrenome, email, idioma);

        assertEquals(minhaConta.irParaMenu().estaLogadoComo(), usuario);

        // Excluir conta após criá-la para poder executar este teste novamente
        assertTrue(minhaConta.excluirConta().confirmarExclusao().excluiuConta());
    }

    @Test
    public void criarProjeto() {
        logar();

        String nome = "testeUTF123456";
        String desc = "this is a automated test";

        ConfiguracoesPage configPage = new PaginaInicialPage(driver).irParaMenu().irParaProjetos().criarNovoProjeto().preencherCamposCom(nome, desc);

        assertTrue(configPage.projetoCriado());
    }
    
    @Test
    public void buscarAlgo(){
        String busca = "testeUTF";
        
        PaginaBuscaPage buscaPage = new PaginaInicialPage(driver).buscar(busca);
        
        assertTrue(buscaPage.campoEstaPreenchidoCom(busca));
        
    }
    
    @Test
    public void adicionarTarefa(){
        logar();
        
        String projeto = "testeUTF123";
        String tarefa = "teste0";
        
        ProjetoPage projetoPage = new PaginaInicialPage(driver).irParaProjeto(projeto).criarTarefa(tarefa);
        
        assertTrue(projetoPage.verificaSeTarefaFoiCriada());
    }
}
