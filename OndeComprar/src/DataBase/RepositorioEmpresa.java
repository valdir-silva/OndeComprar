package DataBase;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import interfaces.IRepositorioEmpresa;
import net.proteanit.sql.DbUtils;
import programa.Empresa;
import programa.Fachada;
import programa.Produto;
import programa.Reserva;
import programa.Cliente;

public class RepositorioEmpresa extends BancoDeDados implements IRepositorioEmpresa{
	
	public boolean logarEmpresa(String login, String senha) {
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
				empresa.setEndereco(Fachada.getInstance().buscarEndereco(Integer.parseInt(this.resultset.getString("endereco_id"))));
			}
			super.desconectar();
			return empresa;
		} catch(Exception e){
			System.out.println("Buscar Erro 2: " + e.getMessage());
		}
		return empresa; 
	}

	@Override
	public TableModel listarReservasEmpresa(int id) {
		TableModel t = null;
    	try{
			super.conectar();
			String query = "SELECT reserva.id, reserva.data, produto.nome, reserva.solicitacao FROM reserva JOIN cliente ON reserva.cliente_id = cliente.id JOIN produto ON reserva.produto_id = produto.id AND produto.empresa_id ='" + id + "';"; //SELECT MAIS COMPLICADO QUE EU JA FIZ
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
	
	@Override
	public TableModel listarPromocoesEmpresa(int id) {
		TableModel t = null;
    	try{
			super.conectar();
			String query = "SELECT promocao.id, promocao.valida_ate, produto.nome, produto.preco, promocao.preco_promo FROM promocao JOIN produto ON promocao.produto_id = produto.id AND produto.empresa_id ='" + id + "';";
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
	
	@Override
	public int reservasPendentesEmpresa(int id) {
		int n = 0;
    	try{
			super.conectar();
			String query = "select count(*) FROM reserva JOIN cliente ON reserva.cliente_id = cliente.id JOIN produto ON reserva.produto_id = produto.id AND reserva.solicitacao ='pendente' AND produto.empresa_id = '" + id + "';";
			this.resultset = this.statement.executeQuery(query);
			this.resultset.next();
			n = this.resultset.getInt("count(*)");
			super.desconectar();
			return n;
		} catch(Exception e){
			System.out.println("Pendentes Erro: " + e.getMessage());
		}
    	return n;
	}
	public int reservasAceitasEmpresa(int id) {
		int n = 0;
    	try{
			super.conectar();
			String query = "select count(*) FROM reserva JOIN cliente ON reserva.cliente_id = cliente.id JOIN produto ON reserva.produto_id = produto.id AND reserva.solicitacao ='aceita' AND produto.empresa_id = '" + id + "';";
			this.resultset = this.statement.executeQuery(query);
			this.resultset.next();
			n = this.resultset.getInt("count(*)");
			super.desconectar();
			return n;
		} catch(Exception e){
			System.out.println("Aceitas Erro: " + e.getMessage());
		}
    	return n;
	}
	public int reservasRecusadasEmpresa(int id) {
		int n = 0;
    	try{
			super.conectar();
			String query = "select count(*) FROM reserva JOIN cliente ON reserva.cliente_id = cliente.id JOIN produto ON reserva.produto_id = produto.id AND reserva.solicitacao ='recusada' AND produto.empresa_id = '" + id + "';";
			this.resultset = this.statement.executeQuery(query);
			this.resultset.next();
			n = this.resultset.getInt("count(*)");
			super.desconectar();
			return n;
		} catch(Exception e){
			System.out.println("Recusadas Erro: " + e.getMessage());
		}
    	return n;
	}

	@Override
	public Reserva tabelaParaTelaEmpresa(int id) {
		Reserva reserva = new Reserva();
		try{
			super.conectar();
			String query = "SELECT * from reserva WHERE id = " + id + ";";
			this.resultset = this.statement.executeQuery(query);
			while(this.resultset.next()){
				reserva.setId(Integer.parseInt(this.resultset.getString("id")));
				reserva.setData(this.resultset.getString("data"));
				reserva.setSolicitacao(this.resultset.getString("solicitacao"));
				reserva.setProduto(Fachada.getInstance().buscarProduto(Integer.parseInt(this.resultset.getString("produto_id"))));
				reserva.setCliente(Fachada.getInstance().buscarUsuario(Integer.parseInt(this.resultset.getString("cliente_id"))));
				reserva.getCliente().setEndereco(Fachada.getInstance().buscarEndereco(Integer.parseInt(this.resultset.getString("cliente_endereco_id"))));
			}
			super.desconectar();
			return reserva;
		} catch(Exception e){
			System.out.println("Buscar Erro 1: " + e.getMessage());
		}
		return reserva; 
	}
	
	@Override
	public void aceitarReserva(int id) {
			try{
				super.conectar();
				String query = "UPDATE reserva SET solicitacao = 'aceita' WHERE id = " + id + ";";
				this.statement.executeUpdate(query);
				super.desconectar();
			} catch (Exception e){
				System.out.println("Aceitar Reserva ERRO:" + e.getMessage());
			}
	}

	@Override
	public void recusarReserva(int id) {
		try{
			super.conectar();
			String query = "UPDATE reserva SET solicitacao = 'recusada' WHERE id = " + id + ";";
			this.statement.executeUpdate(query);
			super.desconectar();
		} catch (Exception e){
			System.out.println("Aceitar Reserva ERRO:" + e.getMessage());
		}
	}

	@Override
	public int promocoesAtivas(int id, String data) {
		int n = 0;
    	try{
			super.conectar();
			String query = "select count(*) FROM promocao JOIN produto ON promocao.produto_id = produto.id AND produto.empresa_id ='" + id + "' AND promocao.valida_ate !='" + data + "' ;";
			this.resultset = this.statement.executeQuery(query);
			this.resultset.next();
			n = this.resultset.getInt("count(*)");
			super.desconectar();
			return n;
		} catch(Exception e){
			System.out.println("Recusadas Erro: " + e.getMessage());
		}
    	return n;
	}

	@Override
	public int promocoesAcabando(int id, String data) {
		int n = 0;
    	try{
			super.conectar();
			String query = "select count(*) FROM promocao JOIN produto ON promocao.produto_id = produto.id AND produto.empresa_id ='" + id + "' AND promocao.valida_ate ='" + data + "';";
			this.resultset = this.statement.executeQuery(query);
			this.resultset.next();
			n = this.resultset.getInt("count(*)");
			super.desconectar();
			return n;
		} catch(Exception e){
			System.out.println("Recusadas Erro: " + e.getMessage());
		}
    	return n;
	}

	@Override
	public void salvarPromocao(String preco, String validade, String produto_id) {
		try{
			super.conectar();
			String query = "INSERT INTO promocao (preco_promo, valida_ate, produto_id) VALUES('" + preco + "', '" + validade +"', '" + produto_id + "');";
			this.statement.executeUpdate(query);
			super.desconectar();
		} catch (Exception e){
			System.out.println("Inserir Promocao ERRO: " + e.getMessage());
		}
	}
}
