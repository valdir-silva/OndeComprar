package programa;

import DataBase.BancoDeDados;
import DataBase.RepositorioProduto;

public class Programa {

	public static void main(String[] args) {

		RepositorioProduto bancoDeDados = new RepositorioProduto();
		String nome = "Mouse Gamer";
		String marca = "ADATA";
		double preco = 99.10;
		int id=2;
		
		bancoDeDados.conectar();
		if(bancoDeDados.estaConectado()){
			//bancoDeDados.apagarProduto(id);
			//bancoDeDados.editarProduto(id, nome);
			//bancoDeDados.inserirProduto(nome, marca, preco);
			bancoDeDados.listarProdutos();
			bancoDeDados.desconectar();
		} else {
			System.out.println("Não foi posível conectar ao banco de dados!");
		}
	}

}
