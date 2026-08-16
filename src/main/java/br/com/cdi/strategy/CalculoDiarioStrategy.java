package br.com.cdi.strategy;

public class CalculoDiarioStrategy implements CalculoRendimentoStrategy{
		
	@Override
	public double calcular(double valorInicial, double taxaCdi) {
		double rendimento = valorInicial * taxaCdi/100;
		return rendimento;
	}

}
