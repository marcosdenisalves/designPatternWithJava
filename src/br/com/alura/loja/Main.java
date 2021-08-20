package br.com.alura.loja;

import java.math.BigDecimal;
import java.util.Arrays;

import br.com.alura.loja.pedido.GerarPedido;
import br.com.alura.loja.pedido.GerarPedidoHandler;
import br.com.alura.loja.pedido.acao.EnviarEmailPedido;
import br.com.alura.loja.pedido.acao.LogDePedido;
import br.com.alura.loja.pedido.acao.SalvarPedidoNoBanco;

public class Main {

	public static void main(String[] args) {
		String cliente = "Ana da Silva";
		BigDecimal valorOrcamento = new BigDecimal("745.99");
		int quantidadeItens = 3;
		
		GerarPedido gerador = new GerarPedido(cliente, valorOrcamento, quantidadeItens);
		GerarPedidoHandler handler = new GerarPedidoHandler(Arrays.asList(
				new EnviarEmailPedido(),
				new SalvarPedidoNoBanco(),
				new LogDePedido()));
		
		handler.execute(gerador);
	}
}
