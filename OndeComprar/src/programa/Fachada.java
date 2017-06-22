package programa;

import javax.swing.table.TableModel;

import DataBase.RepositorioEmpresa;
import DataBase.RepositorioProduto;
import DataBase.RepositorioUsuario;
import interfaces.IRepositorioEmpresa;
import interfaces.IRepositorioProduto;
import interfaces.IRepositorioUsuario;

public class Fachada {
		private static Fachada instance;
		private ControleProdutos produtos;
		private ControleUsuarios usuarios;
		private ControleEmpresas empresas;
		
		public Fachada(){
			IRepositorioProduto produto = new RepositorioProduto(); produtos = new ControleProdutos(produto);
			IRepositorioUsuario usuario = new RepositorioUsuario(); usuarios = new ControleUsuarios(usuario);
			IRepositorioEmpresa empresa = new RepositorioEmpresa(); empresas = new ControleEmpresas(empresa);
		}
		
		public static Fachada getInstance(){
			if(Fachada.instance == null){
				Fachada.instance = new Fachada();
			}
			return Fachada.instance;
		}
		
		public void listarProdutos(){
			produtos.listarProdutos();
		}
		public void listarProdutos(String order){
			produtos.listarProdutos(order);
		}
		public Produto buscarProduto(int id){
			return produtos.buscarProduto(id);
		}
		public TableModel listarProdutosTabela(String texto, String order){
			return produtos.listarProdutosTabela(texto, order);
		}
		public void inserirProduto(Produto produto){
			produtos.inserirProduto(produto);
		}
		public void atualizarProduto(Produto produto){
			produtos.atualizarProduto(produto);
		}
		public void apagarProduto(int id){
			produtos.apagarProduto(id);
		}
		public Produto produtoParaTela(int id) {
			return produtos.produtoParaTela(id);
		}
		
		// MÉTODOS DE USUARIO
		public boolean logarUsuario(String login, String senha){
			return usuarios.logarUsuario(login, senha);
		}
		public Usuario buscarUsuario(String login){
			return usuarios.buscarUsuario(login);
		}
		public Usuario buscarUsuario(int id){
			return usuarios.buscarUsuario(id);
		}
		public Endereco buscarEndereco(int id){
			return usuarios.buscarEndereco(id);
		}
		public int reservasPendentesUser(int id){
			return usuarios.reservasPendentesUser(id);
		}
		public int reservasAceitasUser(int id){
			return usuarios.reservasAceitasUser(id);
		}
		public int reservasRecusadasUser(int id){
			return usuarios.reservasRecusadasUser(id);
		}
		public void atualizarUsuario(Usuario usuario){
			usuarios.atualizarUsuario(usuario);
		}
		public void solicitarReserva(Reserva reserva){
			usuarios.solicitarReserva(reserva);
		}
		public TableModel listarReservasUser(int id){
			return usuarios.listarReservasUser(id);
		}
		
		// MÉTODOS DE EMPRESA
		public boolean logarEmpresa(String login, String senha){
			return empresas.logarEmpresa(login, senha);
		}
		public Empresa buscarEmpresa(String login){
			return empresas.buscarEmpresa(login);
		}
		public int reservasPendentesEmpresa(int id){
			return empresas.reservasPendentesEmpresa(id);
		}
		public int reservasAceitasEmpresa(int id){
			return empresas.reservasAceitasEmpresa(id);
		}
		public int reservasRecusadasEmpresa(int id){
			return empresas.reservasRecusadasEmpresa(id);
		}
		public Reserva tabelaParaTelaEmpresa(int id){
			return empresas.tabelaParaTelaEmpresa(id);
		}
		//ACEITAR RESERVA
		//RECUSAR RESERVA
		//ALTERAR SENHA
		public TableModel listarReservasEmpresa(int id){
			return empresas.listarReservasEmpresa(id);
		}
}
