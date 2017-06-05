package interfaces;

import programa.Produto;

public interface IBancoDeDados { // verificar se há uma melhor forma de organizar isso, para não ficar todos os métodos dentro dessa classe
	public void conectar();
	public boolean estaConectado();
	public void desconectar();
	public void listarProdutos(); // lista os produtos no console
	public Produto buscarProduto(int id); // busca produtos através do id e retorna o objeto completo
	public void inserirProduto(Produto produto); // fazer método inserir com Overloading para Produto e Empresa;
	public void atualizarProduto(Produto produto); //adicionar clicar em 'editar' do lado de cada campo para liberar a edição.
	public void apagarProduto(int id);
}