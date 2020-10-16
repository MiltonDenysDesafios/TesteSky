@Sky
Feature: Marca

	@ValidarModal
  Scenario: Validar Modal
   Given abri a pagina principal da 'Sky'
   |	|
   |	|
   	And fecho o banner 'Bem Vindo'
   	And fecho o banner 'Ok Entendi' 
    When clico no botao 'Programacao'
    And seleciono a programacao atual
    Then valido se o titulo e o horario estao iguais
  	And finalizo a aplicacao