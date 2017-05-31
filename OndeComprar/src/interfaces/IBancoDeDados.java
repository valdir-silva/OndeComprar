package interfaces;

import programa.Produto;

public interface IBancoDeDados { // verificar se há uma melhor forma de organizar isso, para não ficar todos os métodos dentro dessa classe
	public void conectar();
	public void estaConectado();
	public void desconectar();
	public void listarProduto ();
	public void inserirProduto (Produto produto); // fazer método inserir com Overloading para Produto e Empresa;
	public void editarProduto(Produto produto); // substituir Overloading atual por pre-carregar os campos com o valor original do objeto, talvez até ter que clicar em 'editar' do lado de cada campo para liberar a edição.
	public void apagarProduto(int id);
}
