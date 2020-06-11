package br.com.automacao;

import org.openqa.selenium.By;

public class CalculadoraPage extends BasePage{

	public void acessarTelaPrincipal() {
		acessar(BaseURL);
	}
	
	public void preencherCamposDatela(String lado1, String lado2, String lado3) {
		escrever(By.id("lado1"),lado1);
		escrever(By.id("lado2"),lado2);
		escrever(By.id("lado3"),lado3);
	}

	public void preencherCampoLado1(String lado1) {
		escrever(By.id("lado1"),lado1);
	}
	
	public void preencherCampoLado2(String lado2) {
		escrever(By.id("lado2"),lado2);;
	}
	
	public void preencherCampoLado3(String lado3) {
		escrever(By.id("lado3"),lado3);
	}

	public void cliqueBotaoCalcular() {;
		clique(By.id("calcular"));
	}

	public String getMensagem() {
		return obterTexto(By.id("message"));
	}
	
}