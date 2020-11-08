package br.com.agenda.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.agenda.data.Conexao;
import br.com.agenda.data.ConexaoMySql;
import br.com.agenda.model.Usuario;

public class UsuarioDAO {

	private final Conexao conexao;
	
	public UsuarioDAO() throws SQLException, ClassNotFoundException {
		this.conexao = new ConexaoMySql();
	}
	
	public void inserir(String nomeUsuario) throws SQLException {
		String sqlQuery = "insert into usuario(nome) values (?);";
	
	try {
		PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
		stmt.setString(1, nomeUsuario);
		stmt.execute();
		
		this.conexao.commit();
	} catch (SQLException e) {
		this.conexao.rollback();
		throw e;
		
	}
}

	public List<Usuario> listarTudo() throws SQLException, ClassNotFoundException {
		String sql = "SELECT id, nome FROM usuario order by id;";
		
		try {
			PreparedStatement st = this.conexao.getConnection().prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			List<Usuario> listaPesquisada2 = new ArrayList<Usuario>();
			
			while(rs.next()) {
				Usuario usuario = new Usuario(rs.getLong("id"), rs.getString("nome"));
				listaPesquisada2.add(usuario);
			}
			
			return listaPesquisada2;
		} catch (SQLException exception) {
			throw exception;
		}
	}
	
	public void alterar(String nomeAtualizado, Long id) throws SQLException, ClassNotFoundException {
		String sql = "update usuario set nome = ? where id = ? ;";
		
		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
			stmt.setString(1, nomeAtualizado);
			stmt.setLong(2, id);
			stmt.execute();
			
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}
	}
	
	public void excluir(Long id) throws SQLException, ClassNotFoundException {
		String sql = "delete from usuario where id = ?";
		
		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.execute();
			
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}
	}
}
