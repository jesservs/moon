package entity;

public class Usuario extends Pessoa {
	
	private Integer codUsuario;
	private String matricula;
	private String senha;
	private String perfil;
	private Endereco endereco;
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(String cpf, String nome, String email, String telefone,
			Endereco endereco, Integer codUsuario, String matricula,
			String senha, String perfil) {
		super(cpf, nome, email, telefone, endereco);
		this.codUsuario = codUsuario;
		this.matricula = matricula;
		this.senha = senha;
		this.perfil = perfil;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public Integer getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(Integer codUsuario) {
		this.codUsuario = codUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [codUsuario=" + codUsuario + ", matricula=" + matricula
				+ ", senha=" + senha + ", perfil=" + perfil + "]";
	}




	
}
