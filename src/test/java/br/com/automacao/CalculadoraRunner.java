package br.com.automacao;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/br/com/automacao/Calculadora.feature", // feature que será rodada através desse Runner
		glue = "br.com.automacao", // caminho para encontrar os arquivos de steps correspondentes
		tags = {"@funcionais"}, // executa os testes que estão marcados com essa tag
		plugin =  {"pretty", "html:target/reports/report-html", "json:target/reports/report-json/report.json"},
		monochrome = true,
		snippets = SnippetType.UNDERSCORE, // formato que gera os passos do cenário quando ainda não existe
		dryRun = false,
		strict = false
		)
public class CalculadoraRunner {

}