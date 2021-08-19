package br.com.alura.loja;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.JavaHttpClient;
import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.orcamento.RegistrosDeOrcamento;

public class Main {

	public static void main(String[] args) {
		Orcamento orcamento = new Orcamento(BigDecimal.TEN, 1);
		orcamento.aprovar();
		orcamento.finalizar();

		RegistrosDeOrcamento registro = new RegistrosDeOrcamento(new JavaHttpClient());
		registro.registrar(orcamento);
	}
}
