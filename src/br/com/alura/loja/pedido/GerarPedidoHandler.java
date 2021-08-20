package br.com.alura.loja.pedido;

import java.time.LocalDateTime;
import java.util.List;

import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.pedido.acao.AcaoAposGerarPedido;

public class GerarPedidoHandler {

	private List<AcaoAposGerarPedido> acoes;
	
	public GerarPedidoHandler(List<AcaoAposGerarPedido> acoes) {
		this.acoes = acoes;
	}

	public void execute(GerarPedido dados) {
		Orcamento orcamento = new Orcamento();
		Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(), orcamento);
		
		acoes.forEach(x -> x.executarAcao(pedido));
	}
}
