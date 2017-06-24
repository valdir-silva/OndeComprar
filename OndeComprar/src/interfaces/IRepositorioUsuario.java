package interfaces;

import javax.swing.table.TableModel;

import programa.Endereco;
import programa.Reserva;
import programa.Usuario;

public interface IRepositorioUsuario {
	//NOVO CLIENTE
	public boolean logarUsuario(String login, String senha);
	public Usuario buscarUsuario(String login);
	public Usuario buscarUsuario(int id);
	public Endereco buscarEndereco(int id);
	public int reservasPendentesUser(int id); // RETORNA A QUANTIDADE DE RESERVAS PENDENTES DAQUELE USUARIO 
	public int reservasAceitasUser(int id);
	public int reservasRecusadasUser(int id);
	public int promocoesAtivas(String data);
	public int promocoesAcabando(String data);
	//APAGAR CLIENTE
	public void atualizarUsuario(Usuario usuario);
	//ALTERAR SENHA //CONSIDERAR FAZER UMA "SUPER INTERFACE" CHAMADA CONTA COM OVERLOADING PARA CLIENTE E EMPRESA
	public void solicitarReserva(Reserva reserva);
	public TableModel listarReservasUser(int id);
	public TableModel listarPromocoesUser(int id);
}
