package interfaces;

import programa.Empresa;
import programa.Usuario;

public interface IRepositorioEmpresa {
	//NOVA EMPRESA
	//APAGAR EMPRESA
	//ATUALIZAR EMPRESA
	public boolean logar(String login, String senha);
	public Empresa buscarEmpresa(String login);
	//ACEITAR RESERVA
	//RECUSAR RESERVA
	//ALTERAR SENHA
}
