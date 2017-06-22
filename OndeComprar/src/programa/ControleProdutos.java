package programa;

import java.sql.ResultSet;

import javax.swing.table.TableModel;

import interfaces.IRepositorioProduto;

public class ControleProdutos implements IRepositorioProduto{ 
	IRepositorioProduto repositorioProduto;
	Produto produto;
	
	public ControleProdutos (IRepositorioProduto repositorioProduto) {
		this.repositorioProduto = repositorioProduto;
	}
	
	public void listarProdutos(){
		repositorioProduto.listarProdutos();
	}
	public void listarProdutos(String order){ 
		repositorioProduto.listarProdutos(order);
	}
	public Produto buscarProduto(int id){ 
		return repositorioProduto.buscarProduto(id);
	}
	public void inserirProduto(Produto produto){
		repositorioProduto.inserirProduto(produto);
	}
	public void atualizarProduto(Produto produto){
		repositorioProduto.atualizarProduto(produto);
	}
	public void apagarProduto(int id){ 
		repositorioProduto.apagarProduto(id);
	}

	public TableModel listarProdutosTabela(String texto, String order) {
		return repositorioProduto.listarProdutosTabela(texto, order);
	}

	@Override
	public Produto produtoParaTela(int id) {
		return repositorioProduto.produtoParaTela(id);
	}
}
