package br.com.alura.loja.orcamento;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.loja.orcamento.situacao.EmAnalise;
import br.com.alura.loja.orcamento.situacao.Finalizado;
import br.com.alura.loja.orcamento.situacao.SituacaoOrcamento;

public class Orcamento implements Orcavel {

	private BigDecimal valor;
	private SituacaoOrcamento situcao;
	private List<Orcavel> itens;

	public Orcamento() {
		this.valor = BigDecimal.ZERO;
		this.situcao = new EmAnalise();
		this.itens = new ArrayList<>();
	}

	public void aplicarDescontoExtra() {
		BigDecimal valorDoDescontoExtra = this.situcao.calcularValorDescontoExtra(this);

		this.valor = this.valor.subtract(valorDoDescontoExtra);
	}

	public void aprovar() {
		this.situcao.aprovar(this);
	}

	public void reprovar() {
		this.situcao.reprovar(this);
	}

	public void finalizar() {
		this.situcao.finalizar(this);
	}

	public BigDecimal getValor() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return valor;
	}

	public int getQuantidadeItens() {
		return itens.size();
	}

	public SituacaoOrcamento getSitucao() {
		return situcao;
	}

	public void setSitucao(SituacaoOrcamento situcao) {
		this.situcao = situcao;
	}

	public boolean isFinalizado() {
		return situcao instanceof Finalizado;
	}

	public void adicionarItem(Orcavel item) {
		this.valor = valor.add(item.getValor());
		this.itens.add(item);
	}
}