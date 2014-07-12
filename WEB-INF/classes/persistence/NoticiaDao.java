package persistence;

import java.util.ArrayList;
import java.util.List;

import entity.Noticia;
import entity.Usuario;


public class NoticiaDao extends Dao{

	public void create(Noticia n) throws Exception{
		open();
			stmt = con.prepareStatement("insert into noticia values(null,?,?,?)");
			stmt.setString(1, n.getTitulo());
			stmt.setString(2, n.getDescricao());
			stmt.setString(3, n.getFoto());
			stmt.execute();
		close();
	}
	
	public void alterar(Noticia n) throws Exception{
		open();
			stmt = con.prepareStatement("update noticia set titulo = ?, descricao = ?, foto = ? where idNoticia");
			stmt.setString(1, n.getTitulo());
			stmt.setString(2, n.getDescricao());
			stmt.setString(3, n.getFoto());
			stmt.execute();
		close();
	}
	
	public void excluir(Integer idNoticia) throws Exception{
		open();
			stmt = con.prepareStatement("delete from noticia where idNoticia = ?");
			stmt.setInt(1, idNoticia);
			stmt.execute();
		close();
	}
	
	public List<Noticia> listar() throws Exception{
		open();
			stmt = con.prepareStatement("select * from noticia");
			rs = stmt.executeQuery();
		
		List<Noticia> lista = new ArrayList<Noticia>();
		Noticia n = null;
		while(rs.next()){
			n = new Noticia();
			n.setIdNoticia(rs.getInt(1));
			n.setTitulo(rs.getString(2));
			n.setDescricao(rs.getString(3));
			n.setFoto(rs.getString(4));
			lista.add(n);
		}
		
		close();
		return lista;
	}
	
	public Noticia findByCod(Integer cod) throws Exception{
		open();
		stmt = con.prepareStatement("select * from noticia where idNoticia = ?");
		stmt.setInt(1, cod);
		rs = stmt.executeQuery();

		Noticia n = new Noticia();
		if(rs.next()){
			n.setTitulo(rs.getString("titulo"));
			n.setDescricao(rs.getString("descricao"));
			n.setFoto(rs.getString("foto"));
			n.setIdNoticia(rs.getInt("idNoticia"));
		}
		close();
		return n;
	}
	

}
