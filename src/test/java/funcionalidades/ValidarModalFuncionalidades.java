package funcionalidades;


import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commands.Comandos;

public class ValidarModalFuncionalidades extends Comandos {

	/**
	 * @author Milton
	 * @return clica no botao programacao e posiciona a tela na tabela de canais
	 */
	public static void clicarBotaoProgramacao() {
		String passandoAgora = "//*[@id=\"schedules-container\"]/div[1]/span";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		clicar("//*[@id=\"main-menu\"]/div[2]/div[2]/ul[1]/li[3]/a");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(passandoAgora)));
		// posiciona na palavra programacao
		posicionaNaPalavraProgramacao();

	}

	/**
	 * @author Milton
	 * @return fechar primeiro banner
	 */
	public static void fecharBannerBemVindo() {

		clicar("//*[@id=\"portlet_com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_YQcCxObpxg0J\"]/div/div[2]/div/div[2]/div/div/div/div[1]/button");

	}

	/**
	 * @author Milton
	 * @return fechar segundo banner de cookies
	 */
	public static void fecharBannerOkEntendi() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		clicar("//*[@id=\"wrap-aviso-cookie\"]/div[1]/div/div/div/div[3]/div/div/button");

	}

	/**
	 * @author Milton
	 * @return retorna titulo do elemento
	 */
	public static WebElement programacaoTitle() {

		return driver.findElement(By.cssSelector(".schedule-live .program-schedule-content .program-schedule-title"));

	}

	/**
	 * @author Milton
	 * @return retorna horario do elemento
	 */
	public static WebElement ProgramacaoDuration() {
		return driver.findElement(By.cssSelector(".schedule-live .program-schedule-content .program-duration"));

	}

	/**
	 * @author Milton
	 * @return retorna titulo do elemento
	 */
	public static WebElement programacaoTitleModal() {

		return driver.findElement(By.cssSelector(".sky-modal-program-title"));

	}

	/**
	 * @author Milton
	 * @return retorna horario do elemento
	 */
	public static WebElement ProgramacaoDurationModal() {
		return driver.findElement(By.cssSelector(".sky-modal-program-date-time"));

	}

	/**
	 * @author Milton
	 * @return retorna elemento de programcao do momento
	 */
	public static WebElement programacaoLive() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver.findElement(By.cssSelector(".schedule-live"));

	}

	/**
	 * @author Milton
	 * @return clica na programacao que esta no momento
	 */
	public static void clicarProgramacaoLive() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		programacaoLive().click();
	}

	/**
	 * @author Milton
	 * @return selecionar programacao atual clicar no primeiro e coletar valores
	 */
	public static void selecionarProgramacaoAtual() {
		getFirstProgramTitle();
		getFirstProgramDuration();
		clicarProgramacaoLive();
		getTitlePopup();
		getDurationPopup();
		//coletarValoresModal();

	}
	


	/**
	 * @author Milton
	 * @return coletar texto programacao
	 */
	public String coletarValores() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return programacaoTitle().getText();
		
//		String titulo = programacaoTitle().getText();
//		String horario = ProgramacaoDuration().getText();
//
//		System.out.println(titulo);
//		System.out.println(horario);

	}

	/**
	 * @author Milton
	 * @return coletar texto programacao do modal
	 */
	public static void coletarValoresModal() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sky-modal-program-title")));
		String tituloModal = programacaoTitleModal().getText();
		String horarioModal = ProgramacaoDurationModal().getText();

		System.out.println(tituloModal);
		System.out.println(horarioModal);

	}

	private static WebElement getFirstProgram() {
		return getDriver().findElement(By.cssSelector(".schedule-live"));
	}
	
	public static String getFirstProgramTitle() {
		return getFirstProgram().findElement(By.cssSelector(".program-schedule-title")).getText();
	}
	
	public static String getFirstProgramDuration() {
		return getFirstProgram().findElement(By.cssSelector(".program-duration p")).getText();
	}
	
	public static String getTitlePopup() {
		return getDriver().findElement(By.cssSelector(".sky-modal-program-title")).getText();
	}
	
	public static String getDurationPopup() {
		return getDriver().findElement(By.cssSelector(".sky-modal-program-date-time")).getText();
	}
	
	/**
	 * @author Milton
	 * @return 
	 * @return validar se o texto da programacao esta igual ao do modal
	 */
	public static void validarProgramacaoModal() {
		
		String titlePopup = getTitlePopup();
		String durationPopup = getDurationPopup();
		String firstProgramTitle = getFirstProgramTitle();
		String firstProgramDuration = getFirstProgramDuration();

		if(titlePopup.equals(firstProgramTitle) && durationPopup.equals(firstProgramDuration)) {			
			System.out.println("Nome e duração estão corretos em ambos");
		}else {
			System.out.println("Nome e duração não estão corretos em ambos");
		}
	}
	
	/**
	 * @author Milton
	 * @return metodo para posicionar a tela no ponto mapeado
	 */
	public static void posicionaNaPalavraProgramacao() {

		posicaoDaTela(
				"//*[@id=\"portlet_com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_aKJUz209eKa8\"]/div/div[2]/div/div[2]/section/div/div[1]/div/div/a[1]/h2");
	}

}
