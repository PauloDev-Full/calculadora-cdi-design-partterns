/*
 * 
 * Aplicado o padrão de projeto Singleton para garantir que apenas um cliente HTTP seja instanciado, centralizando a comunicação do programa em um único ponto e otimizando o uso de conexões de rede. 
 */

package br.com.cdi.client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BacenClient {
	
	private static BacenClient instance;
	private final HttpClient client;
	
	private BacenClient() {
		super();
		this.client = HttpClient.newHttpClient();
	}
	
	public static BacenClient getInstance() {
		if(instance == null) {
			instance = new BacenClient();
		}
		return instance;
	}
	
	public String buscarTaxaCdi() throws Exception {
	    
	    HttpRequest request = HttpRequest.newBuilder()
	            .uri(URI.create("https://api.bcb.gov.br/dados/serie/bcdata.sgs.12/dados/ultimos/1?formato=json"))
	            .header("Accept", "application/json")
	            .GET()
	            .build();

	    HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());

	    return response.body();
	}
		
	
}