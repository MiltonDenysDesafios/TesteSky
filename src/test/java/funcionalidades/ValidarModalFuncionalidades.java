package funcionalidades;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commands.Comandos;

public class ValidarModalFuncionalidades extends Comandos{
	
	
	/**
	 * @author Milton
	 * @return
	 * clica no botao programacao e posiciona a tela na tabela de canais
	 */
	public static void clicarBotaoProgramacao() {
		String passandoAgora = "//*[@id=\"schedules-container\"]/div[1]/span";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		clicar("//*[@id=\"main-menu\"]/div[2]/div[2]/ul[1]/li[3]/a");
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(passandoAgora)));
		//posiciona na palavra programacao
		posicionaNaPalavraProgramacao();

		
	}
	/**
	 * @author Milton
	 * @return
	 * fechar primeiro banner 
	 */
	public static void fecharBannerBemVindo() {
		
		clicar("//*[@id=\"portlet_com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_YQcCxObpxg0J\"]/div/div[2]/div/div[2]/div/div/div/div[1]/button");
		
	}
	/**
	 * @author Milton
	 * @return
	 * fechar segundo banner de cookies
	 */
	public static void fecharBannerOkEntendi() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		clicar("//*[@id=\"wrap-aviso-cookie\"]/div[1]/div/div/div/div[3]/div/div/button");
		
	}
	/**
	 * @author Milton
	 * @return
	 * metodo para posicionar a tela no ponto mapeado
	 */
	public static void posicionaNaPalavraProgramacao() {
		
		posicaoDaTela("//*[@id=\"portlet_com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_aKJUz209eKa8\"]/div/div[2]/div/div[2]/section/div/div[1]/div/div/a[1]/h2");
	}

}
