package control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.json.simple.JSONObject;

import persistence.AgendaDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entity.Agenda;

public class AgendaAction extends ActionSupport{

	private Agenda agenda;
	private List<Agenda> lista;
	
	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public List<Agenda> getLista() {
		return lista;
	}

	public void setLista(List<Agenda> lista) {
		this.lista = lista;
	}

	public AgendaAction() {
		agenda = new Agenda();
	}

	public String cadastrar() throws Exception{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		
		try{
			AgendaDao ad = new AgendaDao();
			ad.create(agenda);
			agenda = new Agenda();
			request.setAttribute("msg", "Cadastrada com Sucesso");
		}catch(Exception ex){
			ex.printStackTrace();
			request.setAttribute("msg", "Erro : " + ex.getMessage());
		}
		
		return SUCCESS;
	}
	
	public String listar() throws Exception{
		
		try{
			AgendaDao ad = new AgendaDao();
			lista = ad.listar();
			System.out.println(lista);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String gerandoCalendario(){
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		
		JSONObject json = new JSONObject();
		String jsonAux="";
		try {
			AgendaDao ad = new AgendaDao();	
			this.lista = ad.listar();
			int maximo = lista.size();
			for (Agenda a : lista ) {
				json.put("title", a.getTitulo());
				json.put("start", a.getData());
				if(maximo != 1){
					jsonAux += json.toJSONString() + ",";
				}else{
					jsonAux += json.toJSONString();
				}
				maximo--;
			}
			request.setAttribute("json", jsonAux);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	
}
