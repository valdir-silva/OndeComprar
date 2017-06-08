package DataBase;

import interfaces.IRepositorioProduto;
import programa.Produto;

public class RepositorioProduto extends BancoDeDados implements IRepositorioProduto{

	public void listarProdutos(){
		try{
			super.conectar();
			String query = "SELECT * FROM produto ORDER BY nome";
			this.resultset = this.statement.executeQuery(query);
			while(this.resultset.next()){
				System.out.println("ID: " + this.resultset.getString("id") + " - Nome: " + this.resultset.getString("nome") + " - Marca: " + this.resultset.getString("marca") + " - Preço: " + this.resultset.getFloat("preco"));
			}
			super.desconectar();
		} catch(Exception e){
			System.out.println("Listar Erro: " + e.getMessage());
		}
	}
	public Produto buscarProduto(int id){
		Produto produto = new Produto();
		try{
			super.conectar();
			String query = "SELECT * from produto WHERE id = " + id + ";";
			this.resultset = this.statement.executeQuery(query);
			while(this.resultset.next()){
				produto.setId(Integer.parseInt(this.resultset.getString("id")));
				produto.setMarca(this.resultset.getString("marca"));
				produto.setNome(this.resultset.getString("nome"));
				produto.setPreco(Float.parseFloat(this.resultset.getString("preco")));
			}
			super.desconectar();
			return produto;
		} catch(Exception e){
			System.out.println("Buscar Erro: " + e.getMessage());
		}
		return produto; //perguntar ao professor como fica quando dá erro e retorna este objeto vazio (nao perguntei mas deve usar uma exceção pra isso)
	}
	public void inserirProduto(Produto produto){
		try{
			super.conectar();
			String query = "INSERT INTO produto (nome, marca, preco) VALUES('" + produto.getNome() + "', '" + produto.getMarca() +"', '" + produto.getPreco() + "');";
			this.statement.executeUpdate(query);
			super.desconectar();
		} catch (Exception e){
			System.out.println("Inserir ERRO: " + e.getMessage());
		}
	}
	public void atualizarProduto(Produto produto){
		try{
			super.conectar();
			String query = "UPDATE produto SET nome = '" + produto.getNome() + "', marca = '" + produto.getMarca() + "', preco = '" + produto.getPreco() + "' WHERE id = " + produto.getId() + ";";
			this.statement.executeUpdate(query);
			super.desconectar();
		} catch (Exception e){
			System.out.println("Editar ERRO: " + e.getMessage()); 
		}
	}
	public void apagarProduto(int id){
		try{
			super.conectar();
			String query = "DELETE FROM produto WHERE id = " + id + ";";
			this.statement.executeUpdate(query);
			super.desconectar();
		} catch (Exception e){
			System.out.println("Apagar ERRO:" + e.getMessage());
		}
	}
}
