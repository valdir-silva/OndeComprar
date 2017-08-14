package programa;

import javax.swing.table.TableModel;

import Exceptions.LoginInvalidoException;
import interfaces.IRepositorioCliente;

public class ControleUsuarios implements IRepositorioCliente{
	IRepositorioCliente repositorioUsuario;
	Empresa empresa;
	
	public ControleUsuarios (IRepositorioCliente repositorioUsuario) {
		this.repositorioUsuario = repositorioUsuario;
	}

	@Override
	public boolean logarCliente(String login, String senha) {
		return repositorioUsuario.logarCliente(login, senha);
	}

	@Override
	public Cliente buscarCliente(String login) {
		return repositorioUsuario.buscarCliente(login);
	}

	@Override
	public Cliente buscarCliente(int id) {
		return repositorioUsuario.buscarCliente(id);
	}

	@Override
	public Endereco buscarEndereco(int id) {
		return repositorioUsuario.buscarEndereco(id);
	}

	@Override
	public int reservasPendentesCliente(int id) {
		return repositorioUsuario.reservasPendentesCliente(id);
	}

	@Override
	public int reservasAceitasCliente(int id) {
		return repositorioUsuario.reservasAceitasCliente(id);
	}

	@Override
	public int reservasRecusadasCliente(int id) {
		return repositorioUsuario.reservasRecusadasCliente(id);
	}

	@Override
	public void atualizarCliente(Cliente usuario) {
		repositorioUsuario.atualizarCliente(usuario);
	}

	@Override
	public void solicitarReserva(Reserva reserva) {
		repositorioUsuario.solicitarReserva(reserva);
	}

	@Override
	public TableModel listarReservasCliente(int id) {
		return repositorioUsuario.listarReservasCliente(id);
	}

	@Override
	public TableModel listarPromocoesCliente(int id) {
		return repositorioUsuario.listarPromocoesCliente(id);
	}

	@Override
	public int promocoesAtivas(String data) {
		return repositorioUsuario.promocoesAtivas(data);
	}

	@Override
	public int promocoesAcabando(String data) {
		return repositorioUsuario.promocoesAcabando(data);
	}
}
