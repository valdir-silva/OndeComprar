package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BancoDeDados {
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
			System.out.println("Erro: " + e.getMessage());
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
			this.statement = this.conection.createStatement();
			while(this.resultset.next()){
				System.out.println("ID: " + this.resultset.getString("id") + " - Nome: " + this.resultset.getString("nome") + " - Marca: " + this.resultset.getString("marca") + " - Preço: " + this.resultset.getFloat("preco"));
			}
		} catch(Exception e){
			System.out.println("L Erro: " + e.getMessage());
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
