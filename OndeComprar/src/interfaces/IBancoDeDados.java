package interfaces;

import programa.Produto;

public interface IBancoDeDados { // verificar se há uma melhor forma de organizar isso, para não ficar todos os métodos dentro dessa classe
	public void conectar();
	public boolean estaConectado();
	public void desconectar();
}