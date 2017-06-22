package interfaces;

import javax.swing.table.TableModel;

import programa.Empresa;
import programa.Reserva;
import programa.Usuario;

public interface IRepositorioEmpresa {
	//NOVA EMPRESA
	//APAGAR EMPRESA
	//ATUALIZAR EMPRESA
	public boolean logarEmpresa(String login, String senha);
	public Empresa buscarEmpresa(String login);
	public int reservasPendentesEmpresa(int id); // RETORNA A QUANTIDADE DE RESERVAS PENDENTES DAQUELA EMPRESA 
	public int reservasAceitasEmpresa(int id);
	public int reservasRecusadasEmpresa(int id);
	public Reserva tabelaParaTelaEmpresa(int id);
	//ACEITAR RESERVA
	//RECUSAR RESERVA
	//ALTERAR SENHA
	public TableModel listarReservasEmpresa(int id);
}
