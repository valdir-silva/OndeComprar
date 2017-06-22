package programa;

import java.sql.ResultSet;

import javax.swing.table.TableModel;

import interfaces.IRepositorioProduto;

public class ControleProdutos implements IRepositorioProduto{ // se controleta implementando IRepositorio, como karai que o java sabe o código?
	IRepositorioProduto repositorioProduto;
	Produto produto;
	
	public ControleProdutos (IRepositorioProduto repositorioProduto) { //tinha no programa de matheus, não sei pra que serve
		this.repositorioProduto = repositorioProduto;
	}
	
	public void listarProdutos(){ //que porra que isso vai fazer? NADA!? (LOOP INFINITO)
		repositorioProduto.listarProdutos();
	}
	public void listarProdutos(String order){ // LOOP!!!!!!!!!
		repositorioProduto.listarProdutos(order);
	}
	public Produto buscarProduto(int id){ // LOOP!!!!!!!!!
		return repositorioProduto.buscarProduto(id);
	}
	public void inserirProduto(Produto produto){ // LOOP!!!!!!!!!
		repositorioProduto.inserirProduto(produto);
	}
	public void atualizarProduto(Produto produto){ // LOOP!!!!!!!!!
		repositorioProduto.atualizarProduto(produto);
	}
	public void apagarProduto(int id){ // LOOP!!!!!!!!!
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
