package br.edu.unoesc.lista25.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.lista25.util.Calculadora;
import br.edu.unoesc.lista25.util.ConversorNumerico;

@RestController
@RequestMapping("/api/operacoes")
public class OperationsController {
	
	// Lista de endpoints
	@GetMapping
	public String listarEndpoints() {
		return """
			   <pre>
			   Lista de End-points para cada operação:
		   
			   /api/operacoes/somar-query?num1={numero1}&num2={numero2}
			   /api/operacoes/somar-path/{numero1}/{numero2}
			   
			   /api/operacoes/subtrair-query?num1={numero1}&num2={numero2}
			   /api/operacoes/subtrair-path/{numero1}/{numero2}
			   
			   /api/operacoes/multiplicar-query?num1={numero1}&num2={numero2}
			   /api/operacoes/multiplicar-path/{numero1}/{numero2}
			   
			   /api/operacoes/dividir-query?num1={numero1}&num2={numero2}
			   /api/operacoes/dividir-path/{numero1}/{numero2}
			   
			   /api/operacoes/media-query?num1={numero1}&num2={numero2}
			   /api/operacoes/media-path/{numero1}/{numero2}
			   
			   /api/operacoes/potencia-query?base={base}&expoente={expoente}
			   /api/operacoes/potencia-path/{base}/{expoente}
			   
			   /api/operacoes/raiz-query?num={numero}
			   /api/operacoes/raiz-path/{numero}
			   </pre>
			   """;
	}

	// endpoints para operação de SOMA
	@GetMapping("/somar-query")
	public Double somarQuery(
			@RequestParam(value = "num1", defaultValue = "0") String num1,
			@RequestParam(value = "num2", defaultValue = "0") String num2) {

		Double resultado = Calculadora.somar(
				ConversorNumerico.converteParaDouble(num1),
				ConversorNumerico.converteParaDouble(num2));

		Logger.getLogger(OperationsController.class.getName())
			.log(Level.INFO, "Resultado da soma com query params: " + resultado);

		return resultado;
	}
	@GetMapping("/somar-path/{num1}/{num2}")
	public Double somarPath(
			@PathVariable(value = "num1") String num1,
			@PathVariable(value = "num2") String num2) {

		Double resultado = Calculadora.somar(ConversorNumerico.converteParaDouble(num1),
				ConversorNumerico.converteParaDouble(num2));

		Logger.getLogger(OperationsController.class.getName())
			.log(Level.INFO, "Resultado da soma com path params: " + resultado);

		return resultado;
	}

	// endpoints para operação de SUBTRAÇÃO
	@GetMapping("/subtrair-query")
	public Double subtrairQuery(
			@RequestParam(value = "num1", defaultValue = "0") String num1,
			@RequestParam(value = "num2", defaultValue = "0") String num2) {
		
		Double resultado = Calculadora.subtrair(
				ConversorNumerico.converteParaDouble(num1),
				ConversorNumerico.converteParaDouble(num2));

		Logger.getLogger(OperationsController.class.getName())
			.log(Level.INFO, "Resultado da subtração com query params: " + resultado);

		return resultado;
	}
	@GetMapping("/subtrair-path/{num1}/{num2}")
	public Double subtrairPath(
			@PathVariable(value = "num1") String num1,
			@PathVariable(value = "num2") String num2) {
		
		Double resultado = Calculadora.subtrair(
				ConversorNumerico.converteParaDouble(num1),
				ConversorNumerico.converteParaDouble(num2));

		Logger.getLogger(OperationsController.class.getName())
			.log(Level.INFO, "Resultado da subtração com path params: " + resultado);
		
		return resultado;
	}

