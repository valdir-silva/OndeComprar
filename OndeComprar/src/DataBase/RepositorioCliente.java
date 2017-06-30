package DataBase;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import interfaces.IRepositorioCliente;
import net.proteanit.sql.DbUtils;
import programa.Endereco;
import programa.Fachada;
import programa.Produto;
import programa.Reserva;
import programa.Cliente;

public class RepositorioCliente extends BancoDeDados implements IRepositorioCliente {

	public void solicitarReserva(Reserva reserva) {
		try {
			super.conectar();
			String query = "INSERT INTO reserva (data, produto_id, cliente_id, cliente_endereco_id) VALUES('" + reserva.getData() + "', '" + reserva.getProduto().getId() + "', '" + reserva.getCliente().getId() + "', '" + reserva.getCliente().getEndereco().getId() + "');";
			this.statement.executeUpdate(query);
			super.desconectar();
		} catch(Exception e) {
			System.out.println("Erro Solicitar Reserva: " + e.getMessage());
		}
	}

	public TableModel listarReservasCliente(int id) {
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
	public TableModel listarPromocoesCliente(int id) {
		TableModel t = null;
    	try{
			super.conectar();
			String query = "SELECT promocao.id, promocao.valida_ate, produto.nome, produto.preco, promocao.preco_promo FROM promocao JOIN produto ON promocao.produto_id = produto.id;";
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
	public boolean logarCliente(String login, String senha) {
		try{
			super.conectar();
			String query = "SELECT * from cliente WHERE nome = '" + login + "' and senha='" + senha + "';";
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
	public Cliente buscarCliente(int id) {
		Cliente usuario = new Cliente();
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
				usuario.setEndereco(Fachada.getInstance().buscarEndereco(this.resultset.getInt("endereco_id")));
			}
			super.desconectar();
			return usuario;
		} catch(Exception e){
			System.out.println("Buscar Erro 4: " + e.getMessage());
		}
		return usuario; 
	}

	public Cliente buscarCliente(String login) {
		Cliente usuario = new Cliente();
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
				usuario.setEndereco(Fachada.getInstance().buscarEndereco(this.resultset.getInt("endereco_id")));
			}
			super.desconectar();
			return usuario;
		} catch(Exception e){
			System.out.println("Buscar Erro 3: " + e.getMessage());
		}
		return usuario; 
	}

	@Override
	public int reservasPendentesCliente(int id) {
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
	public int reservasAceitasCliente(int id) {
		int n = 0;
    	try{
			super.conectar();
			String query = "select count(*) FROM reserva JOIN cliente ON reserva.cliente_id = cliente.id JOIN produto ON reserva.produto_id = produto.id AND reserva.solicitacao ='aceita' AND reserva.cliente_id = '" + id + "';"; // OUTRO SELECT FODA
			this.resultset = this.statement.executeQuery(query);
			this.resultset.next();
			n = this.resultset.getInt("count(*)");
			while(this.resultset.next()){
				System.out.println("ID: " + this.resultset.getString("id") + " - Nome: " + this.resultset.getString("nome") + " - Marca: " + this.resultset.getString("marca") + " - Preço: " + this.resultset.getFloat("preco"));
			}
			super.desconectar();
			return n;
		} catch(Exception e){
			System.out.println("Aceitas Erro: " + e.getMessage());
		}
    	return n;
	}
	public int reservasRecusadasCliente(int id) {
		int n = 0;
    	try{
			super.conectar();
			String query = "select count(*) FROM reserva JOIN cliente ON reserva.cliente_id = cliente.id JOIN produto ON reserva.produto_id = produto.id AND reserva.solicitacao ='recusada' AND reserva.cliente_id = '" + id + "';"; // OUTRO SELECT FODA
			this.resultset = this.statement.executeQuery(query);
			this.resultset.next();
			n = this.resultset.getInt("count(*)");
			while(this.resultset.next()){
				System.out.println("ID: " + this.resultset.getString("id") + " - Nome: " + this.resultset.getString("nome") + " - Marca: " + this.resultset.getString("marca") + " - Preço: " + this.resultset.getFloat("preco"));
			}
			super.desconectar();
			return n;
		} catch(Exception e){
			System.out.println("Recusadas Erro: " + e.getMessage());
		}
    	return n;
	}
	public void atualizarCliente(Cliente usuario){
			try{
				super.conectar();
				String query = "UPDATE cliente SET nome = '" + usuario.getNome() + "', email = '" + usuario.getEmail() + "', telefone = '" + usuario.getTelefone() + "' WHERE id = '" + usuario.getId() + "';";
				this.statement.executeUpdate(query);
				super.desconectar();
				JOptionPane.showMessageDialog(null, "Atualizado!");
			} catch (Exception e){
				System.out.println("Editar Usuario ERRO: " + e.getMessage()); 
			}
			Endereco endereco = usuario.getEndereco();
			this.atualizarEndereco(endereco);
	}
	private void atualizarEndereco(Endereco endereco){
		try{
			super.conectar();
			String query = "UPDATE endereco SET cidade = '" + endereco.getCidade() + "', estado = '" + endereco.getEstado() + "', rua = '" + endereco.getRua() +"', cep ='"+ endereco.getCep() + "' WHERE id ='" + endereco.getId() + "';";
			this.statement.executeUpdate(query);
			super.desconectar();
		} catch (Exception e){
			System.out.println("Editar Endereco ERRO: " + e.getMessage()); 
		}
	}
	public Endereco buscarEndereco(int id){
		Endereco endereco = new Endereco();
		try{
			super.conectar();
			String query = "SELECT * from endereco WHERE id = '" + id + "';";
			this.resultset = this.statement.executeQuery(query);
			while(this.resultset.next()){
				endereco.setId(Integer.parseInt(this.resultset.getString("id")));
				endereco.setCidade(this.resultset.getString("cidade"));
				endereco.setEstado(this.resultset.getString("estado"));
				endereco.setRua(this.resultset.getString("rua"));
				endereco.setCep(this.resultset.getString("cep"));
			}
			//super.desconectar(); COMO RESOLVER ISSO? QUANDO UM METODO INTERNO CHAMA, SE DEIXAR O DESCONECTAR DÁ ERRO NO RESULTSET
			return endereco;
		} catch(Exception e){
			System.out.println("Buscar endereco Erro: " + e.getMessage());
		}
		return endereco;
	}

	@Override
	public int promocoesAtivas(String data) {
		int n = 0;
    	try{
			super.conectar();
			String query = "SELECT count(*) FROM promocao JOIN produto ON promocao.produto_id = produto.id AND promocao.valida_ate !='"+ data + "';";
			this.resultset = this.statement.executeQuery(query);
			this.resultset.next();
			n = this.resultset.getInt("count(*)");
			while(this.resultset.next()){
				System.out.println("ID: " + this.resultset.getString("id") + " - Nome: " + this.resultset.getString("nome") + " - Marca: " + this.resultset.getString("marca") + " - Preço: " + this.resultset.getFloat("preco"));
			}
			super.desconectar();
			return n;
		} catch(Exception e){
			System.out.println("Recusadas Erro: " + e.getMessage());
		}
    	return n;
	}

	@Override
	public int promocoesAcabando(String data) {
		int n = 0;
    	try{
			super.conectar();
			String query = "SELECT count(*) FROM promocao JOIN produto ON promocao.produto_id = produto.id AND promocao.valida_ate ='"+ data + "';";
			this.resultset = this.statement.executeQuery(query);
			this.resultset.next();
			n = this.resultset.getInt("count(*)");
			while(this.resultset.next()){
				System.out.println("ID: " + this.resultset.getString("id") + " - Nome: " + this.resultset.getString("nome") + " - Marca: " + this.resultset.getString("marca") + " - Preço: " + this.resultset.getFloat("preco"));
			}
			super.desconectar();
			return n;
		} catch(Exception e){
			System.out.println("Recusadas Erro: " + e.getMessage());
		}
    	return n;
	}
}
