package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import interfaces.IBancoDeDados;
import programa.Produto;

public abstract class BancoDeDados implements IBancoDeDados{ //n�o tenho certeza se pode dar algum problema por estar abstrata
	protected Connection conection = null;
	protected Statement statement = null;
	protected ResultSet resultset = null;
	
	
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
	public boolean estaConectado(){ //acho isso redund�ncia demais j� que j� se usa o try/catch no m�todo conectar()
		if(this.conection != null){
			return true;
		} else {
			return false;
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
