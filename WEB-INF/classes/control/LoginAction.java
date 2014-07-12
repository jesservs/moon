package control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import persistence.UsuarioDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entity.Usuario;

public class LoginAction extends ActionSupport{

	private Usuario login;
	
	public Usuario getLogin() {
		return login;
	}

	public void setLogin(Usuario login) {
		this.login = login;
	}

	public String logar() throws Exception{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		
		try{
			System.out.println("CHEGOU");
			UsuarioDao ud = new UsuarioDao();
			HttpSession session = request.getSession(true);
			Usuario resp = ud.logar(login);
			if(resp != null){
				session.setAttribute("login", resp);
				return SUCCESS;
			}
				
		}catch(Exception ex){
			ex.printStackTrace();
			
		}
		return ERROR;
	}
	
	public String logout() throws Exception{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		
		try{
			HttpSession session = request.getSession();
			session.invalidate();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	
}
