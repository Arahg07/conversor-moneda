package mx.com.alura.conversor.model;

public class ConversorTemperatura {
	private double temperatura;

	/**
	 * Constructor de la clase ConversorTemperatura, recibe un parametro de tipo double
	 * @param temperatura
	 */
	public ConversorTemperatura(double temperatura){

		this.temperatura = temperatura;
	}

	public ConversorTemperatura(){

	}

	/**
	 * Metodo que convierte los grados Fahrenheit a Celcius
	 * @return ResultadoConversorTemperatura
	 */
	public double conversorFahrenheitCelcius() {
		double resultadoConversorTemperatura = (temperatura - 32) * 5 / 9; 
		
		return resultadoConversorTemperatura;
	}

	/**
	 * Metodo que convierte los grados Celcius a Fahrenheit
	 * @return ResultadoConversorTemperatura
	 */
	public double conversorCelciusFahrenheit() {
		double resultadoConversorTemperatura = (temperatura * 9 / 5) + 32;
		
		return resultadoConversorTemperatura;
	}
	

}
