package programa;

import javax.swing.table.TableModel;

import interfaces.IRepositorioUsuario;

public class ControleUsuarios implements IRepositorioUsuario{
	IRepositorioUsuario repositorioUsuario;
	Empresa empresa;
	
	public ControleUsuarios (IRepositorioUsuario repositorioUsuario) {
		this.repositorioUsuario = repositorioUsuario;
	}

	@Override
	public boolean logarUsuario(String login, String senha) {
		return repositorioUsuario.logarUsuario(login, senha);
	}

	@Override
	public Usuario buscarUsuario(String login) {
		return repositorioUsuario.buscarUsuario(login);
	}

	@Override
	public Usuario buscarUsuario(int id) {
		return repositorioUsuario.buscarUsuario(id);
	}

	@Override
	public Endereco buscarEndereco(int id) {
		return repositorioUsuario.buscarEndereco(id);
	}

	@Override
	public int reservasPendentesUser(int id) {
		return repositorioUsuario.reservasPendentesUser(id);
	}

	@Override
	public int reservasAceitasUser(int id) {
		return repositorioUsuario.reservasAceitasUser(id);
	}

	@Override
	public int reservasRecusadasUser(int id) {
		return repositorioUsuario.reservasRecusadasUser(id);
	}

	@Override
	public void atualizarUsuario(Usuario usuario) {
		repositorioUsuario.atualizarUsuario(usuario);
	}

	@Override
	public void solicitarReserva(Reserva reserva) {
		repositorioUsuario.solicitarReserva(reserva);
	}

	@Override
	public TableModel listarReservasUser(int id) {
		return repositorioUsuario.listarReservasUser(id);
	}
	
}
