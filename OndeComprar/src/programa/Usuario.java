package programa;

public class Usuario extends Endereco {
	private int id;
	private String nome;
	private String email;
	private String telefone;
	private String senha;
	private int endereco_id;
	
	public int getEndereco_id() {
		return endereco_id;
	}
	public void setEndereco_id(int endereco_id) {
		this.endereco_id = endereco_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
