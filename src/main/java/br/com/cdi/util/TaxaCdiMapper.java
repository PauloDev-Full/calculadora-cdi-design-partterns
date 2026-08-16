package br.com.cdi.util;

import br.com.cdi.model.TaxaCdiDto;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

public class TaxaCdiMapper {
	private static final ObjectMapper MAPPER = new ObjectMapper();
	
	public List<TaxaCdiDto> converterJsonParaLista(String jsonTexto) throws JsonProcessingException{
	List<TaxaCdiDto> lista = MAPPER.readValue(jsonTexto, new TypeReference<List<TaxaCdiDto>>() {});
	return lista;
	}
}
