package br.com.agenda.teste;

import java.sql.SQLException;
import br.com.agenda.dao.UsuarioDAO;

public class UsuarioTeste {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		/*
		UsuarioDAO dao = new UsuarioDAO();
		dao.inserir("Vinicius");
	   
	
		UsuarioDAO dao = new UsuarioDAO();
		System.out.println("Lista antes de atualizar");
		System.out.println(dao.listarTudo());
		
		UsuarioDAO daoUpdate = new UsuarioDAO();
		daoUpdate.alterar("sdads", 1L);
		
		System.out.println("Lista atualizada:");
		UsuarioDAO pesq = new UsuarioDAO();
		System.out.println(pesq.listarTudo());
	
	*/
		
		UsuarioDAO dao = new UsuarioDAO();
		System.out.println("Lista antes de atualizar");
		System.out.println(dao.listarTudo());
		
		UsuarioDAO del = new UsuarioDAO();
		del.excluir(2L);
		
		System.out.println("Lista atualizada:");
		UsuarioDAO pesq = new UsuarioDAO();
		System.out.println(pesq.listarTudo());
	}
}