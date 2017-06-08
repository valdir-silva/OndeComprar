package programa;

import DataBase.BancoDeDados;
import DataBase.RepositorioProduto;

public class Programa {

	public static void main(String[] args) {
		Produto produto = new Produto(); //quanto o construtor é o padrão se torna reduntante espeficitar? é o mesmo que = null?
		RepositorioProduto repositorio = new RepositorioProduto();
		produto.setNome("i5");
		produto.setMarca("Intel");
		produto.setPreco((float) 990.10);;
		
			//banco.apagarProduto(id);
			//banco.editarProduto(id, nome);
			//banco.inserirProduto(produto);
		String order = "marca";
			repositorio.listarProdutos(order);
	}
}
