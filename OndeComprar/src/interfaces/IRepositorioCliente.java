package interfaces;

import javax.swing.table.TableModel;

import programa.Reserva;
import programa.Usuario;

public interface IRepositorioCliente {
	//NOVO CLIENTE
	public boolean logar(String login, String senha);
	public Usuario buscarCliente(String login);
	public Usuario buscarCliente(int id);
	public int reservasPendentes(int id); // RETORNA A QUANTIDADE DE RESERVAS PENDENTES DAQUELE USUARIO 
	//APAGAR CLIENTE
	//ALTERAR CLIENTE
	//ALTERAR SENHA //CONSIDERAR FAZER UMA "SUPER INTERFACE" CHAMADA CONTA COM OVERLOADING PARA CLIENTE E EMPRESA
	public void solicitarReserva(Reserva reserva);
	public TableModel listarReservas(int id);
}
