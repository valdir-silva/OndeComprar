package DataBase;

import javax.swing.JOptionPane;

import interfaces.IRepositorioEmpresa;
import programa.Empresa;
import programa.Usuario;

public class RepositorioEmpresa extends BancoDeDados implements IRepositorioEmpresa{
	
	public boolean logar(String login, String senha) {
		try{
			super.conectar();
			String query = "SELECT * from empresa WHERE nome = '" + login + "' and senha='" + senha + "';";
			this.resultset = this.statement.executeQuery(query);
			if(this.resultset.next()){
				super.desconectar();
				return true;
			} else {
				super.desconectar();
				return false;
			}
		} catch (Exception e) {
			System.out.println("Logar Erro: " + e.getMessage());
		}
		return false;
	}

	@Override
	public Empresa buscarEmpresa(String login) {
		Empresa empresa = new Empresa();
		try{
			super.conectar();
			String query = "SELECT * from empresa WHERE nome = '" + login + "';";
			this.resultset = this.statement.executeQuery(query);
			while(this.resultset.next()){
				empresa.setId(Integer.parseInt(this.resultset.getString("id")));
				empresa.setNome(this.resultset.getString("nome"));
				empresa.setCnpj(this.resultset.getString("cnpj"));
				empresa.setEmail(this.resultset.getString("email"));
				empresa.setTelefone(this.resultset.getString("telefone"));
				empresa.setSenha(this.resultset.getString("senha"));
				empresa.setEndereco_id(Integer.parseInt(this.resultset.getString("endereco_id")));
			}
			super.desconectar();
			return empresa;
		} catch(Exception e){
			System.out.println("Buscar Erro: " + e.getMessage());
		}
		return empresa; 
	}

}
