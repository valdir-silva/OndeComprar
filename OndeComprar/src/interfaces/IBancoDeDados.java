package interfaces;

import programa.Produto;

public interface IBancoDeDados { // verificar se h� uma melhor forma de organizar isso, para n�o ficar todos os m�todos dentro dessa classe
	public void conectar();
	public void estaConectado();
	public void desconectar();
	public void listarProduto ();
	public void inserirProduto (Produto produto); // fazer m�todo inserir com Overloading para Produto e Empresa;
	public void editarProduto(Produto produto); // substituir Overloading atual por pre-carregar os campos com o valor original do objeto, talvez at� ter que clicar em 'editar' do lado de cada campo para liberar a edi��o.
	public void apagarProduto(int id);
}
