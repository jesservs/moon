package control;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import persistence.NoticiaDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entity.Noticia;

public class NoticiaAction extends ActionSupport{

	private Noticia noticia;
	private List<Noticia> lista;
	
	public NoticiaAction() {
		noticia = new Noticia();
		lista = new ArrayList<Noticia>();
	}

	public Noticia getNoticia() {
		return noticia;
	}

	public List<Noticia> getLista() {
		return lista;
	}

	public void setLista(List<Noticia> lista) {
		this.lista = lista;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}
	
	
	
	public String cadastrar() throws Exception{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		
		try{
			NoticiaDao nd = new NoticiaDao();
			nd.create(noticia);
			noticia = new Noticia();
			request.setAttribute("msg", "Notícia cadastrada com Sucesso");
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
			NoticiaDao nd = new NoticiaDao();
			nd.alterar(noticia);
			request.setAttribute("msg", "Notícia Alterada com Sucesso");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}

	public String excluir() throws Exception{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		
		try{
			
			
			noticia = new NoticiaDao().findByCod(new Integer (request.getParameter("idNoticia")));
			
			NoticiaDao nd = new NoticiaDao();
			nd.excluir(noticia.getIdNoticia());
			
			request.setAttribute("msg", "Notícia Excluída com Sucesso");
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("msg", "Erro : " + ex.getMessage());
		}
		return SUCCESS;
	}

	public String listar() throws Exception{
	
		try{
			NoticiaDao nd = new NoticiaDao();
			lista = nd.listar();
			System.out.println(lista);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		
		return SUCCESS;
	}
}
