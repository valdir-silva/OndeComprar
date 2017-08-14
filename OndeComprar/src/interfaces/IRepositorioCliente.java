package interfaces;

import javax.swing.table.TableModel;

import Exceptions.LoginInvalidoException;
import programa.Endereco;
import programa.Reserva;
import programa.Cliente;

public interface IRepositorioCliente {
	//NOVO CLIENTE
	public boolean logarCliente(String login, String senha);
	public Cliente buscarCliente(String login);
	public Cliente buscarCliente(int id);
	public Endereco buscarEndereco(int id);
	public int reservasPendentesCliente(int id); // RETORNA A QUANTIDADE DE RESERVAS PENDENTES DAQUELE USUARIO 
	public int reservasAceitasCliente(int id);
	public int reservasRecusadasCliente(int id);
	public int promocoesAtivas(String data);
	public int promocoesAcabando(String data);
	//APAGAR CLIENTE
	public void atualizarCliente(Cliente usuario);
	//ALTERAR SENHA //CONSIDERAR FAZER UMA "SUPER INTERFACE" CHAMADA CONTA COM OVERLOADING PARA CLIENTE E EMPRESA
	public void solicitarReserva(Reserva reserva);
	public TableModel listarReservasCliente(int id);
	public TableModel listarPromocoesCliente(int id);
}
