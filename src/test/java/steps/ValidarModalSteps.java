package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class ValidarModalSteps {
	
	 @Given("abri a pagina principal da 'Sky'")
	    public void abrirPage(DataTable data) {
		 commands.Comandos.acessaHomePage(data);

	 }
	 
	 @When("clico no botao 'Programacao'")
	    public void clicarBotaoProgramacao() {
		 funcionalidades.ValidarModalFuncionalidades.clicarBotaoProgramacao();
	 }
	 
	 @And("fecho o banner 'Bem Vindo'")
	    public void fecharBannerBemVindo() {
		 funcionalidades.ValidarModalFuncionalidades.fecharBannerBemVindo();
	 }
	 
	 @And("fecho o banner 'Ok Entendi'")
	    public void fecharBannerOkEntendi() {
		 funcionalidades.ValidarModalFuncionalidades.fecharBannerOkEntendi();
	 }
	 
	 
	
	 
}
