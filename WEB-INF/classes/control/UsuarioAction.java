package control;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import persistence.UsuarioDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entity.Usuario;

public class UsuarioAction extends ActionSupport{

	private Usuario usuario;
	private List<Usuario> lista;
	
	public UsuarioAction() {
		usuario = new Usuario();
		lista = new ArrayList<Usuario>();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getLista() {
		return lista;
	}

	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}
	
	public String cadastrar() throws Exception{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		
		try{
			UsuarioDao fd = new UsuarioDao();
			fd.create(usuario);
			usuario = new Usuario();
			request.setAttribute("msg", "Usuário cadastrado com Sucesso");
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("msg", "Erro : " + ex.getMessage());
		}
		
		return SUCCESS;
	}
	
	
	public String consultar() throws Exception{
		
		try{
			usuario = new UsuarioDao().findByMatricula(usuario.getMatricula());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String consultarDados() throws Exception{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		
		try{
			UsuarioDao fd = new UsuarioDao();
			usuario = fd.findByMatricula(request.getParameter("matricula"));
			fd.alterar(usuario);
			request.setAttribute("msg", "Usuário Localizado com Sucesso");
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("msg", "Erro : " + ex.getMessage());
		}
		return SUCCESS;
	}
	
	public String alterar() throws Exception{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		
		try{
			UsuarioDao fd = new UsuarioDao();
			fd.alterar(usuario);
			request.setAttribute("msg", "Usuário Alterado com Sucesso");
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("msg", "Erro : " + ex.getMessage() + usuario  + "maitrucla:  " + request.getParameter("matricula"));
		}
		return SUCCESS;
	}
	
	
	public String excluir() throws Exception{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		
		try{
			
			HttpServletRequest req = ServletActionContext.getRequest();
			
			usuario = new UsuarioDao().findByMatricula(req.getParameter("matricula"));
			
			UsuarioDao fd = new UsuarioDao();
			fd.excluir(usuario.getMatricula());
			
			request.setAttribute("msg", "Usuário Excluído com Sucesso");
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("msg", "Erro : " + ex.getMessage());
		}
		return SUCCESS;
	}
	
	public String logar() throws Exception{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext()
				.get(ServletActionContext.HTTP_RESPONSE);
		
		try{
			
			UsuarioDao fd = new UsuarioDao();
			if(fd.logar(usuario)!=null)
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("msg", "Usuário ou Senha Incorretos");
		}
		return SUCCESS;
	}
	
	
}
