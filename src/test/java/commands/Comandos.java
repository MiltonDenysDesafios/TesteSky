package commands;


import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;

public class Comandos {
	
	protected static String url ="http://www.sky.com.br";
	protected static List<Map<String, String>> issue_info;
	protected static WebDriver driver;
	protected static List<WebElement> listOfElements;
	
	/**
	 * @author Milton
	 * @return
	 * Abre o browser e maximiza
	 */
	public static void acessaHomePage(DataTable data){		
		issue_info =  data.asMaps(String.class, String.class);

		//WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "E:\\workplace_eclipse\\TesteSky\\src\\main\\resources\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();		
        driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();            
	}
	
	/**
	 * @author Milton
	 * @return
	 * instancia comum para webdriver podendo usar em qualquer classe do codigo
	 */
	public static WebDriver getDriver() {
		return driver;
	}	

	/**
	 * @author Milton
	 * @return
	 * Finaliza o driver 
	 */
	public static void finalizar() {
		try{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.quit();

		}catch(Exception e) {
			
		}
	}
	
	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	public String obterTexto(String id) {
		return obterTexto(By.id(id));
	}
	
	
	/**
	 * @author Milton
	 * @param xpath
	 * @return
	 * clica no elemento mapeado pelo xpath
	 */
	public static void clicar(String xpath) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement Element = driver.findElement(By.xpath(xpath));
		Element.click();
	
	}
	
	/**
	 * @author Milton
	 * @return 
	 * @return
	 * recupera valor de string
	 */
	public static String recuperarValorString(String xpath, String atributo) {				
		
		String atribut = atributo;
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String element = driver.findElement(By.xpath(xpath)).getText();
		return element;			
				
	}
	
	/**
	 * @author Milton
	 * @param xpath
	 * @return
	 * Posiciona a tela no elemento selecionado
	 */
	public static void posicaoDaTela(String xpath){
		try{
			WebElement Element = driver.findElement(By.xpath(xpath));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView();", Element);
		}  catch (Exception e){
			
		}
	}

}
