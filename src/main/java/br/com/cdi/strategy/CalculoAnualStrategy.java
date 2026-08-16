package br.com.cdi.strategy;

public class CalculoAnualStrategy implements CalculoRendimentoStrategy{
	
	@Override
	public double calcular(double valorInicial, double taxaCdi) {
		double rendimento = valorInicial * (taxaCdi/100 * 252);
		return rendimento;
	}
}
