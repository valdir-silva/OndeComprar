package programa;

public class Cliente extends Usuario{
	private String cpf; // ADICIONAR AO BANCO 
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
