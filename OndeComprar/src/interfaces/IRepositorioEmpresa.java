package interfaces;

import javax.swing.table.TableModel;

import programa.Empresa;
import programa.Reserva;
import programa.Cliente;

public interface IRepositorioEmpresa {
	//NOVA EMPRESA
	//APAGAR EMPRESA
	//ATUALIZAR EMPRESA
	//ALTERAR SENHA
	public boolean logarEmpresa(String login, String senha);
	public Empresa buscarEmpresa(String login);
	public int reservasPendentesEmpresa(int id); // RETORNA A QUANTIDADE DE RESERVAS PENDENTES DAQUELA EMPRESA 
	public int reservasAceitasEmpresa(int id);
	public int reservasRecusadasEmpresa(int id);
	public int promocoesAtivas(int id, String data);
	public int promocoesAcabando(int id, String data);
	public void salvarPromocao(String preco, String validade, String produto_id);
	public Reserva tabelaParaTelaEmpresa(int id);
	public void aceitarReserva(int id);
	public void recusarReserva(int id);
	public TableModel listarPromocoesEmpresa(int id);
	public TableModel listarReservasEmpresa(int id);
}
