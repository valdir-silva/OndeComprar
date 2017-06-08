package interfaces;

import programa.Produto;

public interface IRepositorioProduto {
	public void listarProdutos();
	public void listarProdutos(String order);
	public Produto buscarProduto(int id);
	public void inserirProduto(Produto produto);
	public void atualizarProduto(Produto produto);
	public void apagarProduto(int id);
}
