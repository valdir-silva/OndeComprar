package DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.TableModel;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import interfaces.IRepositorioProduto;
import net.proteanit.sql.DbUtils;
import programa.Fachada;
import programa.Produto;

public class RepositorioProduto extends BancoDeDados implements IRepositorioProduto{

	public void listarProdutos(){// POR PADRÃO ORDENA POR ID
		try{
			super.conectar();
			String query = "SELECT * FROM produto ORDER BY id";
			this.resultset = this.statement.executeQuery(query);
			while(this.resultset.next()){
				System.out.println("ID: " + this.resultset.getString("id") + " - Nome: " + this.resultset.getString("nome") + " - Marca: " + this.resultset.getString("marca") + " - Preço: " + this.resultset.getFloat("preco"));
			}
		} catch(Exception e){
			System.out.println("Listar Erro: " + e.getMessage());
		} finally {
			super.desconectar();
		}
	}
	public void listarProdutos(String order){ // overloading para ordenar por outros atributos
		if(order.equals("nome")){
			try{
				super.conectar();
				String query = "SELECT * FROM produto ORDER BY nome";
				this.resultset = this.statement.executeQuery(query);
				while(this.resultset.next()){
					System.out.println("ID: " + this.resultset.getString("id") + " - Nome: " + this.resultset.getString("nome") + " - Marca: " + this.resultset.getString("marca") + " - Preço: " + this.resultset.getFloat("preco"));
				}
			} catch(Exception e){
				System.out.println("Listar Erro: " + e.getMessage());
			} finally {
				super.desconectar();
			}
		} else if (order.equals("marca")){
			try{
				super.conectar();
				String query = "SELECT * FROM produto ORDER BY marca";
				this.resultset = this.statement.executeQuery(query);
				while(this.resultset.next()){
					System.out.println("ID: " + this.resultset.getString("id") + " - Nome: " + this.resultset.getString("nome") + " - Marca: " + this.resultset.getString("marca") + " - Preço: " + this.resultset.getFloat("preco"));
				}
			} catch(Exception e){
				System.out.println("Listar Erro: " + e.getMessage());
			} finally {
				super.desconectar();
			}
		} else if (order.equals("preco")){
			try{
				super.conectar();
				String query = "SELECT * FROM produto ORDER BY preco";
				this.resultset = this.statement.executeQuery(query);
				while(this.resultset.next()){
					System.out.println("ID: " + this.resultset.getString("id") + " - Nome: " + this.resultset.getString("nome") + " - Marca: " + this.resultset.getString("marca") + " - Preço: " + this.resultset.getFloat("preco"));
				}
			} catch(Exception e){
				System.out.println("Listar Erro: " + e.getMessage());
			} finally {
				super.desconectar();
			}
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
				produto.setCategoria(this.resultset.getString("categoria"));
				produto.setPreco(Float.parseFloat(this.resultset.getString("preco")));
			}
			return produto;
		} catch(Exception e){
			System.out.println("Buscar Erro: " + e.getMessage());
		} finally {
			super.desconectar();
		}
		return produto; //perguntar ao professor como fica quando dá erro e retorna este objeto vazio (nao perguntei mas deve usar uma exceção pra isso)
	}
	public void inserirProduto(Produto produto){
		try{
			super.conectar();
			String query = "INSERT INTO produto (nome, marca, categoria, preco) VALUES('" + produto.getNome() + "', '" + produto.getMarca() +"', '" + produto.getCategoria() + "', '" + produto.getPreco() + "');";
			this.statement.executeUpdate(query);
		} catch (Exception e){
			System.out.println("Inserir ERRO: " + e.getMessage());
		} finally {
			super.desconectar();
		}
	}
	public void atualizarProduto(Produto produto){
		try{
			super.conectar();
			String query = "UPDATE produto SET nome = '" + produto.getNome() + "', marca = '" + produto.getMarca() + "', preco = '" + produto.getPreco() + "' WHERE id = " + produto.getId() + ";";
			this.statement.executeUpdate(query);
		} catch (Exception e){
			System.out.println("Editar ERRO: " + e.getMessage()); 
		} finally {
			super.desconectar();
		}
	}
	public void apagarProduto(int id){
		try{
			super.conectar();
			String query = "DELETE FROM produto WHERE id = " + id + ";";
			this.statement.executeUpdate(query);
		} catch (Exception e){
			System.out.println("Apagar ERRO:" + e.getMessage());
		} finally {
			super.desconectar();
		}
	}
    
    public TableModel listarProdutosTabela(String texto, String order){
    	TableModel t = null;
    	try{
			super.conectar();
			String query = "SELECT * FROM produto WHERE nome LIKE '%" + texto + "%' ORDER BY " + order + ";";
			this.resultset = this.statement.executeQuery(query);
			TableModel table = DbUtils.resultSetToTableModel(resultset);
			while(this.resultset.next()){
				System.out.println("ID: " + this.resultset.getString("id") + " - Nome: " + this.resultset.getString("nome") + " - Marca: " + this.resultset.getString("marca") + " - Preço: " + this.resultset.getFloat("preco"));
			}
			return table;
		} catch(Exception e){
			System.out.println("Listar Erro: " + e.getMessage());
		} finally {
			super.desconectar();
		}
    	return t;
    }
	public Produto produtoParaTela(int id){ // QUAL A DIFERENÇA DISSO PARA O PROCURAR NORMAL?
		Produto produto = new Produto();
		try{
			super.conectar();
			String query = "SELECT * from produto WHERE id = " + id + ";";
			this.resultset = this.statement.executeQuery(query);
			while(this.resultset.next()){
				produto.setId(Integer.parseInt(this.resultset.getString("id")));
				produto.setMarca(this.resultset.getString("marca"));
				produto.setNome(this.resultset.getString("nome"));
				produto.setCategoria(this.resultset.getString("categoria"));
				produto.setPreco(Float.parseFloat(this.resultset.getString("preco")));
				produto.setEmpresa(Fachada.getInstance().buscarEmpresa(this.resultset.getString("empresa_id")));
			}
			return produto;
		} catch(Exception e){
			System.out.println("Buscar Erro: " + e.getMessage());
		} finally {
			super.desconectar();
		}
		return produto; 
	}
}
