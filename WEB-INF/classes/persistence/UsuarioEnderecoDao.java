package persistence;

import entity.Endereco;
import entity.Usuario;

public class UsuarioEnderecoDao extends Dao{
	
	public void create(Integer usuario, Integer endereco) throws Exception{
		open();	
			stmt = con.prepareStatement("insert into usuario_endereco values(?,?)");
			stmt.setInt(1, usuario);
			stmt.setInt(2, endereco);
			stmt.execute();
			stmt.close();
		close();
	}
	
	public Endereco findEnderecoByUsuario(Integer cod) throws Exception{
		open();
		stmt = con.prepareStatement("select * from usuario_endereco where idUsuario = ?");
		stmt.setInt(1, cod);
		rs = stmt.executeQuery();
		EnderecoDao ed = new EnderecoDao();
		Endereco e = new Endereco();
		if(rs.next()){
			e = ed.findByCod(rs.getInt("idEndereco"));
		}
		close();
		return e;
	}
	
	public void alterar(Usuario u, Endereco e) throws Exception{
		
		EnderecoDao ed = new EnderecoDao();
		UsuarioDao ud = new UsuarioDao();
		
		ud.alterar(u);
		ed.alterar(e);
	}
	
	public void excluir(Integer idUsuario, Integer idEndereco) throws Exception{
		open();
		stmt = con.prepareStatement("delete from usuario_endereco where idUsuario = ? and idEndereco=?");
		stmt.setInt(1, idUsuario);
		stmt.setInt(2, idEndereco);	
		
		EnderecoDao ed = new EnderecoDao();
		UsuarioDao ud = new UsuarioDao();
		
		ud.excluir(idUsuario);
		ed.excluir(idEndereco);
		
		stmt.execute();
		close();
	}
}
