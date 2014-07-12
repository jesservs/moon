package entity;

public class Agenda {

	private Integer idAgenda;
	private String titulo;
	private String detalhe;
	private String data;
	
	public Agenda() {
		// TODO Auto-generated constructor stub
	}

	public Agenda(Integer idAgenda, String titulo, String detalhe, String data) {
		super();
		this.idAgenda = idAgenda;
		this.titulo = titulo;
		this.detalhe = detalhe;
		this.data = data;
	}

	public Integer getIdAgenda() {
		return idAgenda;
	}

	public void setIdAgenda(Integer idAgenda) {
		this.idAgenda = idAgenda;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDetalhe() {
		return detalhe;
	}

	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	
}
