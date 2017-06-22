package programa;

import javax.swing.table.TableModel;

import interfaces.IRepositorioEmpresa;

public class ControleEmpresas implements IRepositorioEmpresa{
	IRepositorioEmpresa repositorioEmpresa;
	Empresa empresa;
	
	public ControleEmpresas (IRepositorioEmpresa repositorioEmpresa) {
		this.repositorioEmpresa = repositorioEmpresa;
	}

	@Override
	public boolean logarEmpresa(String login, String senha) {
		return repositorioEmpresa.logarEmpresa(login, senha);
	}

	@Override
	public Empresa buscarEmpresa(String login) {
		return repositorioEmpresa.buscarEmpresa(login);
	}

	@Override
	public int reservasPendentesEmpresa(int id) {
		return repositorioEmpresa.reservasPendentesEmpresa(id);
	}

	@Override
	public int reservasAceitasEmpresa(int id) {
		return repositorioEmpresa.reservasAceitasEmpresa(id);
	}

	@Override
	public int reservasRecusadasEmpresa(int id) {
		return repositorioEmpresa.reservasRecusadasEmpresa(id);
	}

	@Override
	public Reserva tabelaParaTelaEmpresa(int id) {
		return repositorioEmpresa.tabelaParaTelaEmpresa(id);
	}

	@Override
	public TableModel listarReservasEmpresa(int id) {
		return repositorioEmpresa.listarReservasEmpresa(id);
	}

}
