/*
 * 
 * Aplicado o padrão de projeto Facade para gerar uma interface limpa para o usuário e manter pontos secundários oculto para o mesmo, assim, tornando mudanças arquiteturais ocultas em caso de atualizações.
 * 
 */
package br.com.cdi.facade;

import br.com.cdi.client.BacenClient;
import br.com.cdi.model.TaxaCdiDto;
import br.com.cdi.strategy.*;
import br.com.cdi.util.TaxaCdiMapper;

import java.util.List;

public class CdiServiceFacade {

    private final TaxaCdiMapper mapper;

    public CdiServiceFacade() {
        this.mapper = new TaxaCdiMapper();
    }

    private double obterUltimaTaxaCdi() throws Exception {

        String json = BacenClient.getInstance().buscarTaxaCdi();
        
        List<TaxaCdiDto> lista = this.mapper.converterJsonParaLista(json);

        TaxaCdiDto ultimoRegistro = lista.get(lista.size() - 1);

        return Double.parseDouble(ultimoRegistro.valor());
    }

    public double calcular(double valorInvestido, CalculoRendimentoStrategy strategy) throws Exception {
        double taxaCdi = obterUltimaTaxaCdi();
        return strategy.calcular(valorInvestido, taxaCdi);
    }

    public double calcularRendimentoDiario(double valorInvestido) throws Exception {
        return calcular(valorInvestido, new CalculoDiarioStrategy());
    }

    public double calcularRendimentoMensal(double valorInvestido) throws Exception {
        return calcular(valorInvestido, new CalculoMensalStrategy());
    }

    public double calcularRendimentoAnual(double valorInvestido) throws Exception {
        return calcular(valorInvestido, new CalculoAnualStrategy());
    }
}