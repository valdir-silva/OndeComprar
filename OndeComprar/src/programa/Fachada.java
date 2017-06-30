package programa;

import javax.swing.table.TableModel;

import DataBase.RepositorioEmpresa;
import DataBase.RepositorioProduto;
import DataBase.RepositorioCliente;
import interfaces.IRepositorioEmpresa;
import interfaces.IRepositorioProduto;
import interfaces.IRepositorioCliente;

public class Fachada {
		private static Fachada instance;
		private ControleProdutos produtos;
		private ControleUsuarios usuarios;
		private ControleEmpresas empresas;
		
		public Fachada(){
			IRepositorioProduto produto = new RepositorioProduto(); produtos = new ControleProdutos(produto);
			IRepositorioCliente usuario = new RepositorioCliente(); usuarios = new ControleUsuarios(usuario);
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
		public boolean logarUsuario(String login, String senha){ // TO FAZENDO AGR NA CLASSE ABSTRATA USUARIO, TIRO DAQUI?
			return usuarios.logarCliente(login, senha);
		}
		public Cliente buscarUsuario(String login){
			return usuarios.buscarCliente(login);
		}
		public Cliente buscarUsuario(int id){
			return usuarios.buscarCliente(id);
		}
		public Endereco buscarEndereco(int id){
			return usuarios.buscarEndereco(id);
		}
		public int reservasPendentesUser(int id){
			return usuarios.reservasPendentesCliente(id);
		}
		public int reservasAceitasUser(int id){
			return usuarios.reservasAceitasCliente(id);
		}
		public int reservasRecusadasUser(int id){
			return usuarios.reservasRecusadasCliente(id);
		}
		public void atualizarUsuario(Cliente usuario){
			usuarios.atualizarCliente(usuario);
		}
		public void solicitarReserva(Reserva reserva){
			usuarios.solicitarReserva(reserva);
		}
		public TableModel listarReservasUser(int id){
			return usuarios.listarReservasCliente(id);
		}
		public TableModel listarPromocoesUser(int id) {
			return usuarios.listarPromocoesCliente(id);
		}
		public int promocoesAtivas(String data) {
			return usuarios.promocoesAtivas(data);
		}
		public int promocoesAcabando(String data) {
			return usuarios.promocoesAcabando(data);
		}
		
		// MÉTODOS DE EMPRESA
		public boolean logarEmpresa(String login, String senha){ // TO FAZENDO AGR NA CLASSE ABSTRATA USUARIO, TIRO DAQUI?
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
		public int promocoesAtivas(int id, String data) {
			return empresas.promocoesAtivas(id, data);
		}
		public int promocoesAcabando(int id, String data) {
			return empresas.promocoesAcabando(id, data);
		}
		public void salvarPromocao(String preco, String validade, String produto_id) {
			empresas.salvarPromocao(preco, validade, produto_id);
		}
		public int reservasRecusadasEmpresa(int id){
			return empresas.reservasRecusadasEmpresa(id);
		}
		public Reserva tabelaParaTelaEmpresa(int id){ // RETORNA UMA RESERVA, MAS VOU TROCAR O NOME DESSE METODO
			return empresas.tabelaParaTelaEmpresa(id);
		}
		public void aceitarReserva(int id){
			empresas.aceitarReserva(id);
		}
		public void recusarReserva(int id){
			empresas.recusarReserva(id);
		}
		public TableModel listarReservasEmpresa(int id){
			return empresas.listarReservasEmpresa(id);
		}
		public TableModel listarPromocoesEmpresa(int id) {
			return empresas.listarPromocoesEmpresa(id);
		}
}
