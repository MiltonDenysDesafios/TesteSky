@Sky
Feature: Marca

	@ValidarModal
  Scenario: Validar Modal
   Given abri a pagina principal da 'Sky'
   |MARCA	|
   |HONDA	|
   	And fecho o banner 'Bem Vindo'
   	And fecho o banner 'Ok Entendi' 
    When clico no botao 'Programacao'
    #And preencho o campo buscar 
    #Then valido se a busca foi correta
  #	And finalizo a aplicacao