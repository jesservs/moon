package entity;

public class Noticia {

	private Integer idNoticia;
	private String titulo;
	private String descricao;
	private String foto;
	
	public Noticia() {

	}

	public Noticia(Integer idNoticia, String titulo, String descricao,
			String foto) {
		super();
		this.idNoticia = idNoticia;
		this.titulo = titulo;
		this.descricao = descricao;
		this.foto = foto;
	}

	public Integer getIdNoticia() {
		return idNoticia;
	}

	public void setIdNoticia(Integer idNoticia) {
		this.idNoticia = idNoticia;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Noticia [idNoticia=" + idNoticia + ", titulo=" + titulo
				+ ", descricao=" + descricao + ", foto=" + foto + "]";
	}
	
	
}
