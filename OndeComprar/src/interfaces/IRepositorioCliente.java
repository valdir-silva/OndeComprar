package interfaces;

import javax.swing.table.TableModel;

import programa.Reserva;
import programa.Usuario;

public interface IRepositorioCliente {
	//NOVO CLIENTE
	public boolean logar(String login, String senha);
	public Usuario buscarCliente(String login); //nao � legal buscar por login j� que n�o � a primary key
	//APAGAR CLIENTE
	//ALTERAR CLIENTE
	//ALTERAR SENHA //CONSIDERAR FAZER UMA "SUPER INTERFACE" CHAMADA CONTA COM OVERLOADING PARA CLIENTE E EMPRESA
	public void solicitarReserva(Reserva reserva);
	public TableModel listarReservas(int id);
}
