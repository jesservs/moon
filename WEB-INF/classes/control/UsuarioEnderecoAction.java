package control;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import persistence.EnderecoDao;
import persistence.UsuarioDao;
import persistence.UsuarioEnderecoDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entity.Endereco;
import entity.Usuario;

public class UsuarioEnderecoAction extends ActionSupport{

	private Endereco endereco;
	private Usuario usuario;
	private List<Usuario> lista;

	public UsuarioEnderecoAction() {
		endereco = new Endereco();
		usuario = new Usuario();
		lista = new ArrayList<Usuario>();
	}
	
	
	
	public List<Usuario> getLista() {
		return lista;
	}



	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}



	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String cadastrar() throws Exception{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		
		try{
			UsuarioDao ud = new UsuarioDao();
			EnderecoDao ed = new EnderecoDao();
			UsuarioEnderecoDao ued = new UsuarioEnderecoDao();
			ued.create(ud.create(usuario), ed.create(endereco));
			request.setAttribute("msg", "Usuário/Endereco cadastrado com Sucesso");
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("msg", "Erro : " + ex.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String consultar() throws Exception{
		
		try{
			usuario = new UsuarioDao().findByMatricula(usuario.getMatricula());
			endereco = new UsuarioEnderecoDao().findEnderecoByUsuario(usuario.getCodUsuario());
			usuario.setEndereco(new EnderecoDao().findByCod(endereco.getCodEndereco()));
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String consultarTodos() throws Exception{
		
		try{
			UsuarioDao ud = new UsuarioDao();
			UsuarioEnderecoDao ued = new UsuarioEnderecoDao();
			lista = ud.findAll();
			for (Usuario u : lista) {
				u.setEndereco(ued.findEnderecoByUsuario(u.getCodUsuario()));
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String alterar() throws Exception{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		
		try{
			UsuarioEnderecoDao ued = new UsuarioEnderecoDao();
			
			usuario.setCodUsuario(new Integer(request.getParameter("usuario.codUsuario")));
			endereco.setCodEndereco(new Integer(request.getParameter("endereco.codEndereco")));
			
			ued.alterar(usuario, endereco);
			request.setAttribute("msg", "Usuário Alterado com Sucesso");
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("msg", "Erro : " + ex.getMessage() + endereco.getCodEndereco());
		}
		return SUCCESS;
	}
	
	public String consultarDados() throws Exception{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		
		try{
			UsuarioDao ud = new UsuarioDao();
			EnderecoDao ed = new EnderecoDao();
			UsuarioEnderecoDao ued = new UsuarioEnderecoDao();

			usuario = ud.findByMatricula(request.getParameter("matricula"));
			endereco = ued.findEnderecoByUsuario(usuario.getCodUsuario());
			
			request.setAttribute("msg", "Usuário Localizado com Sucesso");
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("msg", "Erro : " + ex.getMessage());
		}
		return SUCCESS;
	}
	
	public String excluir() throws Exception{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		
		try{
			
			HttpServletRequest req = ServletActionContext.getRequest();
			
			Integer idU = new Integer(req.getParameter("codUsuario"));
			Integer idE = new Integer(req.getParameter("codEndereco"));
			
			UsuarioEnderecoDao ued = new UsuarioEnderecoDao();
			
			
			ued.excluir(idU,idE);
			
			request.setAttribute("msg", "Usuário Excluído com Sucesso");
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("msg", "Erro : " + ex.getMessage());
		}
		return SUCCESS;
	}
}
