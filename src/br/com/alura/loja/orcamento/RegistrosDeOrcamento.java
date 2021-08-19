package br.com.alura.loja.orcamento;

import java.util.Map;

import br.com.alura.loja.http.HttpAdapter;
import br.com.alura.loja.orcamento.exception.DomainException;

public class RegistrosDeOrcamento {

	private HttpAdapter http;

	public RegistrosDeOrcamento(HttpAdapter http) {
		this.http = http;
	}

	public void registrar(Orcamento orcamento) {
		if (!orcamento.isFinalizado())
			throw new DomainException("Orcamento não finalizado!");
		
		String url = "http://api.externa/orcamento";
		Map<String, Object> dados = Map.of(
				"valor", orcamento.getValor(),
				"quantidadeItens", orcamento.getQuantidadeItens()
				);
		
		http.post(url , dados);
	}
}
