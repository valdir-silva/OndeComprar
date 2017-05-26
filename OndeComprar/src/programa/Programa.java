package programa;

import DataBase.BancoDeDados;

public class Programa {

	public static void main(String[] args) {

		BancoDeDados bancoDeDados = new BancoDeDados();
		
		bancoDeDados.conectar();
		if(bancoDeDados.estaConectado()){
			bancoDeDados.listarProdutos();
			bancoDeDados.desconectar();
		} else {
			System.out.println("N�o foi pos�vel conectar ao banco de dados!");
		}
	}

}
