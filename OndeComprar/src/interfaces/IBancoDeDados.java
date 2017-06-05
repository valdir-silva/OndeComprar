package interfaces;

import programa.Produto;

public interface IBancoDeDados { // verificar se h� uma melhor forma de organizar isso, para n�o ficar todos os m�todos dentro dessa classe
	public void conectar();
	public boolean estaConectado();
	public void desconectar();
	public void listarProdutos(); // lista os produtos no console
	public Produto buscarProduto(int id); // busca produtos atrav�s do id e retorna o objeto completo
	public void inserirProduto(Produto produto); // fazer m�todo inserir com Overloading para Produto e Empresa;
	public void atualizarProduto(Produto produto); //adicionar clicar em 'editar' do lado de cada campo para liberar a edi��o.
	public void apagarProduto(int id);
}