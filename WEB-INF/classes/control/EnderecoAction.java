package control;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.lavieri.modelutil.cep.WebServiceCep;

import persistence.EnderecoDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entity.Endereco;

public class EnderecoAction extends ActionSupport{

	private Endereco endereco;

	public EnderecoAction() {
		endereco = new Endereco();
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String cadastrar(){
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		EnderecoDao ed = new EnderecoDao();
		try {
			System.out.println(request.getParameter("endereco.cep"));
			ed.create(endereco);
			request.setAttribute("msg", "Endereco cadastrado com Sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String consultar(){
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String txtCep = endereco.getCep();
		WebServiceCep wscep = WebServiceCep.searchCep(txtCep);
		
		try {
			if (wscep.wasSuccessful()) { 
			endereco.setLogradouro(wscep.getLogradouro());
			endereco.setCidade(wscep.getCidade());
			endereco.setEstado(wscep.getUf());
			endereco.setBairro(wscep.getBairro());
			request.setAttribute("msg", "Localizado!");
			}else{
				request.setAttribute("msg", "Cep Não Localizado!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erro: " + e.getMessage() + wscep.getException() + wscep.getResultText());
		}
		return SUCCESS;
	}

}
