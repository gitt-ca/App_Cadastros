package model;

public final class VendaProduto {
	
	private int id;
	private int id_venda;
	private int id_produto;
	private int qtde;
	private double valor_unitario;
	private double valor_total_produto;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_venda() {
		return id_venda;
	}
	public void setId_venda(int id_venda) {
		this.id_venda = id_venda;
	}
	public int getId_produto() {
		return id_produto;
	}
	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}
	public int getQtde() {
		return qtde;
	}
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	public double getValor_unitario() {
		return valor_unitario;
	}
	public void setValor_unitario(double valor_unitario) {
		this.valor_unitario = valor_unitario;
	}
	public double getValor_total_produto() {
		return valor_total_produto;
	}
	public void setValor_total_produto(double valor_total_produto) {
		this.valor_total_produto = valor_total_produto;
	}
	
}