	// endpoints para operação de MULTIPLICAÇÃO
	@GetMapping("/multiplicar-query")
	public Double multiplicarQuery(
			@RequestParam(value = "num1", defaultValue = "0") String num1,
			@RequestParam(value = "num2", defaultValue = "0") String num2) {

		Double resultado = Calculadora.multiplicar(
				ConversorNumerico.converteParaDouble(num1),
				ConversorNumerico.converteParaDouble(num2));

		Logger.getLogger(OperationsController.class.getName())
			.log(Level.INFO, "Resultado da multiplicação com query params: " + resultado);

		return resultado;
	}
	@GetMapping("/multiplicar-path/{num1}/{num2}")
	public Double multiplicarPath(
			@PathVariable(value = "num1") String num1,
			@PathVariable(value = "num2") String num2) {
		
		Double resultado = Calculadora.multiplicar(
				ConversorNumerico.converteParaDouble(num1),
				ConversorNumerico.converteParaDouble(num2));

		Logger.getLogger(OperationsController.class.getName())
			.log(Level.INFO, "Resultado da multiplicação com path params: " + resultado);

		return resultado;
	}
	
	
	// endpoints para operação de DIVISÃO
	@GetMapping("/dividir-query")
	public Double dividirQuery(
			@RequestParam(value = "num1", defaultValue = "0") String num1,
			@RequestParam(value = "num2", defaultValue = "0") String num2) {
		
		Double resultado = null;
		try {
			resultado = Calculadora.dividir(
				ConversorNumerico.converteParaDouble(num1),
				ConversorNumerico.converteParaDouble(num2));

			Logger.getLogger(OperationsController.class.getName())
				.log(Level.INFO, "Resultado da divisão com query params: " + resultado);
			
		} catch (ArithmeticException e) { 
			System.out.println("Erro: " + e.getMessage()); 
		}
		
		return resultado;
	}
	@GetMapping("/dividir-path/{num1}/{num2}")
	public Double dividirPath(
		@PathVariable(value = "num1") String num1,
		@PathVariable(value = "num2") String num2) {
		
	Double resultado = null;
	try {
		resultado = Calculadora.dividir(
				ConversorNumerico.converteParaDouble(num1),
				ConversorNumerico.converteParaDouble(num2));

		Logger.getLogger(OperationsController.class.getName())
			.log(Level.INFO, "Resultado da divisão com path params: " + resultado);

	} catch (ArithmeticException e) { System.out.println("Erro: " + e.getMessage()); }
		
		return resultado;
	}


	// endpoints para operação de MÉDIA
	@GetMapping("/media-query")
	public Double mediaQuery(
			@RequestParam(value = "num1", defaultValue = "0") String num1,
			@RequestParam(value = "num2", defaultValue = "0") String num2) {
		
		Double resultado = Calculadora.media(
				ConversorNumerico.converteParaDouble(num1),
				ConversorNumerico.converteParaDouble(num2));

		Logger.getLogger(OperationsController.class.getName())
			.log(Level.INFO, "Resultado da média com query params: " + resultado);

		return resultado;
	}
	@GetMapping("/media-path/{num1}/{num2}")
	public Double mediaPath(
			@PathVariable(value = "num1") String num1,
			@PathVariable(value = "num2") String num2) {
		
		Double resultado = Calculadora.media(
				ConversorNumerico.converteParaDouble(num1),
				ConversorNumerico.converteParaDouble(num2));

		Logger.getLogger(OperationsController.class.getName())
			.log(Level.INFO, "Resultado da média com path params: " + resultado);

		return resultado;
	}


	// endpoints para operação de POTENCIAÇÃO
	@GetMapping("/potencia-query")
	public Double potenciaQuery(
			@RequestParam(value = "base", defaultValue = "0") String base,
			@RequestParam(value = "expoente", defaultValue = "0") String expoente) {
		
		Double resultado = Calculadora.potencia(
				ConversorNumerico.converteParaDouble(base),
				ConversorNumerico.converteParaDouble(expoente));

		Logger.getLogger(OperationsController.class.getName())
			.log(Level.INFO, "Resultado da potenciação com query params: " + resultado);

		return resultado;
	}
	@GetMapping("/potencia-path/{base}/{expoente}")
	public Double potenciaPath(
			@PathVariable(value = "base") String base,
			@PathVariable(value = "expoente") String expoente) {
		
		Double resultado = Calculadora.potencia(
				ConversorNumerico.converteParaDouble(base),
				ConversorNumerico.converteParaDouble(expoente));

		Logger.getLogger(OperationsController.class.getName())
			.log(Level.INFO, "Resultado da potenciação com path params: " + resultado);

		return resultado;
	}

	// endpoints para operação de RAIZ QUADRADA
	@GetMapping("/raiz-query")
	public Double raizQuery(@RequestParam(value = "num", defaultValue = "0") String num) {
		
		Double resultado = null;
		try {
			resultado = Calculadora.raizQuadrada(ConversorNumerico.converteParaDouble(num));
		
			Logger.getLogger(OperationsController.class.getName())
				.log(Level.INFO, "Resultado da raiz quadrada com query params: " + resultado);
			
		} catch (ArithmeticException e) { System.out.println("Erro:" + e.getMessage()); }
		
		return resultado;
	}
	@GetMapping("/raiz-path/{num}")
	public Double raizPath(@PathVariable(value = "num") String num) {
		
		Double resultado = null;
		try {
			resultado = Calculadora.raizQuadrada(ConversorNumerico.converteParaDouble(num));
			
			Logger.getLogger(OperationsController.class.getName())
				.log(Level.INFO, "Resultado da raiz quadrada com path params: " + resultado);
				
		} catch (ArithmeticException e) { System.out.println("Erro:" + e.getMessage()); }
		
		return resultado;
	}
}
