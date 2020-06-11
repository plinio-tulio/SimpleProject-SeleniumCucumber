package br.com.automacao;

import static br.com.automacao.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class BasePage {
	
	final protected String BaseURL = "https://calculadoratriangulo.herokuapp.com/index.php";

	public void acessar(String texto) {
		getDriver().get(texto);
	}

	public void escrever(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);
	}

	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}

	public void clique(By by) {
		getDriver().findElement(by).click();
	}

	public static void scrollClique(By element) {
		WebElement ele = getDriver().findElement(element);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				getDriver().findElement(element));
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		executor.executeScript("arguments[0].click();", ele);
	}
	
	public static void scrollCliqueElement(WebElement ele) {
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				ele);
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		executor.executeScript("arguments[0].click();", ele);
	}

}