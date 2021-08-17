package br.com.alura.loja;

import java.math.BigDecimal;
import java.util.Arrays;

import br.com.alura.loja.pedido.GerarPedido;
import br.com.alura.loja.pedido.GerarPedidoHandler;
import br.com.alura.loja.pedido.acao.EnviarEmailPedido;
import br.com.alura.loja.pedido.acao.SalvarPedidoNoBanco;

public class Main {

	public static void main(String[] args) {
		GerarPedidoHandler handler = new GerarPedidoHandler(Arrays.asList(new SalvarPedidoNoBanco(), new EnviarEmailPedido()));
		handler.execute(new GerarPedido("Carlos", new BigDecimal("200"),5));
	}
}
