package br.com.cdi.strategy;

public class CalculoMensalStrategy implements CalculoRendimentoStrategy{

	@Override
	public double calcular(double valorInicial, double taxaCdi) {
		double rendimento = valorInicial * (taxaCdi/100 * 21);
		return rendimento;
	}

}
