package interfaces;

import programa.Produto;

public interface IBancoDeDados { // verificar se h� uma melhor forma de organizar isso, para n�o ficar todos os m�todos dentro dessa classe
	public void conectar();
	public boolean estaConectado();
	public void desconectar();
}