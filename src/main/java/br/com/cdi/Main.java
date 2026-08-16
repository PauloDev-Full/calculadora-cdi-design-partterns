package br.com.cdi;

import br.com.cdi.facade.CdiServiceFacade;
import br.com.cdi.strategy.CalculoAnualStrategy;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== CONSULTA E CÁLCULO DE RENDIMENTO CDI ===");
        
        double valorInvestido = 1000.00;
        System.out.printf("Valor Inicial do Investimento: R$ %.2f%n%n", valorInvestido);

        try {
        	CdiServiceFacade cdiFacade = new CdiServiceFacade();

            // 1. Usando os métodos de conveniência da Facade
            double rendimentoDiario = cdiFacade.calcularRendimentoDiario(valorInvestido);
            double rendimentoMensal = cdiFacade.calcularRendimentoMensal(valorInvestido);
            
            // 2. Usando o método genérico passando a Strategy diretamente
            double rendimentoAnual = cdiFacade.calcular(valorInvestido, new CalculoAnualStrategy());

            System.out.println("--- Resultados das Projeções ---");
            System.out.printf("Rendimento Diário: R$ %.4f%n", rendimentoDiario);
            System.out.printf("Rendimento Mensal: R$ %.4f%n", rendimentoMensal);
            System.out.printf("Rendimento Anual: R$ %.4f%n", rendimentoAnual);

        } catch (Exception e) {
            System.err.println("Erro ao buscar dados do Banco Central ou calcular o rendimento:");
            e.printStackTrace();
        }
    }
}