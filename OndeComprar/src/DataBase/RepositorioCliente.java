package DataBase;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import interfaces.IRepositorioCliente;
import net.proteanit.sql.DbUtils;
import programa.Produto;
import programa.Reserva;
import programa.Usuario;

public class RepositorioCliente extends BancoDeDados implements IRepositorioCliente {

	public void solicitarReserva(Reserva reserva) {
		try {
			super.conectar();
			String query = "INSERT INTO reserva (data, produto_id, cliente_id, cliente_endereco_id) VALUES('" + reserva.getData() + "', '" + reserva.getProduto_id() + "', '" + reserva.getCliente_id() + "', '" + reserva.getCliente_endereco_int() + "');";
			this.statement.executeUpdate(query);
			super.desconectar();
		} catch(Exception e) {
			System.out.println("Erro Solicitar Reserva: " + e.getMessage());
		}
	}

	public TableModel listarReservas(int id) {
		TableModel t = null;
    	try{
			super.conectar();
			String query = "SELECT reserva.id, reserva.data, produto.nome, reserva.solicitacao FROM reserva JOIN cliente ON reserva.cliente_id = cliente.id JOIN produto ON reserva.produto_id = produto.id AND cliente.id ='" + id + "';"; //SELECT MAIS COMPLICADO QUE EU JA FIZ
			this.resultset = this.statement.executeQuery(query);
			TableModel table = DbUtils.resultSetToTableModel(resultset);
			while(this.resultset.next()){
				System.out.println("ID: " + this.resultset.getString("id") + " - Nome: " + this.resultset.getString("nome") + " - Marca: " + this.resultset.getString("marca") + " - Preço: " + this.resultset.getFloat("preco"));
			}
			super.desconectar();
			return table;
		} catch(Exception e){
			System.out.println("Listar Erro: " + e.getMessage());
		}
    	return t;
	}
	public boolean logar(String login, String senha) {
		try{
			super.conectar();
			String query = "SELECT * from cliente WHERE nome = '" + login + "' and senha='" + senha + "';";
			this.resultset = this.statement.executeQuery(query);
			if(this.resultset.next()){
				super.desconectar();
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "Login ou Senha inválidos");
				super.desconectar();
				return false;
			}
		} catch (Exception e) {
			System.out.println("Logar Erro: " + e.getMessage());
		}
		return false;
	}
	public Usuario buscarCliente(int id) {
		Usuario usuario = new Usuario();
		try{
			super.conectar();
			String query = "SELECT * from cliente WHERE id = '" + id + "';";
			this.resultset = this.statement.executeQuery(query);
			while(this.resultset.next()){
				usuario.setId(Integer.parseInt(this.resultset.getString("id")));
				usuario.setNome(this.resultset.getString("nome"));
				usuario.setEmail(this.resultset.getString("email"));
				usuario.setTelefone(this.resultset.getString("telefone"));
				usuario.setSenha(this.resultset.getString("senha"));
				usuario.setEndereco_id(this.resultset.getInt("endereco_id"));
			}
			super.desconectar();
			return usuario;
		} catch(Exception e){
			System.out.println("Buscar Erro: " + e.getMessage());
		}
		return usuario; 
	}

	public Usuario buscarCliente(String login) {
		Usuario usuario = new Usuario();
		try{
			super.conectar();
			String query = "SELECT * from cliente WHERE nome = '" + login + "';";
			this.resultset = this.statement.executeQuery(query);
			while(this.resultset.next()){
				usuario.setId(Integer.parseInt(this.resultset.getString("id")));
				usuario.setNome(this.resultset.getString("nome"));
				usuario.setEmail(this.resultset.getString("email"));
				usuario.setTelefone(this.resultset.getString("telefone"));
				usuario.setSenha(this.resultset.getString("senha"));
				usuario.setEndereco_id(this.resultset.getInt("endereco_id"));
			}
			super.desconectar();
			return usuario;
		} catch(Exception e){
			System.out.println("Buscar Erro: " + e.getMessage());
		}
		return usuario; 
	}

	@Override
	public int reservasPendentes(int id) {
		int n = 0;
    	try{
			super.conectar();
			String query = "select count(*) FROM reserva JOIN cliente ON reserva.cliente_id = cliente.id JOIN produto ON reserva.produto_id = produto.id AND reserva.solicitacao ='pendente' AND reserva.cliente_id = '" + id + "';"; // OUTRO SELECT FODA
			this.resultset = this.statement.executeQuery(query);
			this.resultset.next();
			n = this.resultset.getInt("count(*)");
			while(this.resultset.next()){
				System.out.println("ID: " + this.resultset.getString("id") + " - Nome: " + this.resultset.getString("nome") + " - Marca: " + this.resultset.getString("marca") + " - Preço: " + this.resultset.getFloat("preco"));
			}
			super.desconectar();
			return n;
		} catch(Exception e){
			System.out.println("Pendentes Erro: " + e.getMessage());
		}
    	return n;
	}
}
