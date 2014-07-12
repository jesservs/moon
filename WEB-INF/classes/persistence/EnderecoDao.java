package persistence;

import java.util.ArrayList;
import java.util.List;

import entity.Endereco;

public class EnderecoDao extends Dao {
	
	public Integer create(Endereco e) throws Exception{
		open();
			stmt = con.prepareStatement("insert into endereco values(null,?,?,?,?,?,?,?)", stmt.RETURN_GENERATED_KEYS);
			stmt.setString(1, e.getLogradouro());
			stmt.setInt(2, e.getNumero());
			stmt.setString(3, e.getComplemento());
			stmt.setString(4, e.getBairro());
			stmt.setString(5, e.getCidade());
			stmt.setString(6, e.getEstado());
			stmt.setString(7, e.getCep());
			stmt.execute();
			rs = stmt.getGeneratedKeys();
			int chave = 0;
			if(rs.next()){
				chave = rs.getInt(1);
			}
			stmt.close();
		close();
		return chave;
	}
	
	public void excluir(Integer cod) throws Exception{
		open();
		stmt = con.prepareStatement("delete from endereco where codEndereco = ?");
		stmt.setInt(1, cod);
		stmt.execute();
		close();
	}
	
	public Endereco findByCod(Integer cod) throws Exception{
		open();
		stmt = con.prepareStatement("select * from endereco where codEndereco = ?");
		stmt.setInt(1, cod);
		
		rs = stmt.executeQuery();
		Endereco e = new Endereco();
		if(rs.next()){
			e.setCodEndereco(rs.getInt("codEndereco"));
			e.setLogradouro(rs.getString("logradouro"));
			e.setNumero(rs.getInt("numero"));
			e.setComplemento(rs.getString("complemento"));
			e.setBairro(rs.getString("bairro"));
			e.setCidade(rs.getString("cidade"));
			e.setEstado(rs.getString("estado"));
			e.setCep(rs.getString("cep"));
		}
		close();
		return e;
	}
	
	public void alterar(Endereco e) throws Exception{
		open();
		stmt = con.prepareStatement("update endereco set logradouro = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, estado = ?, cep = ? where codEndereco = ?");
			stmt.setString(1, e.getLogradouro());
			stmt.setInt(2, e.getNumero());
			stmt.setString(3, e.getComplemento());
			stmt.setString(4, e.getBairro());
			stmt.setString(5, e.getCidade());
			stmt.setString(6, e.getEstado());
			stmt.setString(7, e.getCep());
			stmt.setInt(8, e.getCodEndereco());
			stmt.execute();
		close();
	}
	
}
