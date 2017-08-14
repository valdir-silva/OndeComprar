package DataBase;

import java.util.Arrays;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import interfaces.IRepositorioProduto;
import programa.Produto;

public class RepositorioListaProduto implements IRepositorioProduto{
	private Produto produto;
	RepositorioListaProduto proximo;
	
	public void inserirProduto(Produto produto){
		if(this.produto == null){
			this.produto = produto;
			proximo = new RepositorioListaProduto();
		} else {
			proximo.inserirProduto(produto);
		}
	}
	public Produto procurarProduto (int id){
		Produto produto = null;
		
		if(this.produto == null){
			System.out.println("Produto não encontrado.");
			return produto;
		} else if(this.produto.getId() == id){
			produto = this.produto;
		} else {
			proximo.procurarProduto(id);
		}
		return produto;
	}
	public void removerProduto (int id){	
		if(this.produto == null){
			System.out.println("Produto não encontrado.");
		} else if (this.produto.getId() == id){
			this.produto = null;
		} else {
			proximo.removerProduto(id);
		}
	}
	public void atualizarProduto(Produto produto){
		if(this.produto == null){
			System.out.println("Produto não encontrado.");
		} else if (this.produto.getId() == produto.getId()){
			this.produto = produto;
		} else {
			proximo.removerProduto(produto.getId());
		}
	}

	public TableModel popularTabela(RepositorioListaProduto rep){
		DefaultTableModel table = null;
//		
//		Vector rowData = new Vector();
//	    for (int i = 0; i < 1; i++) {
//	      Vector colData = new Vector(Arrays.asList("qq"));
//	      rowData.add(colData);
//	    }
//	    String[] columnNames = {"a"};
//	    Vector columnNamesV = new Vector(Arrays.asList(columnNames));
//	    
//		table.;
		return table;
	}
	@Override
	public void listarProdutos() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void listarProdutos(String order) {
		// PELO JEITO NÃO ESTOU USANDO MAIS ESSE MÉTODO EM NENHUMA CLASSE
		
	}
	@Override
	public Produto buscarProduto(int id) {
		// PELO JEITO NÃO ESTOU USANDO MAIS ESSE MÉTODO EM NENHUMA CLASSE
		return null;
	}
	@Override
	public TableModel listarProdutosTabela(String texto, String order) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void apagarProduto(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Produto produtoParaTela(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
