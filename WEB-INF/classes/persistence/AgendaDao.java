package persistence;

import java.util.ArrayList;
import java.util.List;

import entity.Agenda;
import entity.Noticia;

public class AgendaDao extends Dao{

	
	public void create(Agenda a) throws Exception{
		open();
			stmt = con.prepareStatement("insert into agenda values(null,?,?,?)");
			stmt.setString(1, a.getTitulo());
			stmt.setString(2, a.getDetalhe());
			stmt.setString(3, a.getData());
			stmt.execute();
		close();
	}
	
	public List<Agenda> listar() throws Exception{
		open();
			stmt = con.prepareStatement("select * from agenda");
			rs = stmt.executeQuery();
		
		List<Agenda> lista = new ArrayList<Agenda>();
		Agenda a = null;
		while(rs.next()){
			a = new Agenda();
			a.setIdAgenda(rs.getInt(1));
			a.setTitulo(rs.getString(2));
			a.setDetalhe(rs.getString(3));
			a.setData(rs.getString(4));
			lista.add(a);
		}
		close();
		return lista;
		
	}
}
