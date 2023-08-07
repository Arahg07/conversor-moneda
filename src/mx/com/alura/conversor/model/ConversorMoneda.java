package mx.com.alura.conversor.model;
public class ConversorMoneda implements Conversor {
	
	private double monedaMexicana;
	private double monedaCambio;

	/**
	 * Constructor de la Clase ConversorMoneda con parametros de tipo Double
	 * @param monedaMexicana
	 * @param monedaCambio
	 */

	public  ConversorMoneda(double monedaMexicana, double monedaCambio){
		this.monedaMexicana = monedaMexicana;
		this.monedaCambio = monedaCambio;
	}


	/**
	 * Metodo convertir el cual realiza la operación de conversor
	 * @return resultadoConversion
	 */
	public double convertir() {
		
		double resultadoConversion = monedaMexicana * monedaCambio;
		
		return resultadoConversion;
	}
	

}
