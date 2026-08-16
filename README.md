#Consulta e Cálculo de Rendimento CDI

Aplicação Java desenvolvida para consultar a taxa diária do CDI em tempo real através da API do Banco Central do Brasil (BACEN) e realizar projeções de rendimento (diário, mensal e anual) aplicando padrões de projeto GoF.

---

##Padrões de Projeto Aplicados

* **Singleton (BacenClient):** Garante a existência de uma única instância do HttpClient durante o ciclo de vida da aplicação, otimizando o uso de recursos de rede e conexões HTTP.
* **Strategy (CalculoRendimentoStrategy):** Encapsula os diferentes algoritmos de cálculo de rendimento (Diário, Mensal e Anual) em classes polimórficas separadas, permitindo a inclusão de novas regras financeiras sem alterar o código existente.
* **Facade (CdiServiceFacade):** Unifica a complexidade do sistema (busca HTTP, conversão de JSON via Jackson e execução do cálculo) em uma interface simples e amigável para o cliente (Main).

---

##Tecnologias Utilizadas

* **Java 21:** Uso de *Records* (TaxaCdiDto) para imutabilidade e clareza de dados.
* **Jackson Databind:** Desserialização do JSON da API para objetos Java.
* **Gradle:** Gerenciamento de dependências e build.
* **API de Dados Abertos do BACEN:** Fonte oficial das séries temporais da taxa CDI.

---

##Estrutura do Projeto

```text
br.com.cdi/
├── Main.java                        <-- Ponto de entrada da aplicação
├── client/
│   └── BacenClient.java             <-- Cliente HTTP (Singleton)
├── facade/
│   └── CdiServiceFacade.java        <-- Interface unificada (Facade)
├── model/
│   └── TaxaCdiDto.java              <-- Modelo de dados (Record)
├── strategy/
│   ├── CalculoRendimentoStrategy.java <-- Interface do cálculo
│   ├── CalculoDiario.java            <-- Implementação diária
│   ├── CalculoMensal.java            <-- Implementação mensal
│   └── CalculoAnualStrategy.java     <-- Implementação anual
└── util/
    └── TaxaCdiMapper.java           <-- Conversor de JSON (Jackson)
```
---
>**Nota Didática:** 

> As fórmulas de cálculo de rendimento utilizadas neste projeto (como a multiplicação direta por 21 ou 252 dias) são aproximações lineares simplificadas. O objetivo principal desta aplicação é estritamente **didático e arquitetural**, servindo para demonstrar a implementação prática de padrões de projeto GoF (Singleton, Strategy e Facade) e integração com APIs REST em Java, e não para uso financeiro real.
