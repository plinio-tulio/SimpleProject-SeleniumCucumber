package br.com.automacao;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static org.junit.Assert.assertEquals;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CalculadoraSteps {
	
	private CalculadoraPage calculadora;

	@Before
	public void setUp() {
		DriverFactory.getDriver();
		calculadora = new CalculadoraPage();
	}
	
	@Given("^Acesso o sistema$")
	public void acesso_o_sistema() throws Throwable {
		calculadora.acessarTelaPrincipal();
	}

	@When("^informo o valor do lado um do triangulo \"([^\"]*)\"$")
	public void informo_o_valor_do_lado_um_do_triangulo(String lado1) throws Throwable {
		calculadora.preencherCampoLado1(lado1);
	}

	@When("^Informo o valor do lado dois do triangulo \"([^\"]*)\"$")
	public void informo_o_valor_do_lado_dois_do_triangulo(String lado2) throws Throwable {
		calculadora.preencherCampoLado2(lado2);
	}

	@When("^Informo o valor do lado tres do triangulo \"([^\"]*)\"$")
	public void informo_o_valor_do_lado_tres_do_triangulo(String lado3) throws Throwable {
		calculadora.preencherCampoLado3(lado3);
	}

	@Then("^Eu visualizo o resultado do tipo de triangulo \"([^\"]*)\"$")
	public void eu_visualizo_o_resultado_do_tipo_de_triangulo(String mensagem) throws Throwable {
		calculadora.cliqueBotaoCalcular();
		assertEquals(mensagem, calculadora.getMensagem());
	}
	
	@After(order = 2, value = { "@funcionais" })
	public void screenshot(Scenario cenario) {

		File file = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target/screenshots/" + cenario.getId() + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@After(order = 1, value = { "@funcionais" })
	public void fechaBrowser() throws InterruptedException {

		DriverFactory.killDriver();
		System.out.println("finalizando cenário de teste.");
	}
}