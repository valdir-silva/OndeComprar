package programa;

public class Promocao {
	private float preco_anterior;
	private float preco_atual;
	private Produto produto;
	
	public float getPreco_anterior() {
		return preco_anterior;
	}
	public void setPreco_anterior(float preco_anterior) {
		this.preco_anterior = preco_anterior;
	}
	public float getPreco_atual() {
		return preco_atual;
	}
	public void setPreco_atual(float preco_atual) {
		this.preco_atual = preco_atual;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
