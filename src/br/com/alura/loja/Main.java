package br.com.alura.loja;

import java.math.BigDecimal;

import br.com.alura.loja.pedido.GerarPedido;
import br.com.alura.loja.pedido.GerarPedidoHandler;

public class Main {

	public static void main(String[] args) {
		GerarPedidoHandler handler = new GerarPedidoHandler(/*dependencias*/);
		handler.execute(new GerarPedido("Carlos", new BigDecimal("200"),5));
	}
}
