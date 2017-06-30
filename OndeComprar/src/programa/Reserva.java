package programa;

public class Reserva {
	private int id;
	private String data;
	private String solicitacao;
	private Produto produto;
	private Cliente usuario;
	
	public Reserva(){ // PERGUNTAR SE ISTO É NECESSÁRIO
		produto = new Produto();
		usuario = new Cliente();
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Cliente getCliente() {
		return usuario;
	}

	public void setCliente(Cliente cliente) {
		this.usuario = cliente;
	}
	
	public String getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(String solicitacao) {
		this.solicitacao = solicitacao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

}
