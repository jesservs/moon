package persistence;

import java.util.ArrayList;
import java.util.List;

import entity.Endereco;
import entity.Usuario;

public class UsuarioDao extends Dao{

	public Integer create(Usuario u) throws Exception{
		open();
			stmt = con.prepareStatement("insert into usuario values(null,?,?,?,?,?,?,?);", stmt.RETURN_GENERATED_KEYS);
			stmt.setString(1, u.getMatricula());
			stmt.setString(2, u.getSenha());
			stmt.setString(3, u.getCpf());
			stmt.setString(4, u.getNome());
			stmt.setString(5, u.getEmail());
			stmt.setString(6, u.getTelefone());
			stmt.setString(7, u.getPerfil());
			stmt.execute();
			rs = stmt.getGeneratedKeys();
			int chave = 0;
			if(rs.next()){
				chave = rs.getInt(1);
			}
		close();
		return chave;
	}
	
	
	public Usuario findByMatricula(String matricula) throws Exception{
		open();
		stmt = con.prepareStatement("select * from usuario where matricula = ?");
		stmt.setString(1, matricula);
		rs = stmt.executeQuery();
		
		Usuario usuario = null;
		if(rs.next()){
			usuario = new Usuario();
			usuario.setCodUsuario(rs.getInt("codUsuario"));
			usuario.setMatricula(rs.getString("matricula"));
			usuario.setCpf(rs.getString("cpf"));
			usuario.setNome(rs.getString("nome"));
			usuario.setEmail(rs.getString("email"));
			usuario.setSenha(rs.getString("senha"));
			usuario.setTelefone(rs.getString("telefone"));
			usuario.setPerfil(rs.getString("perfil"));
		}
		close();
		return usuario;
	}
	
	public void alterar(Usuario u) throws Exception{
		open();
		stmt = con.prepareStatement("update usuario set cpf = ?, nome = ?, email = ?, telefone = ?, perfil = ? where matricula = ?");
			stmt.setString(1, u.getCpf());
			stmt.setString(2, u.getNome());
			stmt.setString(3, u.getEmail());
			stmt.setString(4, u.getTelefone());
			stmt.setString(5, u.getPerfil());
			stmt.setString(6, u.getMatricula());
			stmt.execute();
		close();
	}
	
	public void excluir(String matricula) throws Exception{
		open();
		stmt = con.prepareStatement("delete from usuario where matricula = ?");
		stmt.setString(1, matricula);
		stmt.execute();
		close();
	}
	
	public void excluir(Integer id) throws Exception{
		open();
		stmt = con.prepareStatement("delete from usuario where codUsuario = ?");
		stmt.setInt(1, id);
		stmt.execute();
		close();
	}
	
	public Usuario logar(Usuario u) throws Exception{
		open();
		stmt = con.prepareStatement("select * from usuario where matricula = ? and senha = ?");
		stmt.setString(1, u.getMatricula());
		stmt.setString(2, u.getSenha());
		rs = stmt.executeQuery();
		
		Usuario usuario = null;
		if(rs.next()){
			usuario = new Usuario();
			usuario.setMatricula(rs.getString("matricula"));
			usuario.setCpf(rs.getString("cpf"));
			usuario.setNome(rs.getString("nome"));
			usuario.setEmail(rs.getString("email"));
			usuario.setSenha(rs.getString("senha"));
			usuario.setTelefone(rs.getString("telefone"));
			usuario.setPerfil(rs.getString("perfil"));
		}
		close();
		return usuario;
	}
	
	public Usuario findByCod(Integer cod) throws Exception{
		open();
		stmt = con.prepareStatement("select * from usuario where idUsuario = ?");
		stmt.setInt(1, cod);
		rs = stmt.executeQuery();

		Usuario u = new Usuario();
		if(rs.next()){
			u.setCpf(rs.getString("cpf"));
			u.setEmail(rs.getString("email"));
			u.setMatricula(rs.getString("matricula"));
			u.setNome(rs.getString("nome"));
			u.setPerfil(rs.getString("perfil"));
			u.setSenha(rs.getString("senha"));
			u.setTelefone(rs.getString("telefone"));
		}
		close();
		return u;
	}
	
	public List<Usuario> findAll() throws Exception{
		open();
		stmt = con.prepareStatement("select * from usuario");
		rs = stmt.executeQuery();
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		Usuario u = null;
		while(rs.next()){
			u = new Usuario();
			u.setCodUsuario(rs.getInt("codUsuario"));
			u.setCpf(rs.getString("cpf"));
			u.setEmail(rs.getString("email"));
			u.setMatricula(rs.getString("matricula"));
			u.setNome(rs.getString("nome"));
			u.setPerfil(rs.getString("perfil"));
			u.setSenha(rs.getString("senha"));
			u.setTelefone(rs.getString("telefone"));
			lista.add(u);
		}
		close();
		return lista;
	}
	
	public static void main(String[] args) {
		UsuarioDao ud = new UsuarioDao();
		try {
			for (Usuario u : ud.findAll()) {
				System.out.println(u);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
