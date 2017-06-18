package programa;

public class Reserva {
	private int id;
	private String data;
	private int produto_id;
	private int cliente_id;
	private int cliente_endereco_int;
	
	public Reserva(){
		cliente_endereco_int = 1;
	}
	
	public int getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}
	public int getCliente_endereco_int() {
		return cliente_endereco_int;
	}
	public void setCliente_endereco_int(int cliente_endereco_int) {
		this.cliente_endereco_int = cliente_endereco_int;
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
	public int getProduto_id() {
		return produto_id;
	}
	public void setProduto_id(int produto_id) {
		this.produto_id = produto_id;
	}
}
