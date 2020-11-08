package br.com.agenda.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.agenda.data.Conexao;
import br.com.agenda.data.ConexaoMySql;
import br.com.agenda.model.Local;

public class LocalDAO {
	
	private final Conexao conexao;
	
	public LocalDAO() throws SQLException, ClassNotFoundException {
		this.conexao = new ConexaoMySql();
	}
	
	public void inserir(String nomeLocal) throws SQLException {
		String sqlQuery = "insert into local(nome) values (?);";
	
	try {
		PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
		stmt.setString(1, nomeLocal);
		stmt.execute();
		
		this.conexao.commit();
	} catch (SQLException e) {
		this.conexao.rollback();
		throw e;
		}
	}

	public List<Local> listarTudo() throws SQLException, ClassNotFoundException {
		String sql = "SELECT id, nome FROM local order by id;";
		
		try {
			PreparedStatement st = this.conexao.getConnection().prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			List<Local> listaPesquisada = new ArrayList<Local>();
			
			while(rs.next()) {
				Local local = new Local(rs.getLong("id"), rs.getString("nome"));
				listaPesquisada.add(local);
			}
			
			return listaPesquisada;
		} catch (SQLException exception) {
			throw exception;
		}
	}
	
	public void alterar(String nomeAtualizado, Long id) throws SQLException, ClassNotFoundException {
		String sql = "update local set nome = ? where id = ?";
		
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
		String sql = "delete from local where id = ?";
		
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