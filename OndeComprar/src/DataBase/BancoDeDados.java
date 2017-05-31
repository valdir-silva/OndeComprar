package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import interfaces.IBancoDeDados;
import programa.Produto;

public class BancoDeDados implements IBancoDeDados{
	private Connection conection = null;
	private Statement statement = null;
	private ResultSet resultset = null;
	
	public void conectar(){
		String servidor = "jdbc:mysql://localhost:3306/ondecomprar";
		String usuario = "root";
		String senha = "";
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
			this.conection = DriverManager.getConnection(servidor, usuario, senha);
			this.statement = this.conection.createStatement();
		} catch (Exception e){
			System.out.println("Conectar Erro: " + e.getMessage());
		}
	}
	public boolean estaConectado(){
		if(this.conection != null){
			return true;
		} else {
			return false;
		}
	}
	public void listarProdutos(){
		try{
			String query = "SELECT * FROM produto ORDER BY nome";
			this.resultset = this.statement.executeQuery(query);
			while(this.resultset.next()){
				System.out.println("ID: " + this.resultset.getString("id") + " - Nome: " + this.resultset.getString("nome") + " - Marca: " + this.resultset.getString("marca") + " - Preço: " + this.resultset.getFloat("preco"));
			}
		} catch(Exception e){
			System.out.println("Listar Erro: " + e.getMessage());
		}
	}
	public Produto buscarProduto(int id){
		Produto produto = new Produto();
		//baser codigo no método listarProdutos()
		return produto;
	}
	public void inserirProduto(Produto produto){ //Passar a receber o objeto Produto e não essas variáveis
		try{
			String query = "INSERT INTO produto (nome, marca, preco) VALUES('" + produto.getNome() + "', '" + produto.getMarca() +"', '" + produto.getPreco() + "');";
			this.statement.executeUpdate(query);
		} catch (Exception e){
			System.out.println("Inserir ERRO: " + e.getMessage());
		}
	}
	public void atualizarProduto(Produto produto){
		try{
			String query = "UPDATE produto SET nome = '" + produto.getNome() + "', marca = '" + produto.getMarca() + "', preco = '" + produto.getPreco() + "' WHERE id = " + produto.getId() + ";";
			this.statement.executeUpdate(query);
		} catch (Exception e){
			System.out.println("Editar ERRO: " + e.getMessage());
		}
	}
	public void apagarProduto(int id){
		try{
			String query = "DELETE FROM produto WHERE id = " + id + ";";
			this.statement.executeUpdate(query);
		} catch (Exception e){
			System.out.println("Apagar ERRO:" + e.getMessage());
		}
	}
	
	public void desconectar(){
		try{
			this.conection.close();
		} catch (Exception e){
			System.out.println("Desconectar Erro: " + e.getMessage());
		}
	}
}
